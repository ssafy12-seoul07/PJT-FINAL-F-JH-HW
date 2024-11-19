package com.ssafy.urs.model.dao;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.urs.model.dto.Route;

public interface BookmarkDao {
	//bookmarked
	//북마크 추가
	int insertBookmark(Route route);
	//북마크 전체읽기
	List<Route> selectAllBookmarks(int userId);
	// 북마크 삭제
	int deleteBookmark(int routeId);
	
	//completed
	//장소유형이 매개변수..라서 이거는 mapper 쓸 때 한번 더 보자
    // boolean updateLocationCheck(boolean isChecked, int routeId, String userId, String locationType);
	// 근데 이거는 프론트의 영역인것같아.."?
		//리뷰로 가져가도되겠다!
	
	
    
//	
	
}
