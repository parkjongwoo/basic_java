package book.com.dto;
public class Book
{
	//일체 손대지 마시오.
	private static int seq=1;
	private int no;
	private String name;
	private String author;
	private String publisher;

	
	public Book(){
		no = seq;
		seq++;
	}
	
	public Book(int no, String name, String author, String publisher) {

		this.no = no;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setName(String name){
		this.name = name;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public void setPublisher(String publisher){
		this.publisher = publisher;		
	}

	public String getName(){
		return name;
	}

	public String getAuthor(){
		return author;
	}

	public String getPublisher(){
		return publisher;
	}
	
	@Override
	public String toString() {
		return  "=======================\n"+
				"책번호 : "+ no + "\n " + 
				"책제목 : "+ name + "\n " +
				"저  자 : "+ author + "\n " +
				"출판사 : "+ publisher + "\n "+
				"=======================\n";
	}
}