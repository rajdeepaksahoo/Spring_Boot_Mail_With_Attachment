package com.springboot.mail.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
@Data
@NoArgsConstructor
@Component
public class MyEntity {
    String to;
    String subject;
    String body;
}
