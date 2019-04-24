package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.PessoaDAO;
import br.pro.delfino.drogaria.dao.CidadeDAO;
import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drogaria.domain.Pessoa;
import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private Estado estado;
	private List<Pessoa> pessoas;
	private List<Estado> estados;
	private List<Cidade> cidades;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> Pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa Pessoa) {
		this.pessoa = Pessoa;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidade(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o Pessoa!");
			erro.printStackTrace();
		}
	}

	public void novo() {

		try {
			pessoa = new Pessoa();

			cidades = new ArrayList<Cidade>();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao criar a Pessoa!");
			erro.printStackTrace();
		}

	}

	public void salvar() {
		try {
			PessoaDAO PessoaDAO = new PessoaDAO();

			PessoaDAO.merge(pessoa);
			novo();
			pessoas = PessoaDAO.listar();
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			Messages.addGlobalInfo("Pessoa salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o Pessoa!");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			PessoaDAO PessoaDAO = new PessoaDAO();
			pessoas = PessoaDAO.listar();
			
			
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");
			PessoaDAO pessoaDAO = new PessoaDAO();
			//pessoaDAO.excluir(pessoa);
			System.out.println(pessoa);
			Messages.addGlobalInfo("Pessoa excluido com sucesso");
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover a  Pessoa!");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {
			CidadeDAO cidadeDao = new CidadeDAO();
			cidades = cidadeDao.listar();

			EstadoDAO estadoDao = new EstadoDAO();
			estados = estadoDao.listar();

			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

			estado = pessoa.getCidade().getEstado();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar a pessoa!");
			erro.printStackTrace();
		}

	}

	public void popular() {
		if (estado != null) {
			try {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());

			} catch (RuntimeException erro) {
				Messages.addGlobalError("Ocorreu um erro ao salvar o Pessoa!");
				erro.printStackTrace();
			}
		} else {
			cidades = new ArrayList<>();
		}

	}
}
