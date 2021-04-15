package com.example.demo.interfacesclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Emailsend 
{
	@Autowired
    private JavaMailSender mailsender;
 public void sendMail(String to, String subject, String body) throws NullPointerException 
    {  System.out.println(to);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("abc@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailsender.send(message);  
    }
}
