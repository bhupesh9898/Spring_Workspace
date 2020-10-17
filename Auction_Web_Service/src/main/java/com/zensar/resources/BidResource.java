package com.zensar.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Bid;
import com.zensar.service.BidService;

@RestController
public class BidResource {

	@Autowired
	private BidService bidService;

	@GetMapping(value = "/bid/history/{productId}")
	public ResponseEntity<Iterable<Bid>> bidHistory(@PathVariable("productId") int productId) {
		boolean hasBids = bidService.bidHistory(productId).iterator().hasNext();
		if (hasBids)
			return new ResponseEntity<Iterable<Bid>>(bidService.bidHistory(productId), HttpStatus.OK);
		else
			return new ResponseEntity<Iterable<Bid>>(bidService.bidHistory(productId), HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/place/bid")
	public ResponseEntity<String> placeBid(@RequestBody Bid bid) {
		int result = bidService.placeBid(bid);
		if (result > 0)
			return new ResponseEntity<String>("Bid Placed", HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>("Bid can not be placed", HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value = "/get/bids/bidder/{bidderId}")
	public ResponseEntity<Iterable<Bid>> getBidsByBidderId(@PathVariable("bidderId") int bidderId) {
		boolean hasBids = bidService.getBidsByBidderId(bidderId).iterator().hasNext();
		if (hasBids)
			return new ResponseEntity<Iterable<Bid>>(bidService.getBidsByBidderId(bidderId), HttpStatus.OK);
		else
			return new ResponseEntity<Iterable<Bid>>(bidService.getBidsByBidderId(bidderId), HttpStatus.NOT_FOUND);
	}
}
