package org.jimmyray.mongo.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Placeholder for REST client for Object Rocket REST API.
 * 
 * @author jimmyray
 * @version 1.0
 */
public class ObjectRocketClient {
	private static Logger log = LoggerFactory
			.getLogger(ObjectRocketClient.class);

	private String apiKey;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public static void main(String[] args) {

	}

	public String listDatabases() {
		String output = null;

		try {

			Client client = Client.create();

			// TODO Flesh out the URI
			WebResource webResource = client.resource("<URI>" + this.apiKey);

			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("REST API Failure: "
						+ response.getEntity(String.class)
						+ ", HTTP error code : " + response.getStatus());
			}

			output = response.getEntity(String.class);

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
			output = e.getLocalizedMessage();
		}

		return output;

	}
}
