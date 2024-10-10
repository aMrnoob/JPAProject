package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;
import serviceImpl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/delete-category"})
public class DeleteCategoryServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	CategoryService categoryService = new CategoryServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		String categoryId = request.getParameter("categoryId");
		  
		try {
			categoryService.deleteCategory(categoryId);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		request.setAttribute("message", "Xóa doanh mục thành công!");
		response.sendRedirect(request.getContextPath() + "/admin/category");
    }
}
