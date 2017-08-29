package com.anticovi.mango.device.domain;

import java.io.IOException;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class DeviceInfoCommand {
	private int di_seq;
	private int d_seq;
	@NotEmpty
	private String di_color;
	private byte[] di_image1;
	private String di_imagename1;
	private MultipartFile di_imagefile1;
	private byte[] di_image2;
	private String di_imagename2;
	private MultipartFile di_imagefile2;
	private byte[] di_image3;
	private String di_imagename3;
	private MultipartFile di_imagefile3;
	private byte[] di_image4;
	private String di_imagename4;
	private MultipartFile di_imagefile4;
	private byte[] di_image5;
	private String di_imagename5;
	private MultipartFile di_imagefile5;
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
	public MultipartFile getDi_imagefile1() {
		return di_imagefile1;
	}
	public void setDi_imagefile1(MultipartFile di_imagefile1) throws IOException {
		this.di_imagefile1 = di_imagefile1;
		setDi_image1(di_imagefile1.getBytes());
		setDi_imagename1(di_imagefile1.getOriginalFilename());
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
	public MultipartFile getDi_imagefile2() {
		return di_imagefile2;
	}
	public void setDi_imagefile2(MultipartFile di_imagefile2) throws IOException {
		this.di_imagefile2 = di_imagefile2;
		setDi_image2(di_imagefile2.getBytes());
		setDi_imagename2(di_imagefile2.getOriginalFilename());
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
	public MultipartFile getDi_imagefile3() {
		return di_imagefile3;
	}
	public void setDi_imagefile3(MultipartFile di_imagefile3) throws IOException {
		this.di_imagefile3 = di_imagefile3;
		setDi_image3(di_imagefile3.getBytes());
		setDi_imagename3(di_imagefile3.getOriginalFilename());
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
	public MultipartFile getDi_imagefile4() {
		return di_imagefile4;
	}
	public void setDi_imagefile4(MultipartFile di_imagefile4) throws IOException {
		this.di_imagefile4 = di_imagefile4;
		setDi_image4(di_imagefile4.getBytes());
		setDi_imagename4(di_imagefile4.getOriginalFilename());
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
	public MultipartFile getDi_imagefile5() {
		return di_imagefile5;
	}
	public void setDi_imagefile5(MultipartFile di_imagefile5) throws IOException {
		this.di_imagefile5 = di_imagefile5;
		setDi_image5(di_imagefile5.getBytes());
		setDi_imagename5(di_imagefile5.getOriginalFilename());
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
		return "DeviceInfoCommand [di_seq=" + di_seq + ", d_seq=" + d_seq + ", di_color=" + di_color
				+ ", di_imagename1=" + di_imagename1 + ", di_imagename2=" + di_imagename2 + ", di_imagename3="
				+ di_imagename3 + ", di_imagename4=" + di_imagename4 + ", di_imagename5=" + di_imagename5
				+ ", di_quantity=" + di_quantity + ", di_price=" + di_price + "]";
	}
	
	
	
}
