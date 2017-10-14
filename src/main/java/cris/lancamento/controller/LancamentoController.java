package cris.lancamento.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;

import cris.lancamento.model.Lancamento;

@Model
public class LancamentoController {

	private Lancamento lancamento;
	private List<Lancamento> listaLancamento;
	private List<String> meses;
	private int ano;
	private String mes;
	
	@PostConstruct
	private void init() {
		lancamento = this.novo();
		meses = this.initMeses();
		ano = this.initAno();
		mes = this.initMes();
		listaLancamento = new ArrayList<>();
	}
	
	private Lancamento novo(){
		Lancamento novo = new Lancamento();
		Date hoje = GregorianCalendar.getInstance().getTime();
		novo.setVencimento(hoje);
		return novo;
	}
	
	private List<String> initMeses() {
		List<String> retorno = new ArrayList<>();
		retorno.add("Jan");
		retorno.add("Fev");
		retorno.add("Mar");
		retorno.add("Abr");
		retorno.add("Mai");
		retorno.add("Jun");
		retorno.add("Jul");
		retorno.add("Ago");
		retorno.add("Set");
		retorno.add("Out");
		retorno.add("Nov");
		retorno.add("Dez");
		return retorno;
	}
	
	private int initAno() {
		return GregorianCalendar.getInstance().get(Calendar.YEAR);
	}
	
	private String initMes() {
		String retorno = meses.get(GregorianCalendar.getInstance().get(Calendar.MONTH));
		return retorno;
	}
	
	public String adicionar() {
		return "frm";
	}
	
	public String salvar() {
		listaLancamento.add(lancamento);
		return "lst";
	}
	
	public String cancelar() {
		return "lst";
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public List<String> getMeses() {
		return meses;
	}

	public void setMeses(List<String> meses) {
		this.meses = meses;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public List<Lancamento> getListaLancamento() {
		return listaLancamento;
	}

	public void setListaLancamento(List<Lancamento> listaLancamento) {
		this.listaLancamento = listaLancamento;
	}
	
	
	
}
