package dao;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Customer;

public class CustomerDao extends GenericCRUD<Customer>{

//	6)  Đếm số đơn hàng của từng khách hàng.
//	+ getOrdersByCustomers() : Map<Customer, Integer>
	
	public Map<Customer, Integer> getOrdersByCustomers(){
		
		Map<Customer, Integer> map = null;
		
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			
			String query = "select [customer_id], n = count(*)\r\n"
					+ "from [dbo].[orders]\r\n"
					+ "group by [customer_id]";
			
			List<Object[]> list = session.createNativeQuery(query, Object[].class)
			.getResultList();
			
			map = list.stream().collect(Collectors.toMap(o -> find(Customer.class, o[0]),  o -> (int)o[1]));
			
			tr.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return map;
	}
	
//	6)  Đếm số đơn hàng của từng khách hàng.
//	+ getOrdersByCustomers() : Map<Customer, Integer>
	public Map<Customer, Integer> getOrdersByCustomers2(){
		
		Map<Customer, Integer> map = new HashMap<Customer, Integer>();
		
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			
			String query = "select [customer_id], n = count(*)\r\n"
					+ "from [dbo].[orders]\r\n"
					+ "group by [customer_id]";
			
			List<Object[]> list = session.createNativeQuery(query, Object[].class)
					.getResultList();
			
			for(Object[] o : list) {
				map.put(find(Customer.class, o[0]), (int)o[1]);
			}
			
			tr.commit();
			return map;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
	}
	
	
//	6-1-1)  Đếm số đơn hàng của từng khách hàng. Sap xep theo first name
//	+ getOrdersByCustomers() : Map<Customer, Integer>
//	Primitive type: 8 + 1 = 9
//	byte, short, int, long, float, double, char, boolean + String
//	Wrapper class: Byte, Short, Integer, Long, Float, Double, Character, Boolean + String
	public Map<Customer, Integer> getOrdersByCustomersSortByName(){
		
//		Comparator<Customer> comparator = new Comparator<Customer>() {
//
//			@Override
//			public int compare(Customer o1, Customer o2) {
//				return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
//			}
//		};
		
//		Comparator<Customer> comparator = (Customer o1, Customer o2) -> {
//				return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
//			};
		
		Comparator<Customer> comparator = (o1, o2) -> {
			return o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
		};
		
		Map<Customer, Integer> map = new TreeMap<Customer, Integer>(comparator);
		
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			
			String query = "select [customer_id], n = count(*)\r\n"
					+ "from [dbo].[orders]\r\n"
					+ "group by [customer_id]";
			
			List<Object[]> list = session.createNativeQuery(query, Object[].class)
					.getResultList();
			
			for(Object[] o : list) {
				map.put(find(Customer.class, o[0]), (int)o[1]);
			}
			
			tr.commit();
			return map;
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return null;
	}
	
//	6-1-2)  Đếm số đơn hàng của từng khách hàng. Sap xep theo first name
//	+ getOrdersByCustomers() : Map<Customer, Integer>
	public Map<Customer, Integer> getOrdersByCustomersSortByName2(){
		
		Map<Customer, Integer> map = null;
		
		Transaction tr = null;
		try(Session session = sessionFactory.openSession();){
			
			tr = session.beginTransaction();
			
			String query = "select [customer_id], n = count(*)\r\n"
					+ "from [dbo].[orders]\r\n"
					+ "group by [customer_id]";
			
			map = session.createNativeQuery(query, Object[].class)
					.getResultList()
					.stream()
					.collect(Collectors.toMap (o -> find(Customer.class, o[0]),
							o -> (int)o[1], 
							(a, b) -> a,
							TreeMap::new));
			
			tr.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		
		return map;
	}
		
//		6-2-1)  Đếm số đơn hàng của từng khách hàng. Sap xep theo tong hoa don
//		+ getOrdersByCustomers() : Map<Customer, Integer>
		
		public Map<Customer, Integer> getOrdersByCustomersSortByNumberOfOrders(){
			
			Map<Customer, Integer> map = new LinkedHashMap<Customer, Integer>();
			
			Transaction tr = null;
			try(Session session = sessionFactory.openSession();){
				tr = session.beginTransaction();
				
				String query = "select [customer_id], n = count(*)\r\n"
						+ "from [dbo].[orders]\r\n"
						+ "group by [customer_id]\r\n"
						+ "order by n desc";
				
				List<Object[]> list = session.createNativeQuery(query, Object[].class).getResultList();
				
				for(Object[] o : list) {
					Customer customer = find(Customer.class, o[0]);
					int n = (int) o[1];
					
					map.put(customer, n);
				}
				
				tr.commit();
				
				return map;
			}catch (Exception e) {
				e.printStackTrace();
				tr.rollback();
			}
			
			return null;
			
		}
		
//		6-2-2)  Đếm số đơn hàng của từng khách hàng. Sap xep theo tong hoa don
//		+ getOrdersByCustomers() : Map<Customer, Integer>
		
		public Map<Customer, Integer> getOrdersByCustomersSortByNumberOfOrders2(){
			
			Map<Customer, Integer> map = null;
			
			Transaction tr = null;
			try(Session session = sessionFactory.openSession();){
				tr = session.beginTransaction();
				
				String query = "select [customer_id], n = count(*)\r\n"
						+ "from [dbo].[orders]\r\n"
						+ "group by [customer_id]\r\n"
						+ "order by n desc";
				
				map = session.createNativeQuery(query, Object[].class)
				.getResultList()
				.stream()
				.collect(Collectors.toMap(
						o -> find(Customer.class, o[0]),
						o -> (int)o[1],
						(a, b) -> a, 
						LinkedHashMap::new));
				
				tr.commit();
				
				return map;
			}catch (Exception e) {
				e.printStackTrace();
				tr.rollback();
			}
			
			return map;
		}	
}



