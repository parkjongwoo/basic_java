package book.com.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import book.com.dao.BookDataAccessDao;
import book.com.dao.OracleBookDataAccessDaoImpl;
import book.com.dto.Book;
import book.com.view.FormatWriter;
import book.com.view.InputValueReader;
import book.com.view.Menu;
import book.com.view.Message;

//도서관리 시스템 로직부분
public class BookManager {
	// 더이상 객체 변수 선언하지 마시오.
	InputValueReader reader = new InputValueReader();

//	BookDataAccessDao dao = new ArrayListBookDataAccessDaoImpl();
	 BookDataAccessDao dao = new OracleBookDataAccessDaoImpl();

	public void start() {
		int inputValue = 0;
		dao.selectAll();
		do {
			do {
				printMenuAndMessage(Menu.MENU01,Message.MESSAGE09);
				inputValue = reader.readIntValue();

				switch (inputValue) {
				case 1:
					// 저장
					inputBook();					
					break;
				case 2:
					// 검색
					inputValue = searchBookByTitle(inputValue);
					break;
				case 3:
					// 전체출력
					FormatWriter.showBookList(dao.selectAll());
					break;
				}
			} while (inputValue != 4);
			printMessageAndMenu(Message.MESSAGE18,Menu.MENU02);
			inputValue = reader.readIntValue();
		} while (inputValue != 1);
		FormatWriter.showMessage(Message.MESSAGE20);
		
	}
	
	private void inputBook() {
		FormatWriter.showMessage(Message.MESSAGE11);
		
		Book b = reader.readBookData();
		
		printMessageAndMenu(Message.MESSAGE01, Menu.MENU02);
		
		int yn = reader.readIntValue();
		if(yn == 1) {
			dao.saveBook(b);
		}
	}

	private int searchBookByTitle(int inputValue) {
		FormatWriter.showMessage(Message.MESSAGE03);
		String seachWord = reader.readStringValue();
		ArrayList<Book> searchResult = dao.searchBookByName(seachWord);
		FormatWriter.showBookList(searchResult);
		return searchBookSubMenu(searchResult, inputValue);
	}

	private int searchBookSubMenu( ArrayList<Book> searchResult, int inputValue) {		
		if(searchResult.size()<=0) {
			FormatWriter.showMessage(Message.MESSAGE19);
			return inputValue;			
		}else {
			FormatWriter.showMessage("총 " + searchResult.size() + "권이 검색되었습니다.");			
		}
		printMenuAndMessage(Menu.MENU03,Message.MESSAGE09);

		inputValue = reader.readIntValue();

		switch (inputValue) {
		case 1:			
			modifyBook(searchResult);
			break;
		case 2:
			deleteBook(searchResult);
			break;
		}
		return inputValue;
	}

	private void modifyBook(ArrayList<Book> searchResult) {
		FormatWriter.showMessage(Message.MESSAGE10);
		int bookNo = reader.readIntValue();
		int yn = 0;
		Book book = dao.selectByNo(bookNo);
		Map<Integer, String> updateContent = new HashMap<Integer, String>();
		updateContent.put(1, book.getName());
		updateContent.put(1, book.getAuthor());
		updateContent.put(1, book.getPublisher());
		do {
			printMenuAndMessage(Menu.MENU04,Message.MESSAGE13);;			
			int method = reader.readIntValue();
			
			FormatWriter.showMessage(Message.MESSAGE17);		
			String value = reader.readStringValue();
			
			updateContent.put(method, value);			
			
			printMessageAndMenu(Message.MESSAGE14, Menu.MENU02);
			yn = reader.readIntValue();			
		}while(yn==1);
		dao.updateBook(bookNo, updateContent);
	}
	
	private void deleteBook(ArrayList<Book> searchResult) {
		FormatWriter.showMessage(Message.MESSAGE10);
		int bookNo = reader.readIntValue();
		printMessageAndMenu(Message.MESSAGE07, Menu.MENU02);
		int yn = reader.readIntValue();
		if(yn==1) {
			dao.deleteBook(bookNo);
			FormatWriter.showMessage(Message.MESSAGE08);
		}
	}

	private void printMenuAndMessage(String menu, String message) {
		FormatWriter.showMenu(menu);
		FormatWriter.showMessage(message);
	}
	
	private void printMessageAndMenu(String message, String menu ) {
		FormatWriter.showMessage(message);
		FormatWriter.showMenu(menu);
	}
}
