# KInventory
KInventory


Equipment Inventory Management

Tools and Technology used

•	Spring Tool Suite
•	IBM Cloud (Bluemix) Services - Liberty for Java, CloudantDB
•	Spring Boot 2.0, RestTemplate, ThymeLeaf
Goal
The primary goal of the application is managing inventory for equipment in the organisation. It will provide service like adding the new equipment, searching the existing equipment and listing out all those existing  equipments. 
Use Case 1(fetch X Equipment)
	
	It will fetch all those records from CloudantDB using rest api call and displayed in html page as tabular format 
	Request URL: https://kinv.eu-gb.mybluemix.net/allequip
	Response: [{EquipmentNumber, Address, Contract Start Date, Contract End Date, Status}]

 
Use Case 2(Searching Equipment by EquipmentID)

	It will help to search particular equipment status and where it is running those information we can get through rest api calls and displayed in html page as tabular format 
	Request URL: https://kinv.eu-gb.mybluemix.net/equipid
	Request Parameter: equipmentNumber
	Response: {EquipmentNumber, Address, Contract Start Date, Contract End Date, Status}

 


 



Use Case 3(Adding new equipment to Inventory)
	
	This functionality will helps you to add new equipment details into CloudantDB.
	Request URL: https://kinv.eu-gb.mybluemix.net/addequip
	Request Body: {EquipmentNumber, Address, Contract Start Date, Contract End Date, Status}
	Response Body: {EquipmentNumber, rev, ok}
	
 

 
