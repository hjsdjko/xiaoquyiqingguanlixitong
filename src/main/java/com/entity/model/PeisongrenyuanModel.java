package com.entity.model;

import com.entity.PeisongrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 配送人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeisongrenyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 配送人员姓名
     */
    private String peisongrenyuanName;


    /**
     * 配送人员手机号
     */
    private String peisongrenyuanPhone;


    /**
     * 配送人员身份证号
     */
    private String peisongrenyuanIdNumber;


    /**
     * 配送人员头像
     */
    private String peisongrenyuanPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String peisongrenyuanEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：配送人员姓名
	 */
    public String getPeisongrenyuanName() {
        return peisongrenyuanName;
    }


    /**
	 * 设置：配送人员姓名
	 */
    public void setPeisongrenyuanName(String peisongrenyuanName) {
        this.peisongrenyuanName = peisongrenyuanName;
    }
    /**
	 * 获取：配送人员手机号
	 */
    public String getPeisongrenyuanPhone() {
        return peisongrenyuanPhone;
    }


    /**
	 * 设置：配送人员手机号
	 */
    public void setPeisongrenyuanPhone(String peisongrenyuanPhone) {
        this.peisongrenyuanPhone = peisongrenyuanPhone;
    }
    /**
	 * 获取：配送人员身份证号
	 */
    public String getPeisongrenyuanIdNumber() {
        return peisongrenyuanIdNumber;
    }


    /**
	 * 设置：配送人员身份证号
	 */
    public void setPeisongrenyuanIdNumber(String peisongrenyuanIdNumber) {
        this.peisongrenyuanIdNumber = peisongrenyuanIdNumber;
    }
    /**
	 * 获取：配送人员头像
	 */
    public String getPeisongrenyuanPhoto() {
        return peisongrenyuanPhoto;
    }


    /**
	 * 设置：配送人员头像
	 */
    public void setPeisongrenyuanPhoto(String peisongrenyuanPhoto) {
        this.peisongrenyuanPhoto = peisongrenyuanPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getPeisongrenyuanEmail() {
        return peisongrenyuanEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setPeisongrenyuanEmail(String peisongrenyuanEmail) {
        this.peisongrenyuanEmail = peisongrenyuanEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
