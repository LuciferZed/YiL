package com.yijie.yilian.model;

//项目对应图片文件
public class ProjPic {
	
	//自增ID
	private Integer id;
	
	//对应项目UUID
	private String pro_uuid;
	
	//图片排序序号
	private Integer sort;
	
	//图片地址
	private String url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPro_uuid() {
		return pro_uuid;
	}

	public void setPro_uuid(String pro_uuid) {
		this.pro_uuid = pro_uuid;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ProjPic [id=" + id + ", pro_uuid=" + pro_uuid + ", sort=" + sort + ", url=" + url + "]";
	}

	public ProjPic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProjPic(Integer id, String pro_uuid, Integer sort, String url) {
		super();
		this.id = id;
		this.pro_uuid = pro_uuid;
		this.sort = sort;
		this.url = url;
	}

}
