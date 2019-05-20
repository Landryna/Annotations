package main;

public class VinputText {
	
	//entered String every 85milisecond, checkinch if its valid
	public static String value;
	public static void registerValidaor(Validator validator)
	{
		validator.validate(value);	
	}

}
