package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Bahia");
		estado.setSigla("BA");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Ignore
	@Test
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("Total: " + resultado.size());
		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());
			;
		}
	}

	@Ignore
	@Test
	public void buscar() {
		Long codigo = 6L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if (estado == null) {
			System.out.println("Nem te conheço!!!");
		} else {
			System.out.println(estado.getSigla() + " - " + estado.getNome());

		}
	}
	
	
	@Test
	public void excluir(){
		Long codigo = 7L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Ignore
	@Test
	public void editar() {
		Long codigo = 7L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nem te conheço!!!");
		} else {
			System.out.println("Registro alterado: ");
			System.out.println("Alterando o  - " + estado.getNome() + " - " + estado.getSigla());
			estado.setNome("Narnia");
			estado.setSigla("NA");
			estadoDAO.editar(estado);
			System.out.println("Registro alterado: ");
			System.out.println("Alterando o  - " + estado.getNome() + estado.getSigla());

		}
	}
}
