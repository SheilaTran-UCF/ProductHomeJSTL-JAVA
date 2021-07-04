package cyber.java.jsp.model;

public class Product {
	private String code;
	private String name;
	private String quantity;
	private String price;

	public Product() {

	}

	public Product(String code, String name, String quantity, String price) {
		this.code = code;
		this.name = name;
		this.quantity = quantity;
		this.price = price;

	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

}
