package model.vo;

public class RentVO {
	int rid;
	String cpid;
	int vid;
	String rsdate;
	String redate;
	
	String vname;
	String cname;
	String returnSche;
	String isReturned;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getRsdate() {
		return rsdate;
	}
	public void setRsdate(String rsdate) {
		this.rsdate = rsdate;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String isReturned() {
		return isReturned;
	}
	public void setReturned(String isReturned) {
		this.isReturned = isReturned;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getIsReturned() {
		return isReturned;
	}
	public void setIsReturned(String isReturned) {
		this.isReturned = isReturned;
	}
	public String getReturnSche() {
		return returnSche;
	}
	public void setReturnSche(String returnSche) {
		this.returnSche = returnSche;
	}
}
