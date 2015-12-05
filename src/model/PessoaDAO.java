package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.EntityManager;

import dto.Pessoa;
import dto.Usuario;


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
	
	public int saveAndFindId(Pessoa obj)throws Exception{
		Pessoa pessoa = executarFind(obj);
		return pessoa.getId();
	}
	
	
	public Pessoa getPessoaById(int id)throws Exception{
		
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "from Pessoa WHERE id = :id ";
		
		args.put("id", id);
		
		ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) consultar(query_string, args);
		
		if(pessoas.size() > 0)
			 return pessoas.get(0);
		
		return null;
		
	}
	

}
