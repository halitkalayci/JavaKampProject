package eCommerceSimulation.core.utils;

public class BusinessRules {
	// TODO : Implementation of IResult
    public static boolean run(boolean... logics) {
   	 for(boolean b : logics) {
   		 if(!b) return false;
   	 }
   	 return true;
    }
}
