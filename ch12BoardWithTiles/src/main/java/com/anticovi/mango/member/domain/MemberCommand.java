package com.anticovi.mango.member.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberCommand {
	private int m_seq;
	@NotEmpty
	private String m_id;
	@NotEmpty
	private String m_pw;
	@NotEmpty
	private String m_name;
	@NotEmpty
	private String m_phone1;
	@NotEmpty
	private String m_phone2;
	@NotEmpty
	private String m_phone3;
	@NotEmpty
	private String m_birth;
	@NotEmpty
	private String m_address1;
	private String m_address2;
	private String m_mydevice1;
	private String m_mydevice2;
	private String m_mydevice3;
	private int m_status;
	private Date m_regdate;
	
	public boolean isCheckedPw(String user_pw){
		if(m_pw.equals(user_pw)){
			return true;
		}
		return false;
	}
	
	public Date getM_regdate() {
		return m_regdate;
	}
	public void setM_regdate(Date m_regdate) {
		this.m_regdate = m_regdate;
	}
	public int getM_seq() {
		return m_seq;
	}
	public void setM_seq(int m_seq) {
		this.m_seq = m_seq;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone1() {
		return m_phone1;
	}
	public void setM_phone1(String m_phone1) {
		this.m_phone1 = m_phone1;
	}
	public String getM_phone2() {
		return m_phone2;
	}
	public void setM_phone2(String m_phone2) {
		this.m_phone2 = m_phone2;
	}
	public String getM_phone3() {
		return m_phone3;
	}
	public void setM_phone3(String m_phone3) {
		this.m_phone3 = m_phone3;
	}
	public String getM_birth() {
		return m_birth;
	}
	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}
	public String getM_address1() {
		return m_address1;
	}
	public void setM_address1(String m_address1) {
		this.m_address1 = m_address1;
	}
	public String getM_address2() {
		return m_address2;
	}
	public void setM_address2(String m_address2) {
		this.m_address2 = m_address2;
	}
	public String getM_mydevice1() {
		return m_mydevice1;
	}
	public void setM_mydevice1(String m_mydevice1) {
		this.m_mydevice1 = m_mydevice1;
	}
	public String getM_mydevice2() {
		return m_mydevice2;
	}
	public void setM_mydevice2(String m_mydevice2) {
		this.m_mydevice2 = m_mydevice2;
	}
	public String getM_mydevice3() {
		return m_mydevice3;
	}
	public void setM_mydevice3(String m_mydevice3) {
		this.m_mydevice3 = m_mydevice3;
	}
	public int getM_status() {
		return m_status;
	}
	public void setM_status(int m_status) {
		this.m_status = m_status;
	}
	@Override
	public String toString() {
		return "MemberCommand [m_seq=" + m_seq + ", m_id=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name
				+ ", m_phone1=" + m_phone1 + ", m_phone2=" + m_phone2 + ", m_phone3=" + m_phone3 + ", m_birth="
				+ m_birth + ", m_address1=" + m_address1 + ", m_address2=" + m_address2 + ", m_mydevice1=" + m_mydevice1
				+ ", m_mydevice2=" + m_mydevice2 + ", m_mydevice3=" + m_mydevice3 + ", m_status=" + m_status
				+ ", m_regdate=" + m_regdate + "]";
	}
	

}
