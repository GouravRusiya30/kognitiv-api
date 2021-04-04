package com.kognitiv.backend.assignment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kognitiv.backend.assignment.dao.OfferRepository;
import com.kognitiv.backend.assignment.exception.RecordNotFoundException;
import com.kognitiv.backend.assignment.model.Offer;

@Service
public class OfferService implements IOfferService {
	
	@Autowired
	OfferRepository repository;

	@Autowired
	ImagesRandomService imagesRandomService;

	public List<Offer> getAllOffers() {
		List<Offer> offerList = repository.findAll();

		if (offerList.size() > 0) {
			return offerList;
		} else {
			return new ArrayList<Offer>();
		}
	}

	public Offer getOfferById(Long id) throws RecordNotFoundException {
		Optional<Offer> offer = repository.findById(id);

		if (offer.isPresent()) {
			return offer.get();
		} else {
			throw new RecordNotFoundException("No offer record exist for given id");
		}
	}

	public String postOffer(Offer offer) {
		Offer response = null;

		try {
			List<String> imagesList = new ArrayList<>();
			imagesList.add(imagesRandomService.fetchRandomImages());
			imagesList.add(imagesRandomService.fetchRandomImages());
			
			offer.setImages(imagesList);
			
			response = repository.save(offer);
		} catch (Exception ex) {
			// log exception
		}
		return (response == null) ? "false" : "true";
	}
}
