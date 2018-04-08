package Service.domain;

public class Technician {
	private String tname;
	private String thpnum;
	private String workingdate;


	public Technician(String tname,String thpnum, String workingdate) {
		this.tname=tname;
		this.thpnum=thpnum;
		this.workingdate=workingdate;
	}
	
	public String getTname() {
		return tname;
	}
	
	public String getThpnum() {
		return thpnum;
	}
	
	public String getWorkingdate() {
		return workingdate;
	}
	
	

}
