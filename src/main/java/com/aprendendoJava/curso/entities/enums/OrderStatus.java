package com.aprendendoJava.curso.entities.enums;

public enum OrderStatus {
	WAITTING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	/*
	 * esse método irá passar o texto de cada um dos enuns ao se fornecer um número
	 * pois no banco de dados fica gravado um numero sequencial e não o texto dos
	 * enuns
	 */
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Código de Status inválido");
	}
}
