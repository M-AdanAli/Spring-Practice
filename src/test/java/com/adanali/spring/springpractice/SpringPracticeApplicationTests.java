package com.adanali.spring.springpractice;

import com.adanali.spring.springpractice.MVCBootAndREST.REST.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class SpringPracticeApplicationTests {

    private RestTemplate restTemplate;

    @BeforeEach
    void setup(){
        restTemplate = new RestTemplate();
    }
    @Test
    void contextLoads() {
    }

    @Test
    void shouldGetEmployeeById() {

        String url = "http://localhost:8081/office/employees/{id}";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_XML));

        ResponseEntity<String> response =
                restTemplate.exchange(url,HttpMethod.GET,new HttpEntity<>(headers),String.class,1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void shouldReturnBadRequestForInvalidEmployee() {

        String url = "http://localhost:8081/office/employees/{id}";
        Assertions.assertThrows(HttpClientErrorException.class, ()->{ResponseEntity<Employee> response =
                restTemplate.getForEntity(url, Employee.class, 99);});
    }

    @Test
    void shouldGetEmployeeWithHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String url = "http://localhost:8081/office/employees/{id}";

        ResponseEntity<Employee> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        entity,
                        Employee.class,
                        1
                );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
    }

    @Test
    void shouldCreateEmployee() {

        String employee = """
                <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
                <employee>
                    <name>Adan</name>
                    <role>Back-end Engineer</role>
                </employee>
                """;

        HttpEntity<String> entity = new HttpEntity<>(employee);
        entity.getHeaders().setContentType(MediaType.APPLICATION_XML);

        String url = "http://localhost:8081/office/employees/new";

        ResponseEntity<Void> response =
                restTemplate.postForEntity(url, entity, Void.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        /*Employee created =
                restTemplate.getForObject("http://localhost:8081/office/employees/5", Employee.class);

        assertEquals("Adan", created.getName());*/
    }

    @Test
    void shouldGetAllEmployees() {

        String url = "http://localhost:8081/office/employees";

        /*HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_XML));*/

        ResponseEntity<String> response =
                restTemplate.exchange(
                        url,
                        HttpMethod.GET,
                        null/*new HttpEntity<>(headers)*/,
                        String.class
                );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        System.out.println(response);
    }

}
