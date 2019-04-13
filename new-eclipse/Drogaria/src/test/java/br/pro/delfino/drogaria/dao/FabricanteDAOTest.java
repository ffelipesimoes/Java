package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Estado;
import br.pro.delfino.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Ignore
	@Test
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setFabricante("Apple");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Ignore
	@Test
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		System.out.println("Total: " + resultado.size());
		for(Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getFabricante());
		}
	}
	@Ignore
	@Test
	public void buscar() {
		Long codigo = 4L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getFabricante());
		}
	}
	@Ignore
	@Test
	public void excluir(){
		Long codigo = 8L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			fabricanteDAO.excluir(fabricante);
			System.out.println("Registro removido:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getFabricante());
		}
	}

	@Ignore
	@Test
	public void editar() {
		Long codigo = 7L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nem te conheço!!!");
		} else {
			System.out.println("Registro alterado: ");
			System.out.println("Alterando o  - " + fabricante.getFabricante());
			fabricante.setFabricante("Narnia");
			fabricanteDAO.editar(fabricante);
			System.out.println("Registro alterado: ");
			System.out.println("Alterando o  - " + fabricante.getFabricante());

		}
	}
	@Test
	public void merge() {
		//Fabricante fabricante = new Fabricante();
		//fabricante.setFabricante("Desconhecido");
		
		//FabricanteDAO fabricanteDAO = new FabricanteDAO();
		//fabricanteDAO.merge(fabricante);
		
		Long codigo = 4L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		fabricante.setFabricante("Narnia");
		fabricanteDAO.merge(fabricante);
	}
}
