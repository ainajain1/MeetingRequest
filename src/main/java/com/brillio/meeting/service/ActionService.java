package com.brillio.meeting.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ActionService {

	List<String> getAvailableRooms();

	String bookRoom(int id);

	void cancelRoom(int referenceId);

}
