package com.kone.bluemix.ModelWrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sradhakrishnan2
 * 
 * Wrapper model to receive response from Cloudant DB while retrieving the record
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class EquipmentWrapper {
	
	public EquipmentWrapper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EquipmentWrapper(String id, String addr, String con_strt_d, String con_end_d, String stat) {
		super();
		this.id = id;
		this.addr = addr;
		this.con_strt_d = con_strt_d;
		this.con_end_d = con_end_d;
		this.stat = stat;
	}

	@JsonProperty("_id")
	private String id;
	
	
	
	@JsonProperty("address")
	private String addr;

	@JsonProperty("contract_start_date")
	private String con_strt_d;
	
	@JsonProperty("contract_end_date")
	private String con_end_d;
	
	@JsonProperty("status")
	private String stat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCon_strt_d() {
		return con_strt_d;
	}

	public void setCon_strt_d(String con_strt_d) {
		this.con_strt_d = con_strt_d;
	}

	public String getCon_end_d() {
		return con_end_d;
	}

	public void setCon_end_d(String con_end_d) {
		this.con_end_d = con_end_d;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	@Override
	public String toString() {
		return "EquipmentWrapper [id=" + id + ", addr=" + addr + ", con_strt_d=" + con_strt_d + ", con_end_d="
				+ con_end_d + ", stat=" + stat + "]";
	}

	
}
