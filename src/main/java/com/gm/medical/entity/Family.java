package com.gm.medical.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * 家庭档案管理模块
 * @author 演示
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_family")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Family {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 家庭编号
	 */
	private String famicode;
	/**
	 * 乡镇编号
	 */

	private String town;
	/**
	 * 村编号
	 */

	private String village;
	/**
	 * 组编号
	 */

	private String groupno;
	/**
	 * 户主信息
	 */
	private String persname;
	/**
	 *户属性 
	 */
	private String housepro;
	/**
	 * 人口数
	 */
	private int popunum;
	/**
	 * 农业人口数
	 */
	private int agrinum;
	/**
	 * 家庭住址
	 */
	private String address;
	/**
	 * 建档时间
	 */
	private String creattime;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getFamicode() {
		return famicode;
	}

	public void setFamicode(String famicode) {
		this.famicode = famicode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}


	public String getGroupno() {
		return groupno;
	}

	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}

	public String getHousepro() {
		return housepro;
	}

	public void setHousepro(String housepro) {
		this.housepro = housepro;
	}

	public int getPopunum() {
		return popunum;
	}

	public void setPopunum(int popunum) {
		this.popunum = popunum;
	}

	public int getAgrinum() {
		return agrinum;
	}

	public void setAgrinum(int agrinum) {
		this.agrinum = agrinum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreattime() {
		return creattime;
	}

	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}


	public String getPersname() {
		return persname;
	}

	public void setPersname(String persname) {
		this.persname = persname;
	}
}
