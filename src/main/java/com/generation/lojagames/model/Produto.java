package com.generation.lojagames.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {
	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min = 1, max = 255, message = "O nome do produto deve ter entre 1 e 255 caracteres!")
	private String nome;
	
	@NotBlank
	@Size(min = 1, max = 510, message = "A descricao do produto deve ter entre 1 e 510 caracteres!")
	private String descricao;
	
	@PositiveOrZero
	private BigDecimal preco;
	
	private LocalDate data_lancamento;
	
	@NotBlank
	@Size(min = 1, max = 255, message = "A plataforma do produto deve ter entre 1 e 255 caracteres!")
	private String plataforma;
	
	@PositiveOrZero
	private int quantidade;
	
	private boolean disponivel;
	
	// Relacionamento
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;

	// Get e Set do produto
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public LocalDate getData_lancamento() {
		return data_lancamento;
	}

	public void setData_lancamento(LocalDate data_lancamento) {
		this.data_lancamento = data_lancamento;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	// Get e Set da categoria
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	// Get e Set do usuario
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
