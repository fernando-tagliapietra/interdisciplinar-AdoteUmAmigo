package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.EntityManager;

import dto.Adocao;
import dto.Animal;


public class AdocaoDAO extends HibernateHelper<Adocao> implements IDAO<Adocao> {

	public static AnimalDAO animalDao = new AnimalDAO();
	
	
	@Override
	public ArrayList<Adocao> list() throws Exception {		
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "from Adocao";
		return  (ArrayList<Adocao>) consultar(query_string, args);
	}

	@Override
	public void save(Adocao obj) throws Exception {
		
		obj.setData(new Date());
		Adocao adocao = executarFind(obj);
		
		EntityManager em =  new HibernateHelper<Animal>().getFactory();
		
		for (Animal animal : obj.getAnimals()) {
			
			em.getTransaction().begin(); 
			
			Animal animal1 = em.find(Animal.class, animal.getId());
			
			Animal animal_updated = em.merge(animal1);
			animal_updated.setAdocaoId(adocao.getId());
			
			em.flush();
			em.getTransaction().commit();
		}
		
		em.close();
	}


}
