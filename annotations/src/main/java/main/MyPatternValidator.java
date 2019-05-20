package main;

import java.lang.annotation.Annotation;

public class MyPatternValidator implements Validator{
	
	public static boolean validatorStatus=false;
	private Pattern pattern;
	private Annotation annotation;
	public void validate(String value) {
		try {
			annotation = Main.field.getAnnotation(Pattern.class);
			pattern = (Pattern) annotation;
			//checking if the value matches to the regex value i entered 
			if(value.matches(pattern.regex()))
			{
				validatorStatus=true;
			}	
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
	}
	public boolean isValid() {
		if(validatorStatus==true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public String getMessage() {
		if(isValid())
		{	
			validatorStatus=false;
			return "Correct";
		}
		else
		{
			return pattern.massage();
		}
		
	
	}

}
