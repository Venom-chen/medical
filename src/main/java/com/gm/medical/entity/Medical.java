package com.gm.medical.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * 医疗机构管理类
 * @author 演示
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_medical")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Medical {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 机构编码
	 */
	private String jgbm;
	/**
	 * 组织机构编码
	 */
	private String zzjgbm;
	/**
	 * 机构名称
	 */
	private String jgmc;
	/**
	 * 地区编码
	 */
	private String dqbm;
	/**
	 * 行政区域编码
	 */
	private String areacode;
	/**
	 * 隶属关系
	 */

	private String lsgx;

	/**
	 * 机构级别
	 */
	private String jgjb;
	/**
	 * 申报定点类型
	 */

	private String sbddlx;
	/**
	 * 批准定点类型
	 */

	private String pzddlx;
	/**
	 * 所属经济类型
	 */

	private String ssjjlx;
	/**
	 * 卫生机构大类
	 */

	private String wsjgdl;
	/**
	 * 卫生机构小类
	 */

	private String wsjgxl;
	
	/**
	 * 主管单位
	 */
	private String zgdw;
	/**
	 * 开业时间
	 */
	private String kysj;
	/**
	 * 法人代表
	 */
	private String frdb;
	/**
	 * 注册资金
	 */
	private double zczj;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJgbm() {
		return jgbm;
	}

	public void setJgbm(String jgbm) {
		this.jgbm = jgbm;
	}

	public String getZzjgbm() {
		return zzjgbm;
	}

	public void setZzjgbm(String zzjgbm) {
		this.zzjgbm = zzjgbm;
	}

	public String getJgmc() {
		return jgmc;
	}

	public void setJgmc(String jgmc) {
		this.jgmc = jgmc;
	}

	public String getDqbm() {
		return dqbm;
	}

	public void setDqbm(String dqbm) {
		this.dqbm = dqbm;
	}

	public String getAreacode() {
		return areacode;
	}
	public String getZgdw() {
		return zgdw;
	}
	public void setZgdw(String zgdw) {
		this.zgdw = zgdw;
	}
	
	public String getFrdb() {
		return frdb;
	}
	public void setFrdb(String frdb) {
		this.frdb = frdb;
	}
	public double getZczj() {
		return zczj;
	}
	public void setZczj(double zczj) {
		this.zczj = zczj;
	}
	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}
	public String getKysj() {
		return kysj;
	}
	public void setKysj(String kysj) {
		this.kysj = kysj;
	}

	public String getLsgx() {
		return lsgx;
	}

	public void setLsgx(String lsgx) {
		this.lsgx = lsgx;
	}

	public String getJgjb() {
		return jgjb;
	}

	public void setJgjb(String jgjb) {
		this.jgjb = jgjb;
	}

	public String getSbddlx() {
		return sbddlx;
	}

	public void setSbddlx(String sbddlx) {
		this.sbddlx = sbddlx;
	}

	public String getPzddlx() {
		return pzddlx;
	}

	public void setPzddlx(String pzddlx) {
		this.pzddlx = pzddlx;
	}

	public String getSsjjlx() {
		return ssjjlx;
	}

	public void setSsjjlx(String ssjjlx) {
		this.ssjjlx = ssjjlx;
	}

	public String getWsjgdl() {
		return wsjgdl;
	}

	public void setWsjgdl(String wsjgdl) {
		this.wsjgdl = wsjgdl;
	}

	public String getWsjgxl() {
		return wsjgxl;
	}

	public void setWsjgxl(String wsjgxl) {
		this.wsjgxl = wsjgxl;
	}
}
