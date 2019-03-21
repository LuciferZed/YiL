package com.yijie.yilian.model;

import java.util.List;

/*
 * 项目信息
 */
public class Proj {
	
	//自增ID
	private Integer id;
	
	//系统生成UUID
	private String uuid;
	
	//对应发布账户UUID
	private String user_uuid;
	
	//项目名称
	private String title;
	
	//项目信息
	private String message;
	
	//区域
	private String area;
	
	//工期
	private Integer days;
	
	//预算
	private Double budget;
	
	//联系方式（电话）
	private String phone;
	
	//联系方式（QQ）
	private String OICQ;
	
	//项目类型
	private String type;
	
	//交换项目所需积分
	private Integer price;
	
	//项目图片文件
	private List<ProjPic> projPic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOICQ() {
		return OICQ;
	}

	public void setOICQ(String oICQ) {
		OICQ = oICQ;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<ProjPic> getProjPic() {
		return projPic;
	}

	public void setProjPic(List<ProjPic> projPic) {
		this.projPic = projPic;
	}

	@Override
	public String toString() {
		return "Proj [id=" + id + ", uuid=" + uuid + ", user_uuid=" + user_uuid + ", title=" + title + ", message="
				+ message + ", area=" + area + ", days=" + days + ", budget=" + budget + ", phone=" + phone + ", OICQ="
				+ OICQ + ", type=" + type + ", price=" + price + ", projPic=" + projPic + "]";
	}

	public Proj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proj(Integer id, String uuid, String user_uuid, String title, String message, String area, Integer days,
			Double budget, String phone, String oICQ, String type, Integer price, List<ProjPic> projPic) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.user_uuid = user_uuid;
		this.title = title;
		this.message = message;
		this.area = area;
		this.days = days;
		this.budget = budget;
		this.phone = phone;
		OICQ = oICQ;
		this.type = type;
		this.price = price;
		this.projPic = projPic;
	}

}
