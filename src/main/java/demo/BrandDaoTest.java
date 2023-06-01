package demo;

import dao.BrandDao;
import entity.Brand;

public class BrandDaoTest {
	public static void main(String[] args) {
		
		BrandDao brandDao = new BrandDao();
		
		Brand b = null;
//		boolean addRs = brandDao.add(b = new Brand("sdfsdfsd"));
//		System.out.println(addRs);
		
		b = brandDao.find(Brand.class, 12);
		
		b.setName("Bike");
		
		boolean updateRs = brandDao.update(b);
		System.out.println(updateRs);
		
		boolean deleteRs = brandDao.delete(b);
		System.out.println(deleteRs);
		
		brandDao.getAll(Brand.class)
		.forEach(br -> System.out.println(br));
		
		
		
	}
}
