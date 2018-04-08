package Service.domain;

public interface IClientList {
	
	public Client registerClient(String name,String address,String hpnum,Service service);
	
	public Client searchClient(String name);//yes
	
	//public int getNumberOfClients();
	
}
