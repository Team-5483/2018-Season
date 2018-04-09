package org.usfirst.frc.team5483.utils;

public class Maths {
	
	public static double square(double a) {
		if(a > 0)
			return a*a;
		return -a*a;
	}
	
	public static double cube(double a) {
		return a*a*a;
	}
	
	public static double sig(double a) {
		return 2*(1/( 1 + Math.pow(Math.E,(-1*(5*a))))-0.5);
	}
	
	public static double sig2(double a) {
		int b = 1;
		if( a < 0) b = -1;

		
		return b*((1/(1 + Math.pow(Math.E,((b*-4*a)+3)))) + 0.2);
	}
	
	public static double sig3(double a) {
		if(a ==0) return 0;
		int b = 1;
		if( a < 0) b = -1;
		return b*((1/(1 + Math.pow(Math.E,((b*-4*a)+3)))))*1.2;
		
	}
}
