//Jorell Socorro Exercise 4 BMI Testing
import java.util.*;
import java.text.*;
public class bmiTest {
	public static void main(String[]args) {
		//Formats the decimal to its thousandth place
		DecimalFormat df = new DecimalFormat("#.###");
		//declare Scanner class
		Scanner scan = new Scanner(System.in);
		//declare the variables
		String name, input;
		int weight, feet, inches;
		//Determines Metric or English
		System.out.println("Do you want to use metric(m) or english(e) units??");
		input = scan.next();
		
		//This is the English system
		if (input.contentEquals("e")) {
			System.out.println("What is your name?");
			name = scan.next();
			//Prompts the user their height first in ft then in inches
			System.out.println("What is your height in feet?");
			feet = scan.nextInt();
			System.out.println("Inches?");
			inches = scan.nextInt();
			/*
			System.out.println("Test Result:"+
			df.format(meterConvert(feet, inches))+"m");
			*/
			//Prompts the user their weight in pounds
			System.out.println("What is your weight in lbs?");
			weight = scan.nextInt();
			/*
			System.out.println("Test Result:"+
			df.format(weightConvert(weight))+"kg");
			*/
			//declare variables that will calculate the BMI in metric
			double meter,kilo, BMI;
			meter = meterConvert(feet, inches);
			kilo = weightConvert(weight);
			BMI = BMIM(meter, kilo);
			//outputs the BMI 
			System.out.println("Your BMI is:"+df.format(BMI));
			//Determines where you scale
			if(BMI>30) {
				System.out.println("You are obese!!! You gotta go on a diet!!!");
			}
			else if(BMI < 29.99 && BMI > 25){
				System.out.println("You are overweight, slow down your eating!!!");
			}
			else if(BMI < 24.6 && BMI > 18.5){
				System.out.println("You have a normal BMI, awesome!!!");
			}
			else {
				System.out.println("You are underweight, eat more!!!");
			}
			//Display user info
			System.out.println("User inputs:\n"
			+"Height:"+feet+"'"+inches+"\n"
			+"Weight:"+weight+"lbs"+"\n"
			+"Signature:"+name);
		}
		
		//This is the metric system 
		else if(input.contentEquals("m")) {
			System.out.println("What is your name?");
			name = scan.next();
			
			//Prompts the user their height first in ft then in inches
			System.out.println("What is your height in inches?");
			inches = scan.nextInt();
			
			//Prompts the user their weight
			System.out.println("What is your weight in ounces?");
			weight = scan.nextInt();
			int pounds = weightConvertOunces(weight);
			//System.out.println("Pounds:"+pounds);
			double BMI = BMIE(pounds,inches);
			System.out.println("Your BMI is:"+df.format(BMI));
			//Determines where you scale
			if(BMI>30) {
				System.out.println("You are obese!!! You gotta go on a diet!!!");
			}
			else if(BMI < 29.99 && BMI > 25){
				System.out.println("You are overweight, slow down your eating!!!");
			}
			else if(BMI < 24.6 && BMI > 18.5){
				System.out.println("You have a normal BMI, awesome!!!");
			}
			else {
				System.out.println("You are underweight, eat more!!!");
			}
			//Display user info
			System.out.println("User inputs:\n"
			+"Height:"+inches+"inches"+"\n"
			+"Weight:"+weight+"ounces"+"\n"
			+"Signature:"+name);
			
		}
		
	}
	
	//////////////////ALL OF THE METHODS THAT CONVERTS AND CALCULATES//////////////////////////////////
	
	//converts feet and inches into meters
	public static double meterConvert(double f, double i) {
		double exFt= i/12;
		double totalFt = (double)f + exFt;
		double meter = totalFt/3.2808;
		return (double) meter;
	}
	//converts the weight from pounds to kilograms
	public static double weightConvert(int w) {
		double kilo = w/2.2;
		return (double) kilo;
	}
	public static int weightConvertOunces(int o) {
		int pounds = o/16;
		return pounds;
	}
	//Calculates BMI in English
	public static double BMIM(double m, double k) {
		double resultBMI = k/(m*m);
		return resultBMI;
	}
	//Calculate BMI in metric
	public static double BMIE(double p, double i) {
		double resultBMI = p/(i*i)*703;
		return resultBMI;
	}
}
