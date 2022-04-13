package com.epam.utility;
import java.util.*;
public class ScannerUtil {
	
	private static Scanner sc;
    private ScannerUtil()
	{
		
	}
	
	public static Scanner getScanner()
	{
		sc=new Scanner(System.in);
		return sc;
	}

}
