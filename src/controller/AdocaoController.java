package controller;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.Adocao;
import dto.Animal;
import dto.Pessoa;
import model.AdocaoDAO;
import model.IDAO;
import model.PessoaDAO;

@Path("/adocao")
public class AdocaoController {

	public static IDAO<Adocao> adocaoDao = new AdocaoDAO();
	public static PessoaDAO pessoaDao = new PessoaDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Adocao> getAdocoes() throws Exception{
		return adocaoDao.list();
	}
	
	@POST
	@Path("/save/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveJSON( Adocao adocao ) throws Exception {
		adocaoDao.save(adocao);
		return null;
	}
	
	@POST
	@Path("/save")
	public Response save( @QueryParam("pessoa_id") String pessoa_id, @QueryParam("instituicao_id") String instituicao_id) throws Exception {
		//adocaoDao.save(adocao);
		return null;
	}
	
	public static void realizarAdocao(int pessoa_id, int instituicao_id, int animal_id ) throws Exception{
		
		Pessoa pessoa = pessoaDao.getPessoaById(pessoa_id);
		
		Date nasc= pessoa.getDataNascimento();
		Date now = new Date();
		
		LocalDate startDate = LocalDate.of(nasc.getYear(),nasc.getMonth(), nasc.getDay());
	    LocalDate endDate = LocalDate.of(now.getYear(), now.getMonth(), now.getDay());

	    long numberOfYears = ChronoUnit.YEARS.between(startDate, endDate);
	    
	    if (numberOfYears < 16)
	    	throw new Exception("Idade n�o permitida para doa��o");
	    
	    ///VALIDACAO DE QUANTIDADE DE ANIMAIS DE CADA TIPO
	    
	    Adocao adocao = new Adocao();
		adocao.setInstituicaoId(instituicao_id);
		adocao.setPessoaId(pessoa_id);
		
		Animal animal = AnimalController.getAnimal(animal_id);
		
		adocao.addAnimal(animal);
		adocaoDao.save(adocao);
		
	}
	
	
	
	
}
