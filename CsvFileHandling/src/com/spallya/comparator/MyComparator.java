package com.spallya.comparator;

import java.util.Comparator;

import com.spallya.model.Flat;

public class MyComparator implements Comparator<Flat> {

	private String columnName;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public int compare(Flat f1, Flat f2) {

		switch (columnName) {
		case "street":
			return f1.getStreet().compareTo(f2.getStreet());

		case "city":
			return f1.getCity().compareTo(f2.getCity());

		case "state":
			return f1.getState().compareTo(f2.getState());

		case "type":
			return f1.getType().compareTo(f2.getType());

		case "saleDate":
			return f1.getSaleDate().compareTo(f2.getSaleDate());

		case "zip":
			return (f1.getZip() - f2.getZip());

		case "beds":
			return (f1.getBeds() - f2.getBeds());

		case "baths":
			return (f1.getBaths() - f2.getBaths());

		case "sqFeet":
			return (f1.getSqFeet() - f2.getSqFeet());

		case "price":
			return (f1.getPrice() - f2.getPrice());

		case "latitude":
			return (int) (f1.getLatitude() - f2.getLatitude());

		case "longitude":
			return (int) (f1.getLongitude() - f2.getLongitude());
		}

		return 0;
	}

}
