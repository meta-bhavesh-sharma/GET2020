package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.training.shape.*;;

@RestController
public class MailSend {
		
		@Autowired
		@Qualifier("mockmail")
		Mail mail;
		
	   
		@GetMapping("/send") 
		public String mailSender() {
			
			mail.sendMail();
			
			return "Mail Send";
		}
		


}
