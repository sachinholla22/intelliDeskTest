package com.ticketsystem.ticketsystem.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    
    private final JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private  String sendFrom;

    public EmailService(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }


    public void sendEmail(String to,String subject , String body){
        SimpleMailMessage message=new SimpleMailMessage();

        message.setFrom(sendFrom);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}

