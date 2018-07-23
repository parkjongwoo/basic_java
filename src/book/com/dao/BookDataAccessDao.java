﻿package book.com.dao;

import java.util.ArrayList;
import java.util.Map;

import book.com.dto.Book;

public interface BookDataAccessDao {

	public boolean saveBook(Book b);
	public ArrayList<Book> selectAll();
	public Book selectByNo(int no);	
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent);
	public boolean deleteBook(int no);
	public ArrayList<Book> searchBookByName(String subName);
	//public ArrayList<Book> searchBookByAuthor(String subAuthor);
	//public ArrayList<Book> searchBookByPublisher(String publisher);
}
