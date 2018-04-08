package Service.domain;

public class Controller {

	private IClientList clientList;
	
	private ITechnicianList technicianList;
	
	private IServiceList serviceList;
	
	private Service selectedService;
	
	private Client selectedClient;
	
	
	public Controller() {
		clientList = new ClientArrayList();
		technicianList = new TechnicianArrayList();
		serviceList = new ServiceArrayList();
		selectedService = null;
		selectedClient = null;
	}

	//get selected service yes
	public Service getSelectedService() {
		return selectedService;
	}
	
	//create new client yes
	public void registerClient(String name, String address, String hpnum) {
		selectedClient = clientList.registerClient(name,address,hpnum,selectedService);
		selectedService.setClient(selectedClient);
	}
	
	
	//create new technician yes
	public void addTechnician(String name, String hpnum,String date) {	
		technicianList.addTechnician(name, hpnum,date);
	}
	
	//create new service yes
	public void createService(int id) {
		selectedService = serviceList.createService(id);
	}
	
	//search and display entered client name yes
	public Client searchClient(String name) {
		return clientList.searchClient(name);
	}
	
	//search and display services yes
	public Service searchServices(int id) {
		return serviceList.searchServices(id);
	}
	
	//search and display technicians yes
	public Technician searchTechnician (String date) {
		return technicianList.searchTechnicians(date);
	}
	
	//assign technician to the selected service yes
	public void technicianAssignment(String tdate, Service aService,String tname, String thpnum) {
		selectedService =getSelectedService();
		Technician theTechnician = searchTechnician(tdate);
		selectedService.setTechnician(theTechnician);
		selectedService.updateDate(tdate);
	}
	
	//record service charge yes
	public void recordServiceCharge(Service theService, double charge) {
		selectedService=theService;
		selectedService.updateCharge(charge);
	} 
	
	
}
