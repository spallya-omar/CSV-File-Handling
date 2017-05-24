package com.cognizant.handler;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.cognizant.comparator.MyComparator;
import com.cognizant.model.Flat;

public class CsvFileHandlerImplementation implements CsvFileHandler  {

	MyComparator myComparatorObj = new MyComparator();
	
	public static String delimiter = ",";
	
	@Override
	public ArrayList<Flat> readAndLoadAllContentInList(String fileName){
		ArrayList<Flat> flatsList = new ArrayList<Flat>();
		try  {
            @SuppressWarnings("resource")
			BufferedReader bufferObj = new BufferedReader(new FileReader(fileName));
            String lineReadFromFile = "";
            while ((lineReadFromFile = bufferObj.readLine()) != null) {
                String[] contentOfReadLine = lineReadFromFile.split(delimiter);
                Flat flat = new Flat(contentOfReadLine[0],
                					contentOfReadLine[1],
                					Integer.parseInt(contentOfReadLine[2]),
                					contentOfReadLine[3],
                					Integer.parseInt(contentOfReadLine[4]),
                					Integer.parseInt(contentOfReadLine[5]),
                					Integer.parseInt(contentOfReadLine[6]),
                					contentOfReadLine[7],
                					contentOfReadLine[8],
                					Integer.parseInt(contentOfReadLine[9]),
                					Float.parseFloat(contentOfReadLine[10]),
                					Float.parseFloat(contentOfReadLine[11]));
                flatsList.add(flat);
            }
        } catch (IOException ioExceptionCaught) {
            ioExceptionCaught.printStackTrace();
            System.out.println("IOException Caught");
        }
		return flatsList;
	}
	
	@Override
	public void showAllContentsOfList(ArrayList<Flat> flatsList){
		System.out.println(String.format("%-32s%-18s%-8s%-7s%-5s%-7s" + "%-7s%-13s%-30s"
										+ "%-8s%-10s%-10s","Street", "City", "Zip","Sta"
										+ "te", "Beds", "Baths", "Area", "Type","Sale D"
										+ "ate", "Price", "Latitude", "Longitude"));
		System.out.println();
		for(Flat flatObj : flatsList){
			System.out.println(flatObj.toString());
		}	
	}
	
	@Override
	public ArrayList<Flat> sortListInAscOrDscOrder(ArrayList<Flat> flatsList, 
												String columnName, int orderChoice){
		myComparatorObj.setColumnName(columnName);
		Collections.sort(flatsList, myComparatorObj);
		if(orderChoice == 2)
			Collections.reverse(flatsList);
		return flatsList;
	}
	
	@Override
	public ArrayList<Flat> filterListByColumnNameAndEntiyName(ArrayList<Flat> flatsList, 
												String columnName, String entityName){
		ArrayList<Flat> filteredFlatsList = new ArrayList<Flat>();
		switch (columnName) {
		case "city":{
			for(Flat flatObj : flatsList){
				if(flatObj.getCity().equals(entityName))
					filteredFlatsList.add(flatObj);
			}
			break;
		}
		case "type":{
			for(Flat flatObj : flatsList){
				if(flatObj.getType().equals(entityName))
					filteredFlatsList.add(flatObj);
			}
			break;
		}
		case "state":{
			for(Flat flatObj : flatsList){
				if(flatObj.getState().equals(entityName))
					filteredFlatsList.add(flatObj);
			}
			break;
		}
		case "zip":{
			for(Flat flatObj : flatsList){
				if(flatObj.getZip() == Integer.parseInt(entityName))
					filteredFlatsList.add(flatObj);
			}
			break;
		}
		case "beds":{
			for(Flat flatObj : flatsList){
				if(flatObj.getBeds() == Integer.parseInt(entityName))
					filteredFlatsList.add(flatObj);
			}
			break;
		}
		case "baths":{
			for(Flat flatObj : flatsList){
				if(flatObj.getBaths() == Integer.parseInt(entityName))
					filteredFlatsList.add(flatObj);
			}
			break;
		}
		}
		return filteredFlatsList;
	}

	@Override
	public HashSet<String> getUniqueCityNames(ArrayList<Flat> flatsList) {
		ArrayList<String> flatCityNamesList = new ArrayList<String>();
		for(Flat flatObj : flatsList){
			flatCityNamesList.add(flatObj.getCity());
		}
		Set<String> cityNamesSet = new HashSet<String>(flatCityNamesList);
		return (HashSet<String>) cityNamesSet;
	}

	@Override
	public Set<String> getUniqueStateNames(ArrayList<Flat> flatsList) {
		ArrayList<String> flatStateNamesList = new ArrayList<String>();
		for(Flat flatObj : flatsList){
			flatStateNamesList.add(flatObj.getState());
		}
		Set<String> stateNamesSet = new HashSet<String>(flatStateNamesList);
		return (HashSet<String>) stateNamesSet;
	}

	@Override
	public Set<String> getUniqueTypes(ArrayList<Flat> flatsList) {
		ArrayList<String> flatTypesList = new ArrayList<String>();
		for(Flat flatObj : flatsList){
			flatTypesList.add(flatObj.getType());
		}
		Set<String> typesSet = new HashSet<String>(flatTypesList);
		return (HashSet<String>) typesSet;
	}

	@Override
	public Set<Integer> getUniqueZipCodes(ArrayList<Flat> flatsList) {
		ArrayList<Integer> flatZipCodesList = new ArrayList<Integer>();
		for(Flat flatObj : flatsList){
			flatZipCodesList.add(flatObj.getZip());
		}
		Set<Integer> zipCodesSet = new HashSet<Integer>(flatZipCodesList);
		return (HashSet<Integer>) zipCodesSet;
	}

	@Override
	public Set<Integer> getUniqueNumberOfBeds(ArrayList<Flat> flatsList) {
		ArrayList<Integer> flatNumberOfBedsList = new ArrayList<Integer>();
		for(Flat flatObj : flatsList){
			flatNumberOfBedsList.add(flatObj.getBeds());
		}
		Set<Integer> numberOfBedsSet = new HashSet<Integer>(flatNumberOfBedsList);
		return (HashSet<Integer>) numberOfBedsSet;
	}

	@Override
	public Set<Integer> getUniqueNumberOfBaths(ArrayList<Flat> flatsList) {
		ArrayList<Integer> flatNumberOfBathsList = new ArrayList<Integer>();
		for(Flat flatObj : flatsList){
			flatNumberOfBathsList.add(flatObj.getBaths());
		}
		Set<Integer> numberOfBathsSet = new HashSet<Integer>(flatNumberOfBathsList);
		return (HashSet<Integer>) numberOfBathsSet;
	}

}
