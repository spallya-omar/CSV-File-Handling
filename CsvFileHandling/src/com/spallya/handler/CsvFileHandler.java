package com.spallya.handler;

import java.util.ArrayList;
import java.util.Set;

import com.spallya.model.Flat;

public interface CsvFileHandler {
	public ArrayList<Flat> readAndLoadAllContentInList(String fileName);

	public void showAllContentsOfList(ArrayList<Flat> flatsList);

	public ArrayList<Flat> sortListInAscOrDscOrder(ArrayList<Flat> flatsList, String columnName, int orderChoice);

	public ArrayList<Flat> filterListByColumnNameAndEntiyName(ArrayList<Flat> flatsList, String columnName,
			String entityName);

	public Set<String> getUniqueCityNames(ArrayList<Flat> flatsList);

	public Set<String> getUniqueStateNames(ArrayList<Flat> flatsList);

	public Set<String> getUniqueTypes(ArrayList<Flat> flatsList);

	public Set<Integer> getUniqueZipCodes(ArrayList<Flat> flatsList);

	public Set<Integer> getUniqueNumberOfBeds(ArrayList<Flat> flatsList);

	public Set<Integer> getUniqueNumberOfBaths(ArrayList<Flat> flatsList);
}
