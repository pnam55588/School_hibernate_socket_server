package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import db.MySessionFactory;

public abstract class GenericCRUD<T> {
	protected SessionFactory sessionFactory;
	
	public GenericCRUD() {
		sessionFactory = MySessionFactory.getInstance().getSessionFactory();
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean add(T t) {
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			session.persist(t);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean update(T t) {
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			session.merge(t);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public boolean delete(T t) {
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			session.remove(t);
			tr.commit();
			
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return false;
	}
	
	
	public T find(Class<T> clazz, Object id) {
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			T t = session.find(clazz, id);
			tr.commit();
			
			return t;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
	}
	
	public List<T> getAll(Class<T> clazz) {
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			List<T> list = session
					.createQuery("from " + clazz.getName(), clazz)
					.getResultList();
			tr.commit();
			
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
	}
	
	
	
}
