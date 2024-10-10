package controller;

import java.io.IOException;
import java.io.InputStream;

import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.CategoryService;
import serviceImpl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/add-category"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class AddCategoryController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	CategoryService categoryService = new CategoryServiceImpl();
	Category category = new Category();
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		request.getRequestDispatcher("/views/admin/addVideo.jsp").forward(request, response);	 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		category.setCategoryId(request.getParameter("categoryId")); 
		category.setCategoryName(request.getParameter("categoryName")); 
		
		Part imagePart = request.getPart("image"); 
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
		
		category.setImage(imageData);
		
		Boolean status = Boolean.parseBoolean(request.getParameter("status")); 
		category.setStatus(status); 
		
		categoryService.insertCategory(category); 
		request.setAttribute("message", "Thêm doanh mục sản phẩm thành công!");
		
		request.getRequestDispatcher("/views/admin/addCategory.jsp").forward(request, response);
    }
}
