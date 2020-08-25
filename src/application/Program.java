package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDAO sellerDao = DAOFactory.createSellerDAO();

		System.out.println("=== TEST 1: seller findById ===");

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment ===");

		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);

		for (Seller newSeller : sellers) {
			System.out.println(newSeller);
		}

		System.out.println("\n=== TEST 3: seller findAll ===");

		sellers = sellerDao.findAll();

		for (Seller newSeller : sellers) {
			System.out.println(newSeller);
		}

		System.out.println("\n=== TEST 4: seller insert ===");

		Seller otherSeller = new Seller(null, "Grag", "grag@gmail.com", new Date(), 4000.00, department);

		sellerDao.insert(otherSeller);
		System.out.println("New Seller ID: " + otherSeller.getId());

		System.out.println("\n=== TEST 5: seller update ===");

		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 6: seller delete ===");
		
		System.out.println("Enter a ID");
		
		int id = sc.nextInt();
		
		sellerDao.deleteById(id);
		System.out.println("Deleted!");
		
		sc.close();
	}

}
