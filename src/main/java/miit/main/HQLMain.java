package miit.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import miit.entity.EmployeeSalaryDet;
import miit.utility.HibernateUtilities;

public class HQLMain {

	public static void main(String[] args) {

		// simple HQL query without parameter
		String hquery = "from EmployeeSalaryDet";

		// with static parameter
		String hquery2 = "from EmployeeSalaryDet where emp_name='Ram'";

		// with dynamic parameter
		String hquery3 = "from EmployeeSalaryDet where emp_name =:enm and emp_salary=:esalary";

		Session session = HibernateUtilities.hibernateutil().openSession();
		session.beginTransaction();
		Query query = session.createQuery(hquery3);

		query.setParameter("enm", "Ram");
		query.setParameter("esalary", 10000);

		List<EmployeeSalaryDet> lemp = query.getResultList();

		for (EmployeeSalaryDet emp : lemp) {
			System.out.println(emp.getEmp_name() + " ---  " + emp.getEmp_salary());
		}

		session.getTransaction().commit();
		session.close();

	}

}
