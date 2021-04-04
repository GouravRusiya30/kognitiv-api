package com.kognitiv.backend.assignment.service;

import java.util.List;

import com.kognitiv.backend.assignment.exception.RecordNotFoundException;
import com.kognitiv.backend.assignment.model.Offer;

public interface IOfferService {
	
	List<Offer> getAllOffers();
	
	Offer getOfferById(Long id) throws RecordNotFoundException;
	
	String postOffer(Offer offer);
}
