package shiyanlou.hibernate.onetomany.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import shiyanlou.hibernate.onetomany.entity.Group;
import shiyanlou.hibernate.onetomany.entity.User;

public class UserTest {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure();
		
		SessionFactory factory = con.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Group group = new Group();
		
		group.setGroupname("LOL_Group");
		
		Set<User> users = new HashSet<User>();
		
		User user1 = new User();
		
		user1.setUsername("Levis");
		user1.setPassword("1231231");
		
		User user2 = new User();
		
		user2.setUsername("Lee");
		user2.setPassword("32423432");
		
		users.add(user1);
		users.add(user2);
		
		group.setUsers(users);
		
		for (User user : users) {
			session.save(user);
		}
		
		session.save(group);
		
		transaction.commit();
		session.close();
		factory.close();
		
	}
	
}
