package book.com.dao;

import java.util.ArrayList;
import java.util.Map;

import book.com.dto.Book;

//ArrayList를 이용한 DAO
public class ArrayListBookDataAccessDaoImpl implements BookDataAccessDao {
	// 더이상 객체 변수 선언하지 마시오.
	ArrayList<Book> bookList = new ArrayList<Book>();

	@Override
	public boolean saveBook(Book b) {
		return bookList.add(b);
	}

	@Override
	public ArrayList<Book> selectAll() {
		return bookList;
	}

	@Override
	public Book selectByNo(int no) {
		Book b = null;
		for (int i = 0; i < bookList.size(); i++) {
			Book b2 = bookList.get(i);
			if (b2.getNo() == no) {
				b = b2;
				break;
			}
		}
		return b;
	}

	@Override
	public boolean updateBook(int bookNo, Map<Integer, String> updateContent) {
		Book b = selectByNo(bookNo);
		if (b == null) {
			return false;
		}

		String name = updateContent.get(1);
		String author = updateContent.get(2);
		String publisher = updateContent.get(3);

		b.setName(name);
		b.setAuthor(author);
		b.setPublisher(publisher);

		return true;
	}

	@Override
	public boolean deleteBook(int no) {
		Book b = selectByNo(no);
		if (b == null) {
			return false;
		} else {
			return bookList.remove(selectByNo(no));
		}
	}

	@Override
	public ArrayList<Book> searchBookByName(String subName) {
		ArrayList<Book> result = new ArrayList<Book>();
		for (int i = 0; i < bookList.size(); i++) {
			Book b = bookList.get(i);
			if (b.getName().indexOf(subName) >= 0) {
				result.add(b);
				break;
			}
		}
		return result;
	}	
}
