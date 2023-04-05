package edu.kh.yosangso.product.model.service;

import static edu.kh.yosangso.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.List;

import edu.kh.yosangso.product.model.dao.ProductDAO;
import edu.kh.yosangso.product.model.vo.Product;

public class ProductService {

	private ProductDAO dao = new ProductDAO();

	/** 상품 정보 service
	 * @return
	 */
	public List<Product> selectProduct(int productNo) throws Exception {
		Connection conn = getConnection();
		
		List<Product> list = dao.selectProduct(conn, productNo);
		
		close(conn);
		
		return list;
	}

	/** 전제품 조회 service
	 * @param productNo
	 * @return allProductList
	 */
	/*public List<Product> allProduct(int productNo)throws Exception {
		
		Connection conn = getConnection();
		
		List<Product> allProductList = dao.allProduct(conn, productNo);
		
		close(conn);
		
		return allProductList;
	}*/

	public List<Product> allProudct() throws Exception {
		
		Connection conn = getConnection();
		
		List<Product> allProductList = dao.allProduct(conn);
		
		close(conn);
	
		
		return allProductList;
	}


	
	
	
	
	
	
	
	
	
	
	
}
