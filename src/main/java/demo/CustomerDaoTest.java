package demo;

import dao.CustomerDao;

public class CustomerDaoTest {
	public static void main(String[] args) {
		
		CustomerDao customerDao = new CustomerDao();
//		Customer cus = customerDao.find(Customer.class, 1);
//		
//		System.out.println(cus);
		
//		customerDao.getOrdersByCustomers()
//		.entrySet()
//		.forEach(entry -> {
//			System.out.println("Customer: " + entry.getKey());
//			System.out.println("Number of orders: " + entry.getValue());
//			System.out.println("======");
//		});
		
		customerDao.getOrdersByCustomersSortByName2()
		.entrySet()
		.forEach(entry -> {
			System.out.println("Customer: " + entry.getKey());
			System.out.println("Number of orders: " + entry.getValue());
			System.out.println("======");
		});
		
	}
}
