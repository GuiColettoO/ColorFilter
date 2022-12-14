package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.VagaBO;
import br.com.fiap.to.VagaTO;

@Path("/vaga")
public class VagaResource {
	
	VagaBO pb = new VagaBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<VagaTO> buscar(){
		return pb.listar();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public VagaTO buscar(@PathParam("id") int id) {
		return pb.listar(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(VagaTO vaga, @Context UriInfo uriInfo) {
		
		pb.cadastrar(vaga);
		
		//CONSTRUIR O PATH DE RETORNO
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(vaga.getCodigo()));
		
		//RETORNA O PATH E O STATUS 201
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(VagaTO vaga, @PathParam("id") int id) {
		vaga.setCodigo(id);
		pb.atualiza(vaga);
		return Response.ok().build();}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		pb.remover(id);
		}


}
