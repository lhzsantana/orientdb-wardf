package org.ufsc.client.waRDF;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.jena.graph.Triple;

import java.util.List;

public class WAClient {

    private final String url = "http://localhost:9300/";
    private Client client;

    public WAClient(){
        client = Client.create();
    }

    public void store(Triple triple){

        try{
            WebResource webResource = client.resource(url+"store");

            ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);

            response.getEntity(Triple.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Triple> query(String sparql){

        Client client = Client.create();

        WebResource webResource = client.resource(url+"query");

        ClientResponse response = webResource.accept("application/json").post(ClientResponse.class);

        return response.getEntity(List.class);
    }
}
