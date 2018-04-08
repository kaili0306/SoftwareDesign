package Service.domain;



public class Service {
	private double service_charge;
	private String service_Date;
	private int s_id;
	private Client client;
	private Technician technician;
	
	
	public Service(int id){
		s_id=id;
	}
	
	public double getCharge() {
		return service_charge;
	}
	
	public String getDate() {
		return service_Date;
	}
	
	public int getID() {
		return s_id;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Technician getTechnician() {
		return technician;
	}
	
	public void setTechnician(Technician technician) {
		this.technician=technician;
	}

	public void updateCharge(double charge) {
		service_charge=charge;
	}
	
	public void updateDate(String date) {
		service_Date=date;
	}
}
