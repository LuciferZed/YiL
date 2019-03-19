package com.yijie.yilian.model;

/**
 * @描述 用户账户
 * @author Lucifer
 *
 */
public class User {
	
	//自增ID
	private Integer id;
	
	//系统生成uuid
	private String uuid;
	
	//账户账号
	private String num;
	
	//账户密码
	private String password;
	
	//账户名称（个人/公司）
	private String name;
	
	//账户积分余额
	private Integer balance;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getuuid() {
		return uuid;
	}

	public void setuuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + ", num=" + num + ", password=" + password + ", name=" + name
				+ ", balance=" + balance + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String uuid, String num, String password, String name, Integer balance) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.num = num;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}
	
	

}
