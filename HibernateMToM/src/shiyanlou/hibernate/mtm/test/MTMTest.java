package shiyanlou.hibernate.mtm.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import shiyanlou.hibernate.mtm.entity.Course;
import shiyanlou.hibernate.mtm.entity.Student;

public class MTMTest {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure();
		
		SessionFactory factory = con.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Set<Course> courses = new HashSet<>();
		
		Course cou1 = new Course();
		cou1.setCourseName("Chinese");
		
		Course cou2 = new Course();
		cou2.setCourseName("English");

		Course cou3 = new Course();
		cou3.setCourseName("Math");
		
		courses.add(cou1);
		courses.add(cou2);
		courses.add(cou3);
		
		Set<Student> students = new HashSet<Student>();
        Student s1 = new Student();
        s1.setStudentName("Michael");
        Student s2 = new Student();
        s2.setStudentName("KangKang");
        Student s3 = new Student();
        s3.setStudentName("Jane");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        
        cou1.setStudents(students);
        cou2.setStudents(students);
        cou3.setStudents(students);
        
        s1.setCourses(courses);
        s2.setCourses(courses);
        s3.setCourses(courses);
        
        session.save(cou1);
        session.save(cou2);
        session.save(cou3);
        
        transaction.commit();
        session.close();
        factory.close();
        
	}
	
}
