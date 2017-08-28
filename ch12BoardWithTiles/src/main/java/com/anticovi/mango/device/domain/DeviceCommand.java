package com.anticovi.mango.device.domain;

import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;

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
				+ d_regdate + ", d_type=" + d_type + ", d_explain=" + d_explain + "]";
	}
	
}
