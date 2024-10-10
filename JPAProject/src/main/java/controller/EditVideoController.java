package controller;

import java.io.IOException;
import java.io.InputStream;

import entity.Category;
import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.CategoryService;
import service.VideoService;
import serviceImpl.CategoryServiceImpl;
import serviceImpl.VideoServiceImpl;

@WebServlet(urlPatterns = {"/admin/edit-video"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditVideoController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	VideoService videoService = new VideoServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();
	Video video = new Video();
	String videoId;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		videoId = request.getParameter("videoId");
		
		video = videoService.findVideoById(videoId);
		request.setAttribute("video", video);
		
		request.getRequestDispatcher("/views/admin/editVideo.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		video.setVideoId(videoId);
		
		String categoryId = request.getParameter("categoryId");
	    Category category = categoryService.findCategoryById(categoryId);
		
	    video.setCategory(category);
	    video.setTitle(request.getParameter("title"));
	    video.setDescription(request.getParameter("description"));
	    
	    String viewStr = request.getParameter("view");
	    int viewCount = 0;
	    if (viewStr != null && !viewStr.isEmpty()) {
	        try {
	            viewCount = Integer.parseInt(viewStr);
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	            request.setAttribute("message", "Lượt xem không hợp lệ!");
	            request.getRequestDispatcher("/views/admin/editVideo.jsp").forward(request, response);
	            return;
	        }
	    }
	    video.setViews(viewCount);
	    
	    Part imagePart = request.getPart("poster"); 
		byte[] imageData = null; 
		if(imagePart != null && imagePart.getSize() > 0) { 
			try (InputStream inputStream = imagePart.getInputStream()) { 
				
				imageData = new byte[(int)
				imagePart.getSize()]; 
				inputStream.read(imageData); 
			} 
			catch (IOException e) {
			    e.printStackTrace(); 
			    return;
			} 				
		}
		
		if(imageData == null) {
			video.setPoster(video.getPoster());
		} else {
			video.setPoster(imageData);
		}
	    
	    Boolean active = Boolean.parseBoolean(request.getParameter("active"));
	    video.setActive(active);

	    videoService.updateVideo(video);
	    
	    request.getRequestDispatcher("/views/admin/video.jsp").forward(request, response);
    }
}
