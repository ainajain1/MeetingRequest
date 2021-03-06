package com.brillio.meeting.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.brillio.meeting.dao.ActionDao;
import com.brillio.meeting.dao.impl.BookRepository;
import com.brillio.meeting.exception.MeetingException;
import com.brillio.meeting.model.Book;
import com.brillio.meeting.model.Room;
import com.brillio.meeting.service.ActionService;

public class ActionServiceImpl implements ActionService {

	@Autowired
	ActionDao dao;
	
	@Autowired
    private BookRepository bookRepository;

	public List<String> getAvailableRooms() {
		List<Room> rooms = dao.getAvailableRooms();
		List<String> availableRoomDetail = new ArrayList<String>();
		for (Room room : rooms) {
			availableRoomDetail.add(room.getRoomDetail());
		}
		return availableRoomDetail;
	}

	public String bookRoom(int id) throws MeetingException {
		Room room = dao.getRoom(id);

		if (room == null || dao.isRoomBooked(id) != null) {
			throw new MeetingException("FAILURE");
		}
		Book book = new Book(id);
		book.setIsBooked(1);
		return "Booking Id: " + bookRepository.saveAndFlush(book).getId();
	}

	public void cancelRoom(int referenceId) throws MeetingException {
		Book book = dao.getBook(referenceId);
		if (book == null) throw new MeetingException("Not Found.");
		book.setIsBooked(0);
		bookRepository.saveAndFlush(book);
	}

}
