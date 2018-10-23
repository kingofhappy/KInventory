package com.kone.bluemix.ModelWrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author sradhakrishnan2
 * 
 * Wrapper model to receive row json data from Cloudant DB while retrieving the record
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class RowWrapper {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("value")
	ValuesWrapper value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ValuesWrapper getValue() {
		return value;
	}

	public void setValue(ValuesWrapper value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "RowWrapper [id=" + id + ", key=" + key + ", value=" + value + "]";
	}
	
	

}
