package net.guides.springboot2.springboot2jpacrudexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import es.example.sb.ng.Application;
import es.example.sb.ng.model.EsEmployeeEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {

	}

	@Test
	public void testGetAllEmployees() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/employees",
				HttpMethod.GET, entity, String.class);
		
		assertNotNull(response.getBody());
	}

	@Test
	public void testGetEmployeeById() {
		EsEmployeeEntity employee = restTemplate.getForObject(getRootUrl() + "/employees/1", EsEmployeeEntity.class);
		System.out.println(employee.getEmpFirstName());
		assertNotNull(employee);
	}

	@Test
	public void testCreateEmployee() {
		EsEmployeeEntity employee = new EsEmployeeEntity();
		employee.setEmpEmailId("admin@gmail.com");
		employee.setEmpFirstName("admin");
		employee.setEmpLastName("admin");

		ResponseEntity<EsEmployeeEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/employees", employee, EsEmployeeEntity.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

	@Test
	public void testUpdateEmployee() {
		int id = 1;
		EsEmployeeEntity employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, EsEmployeeEntity.class);
		employee.setEmpFirstName("admin1");
		employee.setEmpLastName("admin2");

		restTemplate.put(getRootUrl() + "/employees/" + id, employee);

		EsEmployeeEntity updatedEmployee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, EsEmployeeEntity.class);
		assertNotNull(updatedEmployee);
	}

	@Test
	public void testDeleteEmployee() {
		int id = 2;
		EsEmployeeEntity employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, EsEmployeeEntity.class);
		assertNotNull(employee);

		restTemplate.delete(getRootUrl() + "/employees/" + id);

		try {
			employee = restTemplate.getForObject(getRootUrl() + "/employees/" + id, EsEmployeeEntity.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
}
