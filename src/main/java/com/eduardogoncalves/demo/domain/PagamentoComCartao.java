package com.eduardogoncalves.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import com.eduardogoncalves.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer numerodeparcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numerodeparcelas) {
		super(id, estado, pedido);
		this.setNumerodeparcelas(numerodeparcelas);
	}

	public Integer getNumerodeparcelas() {
		return numerodeparcelas;
	}

	public void setNumerodeparcelas(Integer numerodeparcelas) {
		this.numerodeparcelas = numerodeparcelas;
	}
	
	
	
}
