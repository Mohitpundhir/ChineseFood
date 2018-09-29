package com.ChineseFood.Backend.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ChineseFood.Backend.model.Product;
@Transactional
@Repository
public class ProductRepoImpl implements ProductRepository{
	
		@Autowired
		private SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.save(product);
			return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
		return false;
		}
	}

	public boolean updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		try 
		{
		  session.update(product);
		  return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteProduct(int productId) {
		Session session=sessionFactory.getCurrentSession();
		try{
		session.delete(getProductId(productId));
		return true;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public List<Product> getAllProduct() {
		Session session=sessionFactory.getCurrentSession();
		try{
		Query query=session.createQuery("from Product");
		List<Product> productList=(List<Product>)query.getResultList();
		return productList;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
		
		}

	public Product getProductId(int productId) {
		Session session=sessionFactory.getCurrentSession();
		try{
	    Product product=(Product)session.get(Product.class,productId);
		return product;
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public List<Product> getAllProducts(int categoryId) {
		
		Session session=sessionFactory.getCurrentSession();
		try{
			System.out.println(categoryId);
			Query query=session.createQuery("from Product where categoryId=:catid");
			query.setParameter("catid",categoryId);
			List<Product> productList=(List<Product>)query.getResultList();
			for(Product p:productList)
			{
				System.out.println(p.getCategoryId()+" "+p.getProductDesc());
				
			}
			
			
			
			return productList;
			}
			catch(HibernateException e)
			{
				e.printStackTrace();
				return null;
			}
			
		
		
		
		
	}

}
