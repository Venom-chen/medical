package com.gm.medical.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * 慢性病政策设置
 * @author 演示
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_policy")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 年份
	 */
	private String runyear;
	/**
	 * 封顶线
	 */
	private double maxline;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 备注
	 */
	private String remark;

	private double rate;
	/**
	 * 报销金额
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRunyear() {
		return runyear;
	}

	public void setRunyear(String runyear) {
		this.runyear = runyear;
	}

	public double getMaxline() {
		return maxline;
	}

	public void setMaxline(double maxline) {
		this.maxline = maxline;
	}

	public String getRemark() {
		return remark;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}
