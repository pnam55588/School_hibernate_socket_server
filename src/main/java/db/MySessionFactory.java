package db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entity.Address;
import entity.Brand;
import entity.Category;
import entity.Contact;
import entity.Customer;
import entity.Order;
import entity.OrderItem;
import entity.Person;
import entity.Product;
import entity.Staff;
import entity.Stock;
import entity.Store;

public class MySessionFactory {
	private static MySessionFactory instance;
	private SessionFactory sessionFactory;

	private MySessionFactory() {

		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();

		Metadata metadata = new MetadataSources(standardRegistry)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Brand.class)
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Contact.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class)
				.addAnnotatedClass(OrderItem.class)
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Staff.class)
				.addAnnotatedClass(Stock.class)
				.addAnnotatedClass(Store.class)
				.getMetadataBuilder()
				.build();

		sessionFactory = metadata
				.getSessionFactoryBuilder()
				.build();

	}

	public static MySessionFactory getInstance() {
		if(instance == null)
			instance = new MySessionFactory();
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
