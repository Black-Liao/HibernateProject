package shiyanlou.hibernate.hql.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import shiyanlou.hibernate.hql.entity.User;

public class UserTest {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure();
		
		SessionFactory factory = con.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from User");
		
		List<User> users = query.list();
		
		for (User user : users) {
			System.out.println(user);
		}
		
		transaction.commit();
		session.close();
		factory.close();
		
	}
	
}
