package com.gm.medical.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * 行政区域模块�?
 * 
 * @author 演示
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "t_area")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Area  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	/**
	 * 乡镇区域编码:县�?�镇、村、组
	 */
	private String areacode;
	/**
	 * 上一�?
	 */
	@Transient
	private Area  parent;
	
	/**
	 * 行政区域名称
	 */
	private String areaname;
	/**
	 * 行政区域级别�?1表示县级�?2表示镇级�?3表示村，4表示�?
	 */
	private int grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Area getParent() {
	  
		return parent;
	}

	public void setParent(Area parent) {
		
		this.parent = parent;
	}
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
	
/*	public static void main(String[]args)throws Exception{
		String number="01";
		System.out.println(Integer.parseInt(number));
	
		System.out.println(String.format("%02d", Integer.parseInt(number)));
	}
*/
}
