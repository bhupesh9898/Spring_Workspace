package com.zensar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Bid;
import com.zensar.repository.BidRepository;
import com.zensar.service.BidService;

@Service
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepository bidRepository;

	@Override
	public Iterable<Bid> bidHistory(int productId) {
		return bidRepository.getBidsByProductId(productId);
	}

	@Override
	public int placeBid(Bid bid) {
		bidRepository.save(bid);
		return 1;
	}

	@Override
	public Iterable<Bid> getBidsByBidderId(int bidderId) {
		return bidRepository.getBidsByBidderId(bidderId);
	}

}
