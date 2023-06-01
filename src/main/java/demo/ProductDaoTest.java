package demo;

import dao.ProductDao;

public class ProductDaoTest {
	public static void main(String[] args) {
		
		ProductDao productDao = new ProductDao();
		
		productDao.getTotalProduct()
		.entrySet()
		.forEach(entry -> {
			System.out.println("Product: " + entry.getKey());
			System.out.println("Total of quantity: " + entry.getValue());
			System.out.println("========");
		});
		
	}
}
