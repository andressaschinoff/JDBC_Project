package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDAO sellerDao = DAOFactory.createSellerDAO();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDepartment ===");
		
		Department department = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(department);
		
		for (Seller newSeller: sellers) {
			System.out.println(newSeller);
		}
		
		System.out.println("\n=== TEST : seller findAll ===");
		
		sellers = sellerDao.findAll();
		
		for (Seller newSeller: sellers) {
			System.out.println(newSeller);
		}
	}

}
