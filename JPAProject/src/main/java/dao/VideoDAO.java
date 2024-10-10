package dao;

import java.util.List;

import entity.Video;

public interface VideoDAO {
	
	int countVideo();
	List<Video> findAllVideo();
	Video findVideoById(String videoId);
	void deleteVideo(String videoId) throws Exception;
	void updateVideo(Video video);
	void insertVideo(Video video);
}
