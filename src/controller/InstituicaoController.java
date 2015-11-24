package controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import dto.Instituicao;
import model.IDAO;
import model.InstituicaoDAO;

public class InstituicaoController {

	
	private IDAO<Instituicao> instituicaoDao = new InstituicaoDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Instituicao> getInstituicao() throws Exception{
		return instituicaoDao.list();
	}
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save( Instituicao instituicao ) throws Exception {
		instituicaoDao.save(instituicao);
		return null;
	}
	
	
	
}
