package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Fabricante;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Ignore
	@Test
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(13L);
		
		Produto produto = new Produto();
		produto.setDescricao("Absorvente");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(4.9));
		produto.setQuantidade(new Short("40"));
		
		ProdutoDAO productDAO = new ProdutoDAO();
		productDAO.salvar(produto);
		System.out.println("Producto salvo com sucesso!");
	}
	
	@Ignore
	@Test
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();
		System.out.println("Segue lista de produtos: ");

		for(Produto produto : resultado) {
			System.out.println("Produto: " + produto.getDescricao());
			System.out.println("Fabricante: " + produto.getFabricante().getFabricante());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("");

		}
	}
	
	@Test
	public void buscar() {
		Long codigo = 15L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		if(produto  == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Produto: " + produto.getDescricao());
			System.out.println("Fabricante: " + produto.getFabricante().getFabricante());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("");
			
			
		}
	}
	
	@Ignore
	@Test
	public void excluir() {
		
		Long codigo = 15L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		if(produto  == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println("Produto: " + produto.getDescricao());
			System.out.println("Fabricante: " + produto.getFabricante().getFabricante());
			System.out.println("Preço: " + produto.getPreco());
			System.out.println("Quantidade: " + produto.getQuantidade());
			System.out.println("");
			
			produtoDAO.excluir(produto);
		}
	}
	@Ignore
	@Test
	public void editar() {
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(13L);
		
		Long codigo = 15L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);
		
		produto.setDescricao("Absorvente");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal(4.9));
		produto.setQuantidade(new Short("30"));
		
		ProdutoDAO productDAO = new ProdutoDAO();
		productDAO.editar(produto);
		System.out.println("Producto salvo com sucesso!");
	}
}
