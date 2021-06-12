package br.com.HearthStoneAPI.entities;

public enum EnumClasse {
	MAGO("Mago"), PALADINO("Paladino"), CACADOR("Caçador"), DRUIDA("Druida"), QUALQUER("Qualquer");

	private String descricao;

	EnumClasse(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}