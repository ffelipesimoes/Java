package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Venda;

public class VendaDAOTest {
	@Ignore
	@Test
	public void salvar() {
		Venda venda = new Venda();

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(21L);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(24L);

		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValorTotal(new BigDecimal("49.99"));

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda);

		System.out.println("Cliente salvo com sucesso! ");

	}

	@Ignore
	@Test
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> venda = vendaDAO.listar();
		System.out.println("Lista de Vendas: ");

		for (Venda resultado : venda) {
			System.out.println("Cliente: " + resultado.getCliente().getPessoa().getNome());
			System.out.println("Funcionario : " + resultado.getFuncionario().getPessoa().getNome());
			System.out.println("Hora: " + resultado.getHorario());
			System.out.println("Valor total: " + resultado.getValorTotal());
			System.out.println("");
		}

	}

	@Ignore
	@Test
	public void buscar() {
		Long codigo = 26L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);
		
		if (venda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

		System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
		System.out.println("Funcionario : " + venda.getFuncionario().getPessoa().getNome());
		System.out.println("Hora: " + venda.getHorario());
		System.out.println("Valor total: " + venda.getValorTotal());
		System.out.println("");
		}
	}
	
	@Ignore
	@Test
	public void excluir() {
		Long codigo = 26L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Removendo a venda: ");
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionario : " + venda.getFuncionario().getPessoa().getNome());
			System.out.println("Hora: " + venda.getHorario());
			System.out.println("Valor total: " + venda.getValorTotal());
			System.out.println("");

			vendaDAO.excluir(venda);

			System.out.println("Venda Removido com sucesso!");
		}

	}
	
	@Test
	public void editar() {
		Long codigo = 27L;
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(codigo);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Alterando a venda: ");
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionario : " + venda.getFuncionario().getPessoa().getNome());
			System.out.println("Hora: " + venda.getHorario());
			System.out.println("Valor total: " + venda.getValorTotal());
			System.out.println("");
			
			

			ClienteDAO clienteDAO = new ClienteDAO();
			Cliente cliente = clienteDAO.buscar(21L);

			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			Funcionario funcionario = funcionarioDAO.buscar(24L);

			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);
			venda.setHorario(new Date());
			venda.setValorTotal(new BigDecimal("49.99"));

			
			vendaDAO.editar(venda);
			
			System.out.println("Alterando a venda: ");
			System.out.println("Cliente: " + venda.getCliente().getPessoa().getNome());
			System.out.println("Funcionario : " + venda.getFuncionario().getPessoa().getNome());
			System.out.println("Hora: " + venda.getHorario());
			System.out.println("Valor total: " + venda.getValorTotal());
			System.out.println("");
			

			System.out.println("Venda editada com sucesso!");
		}

	}

}