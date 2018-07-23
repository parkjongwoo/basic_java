package com.dao;

import java.util.ArrayList;
import java.util.Map;

import com.dto.Book;

//jdbc를 사용한 DAO
//com.db.conn 패키지에 있는 클래스와 Sql 클래스를 이용해서 구현하시오.
public class OracleBookDataAccessDaoImpl implements BookDataAccessDao {

	@Override
	public boolean saveBook(Book b) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Book> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book selectByNo(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Book> searchBookByName(String subName) {
		// TODO Auto-generated method stub
		return null;
	}



}
