package model.vo;

public class Genre {
	private String genid;
	private String genname;
	public String getGenid() {
		return genid;
	}
	public void setGenid(String genid) {
		this.genid = genid;
	}
	public String getGenname() {
		return genname;
	}
	public void setGenname(String genname) {
		this.genname = genname;
	}
	@Override
	public String toString() {
		return genname;
	}	
}
