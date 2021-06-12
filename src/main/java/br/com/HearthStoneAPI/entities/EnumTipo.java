package br.com.HearthStoneAPI.entities;

public enum EnumTipo {

	MAGIA("Magia"), CRIATURA("Criatura");

	private String descricao;

	EnumTipo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}