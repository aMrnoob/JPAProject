package daoImpl;

import java.util.List;

import config.JPAConfig;
import dao.CategoryDAO;
import entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class CategoryDAOImpl implements CategoryDAO{

	@Override
	public int countCategories() {
		
		EntityManager enma = JPAConfig.getEntityManager();
		String jpql = "SELECT count(c) FROM Category c";
		Query query = enma.createQuery(jpql);
		return ((Long)query.getSingleResult()).intValue();
	}

	@Override
	public List<Category> findAllCategories() {
		
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Category> query= enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

	@Override
	public Category findCategoryById(String categoryId) {
		
		EntityManager enma = JPAConfig.getEntityManager();
		Category category = enma.find(Category.class,categoryId);

		return category;
	}

	@Override
	public void deleteCategory(String categoryId) throws Exception {
		
		EntityManager entityManager = null;
	    EntityTransaction transaction = null;

	    try {
	        entityManager = JPAConfig.getEntityManager();
	        transaction = entityManager.getTransaction(); 
	        transaction.begin(); 

	        Category category = entityManager.find(Category.class, categoryId);

	        if (category != null) {
	            entityManager.remove(category); 
	        } else {
	            throw new Exception("Không tìm thấy danh mục với ID: " + categoryId);
	        }

	        transaction.commit(); 

	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace(); 
	        throw e;

	    } finally {
	        if (entityManager != null) {
	            entityManager.close(); 
	        }
	    }
	}

	@Override
	public void updateCategory(Category category) {
		
		EntityManager entityManager = null;
	    EntityTransaction transaction = null;

	    try {
	        entityManager = JPAConfig.getEntityManager(); 
	        transaction = entityManager.getTransaction(); 
	        transaction.begin(); 

	        entityManager.merge(category);

	        transaction.commit(); 

	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback(); 
	        }
	        e.printStackTrace();
	        throw e;

	    } finally {
	        if (entityManager != null) {
	            entityManager.close(); 
	        }
	    }
	}

	@Override
	public void insertCategory(Category category) {
		EntityManager entityManager = null;
	    EntityTransaction transaction = null;

	    try {
	        entityManager = JPAConfig.getEntityManager();
	        transaction = entityManager.getTransaction(); 
	        transaction.begin(); 

	        
	        entityManager.persist(category);

	        transaction.commit();

	    } catch (Exception e) {
	        if (transaction != null && transaction.isActive()) {
	            transaction.rollback(); 
	        }
	        e.printStackTrace();
	        throw e; 

	    } finally {
	        if (entityManager != null) {
	            entityManager.close(); 
	        }
	    }
	}
	
	@Override
	public List<String> findAllCategoryId() {
		
		EntityManager entityManager = JPAConfig.getEntityManager();
	    String jpql = "SELECT c.categoryId FROM Category c";  
	    TypedQuery<String> query = entityManager.createQuery(jpql, String.class);
	    return query.getResultList();
	}
}
