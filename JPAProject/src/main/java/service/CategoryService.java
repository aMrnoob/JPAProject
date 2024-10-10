package service;

import java.util.List;

import entity.Category;

public interface CategoryService {
	
	List<String> findAllCategoryId();
	int countCategories();
	List<Category> findAllCategories();
	Category findCategoryById(String categoryId);
	void deleteCategory(String categoryId) throws Exception;
	void updateCategory(Category category);
	void insertCategory(Category category);
}
