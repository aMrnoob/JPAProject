package controller;

import java.io.IOException;
import java.util.List;

import daoImpl.VideoDAOImpl;
import entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/video"})
public class VideoController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private VideoDAOImpl videoDAO = new VideoDAOImpl();
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		List<Video> video = videoDAO.findAllVideo();
		
		request.setAttribute("video", video);	
		request.getRequestDispatcher("/views/admin/video.jsp").forward(request, response);
	}
}	
