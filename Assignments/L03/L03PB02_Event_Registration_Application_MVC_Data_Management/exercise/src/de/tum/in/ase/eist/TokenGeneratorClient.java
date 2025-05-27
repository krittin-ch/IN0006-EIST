package de.tum.in.ase.eist;

import de.tum.in.ase.eist.common.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TokenGeneratorClient {

    RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/tokenGenerator/";

    private String messages = new String();

    public TokenGeneratorClient() {
        this.restTemplate = new RestTemplate();
    }

    public String generateToken(Employee employee){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Employee> requestEntity = new HttpEntity<>(employee, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(BASE_URL+"getToken", requestEntity, String.class);

        String responseBody = responseEntity.getBody();
        int statusCode = responseEntity.getStatusCodeValue();

        System.out.println("Response Body: " + responseBody);
        System.out.println("Status Code: " + statusCode);
        messages = responseBody;
        return responseBody;

    }

    public String getMessages() {
        return messages;
    }
}
