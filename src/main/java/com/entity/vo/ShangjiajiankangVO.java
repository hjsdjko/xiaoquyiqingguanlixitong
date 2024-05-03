package com.entity.vo;

import com.entity.ShangjiajiankangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 商家健康
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shangjiajiankang")
public class ShangjiajiankangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 商家
     */

    @TableField(value = "shangjia_id")
    private Integer shangjiaId;


    /**
     * 检测时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiance_time")
    private Date jianceTime;


    /**
     * 检测结果
     */

    @TableField(value = "jiance_types")
    private Integer jianceTypes;


    /**
     * 证明文件
     */

    @TableField(value = "shangjiajiankang_file")
    private String shangjiajiankangFile;


    /**
     * 备注
     */

    @TableField(value = "shangjiajiankang_content")
    private String shangjiajiankangContent;


    /**
     * 上报时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：商家
	 */
    public Integer getShangjiaId() {
        return shangjiaId;
    }


    /**
	 * 获取：商家
	 */

    public void setShangjiaId(Integer shangjiaId) {
        this.shangjiaId = shangjiaId;
    }
    /**
	 * 设置：检测时间
	 */
    public Date getJianceTime() {
        return jianceTime;
    }


    /**
	 * 获取：检测时间
	 */

    public void setJianceTime(Date jianceTime) {
        this.jianceTime = jianceTime;
    }
    /**
	 * 设置：检测结果
	 */
    public Integer getJianceTypes() {
        return jianceTypes;
    }


    /**
	 * 获取：检测结果
	 */

    public void setJianceTypes(Integer jianceTypes) {
        this.jianceTypes = jianceTypes;
    }
    /**
	 * 设置：证明文件
	 */
    public String getShangjiajiankangFile() {
        return shangjiajiankangFile;
    }


    /**
	 * 获取：证明文件
	 */

    public void setShangjiajiankangFile(String shangjiajiankangFile) {
        this.shangjiajiankangFile = shangjiajiankangFile;
    }
    /**
	 * 设置：备注
	 */
    public String getShangjiajiankangContent() {
        return shangjiajiankangContent;
    }


    /**
	 * 获取：备注
	 */

    public void setShangjiajiankangContent(String shangjiajiankangContent) {
        this.shangjiajiankangContent = shangjiajiankangContent;
    }
    /**
	 * 设置：上报时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：上报时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
