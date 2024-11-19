package com.ssafy.urs.model.service;

import java.util.List;

import com.ssafy.urs.model.dto.Route;

public interface BookmarkService {
	boolean addBookmark(Route route);
	List<Route> getAllBookmarks(int userId);
	boolean deleteBookmark(int routeId);
}
