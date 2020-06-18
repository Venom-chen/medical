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
@Table(name = "t_Chrmanagement")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Chrmanagement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 农合证号
	 */
	private String ruralcard;
	/**
	 * 慢病证号
	 */
	private String chronid;
	/**
	 * 身份证号
	 */
	private String cardid;
	/**
	 * 疾病名称
	 */
	private String illname;

	/**
	 * 起始时间
	 */
	private String starttime;
	/**
	 * 终止时间
	 */
	private String endtime;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuralcard() {
		return ruralcard;
	}

	public void setRuralcard(String ruralcard) {
		this.ruralcard = ruralcard;
	}

	public String getChronid() {
		return chronid;
	}

	public void setChronid(String chronid) {
		this.chronid = chronid;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getIllname() {
		return illname;
	}

	public void setIllname(String illname) {
		this.illname = illname;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
}
