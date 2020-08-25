package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDAO departmentDao = DAOFactory.createDepartmentDAO();

		System.out.println("=== TEST 1: seller findById ===");

		Department depart = departmentDao.findById(3);

		System.out.println(depart);


		System.out.println("\n=== TEST 2: seller findAll ===");

		List<Department> departments = departmentDao.findAll();

		for (Department department : departments) {
			System.out.println(department);
		}

		System.out.println("\n=== TEST 4: seller insert ===");

		Department otherDepartment = new Department(null, "Food");

		departmentDao.insert(otherDepartment);
		System.out.println("New Seller ID: " + otherDepartment.getId());

		System.out.println("\n=== TEST 5: seller update ===");

		depart = departmentDao.findById(11);
		depart.setName("Computers");
		
		departmentDao.update(depart);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		
		System.out.println("Enter a ID");
		
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		System.out.println("Deleted!");
		
		sc.close();

	}

}
