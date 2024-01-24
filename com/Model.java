package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
	Map<String,User> usersMap=new HashMap<>();
	List<Bus> busList  = new ArrayList<>();
	public Model() {
	
	User u1 = new User("eluri", "ambika", "123456789", "F", "nagambika@gmail.com", "143143");
	usersMap.put("nagambika@gmail.com", u1);
	User u2 = new User("eluri", "kalyan", "678954321", "M", "kalyan@gmail.com", "123456");
	usersMap.put("kalyan@gmail.com", u2);
	User u3 = new User("chandra", "mani", "9177183005", "M", "chandramani@gmail.com", "987654");
	usersMap.put("chandramani@gmail.com", u3);
	User u4 = new User("pawan", "kalyan", "9999599995", "M", "pawankalyan@gmail.com", "010101");
	usersMap.put("pawankalyan@gmail.com", u4);
	User u5 = new User("ram", "charan", "889743325", "M", "ramcharan@gmail.com", "741852");
	usersMap.put("ramcharan@gmail.com", u5);
	User u6 = new User("eluri", "vamsi", "9182389209", "m", "suryavamsi@gmail.com", "Surya@143");
	usersMap.put("suryavamsi@gmail.com", u6);
	User u7 = new User("pallalemudi", "jaysyam", "8897658352", "m", "jaysyam@gmail.com", "jay123");
	usersMap.put("jaysyam@gmail.com", u7);
	
	
	
	Bus b1 = new Bus("Hyderabad","Kakinada",20,800);
	busList.add(b1);

	Bus b2 = new Bus("Hyderabad","Ravulapalem",30,700);
	busList.add(b2);

	Bus b3 = new Bus("Vijayawada","Tadepalligudem",40,400);
	busList.add(b3);

	Bus b4 = new Bus("Vijayawada","Mandapeta",35,500);
	busList.add(b4);
	}
	public Map<String,User> getMap(){
		
		return usersMap;
	}
	public List<Bus> getBusList(){
		return busList;
	}
	
}
