package book.com.sql;

public class Sql {
	
	//jdbc 할때 sql문만 모두 적어 놓는 클래스
	//아래 예시로 한개 써 보았음
	public static final String BOOK_INSERT = "INSERT INTO Book VALUES (?, ?, ?, ?)";
	
	public static final String BOOK_SELECT_ALL = "SELECT * FROM Book";
	
	public static final String BOOK_SELECT_LIKE = "SELECT * FROM Book WHERE NAME LIKE ?";
	
	public static final String BOOK_SELECT_BY_NO = "SELECT * FROM Book WHERE NO=?";
	
	public static final String BOOK_UPDATE = "UPDATE Book SET NAME=?, AUTHOR=?, PUBLISHER=? WHERE NO=?";
	
	public static final String BOOK_DELETE = "DELETE FROM BOOK WHERE NO=?";
	
}
