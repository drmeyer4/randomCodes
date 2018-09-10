package com.example.functional;

import java.util.function.Consumer;

public class LambdaFluentMailerExample {
	private LambdaFluentMailerExample() {}
	
	public LambdaFluentMailerExample from(final String address) { return this; }
	public LambdaFluentMailerExample to(final String address) { return this; }
	public LambdaFluentMailerExample subject(final String line) { return this; }
	public LambdaFluentMailerExample body(final String message) { return this; }
	
	public static void send(final Consumer<LambdaFluentMailerExample> block) {
		final LambdaFluentMailerExample mailer = new LambdaFluentMailerExample();
		block.accept(mailer);
	}
	
	public static void main(String... args) {
		LambdaFluentMailerExample.send(mailer -> 
				mailer.from("from")
					.to("to")
					.subject("subject")
					.body("body"));
		
	}
	
}
