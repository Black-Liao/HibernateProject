package shiyanlou.test.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import shiyanlou.test.hibernate.entity.User;

public class Test {

	public static void main(String[] args) {

		Configuration con = new Configuration().configure();

		SessionFactory sessionFactory = con.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction taTransaction = session.beginTransaction();

//		add(session);
//		find(session);
//		modify(session);
		delete(session);

		taTransaction.commit();

		session.close();
		sessionFactory.close();

	}

	public static void add(Session session) {
		User user = new User();
		user.setId(2);
		user.setUsername("user2");
		user.setPassword("13579");

		session.save(user);
	}

	public static void delete(Session session) {

		StringBuilder hql = new StringBuilder();
		
		hql.append("from ").append(User.class.getName()).append(" where user_username=:name");
		
		Query<User> query = session.createQuery(hql.toString());
		
		query.setParameter("name", "user1");
		
		List<User> users = query.list();
		
		session.delete(users.get(0));
		
	}

	public static void modify(Session session) {

		StringBuilder hql = new StringBuilder();
		
		hql.append("from ").append(User.class.getName()).append(" where user_username=:name");
		
		Query query = session.createQuery(hql.toString());
		
		query.setParameter("name", "user1");
		
		List<User> users = query.list();
		
		for (User user : users) {
			user.setPassword("987654");
			
			session.update(user);
		}
		
	}

	public static void find(Session session) {

		StringBuilder hql = new StringBuilder();
		
		hql.append("from ").append(User.class.getName());
		
		Query query = session.createQuery(hql.toString());
		
		List<User> list = query.list();
		
		for (User user : list) {
			System.out.println(user.getUsername());
		}
		
	}

}
