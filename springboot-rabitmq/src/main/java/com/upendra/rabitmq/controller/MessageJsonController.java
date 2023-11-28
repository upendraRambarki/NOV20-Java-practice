package com.upendra.rabitmq.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.rabitmq.dto.User;
import com.upendra.rabitmq.producer.RabbitMQJsonProducer;

@RestController
@RequestMapping("rabit")

public class MessageJsonController {
	 private RabbitMQJsonProducer jsonProducer;

	    public MessageJsonController(RabbitMQJsonProducer jsonProducer) {
	        this.jsonProducer = jsonProducer;
	    }

	    @PostMapping("/publish")
	    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
	        jsonProducer.sendJsonMessage(user);
	        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
	    }
}
