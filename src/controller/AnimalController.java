package controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.AnimalDAO;
import model.IDAO;
import dto.Animal;


public class AnimalController {

	public static IDAO<Animal> animalDao = new AnimalDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Animal> getAnimals() throws Exception{
		return animalDao.list();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Animal> getAnimalsByInstituicao(@QueryParam("cnpj") String cnpj, @QueryParam("nome") String nome) throws Exception{
		return (new AnimalDAO()).listByInstituicao(cnpj, nome);
	}
	
	public ArrayList<String> getRacasMaisAdotadaRanking(String tipo){
		
		
		if (tipo.equals(""))
			new Exception("Tipo vazio ou inválido");
		
		
		
		
		
		return null;
		
		
		
	}
	
	
	public ArrayList<Animal> getNaoAdotadosByTipo(String tipo) throws Exception{
		return (new AnimalDAO()).listNaoAdotadosByTipo(tipo);
	}
	
	
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save( Animal animal ) throws Exception {
		animalDao.save(animal);
		return null;
		//String output = student.toString();
		//return Response.status(200).entity(output).build();
	}

	
}
