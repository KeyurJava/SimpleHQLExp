package miit.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import miit.entity.EmployeeSalaryDet;

public class HibernateUtilities {

	public static SessionFactory hibernateutil() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(EmployeeSalaryDet.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		return sessionFactory;
	}

}
