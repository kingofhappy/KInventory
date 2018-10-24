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

![img1](https://user-images.githubusercontent.com/17136989/47404695-f06dcb80-d76b-11e8-8d1c-7a32276eecae.png)

Use Case 2(Searching Equipment by EquipmentID)

	It will help to search particular equipment status and where it is running those information we can get through rest api calls and displayed in html page as tabular format 
	Request URL: https://kinv.eu-gb.mybluemix.net/equipid
	Request Parameter: equipmentNumber
	Response: {EquipmentNumber, Address, Contract Start Date, Contract End Date, Status}

![img2](https://user-images.githubusercontent.com/17136989/47404696-f06dcb80-d76b-11e8-9ddd-aafa17fb2311.png)

![img3](https://user-images.githubusercontent.com/17136989/47404697-f1066200-d76b-11e8-99b0-dd9adfe2742f.png)

Use Case 3(Adding new equipment to Inventory)
	
	This functionality will helps you to add new equipment details into CloudantDB.
	Request URL: https://kinv.eu-gb.mybluemix.net/addequip
	Request Body: {EquipmentNumber, Address, Contract Start Date, Contract End Date, Status}
	Response Body: {EquipmentNumber, rev, ok}
	
![img4](https://user-images.githubusercontent.com/17136989/47404698-f19ef880-d76b-11e8-97b0-5994a9a2952d.png)
![img5](https://user-images.githubusercontent.com/17136989/47404692-efd53500-d76b-11e8-9a05-1c380f7be348.png)
![img6](https://user-images.githubusercontent.com/17136989/47404694-efd53500-d76b-11e8-980c-06a512dd19b1.PNG)

 
