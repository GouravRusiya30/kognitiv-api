package com.kognitiv.backend.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kognitiv.backend.assignment.model.Image;

@Service
public class ImagesRandomService {

	@Value("${images.base.url}")
	private String imagesBaseUrl;

	public String fetchRandomImages() throws JsonMappingException, JsonProcessingException {
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(imagesBaseUrl, String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Image> imagesList = mapper.readValue(result, new TypeReference<List<Image>>(){});
		
		// random selection
		int rand = (int) (Math.random() * imagesList.size());
		
		return imagesList.get(rand).getUrl();
	}
}
