package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;

import dto.Instituicao;

public class InstituicaoDAO extends HibernateHelper<Instituicao> implements IDAO<Instituicao> {

	@Override
	public ArrayList<Instituicao> list() throws Exception {
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "from Instituicao";
		return  (ArrayList<Instituicao>) consultar(query_string, args);
	}

	

	
	
	@Override
	public void save(Instituicao obj) throws Exception {
		executar(obj);
	}

}
