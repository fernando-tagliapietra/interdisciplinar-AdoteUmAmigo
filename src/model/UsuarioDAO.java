package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.EntityManager;

import dto.Pessoa;
import dto.Usuario;

public class UsuarioDAO extends HibernateHelper<Usuario> implements IDAO<Usuario>{

	@Override
	public ArrayList<Usuario> list() throws Exception {
		HashMap<String, Object> args = new HashMap<String, Object>();
		String query_string = "from Usuario";
		return  (ArrayList<Usuario>) consultar(query_string, args);
	}
	
	@Override
	public void save(Usuario obj) throws Exception {
		
		Usuario usuario = executarFind(obj);
		
		EntityManager em =  new HibernateHelper<Pessoa>().getFactory();
		
		em.getTransaction().begin();
		
		Pessoa pessoa = em.find(Pessoa.class, obj.getPessoa().getId());	
		Pessoa pessoa_updated = em.merge(pessoa);
		pessoa_updated.setUsuarioId(usuario.getId());
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		
	}
	
	public int saveAndFindId(Usuario obj) throws Exception {
		
		Usuario usuario = executarFind(obj);
		int usuario_id = usuario.getId();
		
		EntityManager em =  new HibernateHelper<Pessoa>().getFactory();
		
		em.getTransaction().begin();
		
		Pessoa pessoa = em.find(Pessoa.class, obj.getPessoa().getId());	
		Pessoa pessoa_updated = em.merge(pessoa);
		pessoa_updated.setUsuarioId(usuario.getId());
		
		em.flush();
		em.getTransaction().commit();
		em.close();
		
		return usuario_id;
		
	}
	
	
	
}
