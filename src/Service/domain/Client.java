package Service.domain;

public class Client {
	private String cname;
	private String caddress;
	private String chpnum;
	private Service service;

	public Client(String name,String address,String hpnum,Service service) {
		cname=name;
		caddress=address;
		chpnum=hpnum;
		this.service = service;
	}
	
	public String getCName() {
		return cname;
	}
	
	public String getCHpNum() {
		return chpnum;
	}
	
	public String getCAddress() {
		return caddress;
	}
	
	public Service getService() {
		return service;
	}
}
