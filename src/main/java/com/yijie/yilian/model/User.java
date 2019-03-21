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
	
	//账户微信登录对应openID
	private String openid;
	
	//账户QQ登录对应UID
	private String QQuid;
	
	//账户电话号码（登录账号）
	private String num;
	
	//账户密码
	private String password;
	
	//账户名称（个人/公司）
	private String name;
	
	//账户积分余额
	private Integer balance;
	
	//账户级别（个人/公司）
	private Integer level;

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getQQuid() {
		return QQuid;
	}

	public void setQQuid(String qQuid) {
		QQuid = qQuid;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + ", openid=" + openid + ", QQuid=" + QQuid + ", num=" + num
				+ ", password=" + password + ", name=" + name + ", balance=" + balance + ", level=" + level + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String uuid, String openid, String qQuid, String num, String password, String name,
			Integer balance, Integer level) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.openid = openid;
		QQuid = qQuid;
		this.num = num;
		this.password = password;
		this.name = name;
		this.balance = balance;
		this.level = level;
	}

}
