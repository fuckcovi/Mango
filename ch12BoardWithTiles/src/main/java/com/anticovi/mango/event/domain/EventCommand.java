package com.anticovi.mango.event.domain;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class EventCommand {

	private int e_seq;
	private String e_title;
	private String e_content;
	private int e_hit;
	private MultipartFile e_upload;
	private byte[] e_uploadfile;
	private String e_filename;
	private String e_start;
	private String e_end;
	
	public int getE_seq() {
		return e_seq;
	}
	public void setE_seq(int e_seq) {
		this.e_seq = e_seq;
	}
	public String getE_title() {
		return e_title;
	}
	public void setE_title(String e_title) {
		this.e_title = e_title;
	}
	public String getE_content() {
		return e_content;
	}
	public void setE_content(String e_content) {
		this.e_content = e_content;
	}
	public int getE_hit() {
		return e_hit;
	}
	public void setE_hit(int e_hit) {
		this.e_hit = e_hit;
	}
	public MultipartFile getE_upload() {
		return e_upload;
	}
	public void setE_upload(MultipartFile e_upload) throws IOException {
		this.e_upload = e_upload;
		
		setE_uploadfile(e_upload.getBytes());
		setE_filename(e_upload.getOriginalFilename());
	}
	public byte[] getE_uploadfile() {
		return e_uploadfile;
	}
	public void setE_uploadfile(byte[] e_uploadfile) {
		this.e_uploadfile = e_uploadfile;
	}
	public String getE_filename() {
		return e_filename;
	}
	public void setE_filename(String e_filename) {
		this.e_filename = e_filename;
	}
	public String getE_start() {
		return e_start;
	}
	public void setE_start(String e_start) {
		this.e_start = e_start;
	}
	public String getE_end() {
		return e_end;
	}
	public void setE_end(String e_end) {
		this.e_end = e_end;
	}
	
	@Override
	public String toString() {
		return "EventCommand [e_seq=" + e_seq + ", e_title=" + e_title + ", e_content=" + e_content + ", e_hit=" + e_hit
				+ ", e_upload=" + e_upload + ", e_filename=" + e_filename + ", e_start=" + e_start + ", e_end=" + e_end
				+ "]";
	}
	
}
