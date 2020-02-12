package com.metacube.training.shape;

import org.springframework.stereotype.Component;

@Component("smtpmail")
public class SmtpMail implements Mail{

	@Override
	public void sendMail()
	{
		System.out.println("SMTP Mail Send");
	}
}
