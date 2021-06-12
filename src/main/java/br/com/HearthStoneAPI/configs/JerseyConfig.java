package br.com.HearthStoneAPI.configs;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.HearthStoneAPI.resources.CartaResource;

@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig(){
		register(CartaResource.class);
	}

}
