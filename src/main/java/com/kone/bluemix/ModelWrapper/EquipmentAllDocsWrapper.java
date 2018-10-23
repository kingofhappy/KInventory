package com.kone.bluemix.ModelWrapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;



/**
 * @author sradhakrishnan2
 * 
 * Wrapper model to accommodate all equipment details from Cloudant DB 
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class EquipmentAllDocsWrapper {
	
	@JsonProperty("total_rows")
	private String total_rows;
	
	@JsonProperty("offset")
	private int offset;
	
	@JsonProperty("rows")
	RowWrapper[] rows;

	public String getTotal_rows() {
		return total_rows;
	}

	public void setTotal_rows(String total_rows) {
		this.total_rows = total_rows;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public RowWrapper[] getRows() {
		return rows;
	}

	public void setRows(RowWrapper[] rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "EquipmentAllDocsWrapper [total_rows=" + total_rows + ", offset=" + offset + ", rows="
				+ Arrays.toString(rows) + "]";
	}
	
	

}
