package com.anticovi.mango.callingPlan.domain;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class CallingPlanCommand {
	private int cp_seq;
	@NotEmpty
	private String cp_category;
	@NotEmpty
	private String cp_name;
	@NotEmpty
	private String cp_modelnum;
	private Date cp_regdate;
	@NotEmpty
	private int cp_price;
	@NotEmpty
	private String cp_call;
	@NotEmpty
	private String cp_data;
	@NotEmpty
	private String cp_message;
	private String cp_detail;
	private byte[] cp_detailimage;
	private String cp_detailimagename;
	private MultipartFile cp_detailimagefile;
	
	public MultipartFile getCp_detailimagefile() {
		return cp_detailimagefile;
	}
	public void setCp_detailimagefile(MultipartFile cp_detailimagefile) throws IOException {
		this.cp_detailimagefile = cp_detailimagefile;
		setCp_detailimage(cp_detailimagefile.getBytes());
		setCp_detailimagename(cp_detailimagefile.getOriginalFilename());
	}
	public int getCp_seq() {
		return cp_seq;
	}
	public void setCp_seq(int cp_seq) {
		this.cp_seq = cp_seq;
	}
	public String getCp_category() {
		return cp_category;
	}
	public void setCp_category(String cp_category) {
		this.cp_category = cp_category;
	}
	public String getCp_name() {
		return cp_name;
	}
	public void setCp_name(String cp_name) {
		this.cp_name = cp_name;
	}
	public String getCp_modelnum() {
		return cp_modelnum;
	}
	public void setCp_modelnum(String cp_modelnum) {
		this.cp_modelnum = cp_modelnum;
	}
	public Date getCp_regdate() {
		return cp_regdate;
	}
	public void setCp_regdate(Date cp_regdate) {
		this.cp_regdate = cp_regdate;
	}
	public int getCp_price() {
		return cp_price;
	}
	public void setCp_price(int cp_price) {
		this.cp_price = cp_price;
	}
	public String getCp_call() {
		return cp_call;
	}
	public void setCp_call(String cp_call) {
		this.cp_call = cp_call;
	}
	public String getCp_data() {
		return cp_data;
	}
	public void setCp_data(String cp_data) {
		this.cp_data = cp_data;
	}
	public String getCp_message() {
		return cp_message;
	}
	public void setCp_message(String cp_message) {
		this.cp_message = cp_message;
	}
	public String getCp_detail() {
		return cp_detail;
	}
	public void setCp_detail(String cp_detail) {
		this.cp_detail = cp_detail;
	}
	public byte[] getCp_detailimage() {
		return cp_detailimage;
	}
	public void setCp_detailimage(byte[] cp_detailimage) {
		this.cp_detailimage = cp_detailimage;
	}
	public String getCp_detailimagename() {
		return cp_detailimagename;
	}
	public void setCp_detailimagename(String cp_detailimagename) {
		this.cp_detailimagename = cp_detailimagename;
	}
	@Override
	public String toString() {
		return "CallingPlanCommand [cp_seq=" + cp_seq + ", cp_category=" + cp_category + ", cp_name=" + cp_name
				+ ", cp_modelnum=" + cp_modelnum + ", cp_regdate=" + cp_regdate + ", cp_price=" + cp_price
				+ ", cp_call=" + cp_call + ", cp_data=" + cp_data + ", cp_message=" + cp_message + ", cp_detail="
				+ cp_detail + ", cp_detailimagename=" + cp_detailimagename + "]";
	}
	
	
}
