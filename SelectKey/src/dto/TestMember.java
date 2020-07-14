package dto;

public class TestMember {
	private int no;
	private String id;
	private String pw;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", pw=" + pw + "]";
	}
	
	
	
}
