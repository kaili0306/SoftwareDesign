package Service.ui;

import java.util.Scanner;

import Service.domain.*;

public class ConsoleUI implements IUserInterface{
	private Scanner scanner;
	
	private Controller controller;
	
	private int id;
	
	public ConsoleUI() {
		scanner = new Scanner(System.in);
		id = 1;
	}
	
	public void setController(Controller controller) {
		this.controller=controller;
	}
	
	public void start() {
		int selection;
		
		do {
			System.out.println("***********************************************");
			System.out.println("Choose an action to: ");
			System.out.println("1.Register request for client");
			System.out.println("2.create new technician");
			System.out.println("3.Search available technician");
			System.out.println("4.Search Client");
			System.out.println("5.Search Services");
			System.out.println("6.Assign technician to the request");
			System.out.println("7.Record Service charge");
			System.out.println("8.Exit");
			System.out.println("***********************************************");
			System.out.print("Please choose an action: ");
			
			selection = scanner.nextInt();
			while(selection < 1 || selection >8) {
				System.out.println("Invalid choice");
				System.out.print("Choose an action again: ");
				selection = scanner.nextInt();
			}
			
			switch(selection) {
			case 1: registerClient(); break;
			case 2: registerTechnician();break;
			case 3: searchtechnician(); break;
			case 4: searchClient(); break;
			case 5: searchService(); break;
			case 6: assigntechnician(); break;
			case 7: recordServiceCharge(); break;
			case 8: System.out.println("GoodBye!");System.exit(0);
			}
			
			System.out.println();
		}while(selection != 8);
	}
	
	private void registerClient() {
		System.out.println("\nRegister client request ");
		System.out.println("========================================");
		
		System.out.print("Enter client name: ");
		String skip = scanner.nextLine();
		String cname = scanner.nextLine();
		
		System.out.print("Enter client address: ");
		String caddress = scanner.nextLine();
		
		System.out.print("Enter client phone number: ");
		String chpnum = scanner.nextLine();
				
		controller.createService(id);
		controller.registerClient(cname, caddress, chpnum);
		
		System.out.println("\nService ID: "+ id);
		System.out.println("Request recorded.");
		id++;
		
	}
	
	private void registerTechnician() {
		System.out.println("\nCreate new technician");
		System.out.println("========================================");
		
		System.out.print("Enter technician name: ");
		String skip = scanner.nextLine();
		String tname = scanner.nextLine();
		
		System.out.println("Enter Technician phone number: ");
		String thpnum = scanner.nextLine();
		
		System.out.println("Enter Technician Working date: ");
		String date = scanner.nextLine();
		
		controller.addTechnician(tname, thpnum,date);
		System.out.println("technician created.");
		
	}
	
	private void searchtechnician() { 
		System.out.println("\nSearch available technician");
		System.out.println("========================================");
		
		System.out.print("Enter date to search for available technician: ");
		String skip = scanner.nextLine();
		String date = scanner.nextLine();
		Technician theTechnician = controller.searchTechnician(date);
		if(theTechnician == null) {
			System.out.println("No Technician on "+ date +" found");
		}else {
			System.out.println("Available Technician(s) on "+date+" :");
			System.out.println("Technician Name: "+theTechnician.getTname());
			System.out.println("Technician phone number: "+theTechnician.getThpnum());
		}
		
	}
	
	private void searchClient() { 
		System.out.println("\nSearch Client");
		System.out.println("========================================");
		
		System.out.print("Enter Client Name: ");
		String skip = scanner.nextLine();
		String cname= scanner.nextLine();
		Client theClient = controller.searchClient(cname);
		if(theClient == null) {
			System.out.println("No Client with "+ cname +" found");
		}else {
			System.out.println("Client name: "+theClient.getCName());
			System.out.println("Client Address: "+theClient.getCAddress());
			System.out.println("Client phone number: "+theClient.getCHpNum());
		}
		
	}
	
	private void searchService() {
		
		System.out.println("\nSearch service");
		System.out.println("========================================");
			
		System.out.print("Enter Service ID: ");
		int sid= scanner.nextInt();
		Service theService = controller.searchServices(sid);
		if(theService == null) {
			System.out.println("No Client with Service Id "+ sid +" found");
		}else {
			Service selectedService = controller.searchServices(sid);
			
			if(selectedService != null) {
				System.out.println("Service ID: "+sid);
				System.out.println("Client name: "+theService.getClient().getCName());
				System.out.println("Client address: "+theService.getClient().getCAddress());
				System.out.println("Client hpnum: "+theService.getClient().getCHpNum());

			}
		}
		
	}
	
	private void assigntechnician() {
		
		System.out.println("\nAssign Technician");
		System.out.println("========================================");
		
		searchtechnician();

		searchService();
		
		Service aService =controller.getSelectedService();
			
		System.out.println("\nEnter technician details to assign technician: ");
		System.out.print("Enter technician name: ");
		String skip = scanner.nextLine();
		String tname= scanner.nextLine();
	
		System.out.print("Enter technician phone number: ");
		String thpnum = scanner.nextLine();
	
		System.out.print("Enter Service Date: ");
		String tdate = scanner.nextLine();
			
		controller.technicianAssignment(tdate, aService, tname, thpnum);
		
		System.out.println("Technician Assigned!");

	}
	
	public void recordServiceCharge() {
		System.out.println("\nRecord Service Charge");
		System.out.println("========================================");
		
		searchService();
		
		Service selectedService = controller.getSelectedService();
		
		if(selectedService.getDate()!= null && selectedService.getTechnician()!=null) {
		System.out.println("Service Date: "+selectedService.getDate());
		System.out.println("Technician: "+selectedService.getTechnician().getTname());
		
		System.out.println("Enter service charge: ");
		double charge= scanner.nextDouble();
		
		controller.recordServiceCharge(selectedService, charge);
		
		System.out.println("Service charge recorded!");
		System.out.println("Service Charge: RM"+selectedService.getCharge());
		
		}else {
			System.out.println("Technician has not assigned!");
		}
	}
}
