package com.anticovi.mango.device.domain;

import java.io.IOException;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class DeviceInfoCommand {
	private int di_seq;
	private int d_seq;
	@NotEmpty
	private String di_color;
	private byte[] di_image;
	private String di_imagename;
	private MultipartFile di_imagefile;
	private int di_quantity;
	private int di_price;
	public int getDi_seq() {
		return di_seq;
	}
	public void setDi_seq(int di_seq) {
		this.di_seq = di_seq;
	}
	public int getD_seq() {
		return d_seq;
	}
	public void setD_seq(int d_seq) {
		this.d_seq = d_seq;
	}
	public String getDi_color() {
		return di_color;
	}
	public void setDi_color(String di_color) {
		this.di_color = di_color;
	}
	public byte[] getDi_image() {
		return di_image;
	}
	public void setDi_image(byte[] di_image) {
		this.di_image = di_image;
	}
	public String getDi_imagename() {
		return di_imagename;
	}
	public void setDi_imagename(String di_imagename) {
		this.di_imagename = di_imagename;
	}
	public MultipartFile getDi_imagefile() {
		return di_imagefile;
	}
	public void setDi_imagefile(MultipartFile di_imagefile) throws IOException {
		this.di_imagefile = di_imagefile;
		setDi_image(di_imagefile.getBytes());
		setDi_imagename(di_imagefile.getOriginalFilename());
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
	@Override
	public String toString() {
		return "DeviceInfoCommand [di_seq=" + di_seq + ", d_seq=" + d_seq + ", di_color=" + di_color + ", di_imagename="
				+ di_imagename + ", di_quantity=" + di_quantity + ", di_price=" + di_price + "]";
	}
	
	
}
