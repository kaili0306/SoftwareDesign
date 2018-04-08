package Service.domain;

import java.util.List;
import java.util.ArrayList;


public class ClientArrayList implements IClientList{
	private List<Client> clients;
	
	public ClientArrayList() {
		clients = new ArrayList<Client>();
	}
	
	public Client registerClient(String name,String address, String hpnum,Service service) {
		Client aClient = new Client(name,address,hpnum,service);
		clients.add(aClient);
		return aClient;
	}
	
	public Client searchClient(String name) {
		Client c = null;
		boolean found = false;
		int i=0;
		while(i<clients.size() && !found) {
			c = clients.get(i);
			if(c.getCName().equals(name)) {
				found = true;
			}else {
				i++;
			}
		}
		if(found)
			return c;
		else
			return null;
	}
	
	/*public int getNumberOfClients(){
		return clients.size();
	}*/
	
}
