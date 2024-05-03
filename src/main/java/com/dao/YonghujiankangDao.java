package com.dao;

import com.entity.YonghujiankangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YonghujiankangView;

/**
 * 用户健康 Dao 接口
 *
 * @author 
 */
public interface YonghujiankangDao extends BaseMapper<YonghujiankangEntity> {

   List<YonghujiankangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
