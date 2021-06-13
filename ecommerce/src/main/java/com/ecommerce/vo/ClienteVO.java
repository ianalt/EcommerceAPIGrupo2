package com.ecommerce.vo;

import java.util.Calendar;
import java.util.List;

import com.ecommerce.entities.Endereco;

public class ClienteVO {
	private Integer idCliente;
	private String email;
	private String username;
	private String senha;
	private String nome;
	private String cpf;
	private String telefone;
	private Calendar dataNascimento;
	private Endereco endereco;
	private List<PedidosVO> listPedidosVO;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<PedidosVO> getListPedidosVO() {
		return listPedidosVO;
	}

	public void setListPedidosVO(List<PedidosVO> listPedidosVO) {
		this.listPedidosVO = listPedidosVO;
	}



}
