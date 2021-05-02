package utilities;

public class BusinessRules {
	// TO DO : IResult Implementation instead of boolean
    public static boolean Run(boolean... logics) {
    	for(boolean logic : logics) {
    		if(logic==false) return false;
    	}
    	return true;
    }
}
