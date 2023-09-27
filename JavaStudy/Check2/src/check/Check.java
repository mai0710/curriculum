package check;

import constants.Constants;

public class Check {
	

	public static void main(String[] args) { 
		
		final  String firstName = "舞";
		final  String lastName = "須藤";

	    System.out.println(firstName + lastName);
	    
	    
	    Pet pet1 = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
	    RobotPet RP1 = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
	    
	    pet1.introduce();
	    RP1.introduce();
	}
}
