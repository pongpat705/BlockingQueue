package com.maoz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {
	
	@Autowired private StartUp startUp;
	
	@RequestMapping("/queue/add")
	public ResponseEntity<Object> addQueue(@RequestParam(required=true, name="number") Integer number){
		startUp.addQueue(number);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/block")
	public String block(){

		return "block";
	}

}
