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
 * 商家健康
 *
 * @author 
 * @email
 */
@TableName("shangjiajiankang")
public class ShangjiajiankangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangjiajiankangEntity() {

	}

	public ShangjiajiankangEntity(T t) {
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
     * 商家
     */
    @ColumnInfo(comment="商家",type="int(11)")
    @TableField(value = "shangjia_id")

    private Integer shangjiaId;


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
    @TableField(value = "shangjiajiankang_file")

    private String shangjiajiankangFile;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "shangjiajiankang_content")

    private String shangjiajiankangContent;


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
	 * 获取：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }
    /**
	 * 设置：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
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
    public String getShangjiajiankangFile() {
        return shangjiajiankangFile;
    }
    /**
	 * 设置：证明文件
	 */

    public void setShangjiajiankangFile(String shangjiajiankangFile) {
        this.shangjiajiankangFile = shangjiajiankangFile;
    }
    /**
	 * 获取：备注
	 */
    public String getShangjiajiankangContent() {
        return shangjiajiankangContent;
    }
    /**
	 * 设置：备注
	 */

    public void setShangjiajiankangContent(String shangjiajiankangContent) {
        this.shangjiajiankangContent = shangjiajiankangContent;
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
        return "Shangjiajiankang{" +
            ", id=" + id +
            ", shangjiaId=" + shangjiaId +
            ", jianceTime=" + DateUtil.convertString(jianceTime,"yyyy-MM-dd") +
            ", jianceTypes=" + jianceTypes +
            ", shangjiajiankangFile=" + shangjiajiankangFile +
            ", shangjiajiankangContent=" + shangjiajiankangContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
