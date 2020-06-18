package com.gm.medical.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gm.medical.entity.Area;
import lombok.*;

import javax.persistence.*;


/**
 * 农合机构管理类
 * @author 演示
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_institution")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Institution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 行政区域编码，类标识符
	 */
	private String areacode;
	/**
	 * 经办机构编码
	 */
	private String agencode;
	
	/**
	 * 经办机构名称
	 */
	private String agenname;
	/**
	 * 经办机构级别，区别于行政区域级别，1表示县级农合办，2表示镇级农合点
	 */
	private int grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getAgencode() {
		return agencode;
	}
	public void setAgencode(String agencode) {
		this.agencode = agencode;
	}
	public String getAgenname() {
		return agenname;
	}
	public void setAgenname(String agenname) {
		this.agenname = agenname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}


}
