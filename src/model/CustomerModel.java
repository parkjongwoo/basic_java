package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.vo.Customer;

public class CustomerModel {

	Connection con;
	
	public CustomerModel() throws Exception{
		
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "tiger";
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. Connection 연결객체 얻어오기
		
		con = DriverManager.getConnection(url, user, password);
	}
	
	public int insertCustomer(Customer dao) throws Exception{
		// 3. sql 문장 만들기
		// 4. sql 전송객체 (PreparedStatement)		
		// 5. sql 전송
		// 6. 닫기 (PreparedStatement  만 닫기)
		int result = 0;
		String sql = "INSERT INTO v_customer(cpid,cname,cphone,caddr,cmail) VALUES(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dao.getCustTel1().trim());
		ps.setString(2, dao.getCustName().trim());
		ps.setString(3, dao.getCustTel2().trim());
		ps.setString(4, dao.getCustAddr().trim());
		ps.setString(5, dao.getCustEmail().trim());
		
		result = ps.executeUpdate();
		ps.close();
		return result;
	}
	
	public ArrayList<Customer> selectByTel(String tel) throws Exception{
		Customer dao;
		ArrayList<Customer> list = new ArrayList<Customer>();
		String sql = "SELECT * FROM v_customer WHERE cpid like ?";
		PreparedStatement ps = con.prepareStatement(sql);		
		ps.setString(1, "%"+tel+"%");		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			dao = new Customer();
			dao.setCustTel1(rs.getString(1));
			dao.setCustName(rs.getString(2));
			dao.setCustTel2(rs.getString(3));
			dao.setCustAddr(rs.getString(4));
			dao.setCustEmail(rs.getString(5));
			list.add(dao);
		}
		ps.close();
		
		return list;
		
	}
	
	public ArrayList<Customer> selectByName(String text) throws Exception{
		ArrayList<Customer> list = new ArrayList<Customer>();
		Customer dao;
		text = "%"+text.trim()+"%";
		String sql = "SELECT * FROM V_CUSTOMER WHERE CNAME LIKE ?";
		PreparedStatement ps = con.prepareStatement(sql);		
		ps.setString(1, text);		
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			dao = new Customer();
			dao.setCustTel1(rs.getString(1));
			dao.setCustName(rs.getString(2));
			dao.setCustTel2(rs.getString(3));
			dao.setCustAddr(rs.getString(4));
			dao.setCustEmail(rs.getString(5));
			list.add(dao);
		}
		ps.close();
		
		return list;
	}
	
	public int updateCustomer(Customer dao) throws Exception{
		
		int result = 0;
		String sql = "UPDATE v_customer SET "
				+ "cname=?,cphone=?,caddr=?,cmail=? WHERE cpid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, dao.getCustName().trim());
		ps.setString(2, dao.getCustTel2().trim());
		ps.setString(3, dao.getCustAddr().trim());
		ps.setString(4, dao.getCustEmail().trim());
		ps.setString(5, dao.getCustTel1().trim());
		
		result = ps.executeUpdate();
		ps.close();
		
		return result;
	}

	
}
