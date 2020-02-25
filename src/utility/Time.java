package utility;

public class Time {
	public static long now(){ 						return System.currentTimeMillis(); 	}
	
	public static boolean isLaterThanNow(long t){ 	return t > now(); 					}
	
	public static boolean isLaterThanNow(int t){ 	return (long)t > now(); 			}
	
	public static long addToNow(long t){ 			return now() + t; 					}
	
	public static long addToNow(int t){ 			return now() + (long)t; 			}
	
	public static long diffFromNow(long t){ 		return now() - t; 					}
}