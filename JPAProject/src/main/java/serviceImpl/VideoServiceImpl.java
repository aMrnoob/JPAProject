package serviceImpl;

import java.util.List;

import dao.VideoDAO;
import daoImpl.VideoDAOImpl;
import entity.Video;
import service.VideoService;

public class VideoServiceImpl implements VideoService{

	VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    public int countVideo() {
        return videoDAO.countVideo(); 
    }

    @Override
    public List<Video> findAllVideo() {
        return videoDAO.findAllVideo();
    }

    @Override
    public Video findVideoById(String videoId) {
        return videoDAO.findVideoById(videoId); 
    }

    @Override
    public void deleteVideo(String videoId) throws Exception {
        try {
            videoDAO.deleteVideo(videoId); 
        } catch (Exception e) {
            e.printStackTrace(); 
            throw e; 
        }
    }

    @Override
    public void updateVideo(Video video) {
        videoDAO.updateVideo(video);
    }

    @Override
    public void insertVideo(Video video) {
        videoDAO.insertVideo(video); 
    }
}
