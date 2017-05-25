package com.cognizant.handler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import com.cognizant.model.Flat;

public class ScreenHandlerImplementation implements ScreenHandler {

	static Scanner scannerObj = new Scanner(System.in);
	static CsvFileHandler csvFileHandlerImplObj = new CsvFileHandlerImplementation();
	static JdbcHandler jdbcHandlerObj = new JdbcHandler();
	static ScreenHandlerImplementation screenHandlerImplementationObj = new 
														ScreenHandlerImplementation();
	static ExceptionsHandler exceptionsHandlerObj = new ExceptionsHandler();
	
	public static int mainChoice;
	public static int sortChoice = 0;
	public static int orderChoice = 0;
	public static int filterChoice = 0;
	public static int filterEntityChoice = 0;
	public static ArrayList<Flat> flatsList;
	public static ArrayList<Flat> filteredFlatsList;
	public static HashSet<String> uniqueNamesSet;
	public static HashSet<Integer> uniqueNumbersSet;
	public static String[] columnNames = {"street","city","zip","state","beds","baths","sqFeet",
											"type","saleDate","price","latitude","longitude",};
	
	public void loadFile(String fileName){
		flatsList = csvFileHandlerImplObj.readAndLoadAllContentInList(fileName);
	}
	
	public void mainMenu(){
		do{
			System.out.println();
			System.out.println("1.Display all contents of CSV File \n2.Sort CSV File according to "
								+ "Particular Column\n3.Filter CSV File\n4.Insert data of CSV file "
								+ "into database\n5.Search CSV File\n6.Exit");
			mainChoice = scannerObj.nextInt();
			switch(mainChoice){
			case 1:{
				csvFileHandlerImplObj.showAllContentsOfList(flatsList);
				break;
			}
			case 2:{
				screenHandlerImplementationObj.sortMenu();
				break;
			}
			case 3:{
				screenHandlerImplementationObj.filterMenu();
				break;
			}
			case 4:{
				try {
					jdbcHandlerObj.csvFileDataInsertionIntoDatabase(flatsList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			case 5:{
				screenHandlerImplementationObj.searchMenu();
				break;
			}
			case 6:{
				System.out.println("Exited successfully.");
				break;
			}
			default:{
				System.out.println("Please choose the correct option.");
				break;
			}
			}
		}while(mainChoice != 6);
	}
	
	public void sortMenu(){
		int flagForSort = 0;
		int flagForOrder = 0;
		while(flagForSort == 0){
			System.out.println();
			System.out.println("Enter the number corresponding to column name");
	        System.out.println("1.Street\n2.City\n3.Zip Code\n4.State\n5.Number "
	        		+ "of beds\n6.Number of baths\n7.Area in square feet\n8.Type\n"
	        		+ "9.Date of sale\n10.Price\n11.Latitude\n12.Longitude");
	        sortChoice = scannerObj.nextInt();
	        if((sortChoice>=1)&&(sortChoice<=12))
	        	flagForSort = 1;
	        else
	        	System.out.println("Please choose the correct option.");
		}
		while(flagForOrder == 0){
			System.out.println("Select the order of sorting:\n1.In ascending order\n2."
	        		+ "In descending order");
	        orderChoice = scannerObj.nextInt();
	        if((orderChoice>=1)&&(orderChoice<=2))
	        	flagForOrder = 1;
	        else
	        	System.out.println("Please choose the correct option.");
		}
        csvFileHandlerImplObj.sortListInAscOrDscOrder(flatsList, columnNames[sortChoice-1], orderChoice);
		csvFileHandlerImplObj.showAllContentsOfList(flatsList);
	}
	
	public void filterMenu(){
		System.out.println();
		do{
			System.out.println("Please select the column by which you want to filter the data:");
			System.out.println("1.By city name\n2.By state name\n3.By zip code\n4.By type of flat\n5.By number of"
								+ " beds\n6.By number of baths");
			filterChoice = scannerObj.nextInt();
			switch(filterChoice){
			case 1:{
				int iterator = 1;
				uniqueNamesSet = (HashSet<String>) csvFileHandlerImplObj.getUniqueCityNames(flatsList);
				do{
					iterator = 1;
					System.out.println();
					System.out.println("Please choose a prticular city");
					for(String cityName : uniqueNamesSet){
						System.out.println(iterator+"."+cityName);
						iterator++;
					}
					filterEntityChoice = scannerObj.nextInt();
					if(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true)
						System.out.println("Please choose the correct option.");
				} while(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true);
				String cityNameToFilter = uniqueNamesSet.toArray()[filterEntityChoice-1].toString();
				filteredFlatsList = csvFileHandlerImplObj.filterListByColumnNameAndEntiyName(flatsList, columnNames[1],
																								       cityNameToFilter);
				csvFileHandlerImplObj.showAllContentsOfList(filteredFlatsList);
				break;
			}
			case 2:{
				int iterator = 1;
				uniqueNamesSet = (HashSet<String>) csvFileHandlerImplObj.getUniqueStateNames(flatsList);
				do{
					iterator = 1;
					System.out.println();
					System.out.println("Please choose a prticular state");
					for(String stateName : uniqueNamesSet){
						System.out.println(iterator+"."+stateName);
						iterator++;
					}
					filterEntityChoice = scannerObj.nextInt();
					if(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true)
						System.out.println("Please choose the correct option.");
				} while(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true);
				String stateNameToFilter = uniqueNamesSet.toArray()[filterEntityChoice-1].toString();
				filteredFlatsList = csvFileHandlerImplObj.filterListByColumnNameAndEntiyName(flatsList, columnNames[3],
																									stateNameToFilter);
				csvFileHandlerImplObj.showAllContentsOfList(filteredFlatsList);
				break;
			}
			case 3:{
				int iterator = 1;
				uniqueNumbersSet = (HashSet<Integer>) csvFileHandlerImplObj.getUniqueZipCodes(flatsList);
				do{
					iterator = 1;
					System.out.println();
					System.out.println("Please choose a prticular zip code");
					for(Integer zipCode : uniqueNumbersSet){
						System.out.println(iterator+"."+zipCode);
						iterator++;
					}
					filterEntityChoice = scannerObj.nextInt();
					if(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true)
						System.out.println("Please choose the correct option.");
				} while(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true);
				String zipCodeToFilter = uniqueNumbersSet.toArray()[filterEntityChoice-1].toString();
				filteredFlatsList = csvFileHandlerImplObj.filterListByColumnNameAndEntiyName(flatsList, columnNames[2],
																										zipCodeToFilter);
				csvFileHandlerImplObj.showAllContentsOfList(filteredFlatsList);
				break;
			}
			case 4:{
				int iterator = 1;
				uniqueNamesSet = (HashSet<String>) csvFileHandlerImplObj.getUniqueTypes(flatsList);
				do{
					iterator = 1;
					System.out.println();
					System.out.println("Please choose a prticular type");
					for(String typeName : uniqueNamesSet){
						System.out.println(iterator+"."+typeName);
						iterator++;
					}
					filterEntityChoice = scannerObj.nextInt();
					if(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true)
						System.out.println("Please choose the correct option.");
				} while(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true);
				String typeNameToFilter = uniqueNamesSet.toArray()[filterEntityChoice-1].toString();
				filteredFlatsList = csvFileHandlerImplObj.filterListByColumnNameAndEntiyName(flatsList, "type",
																								typeNameToFilter);
				csvFileHandlerImplObj.showAllContentsOfList(filteredFlatsList);
				break;
			}
			case 5:{
				int iterator = 1;
				uniqueNumbersSet = (HashSet<Integer>) csvFileHandlerImplObj.getUniqueNumberOfBeds(flatsList);
				do{
					iterator = 1;
					System.out.println();
					System.out.println("Please choose a prticular number of beds");
					for(Integer numberOfBeds : uniqueNumbersSet){
						System.out.println(iterator+"."+numberOfBeds);
						iterator++;
					}
					filterEntityChoice = scannerObj.nextInt();
					if(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true)
						System.out.println("Please choose the correct option.");
				} while(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true);
				String numberOfBedsToFilter = uniqueNumbersSet.toArray()[filterEntityChoice-1].toString();
				filteredFlatsList = csvFileHandlerImplObj.filterListByColumnNameAndEntiyName(flatsList, "beds",
																							numberOfBedsToFilter);
				csvFileHandlerImplObj.showAllContentsOfList(filteredFlatsList);
				break;
			}
			case 6:{
				int iterator = 1;
				uniqueNumbersSet = (HashSet<Integer>) csvFileHandlerImplObj.getUniqueNumberOfBaths(flatsList);
				do{
					iterator = 1;
					System.out.println();
					System.out.println("Please choose a prticular number of beds");
					for(Integer numberOfBaths : uniqueNumbersSet){
						System.out.println(iterator+"."+numberOfBaths);
						iterator++;
					}
					filterEntityChoice = scannerObj.nextInt();
					if(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true)
						System.out.println("Please choose the correct option.");
				} while(exceptionsHandlerObj.gettingOutOfBound(iterator, filterEntityChoice) == true);
				String numberOfBathsToFilter = uniqueNumbersSet.toArray()[filterEntityChoice-1].toString();
				filteredFlatsList = csvFileHandlerImplObj.filterListByColumnNameAndEntiyName(flatsList, "baths",
																							numberOfBathsToFilter);
				csvFileHandlerImplObj.showAllContentsOfList(filteredFlatsList);
				break;
			}
			default:{
				System.out.println("Please choose the correct option.");
				break;
			}
			}
		} while((filterChoice <= 0) || (filterChoice > 6));		
	}
	
	public void searchMenu(){
		
	}
	
}
