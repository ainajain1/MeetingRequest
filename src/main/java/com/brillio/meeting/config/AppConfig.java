package com.brillio.meeting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brillio.meeting.service.ActionService;
import com.brillio.meeting.service.impl.ActionServiceImpl;

@Configuration
public class AppConfig {

	@Bean
	public ActionService actionService() {
		return new ActionServiceImpl();
	}

}
