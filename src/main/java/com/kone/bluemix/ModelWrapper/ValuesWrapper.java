package com.kone.bluemix.ModelWrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sradhakrishnan2
 * 
 * Wrapper model to receive values json data from Cloudant DB while retrieving the record
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ValuesWrapper {
	
	@JsonProperty("rev")
	private String rev;

	public String getRev() {
		return rev;
	}

	public void setRev(String rev) {
		this.rev = rev;
	}

	@Override
	public String toString() {
		return "ValuesWrapper [rev=" + rev + "]";
	}
	
	

}
