package com.panambystudios.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmailController {

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(path = "/email-send", method = RequestMethod.GET)
	public String sendMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Hello");
		message.setText("Hello from Spring Boot Application");
        message.setTo("rafa.jo.souza@hotmail.com");
        message.setFrom("rafa.souza.test@gmail.com");

		try {
			mailSender.send(message);
			return "Email enviado com sucesso!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao enviar email.";
		}
	}
}
