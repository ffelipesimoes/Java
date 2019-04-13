package br.pro.delfino.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Pessoa;

public class PessoaDAOTest {

	@Ignore
	@Test
	public void salvar() {

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(16L);

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Eduardo Simoes");
		pessoa.setCpf("123.456.789-00");
		pessoa.setRg("20020000000");
		pessoa.setRua("Rua das lagoas");
		pessoa.setNumero(new Short("002"));
		pessoa.setBairro("Meidu Mar");
		pessoa.setCep("60000-000");
		pessoa.setComplemento("barco");
		pessoa.setTelefone("85999999999");
		pessoa.setCelular("85999999999");
		pessoa.setEmail("emaildaleticia@email.com");
		pessoa.setCidade(cidade);

		pessoaDAO.salvar(pessoa);

		System.out.println("Registro salvo com sucesso!");

	}

	@Ignore
	@Test
	public void listar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> pessoa = pessoaDAO.listar();

		System.out.println("Pessoas encontradas: ");
		for (Pessoa resultado : pessoa) {

			System.out.println("Nome: " + resultado.getNome());
			System.out.println("CPF: " + resultado.getCpf());
			System.out.println("RG: " + resultado.getRg());
			System.out.println("RUA: " + resultado.getRua());
			System.out.println("Numero: " + resultado.getNumero());
			System.out.println("Bairro: " + resultado.getBairro());
			System.out.println("CEP: " + resultado.getCep());
			System.out.println("Complemento: " + resultado.getComplemento());
			System.out.println("Telefone: " + resultado.getTelefone());
			System.out.println("Celular: " + resultado.getCelular());
			System.out.println("Email: " + resultado.getEmail());
			System.out.println(
					"Cidade: " + resultado.getCidade().getNome() + " - " + resultado.getCidade().getEstado().getNome());
			System.out.println("");

		}

	}

	@Ignore
	@Test
	public void buscar() {
		Long codigo = 20L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("RUA: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println(
					"Cidade: " + pessoa.getCidade().getNome() + " - " + pessoa.getCidade().getEstado().getNome());
			System.out.println("");

		}
	}

	@Ignore
	@Test
	public void excluir() {
		Long codigo = 20L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

			System.out.println("Deletando a pessoa: ");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println(
					"Cidade: " + pessoa.getCidade().getNome() + " - " + pessoa.getCidade().getEstado().getNome());
			System.out.println("");

			pessoaDAO.excluir(pessoa);

		}

	}

	@Test
	public void editar() {
		Long codigo = 19L;
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(16L);

		if (pessoa == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Editando a pessoa: ");

			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("RUA: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println(
					"Cidade: " + pessoa.getCidade().getNome() + " - " + pessoa.getCidade().getEstado().getNome());
			System.out.println("");

			System.out.println("Para: ");

			pessoa.setNome("Leticia Simoes");
			pessoa.setCpf("123.456.789-00");
			pessoa.setRg("20020000000");
			pessoa.setRua("Rua das lagoas");
			pessoa.setNumero(new Short("002"));
			pessoa.setBairro("Mar Menino");
			pessoa.setCep("60000-000");
			pessoa.setComplemento("nenhum");
			pessoa.setTelefone("85999999999");
			pessoa.setCelular("85999999999");
			pessoa.setEmail("emaildaleticia@email.com");
			pessoa.setCidade(cidade);

			pessoaDAO.editar(pessoa);

			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("CPF: " + pessoa.getCpf());
			System.out.println("RG: " + pessoa.getRg());
			System.out.println("RUA: " + pessoa.getRua());
			System.out.println("Numero: " + pessoa.getNumero());
			System.out.println("Bairro: " + pessoa.getBairro());
			System.out.println("CEP: " + pessoa.getCep());
			System.out.println("Complemento: " + pessoa.getComplemento());
			System.out.println("Telefone: " + pessoa.getTelefone());
			System.out.println("Celular: " + pessoa.getCelular());
			System.out.println("Email: " + pessoa.getEmail());
			System.out.println(
					"Cidade: " + pessoa.getCidade().getNome() + " - " + pessoa.getCidade().getEstado().getNome());
			System.out.println("");

		}
	}
}
