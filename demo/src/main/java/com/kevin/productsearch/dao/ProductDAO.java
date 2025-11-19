package com.kevin.productsearch.dao;

import com.kevin.productsearch.model.Product;
import com.kevin.productsearch.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO {
	private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	
	public List<Product> searchAllFields(String keyword) {
		if (keyword == null) keyword = "";
		String q = "%" + keyword.toLowerCase() + "%";
		String hql = "from Product  where "
				+ "lower(productName) like :q "
				+ "or lower(category) like :q "
				+ "or lower(description) like :q "
				+ "or function('str', price) like :q "
				+ "or function('str', stockQuantity) like :q "
				+ "or function('str', productId) like :q";

		try (Session session = sessionFactory.openSession()) {
			Query<Product> query = session.createQuery(hql, Product.class);
			query.setParameter("q", q);
			return query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return List.of();
		}
	}

	public List<Product> getAllProducts() {
		try (Session session = sessionFactory.openSession()) {
			Query<Product> q = session.createQuery("from Product", Product.class);
			return q.list();
		} catch (Exception e) {
			e.printStackTrace();
			return List.of();
		}
	}

	

}
