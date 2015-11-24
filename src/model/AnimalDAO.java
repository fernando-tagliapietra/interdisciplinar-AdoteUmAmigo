package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;

import dto.Animal;

public class AnimalDAO extends HibernateHelper<Animal> implements IDAO<Animal> {

	@Override
	public ArrayList<Animal> list() throws Exception {
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "SELECT e from animal e ";
		return  (ArrayList<Animal>) consultar(query_string, args);
	}

	@Override
	public void save(Animal obj) throws Exception {
		executar(obj);
	}
	
	
	public ArrayList<String> listRacasMaisAdotadas(String tipo){
		
		HashMap<String, Object> args = new HashMap<String, Object>();
		
		//String query_string = "select a.nomeAdotivo, COUNT() from Animal as a " 
		/// NAO TEM RACA ESSES BIXO TCHE
		return null;
			
		
		
		
	}
	
	public ArrayList<Animal> listNaoAdotadosByTipo(String tipo) throws Exception{
		
		HashMap<String, Object> args = new HashMap<String, Object>();
		
		String query_string = "from Animal as a where a.disponivelAdocao = 1 and a.tipo = :tipo"; 
		
		
		if (!tipo.equals("")){
			args.put("tipo", tipo);
		}
		
		return  (ArrayList<Animal>) consultar(query_string, args);		
		
		
	}
	
	

	public ArrayList<Animal> listByInstituicao(String cnpj, String intituicao_nome) throws Exception {
		HashMap<String, Object> args = new HashMap<String, Object>();
		
		String query_string = "from Animal as a "
				+ "inner join fetch a.adocao "
				+ "inner join fetch a.adocao.instituicao "
				+ "where 1=1";
		
		if (!cnpj.equals("")){			
			args.put("cnpj", cnpj);
			query_string += "and a.adocao.instituicao.cnpj = :cnpj";
		}
		
		if (!intituicao_nome.equals("")){
			args.put("nome", intituicao_nome);
			query_string += "and a.adocao.instituicao.nome = :nome";
		}
		
		return  (ArrayList<Animal>) consultar(query_string, args);
	}
}