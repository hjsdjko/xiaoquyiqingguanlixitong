package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.PeisongrenyuanDao;
import com.entity.PeisongrenyuanEntity;
import com.service.PeisongrenyuanService;
import com.entity.view.PeisongrenyuanView;

/**
 * 配送人员 服务实现类
 */
@Service("peisongrenyuanService")
@Transactional
public class PeisongrenyuanServiceImpl extends ServiceImpl<PeisongrenyuanDao, PeisongrenyuanEntity> implements PeisongrenyuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<PeisongrenyuanView> page =new Query<PeisongrenyuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
