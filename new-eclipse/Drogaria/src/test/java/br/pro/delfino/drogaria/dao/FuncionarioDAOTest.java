package br.pro.delfino.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Funcionario;
import br.pro.delfino.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {

	@Ignore
	@Test
	public void salvar() {
		Funcionario funcionario = new Funcionario();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(19L);

		funcionario.setDataAdmissao(new Date());
		funcionario.setCarteiraTrabalho("123.123.123");
		funcionario.setPessoa(pessoa);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);

		System.out.println("Funcionario salvo com sucesso! ");
	}
	
	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> funcionario = funcionarioDAO.listar();
		System.out.println("Lista de Funcionarios: ");

		for (Funcionario resultado : funcionario) {
			System.out.println("Funcionario: " + resultado.getPessoa().getNome());
			System.out.println("CPF: " + resultado.getPessoa().getCpf());
			System.out.println("Carteira de trabalho: " + resultado.getCarteiraTrabalho());
			System.out.println("Data de Admissao: " + resultado.getDataAdmissao());
			System.out.println("");

		}

	}
	@Ignore
	@Test
	public void buscar() {
		Long codigo = 24L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Funcionario: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissao: " + funcionario.getDataAdmissao());
			System.out.println("");
		}
	}
	@Ignore
	@Test
	public void excluir() {
		Long codigo = 25L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Removendo o registro: ");
			System.out.println("Funcionario: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissao: " + funcionario.getDataAdmissao());
			System.out.println("");

			funcionarioDAO.excluir(funcionario);

			System.out.println("Funcionario Removido com sucesso!");
		}
	}
	
	@Test
	public void editar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(18L);

		Long codigo = 24L;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(codigo);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Funcionario: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissao: " + funcionario.getDataAdmissao());
			System.out.println("");
			
			funcionario.setDataAdmissao(new Date());
			funcionario.setCarteiraTrabalho("123.123.122");
			funcionario.setPessoa(pessoa);

			funcionarioDAO.editar(funcionario);

			System.out.println("Registro atualizado: ");

			System.out.println("Funcionario: " + funcionario.getPessoa().getNome());
			System.out.println("CPF: " + funcionario.getPessoa().getCpf());
			System.out.println("Carteira de trabalho: " + funcionario.getCarteiraTrabalho());
			System.out.println("Data de Admissao: " + funcionario.getDataAdmissao());
			System.out.println("");
		}

	}
}
