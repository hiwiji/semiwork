package edu.kh.yosangso.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.yosangso.product.model.service.ProductService;
import edu.kh.yosangso.product.model.vo.Product;





@WebServlet("/product/listtest")
public class AllProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어와 변수 저장하기
		
		ProductService service = new ProductService();
		
		
		try {
			
			List<Product> allProductList = service.allProudct();
			
			req.setAttribute("allProductList", allProductList);
			
			RequestDispatcher dispatcher
			= req.getRequestDispatcher("/WEB-INF/views/product/listtest.jsp");
			
			dispatcher.forward(req, resp);
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		
		System.out.println(service);
	}
}
