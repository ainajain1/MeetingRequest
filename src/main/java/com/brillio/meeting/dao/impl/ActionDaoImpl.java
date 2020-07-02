package com.brillio.meeting.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brillio.meeting.dao.ActionDao;
import com.brillio.meeting.model.Book;
import com.brillio.meeting.model.Room;

@Repository
public class ActionDaoImpl implements ActionDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Room> getAvailableRooms() {
		SQLQuery query = sessionFactory.openSession().createSQLQuery("select * from room where id NOT IN(select room_id from book where is_booked=1)");
		query.addEntity(Room.class);
		return query.list();
	}

	public Room getRoom(int id) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Room.class)
				.add(Restrictions.eq("id", id));
		List list = criteria.list();
		if (list == null || list.isEmpty())
			return null;
		return (Room) criteria.list().get(0);
	}

	public int bookRoom(int roomId) {
		Book book = new Book(roomId);
		book.setIsBooked(1);
		sessionFactory.openSession().save(book);
		sessionFactory.close();
		return book.getId();
	}

	public void update(Object object) {
		sessionFactory.openSession().update(object);
	}

	public Book getBook(int referenceId) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Book.class)
				.add(Restrictions.eq("id", referenceId)).add(Restrictions.eq("isBooked", 1));
		List list = criteria.list();
		if (list == null || list.isEmpty())
			return null;
		return (Book) criteria.list().get(0);
	}
	
	public Book isRoomBooked(int roomId) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Book.class)
				.add(Restrictions.eq("roomId", roomId)).add(Restrictions.eq("isBooked", 1));
		List list = criteria.list();
		if (list == null || list.isEmpty())
			return null;
		return (Book) criteria.list().get(0);
	}

}
