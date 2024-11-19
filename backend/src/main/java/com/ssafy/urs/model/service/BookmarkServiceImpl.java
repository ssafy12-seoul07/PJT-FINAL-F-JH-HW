package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dao.BookmarkDao;
import com.ssafy.urs.model.dto.Route;

public class BookmarkServiceImpl implements BookmarkService {
	private final BookmarkDao bd;
	
	public BookmarkServiceImpl(BookmarkDao bd) {
		this.bd=bd;
	}

	@Override
	public boolean addBookmark(Route route) {
		int result=bd.insertBookmark(route);
		return result>0;
	}

	@Override
	public List<Route> getAllBookmarks(int userId) {
		return bd.selectAllBookmarks(userId);
	}

	@Override
	public boolean deleteBookmark(int routeId) {
		int result=bd.deleteBookmark(routeId);
		return result>0;
	}
	
	
	
}
