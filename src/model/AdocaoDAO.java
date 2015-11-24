package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;

import dto.Adocao;


public class AdocaoDAO extends HibernateHelper<Adocao> implements IDAO<Adocao> {

	
	@Override
	public ArrayList<Adocao> list() throws Exception {		
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "from Adocao";
		return  (ArrayList<Adocao>) consultar(query_string, args);
	}

	@Override
	public void save(Adocao obj) throws Exception {
		executar(obj);
	}


}
