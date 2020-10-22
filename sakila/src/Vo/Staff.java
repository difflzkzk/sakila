package Vo;

public class Staff {
	//11개의 필드(속성) (멤버 변수)
	// toString 메서드 오버라이딩
	private int staffid;
	private String firstname;
	private String lastname;
	private int addressid;
	private	String picture;
	private	String email;
	private int storeid;
	private int active;
	private String username;
	private String password;
	private String lastupdate;
	
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	public String toString() {
		return "Staff [staffId=" + staffid + ", firstName=" + firstname + ", lastName=" + lastname + ", addressId="
				+ addressid + ", picture=" + picture + ", email=" + email + ", storeId=" + storeid + ", active="
				+ active + ", userName=" + username + ", password=" + password + ", lastUpdate=" + lastupdate + "]";
	}
	
}
