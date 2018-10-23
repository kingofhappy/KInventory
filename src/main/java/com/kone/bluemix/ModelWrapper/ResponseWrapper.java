package com.kone.bluemix.ModelWrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author sradhakrishnan2
 * 
 * Wrapper model to receive response from Cloudant DB while adding the new record
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseWrapper {
	
	@JsonProperty("ok")
	private String ok;
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("rev")
	private String rev;

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	@Override
	public String toString() {
		return "ResponseWrapper [ok=" + ok + ", id=" + id + ", rev=" + rev + "]";
	}

}
