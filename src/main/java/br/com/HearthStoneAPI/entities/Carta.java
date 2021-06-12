package br.com.HearthStoneAPI.entities;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "carta")
@Table(name = "tb_carta")
public class Carta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private int ataque;
	private int defesa;
	private EnumTipo tipo;
	private EnumClasse classe;

	public Carta() {

	}

	public Carta(int id, String nome, String descricao, int ataque, int defesa, EnumTipo tipo, EnumClasse classe) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ataque = ataque;
		this.defesa = defesa;
		this.tipo = tipo;
		this.classe = classe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public EnumTipo getTipo() {
		return tipo;
	}

	public void setTipo(EnumTipo tipo) {
		this.tipo = tipo;
	}

	public EnumClasse getClasse() {
		return classe;
	}

	public void setClasse(EnumClasse classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Carta [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", ataque=" + ataque + ", defesa="
				+ defesa + ", tipo=" + tipo + ", classe=" + classe + "]";
	}

}