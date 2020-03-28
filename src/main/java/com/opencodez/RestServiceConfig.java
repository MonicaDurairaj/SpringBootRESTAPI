package com.opencodez;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class RestServiceConfig extends ResourceConfig {
	public RestServiceConfig() {
		register(MongoDbRestService.class);
	}

}
