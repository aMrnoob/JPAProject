package serviceImpl;

import java.util.List;

import dao.CategoryDAO;
import daoImpl.CategoryDAOImpl;
import entity.Category;
import service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	CategoryDAO categoryDAO = new CategoryDAOImpl();
		
	@Override
	public void insertCategory(Category category) {
		categoryDAO.insertCategory(category);
	}

	@Override
	public void updateCategory(Category category) {
		categoryDAO.updateCategory(category);
	}

	@Override
	public void deleteCategory(String categoryId) throws Exception {
		try {
			categoryDAO.deleteCategory(categoryId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Category findCategoryById(String categoryId) {
		return categoryDAO.findCategoryById(categoryId);
	}

	@Override
	public int countCategories() {
		return categoryDAO.countCategories();
	}

	@Override
	public List<Category> findAllCategories() {
		return categoryDAO.findAllCategories();
	}

	@Override
	public List<String> findAllCategoryId() {
		return categoryDAO.findAllCategoryId();
	}

}
