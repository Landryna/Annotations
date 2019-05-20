package main;

public class Test {
	
	@Pattern(massage="Invalid input type.\nValid input for example: 00-000",regex="\\d\\d-\\d\\d\\d")
	public String postalCode;

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
