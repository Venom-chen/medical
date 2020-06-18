package com.gm.medical.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gm.medical.entity.Family;
import lombok.*;;import javax.persistence.*;

/**
 * 个人信息
 * @author 演示
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_person")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 个人编号/农合证号
	 */
	private String perscode;
	/**
	 * 对应家庭档案
	 */
	private String famicode;
	/**
	 * 农合证卡号
	 */
	private String ruralcard;
	/**
	 * 与户主关系
	 */
	private String relation;//1:表示户主，2表示配偶,3表示子，4表示女，5表示孙子，6表示孙女
	/**
	 * 身份证号
	 */
	private String cardid;
	/**
	 * 姓名
	 */
	private String persname;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 人员属性
	 */
	private String perspro;
	/**
	 * 是否农村户口
	 */
	private String isrural;

	/**
	 * 常住地址
	 */
	private String liveaddress;
	/**
	 * 联系电话
	 */
	private String telephone;

	private String village;
	/**
	 * 参合证号
	 */
	private String chid;
	/**
	 * 参合时间
	 */
	private String chtime;
	/**
	 * 参合发票
	 */
	private int chinvoice;

	private String isch;

	public String getIsch() {
		return isch;
	}

	public void setIsch(String isch) {
		this.isch = isch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getChtime() {
		return chtime;
	}

	public void setChtime(String chtime) {
		this.chtime = chtime;
	}

	public int getChinvoice() {
		return chinvoice;
	}

	public void setChinvoice(int chinvoice) {
		this.chinvoice = chinvoice;
	}

	//根据农合证号加载农民档案信息


	public String getRuralcard() {
		return ruralcard;
	}

	public void setRuralcard(String ruralcard) {
		this.ruralcard = ruralcard;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getPerspro() {
		return perspro;
	}

	public void setPerspro(String perspro) {
		this.perspro = perspro;
	}

	public String getIsrural() {
		return isrural;
	}

	public void setIsrural(String isrural) {
		this.isrural = isrural;
	}


	public String getLiveaddress() {
		return liveaddress;
	}

	public void setLiveaddress(String liveaddress) {
		this.liveaddress = liveaddress;
	}

	public String getPerscode() {
		return perscode;
	}
	public void setPerscode(String perscode) {
		this.perscode = perscode;
	}

	public String getPersname() {
		return persname;
	}
	public void setPersname(String persname) {
		this.persname = persname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getFamicode() {
		return famicode;
	}

	public void setFamicode(String famicode) {
		this.famicode = famicode;
	}

	public String getChid() {
		return chid;
	}

	public void setChid(String chid) {
		this.chid = chid;
	}
}
