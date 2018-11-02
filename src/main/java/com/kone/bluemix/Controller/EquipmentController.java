package com.kone.bluemix.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.kone.bluemix.ExceptionHandling.ErrorCustomResponse;
import com.kone.bluemix.ModelWrapper.EquipmentWrapper;
import com.kone.bluemix.ModelWrapper.ResponseWrapper;
import com.kone.bluemix.ModelWrapper.RowWrapper;
import com.kone.bluemix.Service.EquipmentService;
import com.kone.bluemix.Utils.EIConstant;

/**
 * @author sradhakrishnan2
 * 
 *         Rest Controller to control the whole application
 *
 */
@Controller
@RequestMapping("/")
public class EquipmentController {

	@Autowired
	private EquipmentService es;
	
	@Autowired
    @Qualifier("simpleRestTemplate")
    private RestTemplate rt;

	/**
	   This is control will take to the index page to lauch application
	*/
	@GetMapping(value = "")
	public String indexpage(Model model) {
		
		return "index";
	}

	/**
	   This is control will helps to add new equipment into cloudant DB
	*/
	@GetMapping(value = "addequip")
	public String addEquipment(Model model) {
		EquipmentWrapper ew = new EquipmentWrapper();
		model.addAttribute("ewForm", ew);
		return "add";
	}

	/**
	   This is control will helps to retrieve all equipment details from cloudant DB
	*/
	@GetMapping(value = "allequip")
	public String allEquipments(Model model) {
		List<EquipmentWrapper> resp = es.allEquipments();
		model.addAttribute("resp", resp);
		return "allequip";

	}

	/**
	   This is control will helps to retrieve equipment details by equipment id from cloudant DB
	*/
	/**
	 * @param eid
	 * @param model
	 * @return 
	 */
	@PostMapping(value = "equipid")
	public String trackEquipment(@RequestParam("id") String eid, Model model) {
		String dURL=EIConstant.CON_URL+EIConstant.DBNAME+EIConstant.DOC+EIConstant.DOC_CHECK+EIConstant.QUOTE+eid+EIConstant.QUOTE;
	
		List<RowWrapper> ob=new ArrayList<>(Arrays.asList(es.allDocs(dURL).getBody().getRows()));
		EquipmentWrapper resp = new EquipmentWrapper();
		if(!ob.isEmpty() || !ob.equals(null)) {
		resp = es.trackEquipment(eid);
		model.addAttribute("resp", resp);
		return "equipment";
		}else {
			ErrorCustomResponse err= new ErrorCustomResponse();
			err.setDetail(eid);
			err.setMessage("Equipment doesn't exist. Please add into the Inventory");
			model.addAttribute("resp", err);

			return "error";
		}
		
		
		
	}
	
	/**
	   This is control will helps to retrieve equipment details by equipment id from cloudant DB
	*/
	/**
	 * @param model
	 * @return
	 */
	@GetMapping(value = "equipid")
	public String trackEquipmentbyIDisplay(Model model) {
		return "equipid";
	}

	/**
	   This is control will helps to add new equipment into cloudant DB
	*/
	/**
	 * @param ewForm
	 * @param model
	 * @return
	 */
	@PostMapping(value = "addequip")
	public String addEquipment(@ModelAttribute("ewForm") EquipmentWrapper ewForm, Model model) {
		
		String dURL=EIConstant.CON_URL+EIConstant.DBNAME+EIConstant.DOC+EIConstant.DOC_CHECK+EIConstant.QUOTE+ewForm.getId()+EIConstant.QUOTE;
		
		RowWrapper[] ob=es.allDocs(dURL).getBody().getRows();
		ResponseWrapper resp = new ResponseWrapper();
		if(ob.length==0) {
			resp = es.addEquipment(ewForm);
			model.addAttribute("resp", resp);
			model.addAttribute("msg", "Equipment Added Successfully");		
		return "success";
		}else {
			ErrorCustomResponse err= new ErrorCustomResponse();
			err.setDetail(ewForm.getId());
			err.setMessage("Equipment Already exist in the Inventory");
			model.addAttribute("resp", err);

			return "error";
		}
		

	}

}
