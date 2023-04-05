package edu.kh.yosangso.product.model.dao;

import static edu.kh.yosangso.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.yosangso.product.model.vo.Product;

public class ProductDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	// 기본생성자
	public ProductDAO() {
		try {
			prop = new Properties();
			
			String filePath = ProductDAO.class.getResource("/edu/kh/yosangso/sql/product-sql.xml").getPath();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}

	
/*
	public List<Product> selectProduct(Connection conn, int productNo) throws Exception {
		
		List<Product> list = new ArrayList<Product>();
		
		return null;
	} */

	/** 전제품 조회 DAO
	 * @param conn
	 * @param productNo
	 * @return allProductList
	 */
	/*public List<Product> allProduct(Connection conn, int productNo) throws Exception {
		
		// 결과저장용 변수 선언
		List<Product> allProductList = new ArrayList<>();
		
		try {
			//SQL 얻어오기 (product-sql.xml구문 작성함)
			String sql = prop.getProperty("allProductList");
			
			// 물음표사용해서 PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productNo);
			
			// SQL 수행 결과 (ResultSet) 반환 받기
			rs = pstmt.executeQuery();
			
			//조회결과 얻어와 한 행씩 접근하여
			// Employee 객체 생성 후에 컬럼값 옮겨 담기
			// -> List 추가
			while(rs.next()) {
				Product product = new Product();
				
				product.setProductNo(rs.getInt("PRODUCT_NO"));
				product.setProductName(rs.getString("PRODUCT_NM"));
				product.setPrice(rs.getInt("PRICE"));
				
				allProductList.add(product);		
			}
				
		} finally {
				close(rs);
				close(pstmt);
		}
			
		return allProductList;
	}*/



	public List<Product> allProduct(Connection conn) throws Exception  {
		
		List<Product> allProductList = new ArrayList<>();
		
		try {
			String sql = prop.getProperty("allProudct");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int productNo = rs.getInt("PRODUCT_NO");
				String productName = rs.getString("PRODUCT_NM");
				int price = rs.getInt("PRICE");
				
				allProductList.add(
						new Product(productNo, productName, price));
				
			}
			
		} finally {
			close(rs);
			close(stmt);
		}
		return allProductList;
	}




	
	
	
	
}
