package cyber.java.jsp.controller;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


import cyber.java.jsp.model.Product;




public class ProductController {
	private List<Product> products;

	 public ProductController() {
		// TODO Auto-generated constructor stub
	
		products = new LinkedList<Product>();
		
		products.add(new Product("PRO 001", "VIP PRODUCT", "2000", "50.50"));
		products.add(new Product("PRO 002", "VIP PRODUCT", "2005", "50.52"));
		products.add(new Product("PRO 003", "VIP PRODUCT", "2010", "50.53"));
		products.add(new Product("PRO 004", "VIP PRODUCT", "2020", "50.54"));
		products.add(new Product("PRO 005", "VIP PRODUCT", "2030", "50.58"));
		products.add(new Product("PRO 006", "VIP PRODUCT", "2008", "50.60"));
		products.add(new Product("PRO 007", "VIP PRODUCT", "2009", "50.55"));
		products.add(new Product("PRO 008", "VIP PRODUCT", "2025", "50.20"));
		products.add(new Product("PRO 009", "VIP PRODUCT", "2050", "50.35"));
		
	}
	 public List<Product> findAllProducts() {
			return products;
		}

	public Product findProductByCode(String code) {
		if (code == null || code.equals(""))
			return null;

		for (Product pro : products) {
			if (pro.getCode().equals(code))
				return pro;
		}
		return null;
	}

	public void deleteProductByCode(String code) {
		if (code == null || code.equals(""))
			return;
		for (Product pro : products) {
			if (!pro.getCode().equals(code))
				continue;

			products.remove(pro);
			return;
		}

	}

	public void addNewProduct(Product product) {
		if (product.getCode() == null || product.getCode().equals(""))

			return;

		for (Product pro : products) {
			if (!pro.getCode().equals(product.getCode()))
				continue;

			return;
		}
		products.add(product);
	}
	public void update(Product productToUpdate, String codeToUpdate) {
		for(int i =0; i<products.size(); i++) {
			if(!products.get(i).getCode().equals(codeToUpdate))
				continue;
			
			productToUpdate.setCode(codeToUpdate);
			products.set(i, productToUpdate);
		}
		
	}
}