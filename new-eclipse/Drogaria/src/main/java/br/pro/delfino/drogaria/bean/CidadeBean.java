package br.pro.delfino.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.delfino.drogaria.dao.CidadeDAO;
import br.pro.delfino.drogaria.dao.EstadoDAO;
import br.pro.delfino.drogaria.domain.Cidade;
import br.pro.delfino.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> Cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade Cidade) {
		this.cidade = Cidade;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstado(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o Cidade!");
			erro.printStackTrace();
		}
	}

	public void novo() {

		try {
			cidade = new Cidade();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao criar a Cidade!");
			erro.printStackTrace();
		}

	}

	public void salvar() {
		try {
			CidadeDAO CidadeDAO = new CidadeDAO();

			CidadeDAO.merge(cidade);
			novo();
			cidades = CidadeDAO.listar();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			Messages.addGlobalInfo("Cidade salvo com sucesso!");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o Cidade!");
			erro.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {

		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			Messages.addGlobalInfo("Cidade excluido com sucesso");
			cidades = cidadeDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao remover a  Cidade!");
			erro.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {

		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
	
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao salvar a Cidade!");
			erro.printStackTrace();
		}

	}
}
