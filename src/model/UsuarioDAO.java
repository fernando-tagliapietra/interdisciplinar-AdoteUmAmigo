package model;

import helper.HibernateHelper;

import java.util.ArrayList;
import java.util.HashMap;
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
		executar(obj);
	}
}
