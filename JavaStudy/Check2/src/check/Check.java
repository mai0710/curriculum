package check;

import constants.Constants;

public class Check {
	
	private  String firstName = "舞";
	private  String lastName ="須藤";
	
	public void pl(){
		System.out.println(firstName + lastName);
	}
	
	public static void main(String[] args) { 
		
		Check woman = new Check();
		woman.pl();
	
		
	    Pet pet1 = new Pet(Constants.CHECK_CLASS_JAVA,Constants.CHECK_CLASS_HOGE);
	    RobotPet RP1 = new RobotPet(Constants.CHECK_CLASS_R2D2,Constants.CHECK_CLASS_LUKE);
	    
	    pet1.introduce();
	    RP1.introduce();
	}
}