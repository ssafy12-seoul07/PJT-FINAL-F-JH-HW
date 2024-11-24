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
	int insertBookmark(Bookmark bookmark);
	//북마크 전체읽기
	List<Location> selectAllBookmarks(String userId);
	// 북마크 삭제
	int deleteBookmark(String userId, int routeId);
	
	//completed
	//장소유형이 매개변수..라서 이거는 mapper 쓸 때 한번 더 보자
    // boolean updateLocationCheck(boolean isChecked, int routeId, String userId, String locationType);
	// 근데 이거는 프론트의 영역인것같아.."?
		//리뷰로 가져가도되겠다!
	
	
    
//	
	
}
