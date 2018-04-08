package Service.domain;

public interface ITechnicianList {
	
	public void addTechnician(String name, String hpnum,String date);
	
	public Technician searchTechnicians(String date) ;//yes
	
	//public int getnumberOfTechnicians();

}
