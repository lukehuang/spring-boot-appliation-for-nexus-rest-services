package com.rdops.microservice.nexusservice.nexusservice.nexusController;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.rdops.microservice.nexusservice.nexusservice.nexusModel.NexusBean;

@RestController
public class NexusController {
	
	@Autowired
	org.springframework.web.client.RestTemplate RestTemplate;
	
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello, "+name;
	}
	
	// getNexusRepositories
	@PostMapping("/getNexusRepositories")
	@ResponseBody
	public String getNexusRepositories(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.get("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/repositories")
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// getNexusRepositoryAssests
	@PostMapping("/getNexusRepositoryAssests")
	@ResponseBody
	public String getNexusRepositoryAssests(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.get("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/assets?repository="+1)
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// deleteNexusRepositoryAssestById
	@PostMapping("/deleteNexusRepositoryAssestById")
	@ResponseBody
	public String deleteNexusRepositoryAssestById(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.delete("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/assets/"+1)
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// getNexusRepositoryComponents
	@PostMapping("/getNexusRepositoryComponents")
	@ResponseBody
	public String getNexusRepositoryComponents(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.get("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/components?repository="+1)
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// createNexusRepositoryComponent
	@PostMapping("/createNexusRepositoryComponent")
	@ResponseBody
	public String createNexusRepositoryComponent(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
        
        JSONObject json = new JSONObject();
		json.put("groupId", "RestApi");
		json.put("artifactId", "REST");
		json.put("version", "software");
		json.put("asset", "admin");
		System.out.println(json);
		
		final HttpResponse<JsonNode> response = Unirest.post("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/components?repository="+1)
				.header("Authorization","Basic " + credentialEnc)
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.body(json)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// deleteNexusRepositoryComponentById
	@PostMapping("/deleteNexusRepositoryComponentById")
	@ResponseBody
	public String deleteNexusRepositoryComponentById(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.delete("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/components/"+1)
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// getNexusRepositoryComponentById
	@PostMapping("/getNexusRepositoryComponentById")
	@ResponseBody
	public String getNexusRepositoryComponentById(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.get("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/components/"+1)
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// getNexusRepositoryTasks
	@PostMapping("/getNexusRepositoryTasks")
	@ResponseBody
	public String getNexusRepositoryTasks(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.get("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/tasks")
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// getNexusRepositoryTaskById
	@PostMapping("/getNexusRepositoryTaskById")
	@ResponseBody
	public String getNexusRepositoryTaskById(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.get("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/tasks/"+1)
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// runNexusRepositoryTaskById
	@PostMapping("/runNexusRepositoryTaskById")
	@ResponseBody
	public String runNexusRepositoryTaskById(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.post("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/tasks/"+1+"/run")
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
	// stopNexusRepositoryTaskById
	@PostMapping("/stopNexusRepositoryTaskById")
	@ResponseBody
	public String stopNexusRepositoryTaskById(@RequestBody NexusBean NexusBean) throws IOException, UnirestException, Exception {
		
        byte[] credential = Base64.encodeBase64( (NexusBean.getUsername()+":"+NexusBean.getPassword()).getBytes());
        String credentialEnc = new String(credential);
		
		final HttpResponse<JsonNode> response = Unirest.post("http://"+ NexusBean.getNexusip() +":8081/service/rest/beta/tasks/"+1+"/stop")
				.header("Authorization","Basic " + credentialEnc)
				.asJson();
		
		System.out.println(response.getBody());
		return response.getBody().toString();
		
	}
	
}
