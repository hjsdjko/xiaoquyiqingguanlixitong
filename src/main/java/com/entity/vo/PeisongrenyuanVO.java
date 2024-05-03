package com.entity.vo;

import com.entity.PeisongrenyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 配送人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("peisongrenyuan")
public class PeisongrenyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 配送人员姓名
     */

    @TableField(value = "peisongrenyuan_name")
    private String peisongrenyuanName;


    /**
     * 配送人员手机号
     */

    @TableField(value = "peisongrenyuan_phone")
    private String peisongrenyuanPhone;


    /**
     * 配送人员身份证号
     */

    @TableField(value = "peisongrenyuan_id_number")
    private String peisongrenyuanIdNumber;


    /**
     * 配送人员头像
     */

    @TableField(value = "peisongrenyuan_photo")
    private String peisongrenyuanPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "peisongrenyuan_email")
    private String peisongrenyuanEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：配送人员姓名
	 */
    public String getPeisongrenyuanName() {
        return peisongrenyuanName;
    }


    /**
	 * 获取：配送人员姓名
	 */

    public void setPeisongrenyuanName(String peisongrenyuanName) {
        this.peisongrenyuanName = peisongrenyuanName;
    }
    /**
	 * 设置：配送人员手机号
	 */
    public String getPeisongrenyuanPhone() {
        return peisongrenyuanPhone;
    }


    /**
	 * 获取：配送人员手机号
	 */

    public void setPeisongrenyuanPhone(String peisongrenyuanPhone) {
        this.peisongrenyuanPhone = peisongrenyuanPhone;
    }
    /**
	 * 设置：配送人员身份证号
	 */
    public String getPeisongrenyuanIdNumber() {
        return peisongrenyuanIdNumber;
    }


    /**
	 * 获取：配送人员身份证号
	 */

    public void setPeisongrenyuanIdNumber(String peisongrenyuanIdNumber) {
        this.peisongrenyuanIdNumber = peisongrenyuanIdNumber;
    }
    /**
	 * 设置：配送人员头像
	 */
    public String getPeisongrenyuanPhoto() {
        return peisongrenyuanPhoto;
    }


    /**
	 * 获取：配送人员头像
	 */

    public void setPeisongrenyuanPhoto(String peisongrenyuanPhoto) {
        this.peisongrenyuanPhoto = peisongrenyuanPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getPeisongrenyuanEmail() {
        return peisongrenyuanEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setPeisongrenyuanEmail(String peisongrenyuanEmail) {
        this.peisongrenyuanEmail = peisongrenyuanEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
