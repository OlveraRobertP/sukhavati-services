package com.sukhavati.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("svc")
public class MainRestServices extends ResourceConfig {
	public MainRestServices() {
		packages("com.sukhavati.rest.services");
	}
}
