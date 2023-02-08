package com.gusta.greetingservice.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Greeting {
	private long id;
	private String content;
}
