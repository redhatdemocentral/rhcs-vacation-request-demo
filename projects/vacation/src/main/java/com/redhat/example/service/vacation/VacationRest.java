/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.example.service.vacation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.redhat.example.service.vacation.domain.Vacation;
import com.redhat.example.service.vacation.domain.VacationRequest;



@Path("/")
@ApplicationScoped
public class VacationRest {
	@Inject VacationService vs;

    @GET
    @Path("/hours/{id}")
    @Produces({ "application/json" })
    public double getHours(@PathParam("id") String id) {
    	System.out.println(">> Hours requested for: " + id);
        return vs.getHours(id);
    }

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    public Vacation getVacation(@PathParam("id") String id) {
    	System.out.println(">> Vacation information requested for: " + id);
    	return vs.getVacations().get(id);
    }
    
    @GET
    @Path("/")
    @Produces({ "application/json" })
    public List<Vacation> getVacations() {
    	System.out.println(">> Vacation information list requested");
    	List<Vacation> vList = new ArrayList<Vacation>();
    	for (Map.Entry<String, Vacation> entry : vs.getVacations().entrySet()) {
    		vList.add(entry.getValue());
    	}
    	return vList;
    }
    
    @POST
    @Path("/request")
    @Produces({ "application/json" })
    public Vacation requestVacation(VacationRequest vr) {
    	if(vr == null) {
    		System.out.println(">> Vacation request inbound object is null");
    	}
    	System.out.println(">> Vacation request submitted of: " + vr.getAssociateId() + " for " + vr.getHours() + " hours");
    	return vs.requestVacation(vr);
    }

    
    @GET
    @Path("/request/blankdate")
    @Produces({ "application/json" })
    public VacationRequest getVR() {
    	
    	Date startD = new Date(System.currentTimeMillis());
    	Date endD = new Date((System.currentTimeMillis()-(5 * (1000 * 60 * 60 * 24))));
    	
    	VacationRequest vr = new VacationRequest();
    	vr.setAssociateId("1");
    	vr.setId("1");
    	vr.setStartDate(startD);
    	vr.setEndDate(endD);
    	return vr;
    }
}
