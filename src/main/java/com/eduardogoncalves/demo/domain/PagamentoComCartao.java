package com.eduardogoncalves.demo.domain;

import javax.persistence.Entity;

import com.eduardogoncalves.demo.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.setNumerodeparcelas(numeroDeParcelas);
	}

	public Integer getNumerodeparcelas() {
		return numeroDeParcelas;
	}

	public void setNumerodeparcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
