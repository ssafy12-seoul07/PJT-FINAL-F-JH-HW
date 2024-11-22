package com.ssafy.urs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.urs.model.dto.Bookmark;
import com.ssafy.urs.model.service.BookmarkService;

@RestController
@RequestMapping("/urs/bookmark")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true") // 프론트엔드 도메인

public class BookmarkRestController {

	@Autowired
	BookmarkService bs;
	
	@PostMapping("/add")
	public ResponseEntity<String> addBookmark(@RequestBody Bookmark bookmark){
		boolean result = bs.addBookmark(bookmark);
		if(result) {
			return new ResponseEntity<String>("bookmark successfully added", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("something went wrong", HttpStatus.NOT_IMPLEMENTED);
		}	
	}
	
	//북마크제거
	@DeleteMapping("/delete/{bookmarkId}")
	public ResponseEntity<String> deleteBookmark(@PathVariable int bookmarkId){
		if(bs.deleteBookmark(bookmarkId)) {
			return new ResponseEntity<>("bookmark successfully cancled", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("something went wrong", HttpStatus.NOT_IMPLEMENTED);
		}
	}
	
	//북마크보기
	@GetMapping("/{userId}")
	public <T> ResponseEntity<T> getBookmarkById(@PathVariable String userId){
		List<Bookmark> bookmark = bs.getAllBookmarks(userId);
		if(bookmark ==null) {
			return (ResponseEntity<T>) new ResponseEntity<String>("bookmark is empty", HttpStatus.NOT_IMPLEMENTED);
		} else {
			return (ResponseEntity<T>) new ResponseEntity<List<Bookmark>>(bookmark, HttpStatus.OK);
		}
	}
	
}
