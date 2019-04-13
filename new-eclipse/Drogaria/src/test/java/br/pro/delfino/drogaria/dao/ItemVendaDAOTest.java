package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.ItemVenda;
import br.pro.delfino.drogaria.domain.Produto;
import br.pro.delfino.drogaria.domain.Venda;

public class ItemVendaDAOTest {

	@Ignore
	@Test
	public void salvar() {
		ItemVenda itemvenda = new ItemVenda();

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(27L);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(14L);

		itemvenda.setQuantidade(new Short("11"));
		itemvenda.setValorParcial(new BigDecimal(4.99));
		itemvenda.setVenda(venda);
		itemvenda.setProduto(produto);

		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		itemvendaDAO.salvar(itemvenda);

		System.out.println("Item Venda salvo com sucesso! ");

	}

	@Ignore
	@Test
	public void listar() {
		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		List<ItemVenda> itemvenda = itemvendaDAO.listar();
		System.out.println("Lista de Vendas: ");

		for (ItemVenda resultado : itemvenda) {

			System.out.println("Produto: " + resultado.getProduto().getDescricao());
			System.out.println("Quantidade: " + resultado.getQuantidade());
			System.out.println("Valor parcial: " + resultado.getValorParcial());
			System.out.println("Cliente: " + resultado.getVenda().getCliente().getPessoa().getNome());
			System.out.println("Horario: " + resultado.getVenda().getHorario());
			System.out.println("Total: " + resultado.getVenda().getValorTotal());
			System.out.println("");

		}

	}
	@Ignore
	@Test

	public void buscar() {
		Long codigo = 29L;
		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		ItemVenda itemvenda = itemvendaDAO.buscar(codigo);

		if (itemvenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

			System.out.println("Produto: " + itemvenda.getProduto().getDescricao());
			System.out.println("Quantidade: " + itemvenda.getQuantidade());
			System.out.println("Valor parcial: " + itemvenda.getValorParcial());
			System.out.println("Cliente: " + itemvenda.getVenda().getCliente().getPessoa().getNome());
			System.out.println("Horario: " + itemvenda.getVenda().getHorario());
			System.out.println("Total: " + itemvenda.getVenda().getValorTotal());
			System.out.println("");

		}

	}
	@Test
	public void excluir() {
		Long codigo = 29L;
		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		ItemVenda itemvenda = itemvendaDAO.buscar(codigo);

		if (itemvenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Produto: " + itemvenda.getProduto().getDescricao());
			System.out.println("Quantidade: " + itemvenda.getQuantidade());
			System.out.println("Valor parcial: " + itemvenda.getValorParcial());
			System.out.println("Cliente: " + itemvenda.getVenda().getCliente().getPessoa().getNome());
			System.out.println("Horario: " + itemvenda.getVenda().getHorario());
			System.out.println("Total: " + itemvenda.getVenda().getValorTotal());
			System.out.println("");


			itemvendaDAO.excluir(itemvenda);

			System.out.println("Venda Removido com sucesso!");
		}

	}
	
	@Test
	public void editar() {
		Long codigo = 30L;
		ItemVendaDAO itemvendaDAO = new ItemVendaDAO();
		ItemVenda itemvenda = itemvendaDAO.buscar(codigo);

		if (itemvenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Produto: " + itemvenda.getProduto().getDescricao());
			System.out.println("Quantidade: " + itemvenda.getQuantidade());
			System.out.println("Valor parcial: " + itemvenda.getValorParcial());
			System.out.println("Cliente: " + itemvenda.getVenda().getCliente().getPessoa().getNome());
			System.out.println("Horario: " + itemvenda.getVenda().getHorario());
			System.out.println("Total: " + itemvenda.getVenda().getValorTotal());
			System.out.println("");

			VendaDAO vendaDAO = new VendaDAO();
			Venda venda = vendaDAO.buscar(27L);

			ProdutoDAO produtoDAO = new ProdutoDAO();
			Produto produto = produtoDAO.buscar(14L);

			itemvenda.setQuantidade(new Short("30"));
			itemvenda.setValorParcial(new BigDecimal("4.99"));
			itemvenda.setVenda(venda);
			itemvenda.setProduto(produto);


			
			itemvendaDAO.editar(itemvenda);
			
			System.out.println("Produto: " + itemvenda.getProduto().getDescricao());
			System.out.println("Quantidade: " + itemvenda.getQuantidade());
			System.out.println("Valor parcial: " + itemvenda.getValorParcial());
			System.out.println("Cliente: " + itemvenda.getVenda().getCliente().getPessoa().getNome());
			System.out.println("Horario: " + itemvenda.getVenda().getHorario());
			System.out.println("Total: " + itemvenda.getVenda().getValorTotal());
			System.out.println("");

			System.out.println("Venda editada com sucesso!");
		}

	}

}
