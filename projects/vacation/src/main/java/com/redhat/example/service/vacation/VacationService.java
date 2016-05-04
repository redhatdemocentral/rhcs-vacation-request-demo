package com.redhat.example.service.vacation;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.redhat.example.service.vacation.domain.Vacation;
import com.redhat.example.service.vacation.domain.VacationRequest;

public class VacationService {
	private Map<String, Vacation> vacations = null;
	public VacationService() {
		
		vacations = new HashMap<String, Vacation>();
		Vacation v1 = new Vacation();
		v1.setFirstName("Alice");
		v1.setLastName("Doe");
		v1.setId("1");
		v1.setHours(80);
		
		Vacation v2 = new Vacation();
		v2.setFirstName("Jack");
		v2.setLastName("Doe");
		v2.setId("2");
		v2.setHours(55);

		Vacation v3 = new Vacation();
		v3.setFirstName("Jane");
		v3.setLastName("Doe");
		v3.setId("3");
		v3.setHours(140);

		vacations.put(v1.getId(), v1);
		vacations.put(v2.getId(), v2);
		vacations.put(v3.getId(), v3);
		
	}
	
	public Map<String, Vacation> getVacations() {
		return vacations;
	}
	
	public double getHours(String id) {
		Vacation v = (Vacation) vacations.get(id);
		return v.getHours();
	}
	
	public Vacation requestVacation(VacationRequest vr) {
		Vacation v = (Vacation) vacations.get(vr.getAssociateId());
		int current = v.getHours();
		v.setHours(current - vr.getHours());
		return v;
	}
	
	public static String getNumberOfDays(Date startDate, Date endDate) {
		long endTime = endDate.getTime();
		long startTime = startDate.getTime();
		long diff = endTime - startTime;
		long days = diff / 1000 / 60 / 60 / 24;
		String sDays = new Long(days).toString();
		return sDays;
	}
	
	
}
