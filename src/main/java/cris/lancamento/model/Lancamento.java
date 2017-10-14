package cris.lancamento.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Lancamento implements Serializable{
	
	private static final long serialVersionUID = -2440861855583057430L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@Column(precision=10,scale=2,nullable=false)
	private BigDecimal valor;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date vencimento;
	
	@Column(nullable=false)
	private Boolean pg;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	
	public int getDia() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.setTime(vencimento);
		return cal.get(Calendar.DAY_OF_MONTH); 
	}
	public Boolean getPg() {
		return pg;
	}
	public void setPg(Boolean pg) {
		this.pg = pg;
	}

}
