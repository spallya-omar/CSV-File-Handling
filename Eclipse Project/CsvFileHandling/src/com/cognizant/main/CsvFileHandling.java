package com.cognizant.main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cognizant.handler.ExceptionsHandler;
import com.cognizant.handler.ScreenHandler;
import com.cognizant.handler.ScreenHandlerImplementation;

public class CsvFileHandling {

	public static void main(String[] args) throws IOException {
		ExceptionsHandler exceptionsHandlerObj = new ExceptionsHandler();
		ScreenHandler screenHandlerImplObj = new ScreenHandlerImplementation();
		BufferedReader bufferedReaderobj = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer fileName = new StringBuffer();
		System.out.println("Welcome to the Csv File Handling Application.");
		System.out.println();
		do{
			fileName.delete(0, fileName.length());
			System.out.println("Please enter the full path of your csv file.");
			fileName = fileName.append(bufferedReaderobj.readLine());
			System.out.println("Enter the name of the file on which you want to perform actions.");
			fileName = fileName.append("\\").append(bufferedReaderobj.readLine()).append(".csv");
		} while(exceptionsHandlerObj.doesFileExists(fileName.toString()) == false);
		screenHandlerImplObj.loadFile(fileName.toString());
		screenHandlerImplObj.mainMenu();
	}
}
