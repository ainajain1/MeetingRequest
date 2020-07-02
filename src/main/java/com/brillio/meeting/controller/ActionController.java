package com.brillio.meeting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brillio.meeting.exception.MeetingException;
import com.brillio.meeting.service.ActionService;

@RestController
@RequestMapping("/meeting")
public class ActionController {

	@Autowired
	ActionService service;

	@GetMapping("/available-rooms")
	public ResponseEntity<List<String>> getAvailableRooms() {
		return new ResponseEntity<List<String>>(service.getAvailableRooms(), HttpStatus.OK);
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> bookRoom(@RequestParam("id") int id) throws MeetingException {
		return new ResponseEntity<String>(service.bookRoom(id), HttpStatus.OK);
	}
	
	@PatchMapping("/cancel")
	public ResponseEntity<String> cancelRoom(@RequestParam("booking_id") int referenceId) throws MeetingException {
		service.cancelRoom(referenceId);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
