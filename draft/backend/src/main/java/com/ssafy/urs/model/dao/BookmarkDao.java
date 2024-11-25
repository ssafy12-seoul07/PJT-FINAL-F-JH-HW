package com.ssafy.urs.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.urs.model.dto.Bookmark;
import com.ssafy.urs.model.dto.Location;
import com.ssafy.urs.model.dto.Route;

@Mapper
public interface BookmarkDao {
	//bookmarked
	//북마크 추가
	int insertBookmark(String userId, int routeId);
	//북마크 전체읽기
	List<Location> selectAllBookmarks(String userId);
	// 북마크 삭제
	int deleteBookmark(String userId, int routeId);
	
	
    
//	
	
}
