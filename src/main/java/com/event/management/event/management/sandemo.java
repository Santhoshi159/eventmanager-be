package com.event.management.event.management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
@RequestMapping("/event")
public class sandemo {
	
	@GetMapping

	public String printString() {
		return "team";
	
		// TODO Auto-generated method stub

	}
@GetMapping
@RequestMapping("/name")
public String printStrings() {
	return "santhoshi";
}
@GetMapping
@RequestMapping("/details")
public sample returnDetails() {
	sample Sample=new sample();
	Sample.setName("santhoshi");
	return Sample;
	
}
@GetMapping
@RequestMapping("/san")
public Event returnSan() {
	Event e1=new Event();
	e1.setName("santhoshi");
	e1.setId("82");
	e1.setDate("22");
	e1.setType("type");
	e1.setVenue("coda");
	return e1;
}
@GetMapping
@RequestMapping("details/list")
public List<Event>  returnList(){
List<Event> e1List=new ArrayList<>();

Event e2=new Event();
Event e1=new Event();
e1.setName("santhoshi");
e2.setName("vaishu");
e1.setId("82");
e2.setId("100");
e1.setDate("22");
e1.setDate("22");
e1.setType("type");
e2.setType("xxx");
e1.setVenue("coda");
e2.setVenue("coda");
e1List.add(e1);
e1List.add(e2);
return e1List;

}
@GetMapping
@RequestMapping("/events/list")
public List<Event> getEvent() throws SQLException{
	List<Event> eventList =new ArrayList<>();
	Connection connection=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_db","root","Santhoshi@09");
		Statement statement=connection.createStatement();
		ResultSet results= statement.executeQuery("select * from event");
		while(results.next()) {
			Event event=new Event();
			event.setId(results.getString("id"));
			event.setName(results.getString("name"));
			event.setType(results.getString("type"));
			event.setVenue(results.getString("venue"));
			event.setDate(results.getString("date"));
			eventList.add(event);
			
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		connection.close();
	}
	return eventList;
}

@PostMapping
//@ResponseBody()
@RequestMapping("/sandetails")
public sample1 returnCreate() {
	sample1 Sample=new sample1();
	Sample.setName("santhoshi");
	return Sample;
}



//@PostMapping
//public boolean addEvent(@RequestBodyEvent event) {
//	boolean.isUpdated=eventManagementService.addEvent(event);
	//return isUpdated;
//}
}
