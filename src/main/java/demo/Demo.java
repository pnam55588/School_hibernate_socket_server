package demo;

import db.MySessionFactory;

public class Demo {
	public static void main(String[] args) {
		MySessionFactory.getInstance().getSessionFactory();
		
	}
}
