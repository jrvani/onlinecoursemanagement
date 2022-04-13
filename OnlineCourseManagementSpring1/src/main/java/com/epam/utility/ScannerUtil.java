package com.epam.utility;
import java.util.*;
public class ScannerUtil {
	
	private static Scanner sc;
    private ScannerUtil()
	{
		
	}
	
	public static Scanner getScanner()
	{
		if(sc==null) {
		sc=new Scanner(System.in);
		}
		
		return sc;
	}

	

}
