package com.dao;

import com.entity.PeisongrenyuanjiankangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PeisongrenyuanjiankangView;

/**
 * 配送人员健康 Dao 接口
 *
 * @author 
 */
public interface PeisongrenyuanjiankangDao extends BaseMapper<PeisongrenyuanjiankangEntity> {

   List<PeisongrenyuanjiankangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
