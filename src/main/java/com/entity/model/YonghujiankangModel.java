package com.entity.model;

import com.entity.YonghujiankangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 用户健康
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YonghujiankangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jianceTime;


    /**
     * 检测结果
     */
    private Integer jianceTypes;


    /**
     * 证明文件
     */
    private String yonghujiankangFile;


    /**
     * 备注
     */
    private String yonghujiankangContent;


    /**
     * 上报时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：检测时间
	 */
    public Date getJianceTime() {
        return jianceTime;
    }


    /**
	 * 设置：检测时间
	 */
    public void setJianceTime(Date jianceTime) {
        this.jianceTime = jianceTime;
    }
    /**
	 * 获取：检测结果
	 */
    public Integer getJianceTypes() {
        return jianceTypes;
    }


    /**
	 * 设置：检测结果
	 */
    public void setJianceTypes(Integer jianceTypes) {
        this.jianceTypes = jianceTypes;
    }
    /**
	 * 获取：证明文件
	 */
    public String getYonghujiankangFile() {
        return yonghujiankangFile;
    }


    /**
	 * 设置：证明文件
	 */
    public void setYonghujiankangFile(String yonghujiankangFile) {
        this.yonghujiankangFile = yonghujiankangFile;
    }
    /**
	 * 获取：备注
	 */
    public String getYonghujiankangContent() {
        return yonghujiankangContent;
    }


    /**
	 * 设置：备注
	 */
    public void setYonghujiankangContent(String yonghujiankangContent) {
        this.yonghujiankangContent = yonghujiankangContent;
    }
    /**
	 * 获取：上报时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：上报时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
