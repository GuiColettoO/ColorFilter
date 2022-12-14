package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.to.VagaTO;

public class VagaDAO {
	
	private static List<VagaTO> listaDeVagas;

	public VagaDAO() {
		if(listaDeVagas == null) {
			listaDeVagas = new ArrayList<VagaTO>();
			
			VagaTO pto = new VagaTO();
			pto.setCodigo(1);
			pto.setTitulo("Desenvolvedor Front-End Júnior");
			pto.setNumeroDeVagas(2);
			pto.setDescricao("Para está vaga necessita de conhecimento básico de react.js ");
			listaDeVagas.add(pto);
			
			pto = new VagaTO();
			pto.setCodigo(2);
			pto.setTitulo("Desenvolvedor Back-End Júnior");
			pto.setNumeroDeVagas(1);
			pto.setDescricao("Para está vaga necessita de conhecimento básico de node.js ");
			listaDeVagas.add(pto);
			
			pto = new VagaTO();
			pto.setCodigo(3);
			pto.setTitulo("Desenvolvedor Front-End Pleno");
			pto.setNumeroDeVagas(3);
			pto.setDescricao("Para está vaga necessita de conhecimento avançado de react.js ");
			listaDeVagas.add(pto);
			
			pto = new VagaTO();
			pto.setCodigo(4);
			pto.setTitulo("Desenvolvedor Back-End Pleno");
			pto.setNumeroDeVagas(4);
			pto.setDescricao("Para está vaga necessita de conhecimento Avançado de react.js ");
			listaDeVagas.add(pto);
			
			pto = new VagaTO();
			pto.setCodigo(5);
			pto.setTitulo("Desenvolvedor Full Stack Pleno");
			pto.setNumeroDeVagas(1);
			pto.setDescricao("Precisar fazer pacto para saber tudo ");
			listaDeVagas.add(pto);
			
			pto = new VagaTO();
			pto.setCodigo(1);
			pto.setTitulo("Desenvolvedor Front-End");
			pto.setNumeroDeVagas(2);
			pto.setDescricao("Para está vaga necessita de conhecimento básico de react.js ");
			listaDeVagas.add(pto);
			
			pto = new VagaTO();
		}
	}
	
	// SELECT ALL
	public List<VagaTO> select(){
		return listaDeVagas;
	}

	//SELECT BY_ID
	public VagaTO select(int id) {
		for (int i= 0; i < listaDeVagas.size(); i++) {
			if (listaDeVagas.get(i).getCodigo() == id) {
				return listaDeVagas.get(i);
			}
		}
		return null;
	}
	
	public boolean insert (VagaTO pto) {
		pto.setCodigo(listaDeVagas.size() + 1);
		return listaDeVagas.add(pto);
	}
	
	//UPDATE
	public void update(VagaTO pto) {
		VagaTO p = select(pto.getCodigo());
		p.setNumeroDeVagas(pto.getNumeroDeVagas());
		p.setDescricao(pto.getDescricao());
		p.setTitulo(pto.getTitulo());}

	//DELETE
	public void delete(int id) {
		listaDeVagas.remove(select(id));}
}

