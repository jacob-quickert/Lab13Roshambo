package lab13roshambo;

public abstract class Player {
	private String name;
	private Roshambo r;
	
	
	
	public abstract Roshambo generateRoshambo();



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Roshambo getR() {
		return r;
	}



	public void setR(Roshambo r) {
		this.r = r;
	} 
	
	
	

}
