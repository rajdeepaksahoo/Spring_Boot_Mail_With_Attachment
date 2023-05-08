package com.springboot.mail.email.service;

import com.springboot.mail.entity.MyEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class SpringEmailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendMail(MyEntity myEntity) throws MessagingException, IOException {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("abc@abc.com");
//        message.setSubject(myEntity.getSubject());
//        message.setTo(myEntity.getTo());
//        message.setText(myEntity.getBody());
//
//        MimeBodyPart attachmentPart = new MimeBodyPart();
//        attachmentPart.attachFile(new File("path/to/file"));
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(m);
//        multipart.addBodyPart(attachmentPart);
//
//        javaMailSender.send(message);
//        System.out.println("Mail Sent");


        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(myEntity.getTo());
        helper.setSubject(myEntity.getSubject());
        helper.setText(myEntity.getBody());

        FileSystemResource file = new FileSystemResource(new File("F:\\Photos\\cv\\abc.JPG"));
        helper.addAttachment("attachment.jpg", file);

        javaMailSender.send(message);

    }
}
