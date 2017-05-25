package com.spallya.handler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsHandler {
	@SuppressWarnings("unused")
	private BufferedReader bufferObj;

	public Boolean doesFileExists(String fileName) {
		try{
			bufferObj = new BufferedReader(new FileReader(fileName));
			System.out.println();
            System.out.println("CSV file successfully loaded.");
		} catch(FileNotFoundException fofExceptionCaught){
			System.out.println("File Not Found Exception Caught. Please enter the"
								+ " correct path of file.");
			return false;
        }
		return true;
	}
	
	public boolean gettingOutOfBound(int maxLimit, int userChoice){
		if((userChoice<= 0) || (userChoice > maxLimit))
			return true;
		return false;
	}
}
