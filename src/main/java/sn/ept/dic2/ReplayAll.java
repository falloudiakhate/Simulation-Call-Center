package sn.ept.dic2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import sn.ept.dic2.utils.Utils;

public class ReplayAll {
	
	static int jour = 0;
	
	/**
	 * For simulating the next day
	 */
	public static void nextDay() {
		if(jour == 307) return; // There are only 307 days in the dataset
		jour += 1;
		
		ReplayDay simulation = new ReplayDay();
		try {
			System.out.println("Simulating day : " + jour);
			simulation.simulateOneDay(100000.0, "jours/jour-" + jour + ".csv");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		try {
			Utils.writeHeadersToCSV("final.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ReplayAll.nextDay();
		
	}

}
