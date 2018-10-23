package com.kone.bluemix.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kone.bluemix.ModelWrapper.EquipmentWrapper;
import com.kone.bluemix.ModelWrapper.ResponseWrapper;

/**
 * @author sradhakrishnan2
 *
 */
@Service
public interface EquipmentService {

	public List<EquipmentWrapper> allEquipments();

	public EquipmentWrapper trackEquipment(String eid);

	public ResponseWrapper addEquipment(EquipmentWrapper ewForm);

}
