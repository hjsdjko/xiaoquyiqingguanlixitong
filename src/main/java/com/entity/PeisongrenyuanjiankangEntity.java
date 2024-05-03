package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 配送人员健康
 *
 * @author 
 * @email
 */
@TableName("peisongrenyuanjiankang")
public class PeisongrenyuanjiankangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeisongrenyuanjiankangEntity() {

	}

	public PeisongrenyuanjiankangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 配送人员
     */
    @ColumnInfo(comment="配送人员",type="int(11)")
    @TableField(value = "peisongrenyuan_id")

    private Integer peisongrenyuanId;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="检测时间",type="timestamp")
    @TableField(value = "jiance_time")

    private Date jianceTime;


    /**
     * 检测结果
     */
    @ColumnInfo(comment="检测结果",type="int(11)")
    @TableField(value = "jiance_types")

    private Integer jianceTypes;


    /**
     * 证明文件
     */
    @ColumnInfo(comment="证明文件",type="varchar(200)")
    @TableField(value = "peisongrenyuanjiankang_file")

    private String peisongrenyuanjiankangFile;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "peisongrenyuanjiankang_content")

    private String peisongrenyuanjiankangContent;


    /**
     * 上报时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上报时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：配送人员
	 */
    public Integer getPeisongrenyuanId() {
        return peisongrenyuanId;
    }
    /**
	 * 设置：配送人员
	 */

    public void setPeisongrenyuanId(Integer peisongrenyuanId) {
        this.peisongrenyuanId = peisongrenyuanId;
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
    public String getPeisongrenyuanjiankangFile() {
        return peisongrenyuanjiankangFile;
    }
    /**
	 * 设置：证明文件
	 */

    public void setPeisongrenyuanjiankangFile(String peisongrenyuanjiankangFile) {
        this.peisongrenyuanjiankangFile = peisongrenyuanjiankangFile;
    }
    /**
	 * 获取：备注
	 */
    public String getPeisongrenyuanjiankangContent() {
        return peisongrenyuanjiankangContent;
    }
    /**
	 * 设置：备注
	 */

    public void setPeisongrenyuanjiankangContent(String peisongrenyuanjiankangContent) {
        this.peisongrenyuanjiankangContent = peisongrenyuanjiankangContent;
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

    @Override
    public String toString() {
        return "Peisongrenyuanjiankang{" +
            ", id=" + id +
            ", peisongrenyuanId=" + peisongrenyuanId +
            ", jianceTime=" + DateUtil.convertString(jianceTime,"yyyy-MM-dd") +
            ", jianceTypes=" + jianceTypes +
            ", peisongrenyuanjiankangFile=" + peisongrenyuanjiankangFile +
            ", peisongrenyuanjiankangContent=" + peisongrenyuanjiankangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
