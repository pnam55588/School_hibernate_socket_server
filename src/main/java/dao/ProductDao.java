package dao;

import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Product;

public class ProductDao extends GenericCRUD<Product>{

//	7)  Tính tổng số lượng của từng sản phẩm đã bán ra.
//	+ getTotalProduct(): Map<Product, Integer>
	public Map<Product, Integer> getTotalProduct () {
		
		Map<Product, Integer> map = null;
		
		Transaction tr = null;
		
		try(Session session = sessionFactory.openSession();){
			
			 tr = session.beginTransaction();
			 
			 String query = "select [product_id], total = sum([quantity]) from [dbo].[order_items]\r\n"
			 		+ "group by [product_id]";
			 
			 map = session.createNativeQuery(query, Object[].class)
			 .getResultList()
			 .stream()
			 .collect(Collectors.toMap(o -> find(Product.class, o[0]), o -> (int) o[1]));

			 tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return map;
	}
	
}
