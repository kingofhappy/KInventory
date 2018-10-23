package com.kone.bluemix.ServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kone.bluemix.ModelWrapper.EquipmentAllDocsWrapper;
import com.kone.bluemix.ModelWrapper.EquipmentWrapper;
import com.kone.bluemix.ModelWrapper.ResponseWrapper;
import com.kone.bluemix.ModelWrapper.RowWrapper;
import com.kone.bluemix.Service.EquipmentService;
import com.kone.bluemix.Utils.EIConstant;


/**
 * @author sradhakrishnan2
 * 
 * all Use cases implemented as per the requirement
 *
 */
@Service
public class EquipmentServiceImpl implements EquipmentService{
	
	private final static Logger log = LoggerFactory.getLogger(EquipmentServiceImpl.class);
	@Autowired
    @Qualifier("simpleRestTemplate")
    private RestTemplate rt;
	

    
	ObjectMapper mapper= new ObjectMapper();

	
	/* (non-Javadoc)
	 * @see com.kone.bluemix.Service.EquipmentService#allEquipments()
	 */
	@Override
	public List<EquipmentWrapper> allEquipments()  {
		// TODO Auto-generated method stub
		
		
		String srcURL=EIConstant.CON_URL+EIConstant.DBNAME+EIConstant.DOC;
		log.info("ConnectionURL : " + srcURL);
		ResponseEntity<EquipmentAllDocsWrapper> resp=rt.getForEntity(srcURL, EquipmentAllDocsWrapper.class);
		List<RowWrapper> ob=new ArrayList<>(Arrays.asList(resp.getBody().getRows()));
		List<EquipmentWrapper> li=new ArrayList<>();
		if(resp.getStatusCodeValue()==200) {
		
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<Object> res=new HttpEntity<>(headers);
		for (RowWrapper rw: ob) {
			
			String sURL=EIConstant.CON_URL+EIConstant.DBNAME+"/"+rw.getId();		
			ResponseEntity<EquipmentWrapper> response=rt.exchange(sURL, HttpMethod.GET, res, EquipmentWrapper.class);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			li.add(response.getBody());					
		}
		}
		
		return li;
		
	}

	/* (non-Javadoc)
	 * @see com.kone.bluemix.Service.EquipmentService#trackEquipment(java.lang.String)
	 */
	@Override
	public EquipmentWrapper trackEquipment(String eid) {
		// TODO Auto-generated method stub
		String sURL=EIConstant.CON_URL+EIConstant.DBNAME+"/"+eid;
		
		ResponseEntity<EquipmentWrapper> res=rt.getForEntity(sURL, EquipmentWrapper.class);
		return res.getBody();
	}

	/* (non-Javadoc)
	 * @see com.kone.bluemix.Service.EquipmentService#addEquipment(com.kone.bluemix.ModelWrapper.EquipmentWrapper)
	 */
	@Override
	public ResponseWrapper addEquipment(EquipmentWrapper ewForm) {
		// TODO Auto-generated method stub
		String str = null;
		try {
			str = mapper.writeValueAsString(ewForm);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Accept", "application/json");
		HttpEntity<String> request = new HttpEntity<String>(str, headers);
		String url=EIConstant.CON_URL+EIConstant.DBNAME;
		ResponseEntity<ResponseWrapper> responseBody = rt.exchange(url, HttpMethod.POST,request, ResponseWrapper.class);
        return responseBody.getBody();
	}

	

}
