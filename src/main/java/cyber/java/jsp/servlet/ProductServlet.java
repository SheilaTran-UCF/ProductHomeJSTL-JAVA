package cyber.java.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cyber.java.jsp.controller.ProductController;

import cyber.java.jsp.model.Product;
import cyber.java.jsp.util.PathUtils;
import cyber.java.jsp.util.UrlUtils;

@WebServlet(name = "customerServlet", urlPatterns =

{ UrlUtils.PRODUCT_DASHBOARD, 
		UrlUtils.PRODUCT_ADD, 
		UrlUtils.PRODUCT_UPDATE,
		UrlUtils.PRODUCT_DELETE })
public class ProductServlet extends HttpServlet {
	private ProductController controller;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

//		System.out.printf("\n---->>> %s has been accessd", path);

		switch (path) {

		case UrlUtils.PRODUCT_DASHBOARD:
			List<Product> products = controller.findAllProducts();
			req.setAttribute("products", products);
			
			req.getRequestDispatcher(PathUtils.PRODUCT_DASHBOARD)
			.forward(req, resp);
			break;

		case UrlUtils.PRODUCT_ADD:
			req.getRequestDispatcher(PathUtils.PRODUCT_ADD).forward(req, resp);
			break;

		case UrlUtils.PRODUCT_UPDATE:
			String codeToUpdate = req.getParameter("code");
			Product productToUpdate = controller.findProductByCode(codeToUpdate);
			req.setAttribute("customer", productToUpdate);

			req.getRequestDispatcher(PathUtils.PRODUCT_UPDATE).forward(req, resp);
			break;

		case UrlUtils.PRODUCT_DELETE:
			String codeToBeDeleted = req.getParameter("code");

			if (codeToBeDeleted != null)
				controller.deleteProductByCode(codeToBeDeleted);

			List<Product> updateProductList = controller.findAllProducts() ;
			req.setAttribute("products", updateProductList);

			resp.sendRedirect(req.getContextPath() + UrlUtils.PRODUCT_DASHBOARD);
			break;

		default:
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlUtils.PRODUCT_ADD:
			Product newProduct = new Product();
			newProduct.setCode(req.getParameter("code"));
			newProduct.setName(req.getParameter("name"));
			newProduct.setQuantity(req.getParameter("quantity"));
			newProduct.setPrice(req.getParameter("price"));

			controller.addNewProduct(newProduct);
			resp.sendRedirect(req.getContextPath() + UrlUtils.PRODUCT_DASHBOARD);

			break;
		case UrlUtils.PRODUCT_UPDATE:
			String codeToUpdate = req.getParameter("code");
			Product customerToUpdate = controller.findProductByCode(codeToUpdate);

			customerToUpdate.setName(req.getParameter("name"));
			customerToUpdate.setQuantity(req.getParameter("quantity"));
			customerToUpdate.setPrice(req.getParameter("price"));

			controller.update(customerToUpdate, codeToUpdate);
			resp.sendRedirect(req.getContextPath() + UrlUtils.PRODUCT_DASHBOARD);
			break;
		}

	}

	

	@Override
	public void init() throws ServletException {

		super.init();
		controller = new ProductController();
	}

}
