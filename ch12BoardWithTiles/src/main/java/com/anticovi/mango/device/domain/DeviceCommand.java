package com.anticovi.mango.device.domain;

import java.sql.Date;
import java.util.Arrays;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class DeviceCommand {
	private int d_seq;
	@NotEmpty
	private String d_name;
	@NotEmpty
	private String d_modelnum;
	private Date d_regdate;
	@NotEmpty
	private String d_type;
	@NotEmpty
	private String d_explain;
	private String di_color;
	private byte[] di_image1;
	private String di_imagename1;
	private byte[] di_image2;
	private String di_imagename2;
	private byte[] di_image3;
	private String di_imagename3;
	private byte[] di_image4;
	private String di_imagename4;
	private byte[] di_image5;
	private String di_imagename5;
	private int di_quantity;
	private int di_price;
	private int di_seq;
	
	
	public String getDi_color() {
		return di_color;
	}
	public void setDi_color(String di_color) {
		this.di_color = di_color;
	}
	
	public byte[] getDi_image1() {
		return di_image1;
	}
	public void setDi_image1(byte[] di_image1) {
		this.di_image1 = di_image1;
	}
	public String getDi_imagename1() {
		return di_imagename1;
	}
	public void setDi_imagename1(String di_imagename1) {
		this.di_imagename1 = di_imagename1;
	}
	public byte[] getDi_image2() {
		return di_image2;
	}
	public void setDi_image2(byte[] di_image2) {
		this.di_image2 = di_image2;
	}
	public String getDi_imagename2() {
		return di_imagename2;
	}
	public void setDi_imagename2(String di_imagename2) {
		this.di_imagename2 = di_imagename2;
	}
	public byte[] getDi_image3() {
		return di_image3;
	}
	public void setDi_image3(byte[] di_image3) {
		this.di_image3 = di_image3;
	}
	public String getDi_imagename3() {
		return di_imagename3;
	}
	public void setDi_imagename3(String di_imagename3) {
		this.di_imagename3 = di_imagename3;
	}
	public byte[] getDi_image4() {
		return di_image4;
	}
	public void setDi_image4(byte[] di_image4) {
		this.di_image4 = di_image4;
	}
	public String getDi_imagename4() {
		return di_imagename4;
	}
	public void setDi_imagename4(String di_imagename4) {
		this.di_imagename4 = di_imagename4;
	}
	public byte[] getDi_image5() {
		return di_image5;
	}
	public void setDi_image5(byte[] di_image5) {
		this.di_image5 = di_image5;
	}
	public String getDi_imagename5() {
		return di_imagename5;
	}
	public void setDi_imagename5(String di_imagename5) {
		this.di_imagename5 = di_imagename5;
	}
	public int getDi_quantity() {
		return di_quantity;
	}
	public void setDi_quantity(int di_quantity) {
		this.di_quantity = di_quantity;
	}
	public int getDi_price() {
		return di_price;
	}
	public void setDi_price(int di_price) {
		this.di_price = di_price;
	}
	public int getDi_seq() {
		return di_seq;
	}
	public void setDi_seq(int di_seq) {
		this.di_seq = di_seq;
	}
	public String getD_explain() {
		return d_explain;
	}
	public void setD_explain(String d_explain) {
		this.d_explain = d_explain;
	}
	public int getD_seq() {
		return d_seq;
	}
	public void setD_seq(int d_seq) {
		this.d_seq = d_seq;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public String getD_modelnum() {
		return d_modelnum;
	}
	public void setD_modelnum(String d_modelnum) {
		this.d_modelnum = d_modelnum;
	}
	public Date getD_regdate() {
		return d_regdate;
	}
	public void setD_regdate(Date d_regdate) {
		this.d_regdate = d_regdate;
	}
	public String getD_type() {
		return d_type;
	}
	public void setD_type(String d_type) {
		this.d_type = d_type;
	}
	@Override
	public String toString() {
		return "DeviceCommand [d_seq=" + d_seq + ", d_name=" + d_name + ", d_modelnum=" + d_modelnum + ", d_regdate="
				+ d_regdate + ", d_type=" + d_type + ", d_explain=" + d_explain + ", di_color=" + di_color
				+ ", di_imagename1=" + di_imagename1 + ", di_imagename2=" + di_imagename2 + ", di_imagename3="
				+ di_imagename3 + ", di_imagename4=" + di_imagename4 + ", di_imagename5=" + di_imagename5
				+ ", di_quantity=" + di_quantity + ", di_price=" + di_price + ", di_seq=" + di_seq + "]";
	}
	
	
	
	
}
