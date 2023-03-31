package edu.kh.yosangso.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.yosangso.product.model.service.ProductService;

@WebServlet("/product/allProduct")
public class AllProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// 서비스 객체 생성
		ProductService service  = new ProductService();
		
		
		
		
		try {
		
		
		// jsp 요청 위임 객체 생성
		//req.getRequestDispatcher(path).forward(req, resp);
	
	
		String path = "/WEB-INF/views/product/allProduct.jsp";
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
