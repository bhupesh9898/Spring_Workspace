package com.zensar.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Bid;
import com.zensar.model.User;
import com.zensar.service.BidService;
import com.zensar.util.CustomResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BidResource {

	@Autowired
	private BidService bidService;

	@GetMapping(value = "/bid/history/{productId}")
	public CustomResponse bidHistory(@PathVariable("productId") int productId) {
		if (User.session != null && User.session.getUserProfile().equalsIgnoreCase("Bidder")) {
			boolean hasBids = bidService.bidHistory(productId).iterator().hasNext();
			if (hasBids)
				return new CustomResponse(HttpStatus.OK.value(),
						"Here is the List of Bid History Placed on " + productId);
			else
				return new CustomResponse(HttpStatus.NOT_FOUND.value(), "No Bids Placed On this Product");
		} else {
			return new CustomResponse(HttpStatus.UNAUTHORIZED.value(), "Not a Registered Email Id");
		}
	}

	@PostMapping(value = "/place/bid")
	public CustomResponse placeBid(@RequestBody Bid bid) {
		bid.setUser(User.session);
		System.out.println("\n\n\n\n "+User.session);
		if (User.session != null && User.session.getUserProfile().equalsIgnoreCase("Bidder")) {
			int result = bidService.placeBid(bid);
			if (result == 100)
				return new CustomResponse(HttpStatus.ACCEPTED.value(), " Bid Placed Successfully");
			else
				return new CustomResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Please Increase the Bid Amount");
		} else {
			return new CustomResponse(HttpStatus.UNAUTHORIZED.value(), " You are Not a Registered Bidder");
		}
	}

	@RequestMapping(value = "/get/bids/bidder/{bidderId}")
	public CustomResponse getBidsByBidderId(@PathVariable("bidderId") int bidderId) {
		if (User.session != null && User.session.getUserProfile().equalsIgnoreCase("Bidder")) {
			boolean hasBids = bidService.getBidsByBidderId(bidderId).iterator().hasNext();
			if (hasBids)
				return new CustomResponse(HttpStatus.OK.value(), "Here is the List of Bids Placed By You");
			else
				return new CustomResponse(HttpStatus.NOT_FOUND.value(), "No Bids Placed By You");
		} else {
			return new CustomResponse(HttpStatus.UNAUTHORIZED.value(), "You are Not a Registered Bidder");
		}
	}
}
