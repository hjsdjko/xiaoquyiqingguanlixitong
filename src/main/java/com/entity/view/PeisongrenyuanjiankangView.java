package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.PeisongrenyuanjiankangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 配送人员健康
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("peisongrenyuanjiankang")
public class PeisongrenyuanjiankangView extends PeisongrenyuanjiankangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 检测结果的值
	*/
	@ColumnInfo(comment="检测结果的字典表值",type="varchar(200)")
	private String jianceValue;

	//级联表 配送人员
		/**
		* 配送人员姓名
		*/

		@ColumnInfo(comment="配送人员姓名",type="varchar(200)")
		private String peisongrenyuanName;
		/**
		* 配送人员手机号
		*/

		@ColumnInfo(comment="配送人员手机号",type="varchar(200)")
		private String peisongrenyuanPhone;
		/**
		* 配送人员身份证号
		*/

		@ColumnInfo(comment="配送人员身份证号",type="varchar(200)")
		private String peisongrenyuanIdNumber;
		/**
		* 配送人员头像
		*/

		@ColumnInfo(comment="配送人员头像",type="varchar(200)")
		private String peisongrenyuanPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String peisongrenyuanEmail;



	public PeisongrenyuanjiankangView() {

	}

	public PeisongrenyuanjiankangView(PeisongrenyuanjiankangEntity peisongrenyuanjiankangEntity) {
		try {
			BeanUtils.copyProperties(this, peisongrenyuanjiankangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 检测结果的值
	*/
	public String getJianceValue() {
		return jianceValue;
	}
	/**
	* 设置： 检测结果的值
	*/
	public void setJianceValue(String jianceValue) {
		this.jianceValue = jianceValue;
	}


	//级联表的get和set 配送人员

		/**
		* 获取： 配送人员姓名
		*/
		public String getPeisongrenyuanName() {
			return peisongrenyuanName;
		}
		/**
		* 设置： 配送人员姓名
		*/
		public void setPeisongrenyuanName(String peisongrenyuanName) {
			this.peisongrenyuanName = peisongrenyuanName;
		}

		/**
		* 获取： 配送人员手机号
		*/
		public String getPeisongrenyuanPhone() {
			return peisongrenyuanPhone;
		}
		/**
		* 设置： 配送人员手机号
		*/
		public void setPeisongrenyuanPhone(String peisongrenyuanPhone) {
			this.peisongrenyuanPhone = peisongrenyuanPhone;
		}

		/**
		* 获取： 配送人员身份证号
		*/
		public String getPeisongrenyuanIdNumber() {
			return peisongrenyuanIdNumber;
		}
		/**
		* 设置： 配送人员身份证号
		*/
		public void setPeisongrenyuanIdNumber(String peisongrenyuanIdNumber) {
			this.peisongrenyuanIdNumber = peisongrenyuanIdNumber;
		}

		/**
		* 获取： 配送人员头像
		*/
		public String getPeisongrenyuanPhoto() {
			return peisongrenyuanPhoto;
		}
		/**
		* 设置： 配送人员头像
		*/
		public void setPeisongrenyuanPhoto(String peisongrenyuanPhoto) {
			this.peisongrenyuanPhoto = peisongrenyuanPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getPeisongrenyuanEmail() {
			return peisongrenyuanEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setPeisongrenyuanEmail(String peisongrenyuanEmail) {
			this.peisongrenyuanEmail = peisongrenyuanEmail;
		}


	@Override
	public String toString() {
		return "PeisongrenyuanjiankangView{" +
			", jianceValue=" + jianceValue +
			", peisongrenyuanName=" + peisongrenyuanName +
			", peisongrenyuanPhone=" + peisongrenyuanPhone +
			", peisongrenyuanIdNumber=" + peisongrenyuanIdNumber +
			", peisongrenyuanPhoto=" + peisongrenyuanPhoto +
			", peisongrenyuanEmail=" + peisongrenyuanEmail +
			"} " + super.toString();
	}
}
