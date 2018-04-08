package Service.ui;

import Service.domain.Controller;

public class ServiceApp {
	
	private static IUserInterface userInterface;
	
	private static Controller controller;
	
	public static void main(String[] args) {
		
		controller = new Controller();
		
		userInterface = new ConsoleUI();
		
		userInterface.setController(controller);
		
		userInterface.start();
	}

}
