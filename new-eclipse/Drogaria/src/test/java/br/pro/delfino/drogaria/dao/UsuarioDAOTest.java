package br.pro.delfino.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.delfino.drogaria.domain.Usuario;
import br.pro.delfino.drogaria.domain.Venda;
import br.pro.delfino.drogaria.domain.Usuario;
import br.pro.delfino.drogaria.domain.Usuario;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Produto;
import br.pro.delfino.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@Ignore
	@Test
	public void salvar() {
		Usuario usuario = new Usuario();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(18L);

		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("tjce@123");
		usuario.setTipo('B');

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		System.out.println("Usuario salvo com sucesso! ");

	}

	@Ignore
	@Test
	public void listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuario = usuarioDAO.listar();
		System.out.println("Lista de Vendas: ");

		for (Usuario resultado : usuario) {

			System.out.println("Usuario: " + resultado.getPessoa().getNome());
			System.out.println("Status: " + resultado.getAtivo());
			System.out.println("Valor parcial: " + resultado.getTipo());
			System.out.println("");

		}

	}

	@Ignore
	@Test

	public void buscar() {
		Long codigo = 32L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

			System.out.println("Usuario: " + usuario.getPessoa().getNome());
			System.out.println("Status: " + usuario.getAtivo());
			System.out.println("Valor parcial: " + usuario.getTipo());
			System.out.println("");

		}

	}

	@Ignore
	@Test
	public void excluir() {
		Long codigo = 32L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

			System.out.println("Usuario: " + usuario.getPessoa().getNome());
			System.out.println("Status: " + usuario.getAtivo());
			System.out.println("Valor parcial: " + usuario.getTipo());
			System.out.println("");

		}

		usuarioDAO.excluir(usuario);

		System.out.println("Usuario Removido com sucesso!");
	}

	@Test
	public void editar() {
		Long codigo = 33L;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscar(codigo);

		if (usuario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Usuario: " + usuario.getPessoa().getNome());
			System.out.println("Status: " + usuario.getAtivo());
			System.out.println("Valor parcial: " + usuario.getTipo());
			System.out.println("");

			PessoaDAO pessoaDAO = new PessoaDAO();
			Pessoa pessoa = pessoaDAO.buscar(18L);

			usuario.setAtivo(true);
			usuario.setPessoa(pessoa);
			usuario.setSenha("tjce@123");
			usuario.setTipo('G');

			usuarioDAO.editar(usuario);

			System.out.println("Usuario: " + usuario.getPessoa().getNome());
			System.out.println("Status: " + usuario.getAtivo());
			System.out.println("Valor parcial: " + usuario.getTipo());
			System.out.println("");

			System.out.println("Venda editada com sucesso!");
		}

	}

}
