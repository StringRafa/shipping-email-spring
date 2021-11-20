package com.panambystudios.email.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RestController;
 
@Configuration
@RestController
public class EmailConfig 
{
	
	@Value("${spring.mail.password}")
	private String emailPass;
	
    @Bean
    public JavaMailSender getJavaMailSender() 
    {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
          
        mailSender.setUsername("rafa.souza.test@gmail.com");
        mailSender.setPassword(emailPass);
          
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
          
        return mailSender;
    }
     
    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("rafa.jo.souza@hotmail.com");
        message.setFrom("rafa.souza.test@gmail.com");
        message.setText("FATAL - Application crash. Save your job !!");
        return message;
    }
}
