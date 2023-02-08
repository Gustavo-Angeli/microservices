package com.gusta.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.gusta.greetingservice.config.*;
import com.gusta.greetingservice.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cloud.context.config.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Component
@RefreshScope
@RestController
public class GreetingController {

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingConfig greetingConfig;

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "") String name) {

		if (name.isBlank()) name = greetingConfig.getDefaultValue();

		return Greeting.builder()
				.id(counter.incrementAndGet())
				.content(String.format(template, greetingConfig.getGreeting(), name))
				.build();
	}
}