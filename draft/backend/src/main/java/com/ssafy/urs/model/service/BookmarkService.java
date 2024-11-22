package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dto.Bookmark;
import com.ssafy.urs.model.dto.Route;

public interface BookmarkService {
	boolean addBookmark(Bookmark bookmark);
	boolean deleteBookmark(int bookmakrId);
	List<Bookmark> getAllBookmarks(String userId);
}
