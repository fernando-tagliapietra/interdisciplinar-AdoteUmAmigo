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

import dto.Adocao;
import model.AdocaoDAO;
import model.IDAO;

@Path("/adocao")
public class AdocaoController {

	public IDAO<Adocao> adocaoDao = new AdocaoDAO();
	
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
	
	
}
