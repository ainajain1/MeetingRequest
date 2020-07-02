package com.brillio.meeting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brillio.meeting.exception.MeetingException;

@Service
public interface ActionService {

	List<String> getAvailableRooms();

	String bookRoom(int id) throws MeetingException;

	void cancelRoom(int referenceId) throws MeetingException;

}
