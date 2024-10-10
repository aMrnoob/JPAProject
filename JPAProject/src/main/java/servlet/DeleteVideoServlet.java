package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.VideoService;
import serviceImpl.VideoServiceImpl;

@WebServlet(urlPatterns = {"/admin/delete-video"})
public class DeleteVideoServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	VideoService videoService = new VideoServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String videoId = request.getParameter("videoId");
		  
		try {
			videoService.deleteVideo(videoId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		request.setAttribute("message", "Xóa video thành công!");
		
		response.sendRedirect(request.getContextPath() + "/admin/video");
    }
}	
