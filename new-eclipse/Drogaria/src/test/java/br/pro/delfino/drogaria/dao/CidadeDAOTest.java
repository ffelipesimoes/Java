package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

public class CidadeDAOTest {
	
	@Ignore
	@Test
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(2L);
		
		Cidade cidade = new Cidade();
		
		cidade.setNome("Caucaia");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
	
	@Ignore
	@Test
	public void listar() {
				
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade : resultado) {
			System.out.println("Cidades encontradas: ");
			System.out.println(cidade.getNome() + " - Estado: " + cidade.getEstado().getNome());
		}
	}
	
	@Test
	public void buscarPorEstado() {
				Long estadoCodigo = 2L;
				
		CidadeDAO cidadeDAO = new CidadeDAO();
		
		List<Cidade> resultado = cidadeDAO.buscarPorEstado(estadoCodigo);
		
		for (Cidade cidade : resultado) {
			System.out.println("Código da Cidade: " + cidade.getCodigo());
			System.out.println("Nome da Cidade: " + cidade.getNome());
			System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
			System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			System.out.println();
		}
	}
	
	@Ignore
	@Test
	public void buscar() {
		Long codigo =11L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + "/" + cidade.getEstado().getSigla());
		}
	}
	
	@Ignore
	@Test
	public void excluir() {
		Long codigo =10L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			
			System.out.println("Registro que será excluido:");
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + "/" + cidade.getEstado().getSigla());
			cidadeDAO.excluir(cidade);
		}
	}
	
	@Test
	public void editar() {
		Long codigo =11L;
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);
		
		if(cidade == null){
			System.out.println("Nenhum registro encontrado");
		}else{

			EstadoDAO estadoDAO = new EstadoDAO();
			Estado estado = estadoDAO.buscar(1L);
			
						
						
			System.out.println("Registro que será alterado:");
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + "/" + cidade.getEstado().getSigla());
			cidade.setNome("Itajai");
			cidade.setEstado(estado);
			
			cidadeDAO.editar(cidade);
			System.out.println(cidade.getCodigo() + " - " + cidade.getNome() + "/" + cidade.getEstado().getSigla());

			}
	}
}
