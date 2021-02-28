package com.cms.dao;

/**
 * @author Rishabh Gupta
 *
 */
public class DataManagerConnectionDAO {

	private static DataManager dataManager = new DataManager();
	
	private DataManagerConnectionDAO(){
		
	}
	
	/**
	 * @return DataManager
	 */
	public static DataManager getDriverManager(){
		return dataManager;
	}
}
