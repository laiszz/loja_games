package com.generation.lojagames.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O atributo 'Nome' é obrigatório!")
	private String nome;

	@NotNull(message = "O atributo 'Usuário' é obrigatório!")
	@Email(message = "O atributo 'Usuário' deve ser um e-mail válido!")
	private String usuario;

	@NotBlank(message = "O atributo 'Senha' é obrigatório!")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres!")
	private String senha;

	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres!")
	private String foto;
	
	@NotNull(message = "O atributo 'Data de Nascimento' é obrigatório!")
	@Past
	private LocalDate data_nascimento;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Produto> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public LocalDate getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}
