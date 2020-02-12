package com.metacube.training.shape;

import org.springframework.stereotype.Component;

@Component("mockmail")
public class MockMail implements Mail {
	@Override
	public void sendMail()
	{
		System.out.println("Mock Mail Send");
	}
}
