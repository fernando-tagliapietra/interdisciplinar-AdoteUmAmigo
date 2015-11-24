package model;

import java.util.ArrayList;

public interface IDAO<T> {
	
	
	public void save(T obj) throws Exception;
	public ArrayList<T> list() throws Exception; 
	
}
