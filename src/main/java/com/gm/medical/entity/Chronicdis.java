package com.gm.medical.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * 慢性病分类管理类
 * @author 演示
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_chronicdis")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Chronicdis {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 疾病编码
	 */
	private String illcode;
	/**
	 * 疾病名称
	 */
	private String illname;
	/**
	 * 拼音码
	 */
	private String pycode;
	/**
	 * 五笔码
	 */
	private String wbcode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIllcode() {
		return illcode;
	}

	public void setIllcode(String illcode) {
		this.illcode = illcode;
	}

	public String getIllname() {
		return illname;
	}

	public void setIllname(String illname) {
		this.illname = illname;
	}

	public String getPycode() {
		return pycode;
	}

	public void setPycode(String pycode) {
		this.pycode = pycode;
	}

	public String getWbcode() {
		return wbcode;
	}

	public void setWbcode(String wbcode) {
		this.wbcode = wbcode;
	}
	
	

}
