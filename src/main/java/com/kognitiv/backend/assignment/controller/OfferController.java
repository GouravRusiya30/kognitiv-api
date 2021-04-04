package com.kognitiv.backend.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kognitiv.backend.assignment.model.Offer;
import com.kognitiv.backend.assignment.service.OfferService;

@RestController
@RequestMapping(value = "/collect/offer")
public class OfferController {

	@Autowired
	OfferService service;

	@GetMapping
	public List<Offer> getOffers() {
		return service.getAllOffers();
	}

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<KognitivApiResponse> postOffer(@RequestBody Offer offer) {
		KognitivApiResponse response = new KognitivApiResponse();
		response.setSuccess(service.postOffer(offer));
		return new ResponseEntity<KognitivApiResponse>(response, HttpStatus.OK);
	}
}
