package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;
import dto.Pessoa;

public class PessoaDAO extends HibernateHelper<Pessoa> implements IDAO<Pessoa>{

	@Override
	public ArrayList<Pessoa> list() throws Exception {
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "from Pessoa";
		
	
		
		return  (ArrayList<Pessoa>) consultar(query_string, args);
	}

	@Override
	public void save(Pessoa obj) throws Exception {
		executar(obj);
	}

}
