package bo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import model.AdocaoDAO;
import model.IDAO;
import model.PessoaDAO;
import model.UsuarioDAO;
import controller.AnimalController;
import dto.Adocao;
import dto.Animal;
import dto.Pessoa;
import dto.Usuario;



public class AdocaoManager {

	public static IDAO<Adocao> adocaoDao = new AdocaoDAO();
	public static PessoaDAO pessoaDao = new PessoaDAO();
	public static UsuarioDAO usuarioDao = new UsuarioDAO();
	
	
	public static void addPessoaAndAdocao(String nome_pai1, String nome_pai2, String nome_mae1, String nome_mae2, String telefone, String genero, 
		String conjugue, String etnia, String religiao, int deficiencia, int usuario_id, String nome_social, 
		String acesso, String senha, String email, int instituicao_id, int animal_id) throws Exception{
		
		Usuario new_usuario = new Usuario(email, acesso, senha);
		
		int new_usuario_id = usuarioDao.saveAndFindId(new_usuario);
		
		Pessoa new_pessoa =  new Pessoa(nome_pai1, nome_pai2, nome_mae1, nome_mae2, telefone, genero, conjugue,
				etnia, religiao, deficiencia, new_usuario_id, nome_social);
		
		int pessoa_id = pessoaDao.saveAndFindId(new_pessoa);
		
		realizarAdocao(pessoa_id, instituicao_id, animal_id);
	}
		
	
	public static void realizarAdocao(int pessoa_id, int instituicao_id, int animal_id ) throws Exception{
			
		Pessoa pessoa = pessoaDao.getPessoaById(pessoa_id);
			
		Date nasc= pessoa.getDataNascimento();
		Date now = new Date();
		
		LocalDate startDate = LocalDate.of(nasc.getYear(),nasc.getMonth(), nasc.getDay());
	    LocalDate endDate = LocalDate.of(now.getYear(), now.getMonth(), now.getDay());

	    long numberOfYears = ChronoUnit.YEARS.between(startDate, endDate);
	    
	    if (numberOfYears < 16)
	    	throw new Exception("Idade não permitida para doação");
	    
	    ///VALIDACAO DE QUANTIDADE DE ANIMAIS DE CADA TIPO
	    
	    Adocao adocao = new Adocao();
		adocao.setInstituicaoId(instituicao_id);
		adocao.setPessoaId(pessoa_id);
		
		Animal animal = AnimalController.getAnimal(animal_id);
		
		adocao.addAnimal(animal);
		adocaoDao.save(adocao);
		
	}
	
	
	
	
}
