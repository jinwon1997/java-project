package teamprj;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

// 테이블명 + Bean
public class MemberBean {
	
	private int num;
	
	private String id;
	private String password;
	private String password2;
	private String name;
	private String address;
	private String phone;
	private int gender;
	private String registerDate;
	private String ustime;
	private String socialnum;
	private int user_mst;
	private int seat_number;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getUstime() {
		return ustime;
	}
	public void setUstime(String ustime) {
		this.ustime = ustime;
	}
	public String getSocialnum() {
		return socialnum;
	}
	public void setSocialnum(String socialnum) {
		this.socialnum = socialnum;
	}
	public int getUser_mst() {
		return user_mst;
	}
	public void setUser_mst(int user_mst) {
		this.user_mst = user_mst;
	}
	public int getSeat_number() {
		return seat_number;
	}
	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}
	
}
