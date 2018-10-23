package com.kone.bluemix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kone.bluemix.ModelWrapper.EquipmentWrapper;
import com.kone.bluemix.ModelWrapper.ResponseWrapper;
import com.kone.bluemix.Service.EquipmentService;

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
	@PostMapping(value = "equipid")
	public String trackEquipment(@RequestParam("id") String eid, Model model) {

		EquipmentWrapper resp = es.trackEquipment(eid);
		model.addAttribute("resp", resp);
		return "equipment";

	}
	
	/**
	   This is control will helps to retrieve equipment details by equipment id from cloudant DB
	*/
	@GetMapping(value = "equipid")
	public String trackEquipmentbyIDisplay(Model model) {
		return "equipid";
	}

	/**
	   This is control will helps to add new equipment into cloudant DB
	*/
	@PostMapping(value = "addequip")
	public String addEquipment(@ModelAttribute("ewForm") EquipmentWrapper ewForm, Model model) {

		ResponseWrapper resp = es.addEquipment(ewForm);
		model.addAttribute("resp", resp);
		return "success";

	}

}
