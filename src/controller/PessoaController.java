package controller;

import dto.Pessoa;
import dto.Usuario;
import model.IDAO;
import model.PessoaDAO;
import model.UsuarioDAO;

public class PessoaController {

	public static IDAO<Pessoa> pessoaDao = new PessoaDAO();
	public static UsuarioDAO usuarioDao = new UsuarioDAO();
	
	public static void addPessoa(String nome_pai1, String nome_pai2, String nome_mae1, String nome_mae2, String telefone, String genero, 
		String conjugue, String etnia, String religiao, String deficiencia, int usuario_id, String nome_social, 
		String acesso, String senha, String email) throws Exception{
		
		Usuario new_usuario = new Usuario(email, acesso, senha);
		
		int new_usuario_id = usuarioDao.saveAndFindId(new_usuario);
		
		
		
		
		
		
		
		
		
	}
	
	
}
