package com.brillio.meeting.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.brillio.meeting.model.Book;
import com.brillio.meeting.model.Room;

@Transactional
public interface ActionDao {

	List<Room> getAvailableRooms();

	int bookRoom(int roomId);
	
	Room getRoom(int id);

	void update(Object object);

	Book getBook(int referenceId);

	Book isRoomBooked(int id);

}
