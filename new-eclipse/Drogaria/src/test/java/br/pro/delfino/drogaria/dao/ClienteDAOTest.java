package br.pro.delfino.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cliente;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Cliente;

public class ClienteDAOTest {
	@Ignore
	@Test
	public void salvar() {
		Cliente cliente = new Cliente();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(19L);

		cliente.setDataCadastro(new Date());
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		System.out.println("Cliente salvo com sucesso! ");

	}

	@Ignore
	@Test
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> cliente = clienteDAO.listar();
		System.out.println("Lista de Clientes: ");

		for (Cliente resultado : cliente) {
			System.out.println("Cliente: " + resultado.getPessoa().getNome());
			System.out.println("CPF: " + resultado.getPessoa().getCpf());
			System.out.println("Status: " + resultado.getLiberado());
			System.out.println("Data de cadastro: " + resultado.getDataCadastro());
			System.out.println("");

		}

	}

	@Ignore
	@Test
	public void buscar() {
		Long codigo = 21L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Cliente: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("Status: " + cliente.getLiberado());
			System.out.println("Data de cadastro: " + cliente.getDataCadastro());
			System.out.println("");

		}
	}

	@Ignore
	@Test
	public void excluir() {
		Long codigo = 22L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Removendo o cliente: ");
			System.out.println("Cliente: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("Status: " + cliente.getLiberado());
			System.out.println("Data de cadastro: " + cliente.getDataCadastro());
			System.out.println("");

			clienteDAO.excluir(cliente);

			System.out.println("Cliente Removido com sucesso!");
		}
	}

	@Test
	public void editar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(18L);

		Long codigo = 23L;
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("O cliente abaixo será alterado: ");
			System.out.println("Cliente: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("Status: " + cliente.getLiberado());
			System.out.println("Data de cadastro: " + cliente.getDataCadastro());
			System.out.println("");

			cliente.setDataCadastro(new Date());
			cliente.setLiberado(true);
			cliente.setPessoa(pessoa);

			clienteDAO.editar(cliente);

			System.out.println("Registro atualizado: ");

			System.out.println("Cliente: " + cliente.getPessoa().getNome());
			System.out.println("CPF: " + cliente.getPessoa().getCpf());
			System.out.println("Status: " + cliente.getLiberado());
			System.out.println("Data de cadastro: " + cliente.getDataCadastro());
			System.out.println("");
		}

	}

}
