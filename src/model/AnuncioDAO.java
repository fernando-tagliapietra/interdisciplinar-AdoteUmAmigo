package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;
import dto.Anuncio;

public class AnuncioDAO extends HibernateHelper<Anuncio> implements IDAO<Anuncio> {

	@Override
	public ArrayList<Anuncio> list() throws Exception {
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "from Anuncio";		
		return  (ArrayList<Anuncio>) consultar(query_string, args);
	}

	@Override
	public void save(Anuncio obj) throws Exception {
		executar(obj);
	}

}
