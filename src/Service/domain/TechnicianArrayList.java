package Service.domain;

import java.util.List;
import java.util.ArrayList;


public class TechnicianArrayList implements ITechnicianList{
	private List<Technician> technicians;
	
	public TechnicianArrayList() {
		technicians = new ArrayList<Technician>();
	}
	
	public void addTechnician(String name, String hpnum,String date) {
		Technician aTechnician = new Technician(name, hpnum,date);
		technicians.add(aTechnician);
	}
	
	public Technician searchTechnicians(String date) {
		Technician theTechnician = null;
		boolean found = false;
		int i = 0;
		
		while(i<technicians.size() && !found) {
			theTechnician = technicians.get(i);
			if(theTechnician.getWorkingdate().equals(date)) {
				found = true;
			} else {
				i++;
			}
		}
		
		if(found)
			return theTechnician;
		else
			return null;
		
	}
	
	/*public int getnumberOfTechnicians() {
		return technicians.size();
	}*/
}
