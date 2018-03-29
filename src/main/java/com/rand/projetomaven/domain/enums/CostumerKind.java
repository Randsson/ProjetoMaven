package com.rand.projetomaven.domain.enums;

public enum CostumerKind {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Jurídica");
	
	private int cod;
	private String description;

	private CostumerKind(int cod, String description) {
		this.cod= cod;
		this.description = description;
		
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static CostumerKind toEnum(Integer cod) {
		
		if (cod ==null) {
			return null;
		}
		for (CostumerKind kind : CostumerKind.values()) {
			if (cod.equals(kind.getCod())){
				return kind;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + cod);
		
	}

}


