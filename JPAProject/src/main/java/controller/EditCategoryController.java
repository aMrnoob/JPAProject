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

@WebServlet(urlPatterns = {"/admin/edit-category"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class EditCategoryController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	CategoryService categoryService = new CategoryServiceImpl();
	Category category = new Category();
	String categoryId;
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		categoryId = request.getParameter("categoryId");
		
		category = categoryService.findCategoryById(categoryId);
		request.setAttribute("category", category);
		
		request.getRequestDispatcher("/views/admin/editCategory.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		category.setCategoryId(categoryId); 
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
				
		if(imageData == null)
		{
			category.setImage(category.getImage());
		} else {
			category.setImage(imageData);
		}
		
		Boolean status = Boolean.parseBoolean(request.getParameter("status")); 
		category.setStatus(status); 
		
		categoryService.updateCategory(category); 
		response.sendRedirect(request.getContextPath() + "/admin/category");
    }
}
