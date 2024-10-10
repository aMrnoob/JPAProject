package controller;

import java.io.IOException;
import java.util.List;

import daoImpl.CategoryDAOImpl;
import entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/admin/category"})
public class CategoryController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
	
	@Override
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
		List<Category> categories = categoryDAO.findAllCategories();
		
		request.setAttribute("categories", categories);	
		request.getRequestDispatcher("/views/admin/category.jsp").forward(request, response);
	}
}
