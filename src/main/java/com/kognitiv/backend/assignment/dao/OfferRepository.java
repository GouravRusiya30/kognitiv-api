package com.kognitiv.backend.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kognitiv.backend.assignment.model.Offer;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
}
