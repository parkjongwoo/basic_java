package book.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import book.com.db.conn.ConnectionProvider;
import book.com.db.conn.JdbcUtil;
import book.com.dto.Book;
import book.com.sql.Sql;

//jdbc를 사용한 DAO
//com.db.conn 패키지에 있는 클래스와 Sql 클래스를 이용해서 구현하시오.
public class OracleBookDataAccessDaoImpl implements BookDataAccessDao {

	@Override
	public boolean saveBook(Book b){
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;
		try {
			conn = ConnectionProvider.getConnection();
			ps = conn.prepareStatement(Sql.BOOK_INSERT);
			ps.setInt(1, b.getNo());
			ps.setString(2, b.getName());
			ps.setString(3, b.getAuthor());
			ps.setString(4, b.getPublisher());
			
			result = ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(ps);
			JdbcUtil.close(conn);
		}
		return result;
	}

	@Override
	public ArrayList<Book> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = ConnectionProvider.getConnection();
			ps = conn.prepareStatement(Sql.BOOK_SELECT_ALL);		
			rs = ps.executeQuery();
			while(rs.next()) {
				Book b = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(ps);
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
		}
		return list;
	}

	@Override
	public Book selectByNo(int no) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = ConnectionProvider.getConnection();
			ps = conn.prepareStatement(Sql.BOOK_SELECT_BY_NO);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while(rs.next()) {
				book = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(ps);
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
		}
		return book;
	}

	@Override
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;
		String name = updateContent.get(1);
		String author = updateContent.get(2);
		String publisher = updateContent.get(3);
		try {
			conn = ConnectionProvider.getConnection();
			ps = conn.prepareStatement(Sql.BOOK_UPDATE);
			ps.setString(1, name);
			ps.setString(2, author);
			ps.setString(3, publisher);
			ps.setInt(4, bookNo);
			
			result = ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(ps);
			JdbcUtil.close(conn);
		}
		return result;
	}

	@Override
	public boolean deleteBook(int no) {
		Connection conn = null;
		PreparedStatement ps = null;
		boolean result = false;
		try {
			conn = ConnectionProvider.getConnection();
			ps = conn.prepareStatement(Sql.BOOK_DELETE);
			ps.setInt(1, no);
			result = ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(ps);
			JdbcUtil.close(conn);
		}
		return result;
	}

	@Override
	public ArrayList<Book> searchBookByName(String subName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			conn = ConnectionProvider.getConnection();
			ps = conn.prepareStatement(Sql.BOOK_SELECT_LIKE);
			ps.setString(1, "%"+subName+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(ps);
			JdbcUtil.close(rs);
			JdbcUtil.close(conn);
		}
		return list;
	}
}
