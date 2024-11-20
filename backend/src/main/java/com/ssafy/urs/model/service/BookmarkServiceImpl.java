package com.ssafy.urs.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.urs.model.dao.BookmarkDao;
import com.ssafy.urs.model.dto.Bookmark;
import com.ssafy.urs.model.dto.Route;

@Service
public class BookmarkServiceImpl implements BookmarkService {
	private final BookmarkDao bd;
	
	public BookmarkServiceImpl(BookmarkDao bd) {
		this.bd=bd;
	}

	@Override
	public boolean addBookmark(Bookmark bookmark) {
		int result=bd.insertBookmark(bookmark);
		return result>0;
	}

	@Override
	public List<Bookmark> getAllBookmarks(String userId) {
		return bd.selectAllBookmarks(userId);
	}

	@Override
	public boolean deleteBookmark(int bookmarkId) {
		int result=bd.deleteBookmark(bookmarkId);
		return result>0;
	}
	
	
	
}
