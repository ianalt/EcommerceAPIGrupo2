package com.ecommerce.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

// import com.fasterxml.jackson.annotation.JsonBackReference;
// import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;

	@NotBlank
	@Email(message = "E-mail fornecido não e valido")
	@Pattern(regexp = ".+@.+\\..+", message = "E-mail fornecido não e valido")
	@Column(name = "email")
	private String email;

	@NotBlank(message = "Nome de usuário é obrigatório")
	@Size(max = 20, message = "Nome de usuario excede o limite de {max} caracteres")
	@Size(min = 4, message = "Nome de usuário precisa ser maior que {min} caracteres")
	@Column(name = "username", unique = true)
	private String username;

	@NotBlank(message = "Senha de usuário é obrigatória")
	@Column(name = "senha")
	private String senha;

	@Column(name = "nome")//colocar unique
	private String nome;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "datanascimento")
	private Calendar dataNascimento;

	// relacionamento client-endereco
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonDeserialize  // @JsonManagedReference
	@JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
	private Endereco endereco;

	//recursividade
	@JsonBackReference
	@OneToMany(mappedBy = "cliente")
	private List<Pedidos> listPedidos;

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

	public List<Pedidos> getListPedidos() {
		return listPedidos;
	}

	public void setListPedidos(List<Pedidos> listPedidos) {
		this.listPedidos = listPedidos;
	}

}
