package Service.domain;

import java.util.List;
import java.util.ArrayList;


public class ServiceArrayList implements IServiceList{
	
	private List<Service> services;
	
	public ServiceArrayList() {
		services = new ArrayList<Service>();
	}
	
	public Service createService(int id) {
		Service aService = new Service(id);
		services.add(aService);
		return aService;
	}
	
	public Service searchServices(int id) {
		Service theService = null;
		boolean found = false;
		int i =0;
		
		System.out.println(services.size());
		while(i<services.size() && !found) {
			theService = services.get(i);
			if(theService.getID()==id) {
				found = true;
			}else {
				i++;
			}
		}
		
		if(found)
			return theService;
		else
			return null;
		
	}
}
