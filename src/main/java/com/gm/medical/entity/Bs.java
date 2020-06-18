package com.gm.medical.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * 报销
 * @author 演示
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_bs")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Bs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 疾病名称
	 */
	private String illness;
	/**
	 * 总费用
	 */
	private double expenses;
	/**
	 * 发票号
	 */
	private String invoiceno;
	/**
	 * 就诊时间
	 */
	private String clinicaltime;

	private String cardid;
	private double amount;
	/**
	 * 设置启用状态
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	public String getInvoiceno() {
		return invoiceno;
	}

	public void setInvoiceno(String invoiceno) {
		this.invoiceno = invoiceno;
	}

	public String getClinicaltime() {
		return clinicaltime;
	}

	public void setClinicaltime(String clinicaltime) {
		this.clinicaltime = clinicaltime;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
