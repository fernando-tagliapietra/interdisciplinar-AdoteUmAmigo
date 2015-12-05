package bo;

import java.util.ArrayList;

import model.AnimalDAO;
import dto.Animal;

public class AnimalManager {

	public static AnimalDAO animalDao = new AnimalDAO();
	
	public static ArrayList<Animal> getAnimaisAdotados() throws Exception{
		return animalDao.list(false);
	}
	
	
}
