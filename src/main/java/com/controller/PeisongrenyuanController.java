
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 配送人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/peisongrenyuan")
public class PeisongrenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(PeisongrenyuanController.class);

    private static final String TABLE_NAME = "peisongrenyuan";

    @Autowired
    private PeisongrenyuanService peisongrenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ShangjiaService shangjiaService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("配送人员".equals(role))
            params.put("peisongrenyuanId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = peisongrenyuanService.queryPage(params);

        //字典表数据转换
        List<PeisongrenyuanView> list =(List<PeisongrenyuanView>)page.getList();
        for(PeisongrenyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PeisongrenyuanEntity peisongrenyuan = peisongrenyuanService.selectById(id);
        if(peisongrenyuan !=null){
            //entity转view
            PeisongrenyuanView view = new PeisongrenyuanView();
            BeanUtils.copyProperties( peisongrenyuan , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PeisongrenyuanEntity peisongrenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,peisongrenyuan:{}",this.getClass().getName(),peisongrenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<PeisongrenyuanEntity> queryWrapper = new EntityWrapper<PeisongrenyuanEntity>()
            .eq("username", peisongrenyuan.getUsername())
            .or()
            .eq("peisongrenyuan_phone", peisongrenyuan.getPeisongrenyuanPhone())
            .or()
            .eq("peisongrenyuan_id_number", peisongrenyuan.getPeisongrenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeisongrenyuanEntity peisongrenyuanEntity = peisongrenyuanService.selectOne(queryWrapper);
        if(peisongrenyuanEntity==null){
            peisongrenyuan.setCreateTime(new Date());
            peisongrenyuan.setPassword("123456");
            peisongrenyuanService.insert(peisongrenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者配送人员手机号或者配送人员身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PeisongrenyuanEntity peisongrenyuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,peisongrenyuan:{}",this.getClass().getName(),peisongrenyuan.toString());
        PeisongrenyuanEntity oldPeisongrenyuanEntity = peisongrenyuanService.selectById(peisongrenyuan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<PeisongrenyuanEntity> queryWrapper = new EntityWrapper<PeisongrenyuanEntity>()
            .notIn("id",peisongrenyuan.getId())
            .andNew()
            .eq("username", peisongrenyuan.getUsername())
            .or()
            .eq("peisongrenyuan_phone", peisongrenyuan.getPeisongrenyuanPhone())
            .or()
            .eq("peisongrenyuan_id_number", peisongrenyuan.getPeisongrenyuanIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeisongrenyuanEntity peisongrenyuanEntity = peisongrenyuanService.selectOne(queryWrapper);
        if("".equals(peisongrenyuan.getPeisongrenyuanPhoto()) || "null".equals(peisongrenyuan.getPeisongrenyuanPhoto())){
                peisongrenyuan.setPeisongrenyuanPhoto(null);
        }
        if(peisongrenyuanEntity==null){
            peisongrenyuanService.updateById(peisongrenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者配送人员手机号或者配送人员身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PeisongrenyuanEntity> oldPeisongrenyuanList =peisongrenyuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        peisongrenyuanService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PeisongrenyuanEntity> peisongrenyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PeisongrenyuanEntity peisongrenyuanEntity = new PeisongrenyuanEntity();
//                            peisongrenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //peisongrenyuanEntity.setPassword("123456");//密码
//                            peisongrenyuanEntity.setPeisongrenyuanName(data.get(0));                    //配送人员姓名 要改的
//                            peisongrenyuanEntity.setPeisongrenyuanPhone(data.get(0));                    //配送人员手机号 要改的
//                            peisongrenyuanEntity.setPeisongrenyuanIdNumber(data.get(0));                    //配送人员身份证号 要改的
//                            peisongrenyuanEntity.setPeisongrenyuanPhoto("");//详情和图片
//                            peisongrenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            peisongrenyuanEntity.setPeisongrenyuanEmail(data.get(0));                    //电子邮箱 要改的
//                            peisongrenyuanEntity.setCreateTime(date);//时间
                            peisongrenyuanList.add(peisongrenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //配送人员手机号
                                if(seachFields.containsKey("peisongrenyuanPhone")){
                                    List<String> peisongrenyuanPhone = seachFields.get("peisongrenyuanPhone");
                                    peisongrenyuanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> peisongrenyuanPhone = new ArrayList<>();
                                    peisongrenyuanPhone.add(data.get(0));//要改的
                                    seachFields.put("peisongrenyuanPhone",peisongrenyuanPhone);
                                }
                                //配送人员身份证号
                                if(seachFields.containsKey("peisongrenyuanIdNumber")){
                                    List<String> peisongrenyuanIdNumber = seachFields.get("peisongrenyuanIdNumber");
                                    peisongrenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> peisongrenyuanIdNumber = new ArrayList<>();
                                    peisongrenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("peisongrenyuanIdNumber",peisongrenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<PeisongrenyuanEntity> peisongrenyuanEntities_username = peisongrenyuanService.selectList(new EntityWrapper<PeisongrenyuanEntity>().in("username", seachFields.get("username")));
                        if(peisongrenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeisongrenyuanEntity s:peisongrenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //配送人员手机号
                        List<PeisongrenyuanEntity> peisongrenyuanEntities_peisongrenyuanPhone = peisongrenyuanService.selectList(new EntityWrapper<PeisongrenyuanEntity>().in("peisongrenyuan_phone", seachFields.get("peisongrenyuanPhone")));
                        if(peisongrenyuanEntities_peisongrenyuanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeisongrenyuanEntity s:peisongrenyuanEntities_peisongrenyuanPhone){
                                repeatFields.add(s.getPeisongrenyuanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [配送人员手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //配送人员身份证号
                        List<PeisongrenyuanEntity> peisongrenyuanEntities_peisongrenyuanIdNumber = peisongrenyuanService.selectList(new EntityWrapper<PeisongrenyuanEntity>().in("peisongrenyuan_id_number", seachFields.get("peisongrenyuanIdNumber")));
                        if(peisongrenyuanEntities_peisongrenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PeisongrenyuanEntity s:peisongrenyuanEntities_peisongrenyuanIdNumber){
                                repeatFields.add(s.getPeisongrenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [配送人员身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        peisongrenyuanService.insertBatch(peisongrenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        PeisongrenyuanEntity peisongrenyuan = peisongrenyuanService.selectOne(new EntityWrapper<PeisongrenyuanEntity>().eq("username", username));
        if(peisongrenyuan==null || !peisongrenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(peisongrenyuan.getId(),username, "peisongrenyuan", "配送人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","配送人员");
        r.put("username",peisongrenyuan.getPeisongrenyuanName());
        r.put("tableName","peisongrenyuan");
        r.put("userId",peisongrenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody PeisongrenyuanEntity peisongrenyuan, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<PeisongrenyuanEntity> queryWrapper = new EntityWrapper<PeisongrenyuanEntity>()
            .eq("username", peisongrenyuan.getUsername())
            .or()
            .eq("peisongrenyuan_phone", peisongrenyuan.getPeisongrenyuanPhone())
            .or()
            .eq("peisongrenyuan_id_number", peisongrenyuan.getPeisongrenyuanIdNumber())
            ;
        PeisongrenyuanEntity peisongrenyuanEntity = peisongrenyuanService.selectOne(queryWrapper);
        if(peisongrenyuanEntity != null)
            return R.error("账户或者配送人员手机号或者配送人员身份证号已经被使用");
        peisongrenyuan.setCreateTime(new Date());
        peisongrenyuanService.insert(peisongrenyuan);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        PeisongrenyuanEntity peisongrenyuan = peisongrenyuanService.selectById(id);
        peisongrenyuan.setPassword("123456");
        peisongrenyuanService.updateById(peisongrenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        PeisongrenyuanEntity peisongrenyuan = peisongrenyuanService.selectOne(new EntityWrapper<PeisongrenyuanEntity>().eq("username", username));
        if(peisongrenyuan!=null){
            peisongrenyuan.setPassword("123456");
            boolean b = peisongrenyuanService.updateById(peisongrenyuan);
            if(!b){
               return R.error();
            }
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrPeisongrenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        PeisongrenyuanEntity peisongrenyuan = peisongrenyuanService.selectById(id);
        if(peisongrenyuan !=null){
            //entity转view
            PeisongrenyuanView view = new PeisongrenyuanView();
            BeanUtils.copyProperties( peisongrenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = peisongrenyuanService.queryPage(params);

        //字典表数据转换
        List<PeisongrenyuanView> list =(List<PeisongrenyuanView>)page.getList();
        for(PeisongrenyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PeisongrenyuanEntity peisongrenyuan = peisongrenyuanService.selectById(id);
            if(peisongrenyuan !=null){


                //entity转view
                PeisongrenyuanView view = new PeisongrenyuanView();
                BeanUtils.copyProperties( peisongrenyuan , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody PeisongrenyuanEntity peisongrenyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,peisongrenyuan:{}",this.getClass().getName(),peisongrenyuan.toString());
        Wrapper<PeisongrenyuanEntity> queryWrapper = new EntityWrapper<PeisongrenyuanEntity>()
            .eq("username", peisongrenyuan.getUsername())
            .or()
            .eq("peisongrenyuan_phone", peisongrenyuan.getPeisongrenyuanPhone())
            .or()
            .eq("peisongrenyuan_id_number", peisongrenyuan.getPeisongrenyuanIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PeisongrenyuanEntity peisongrenyuanEntity = peisongrenyuanService.selectOne(queryWrapper);
        if(peisongrenyuanEntity==null){
            peisongrenyuan.setCreateTime(new Date());
        peisongrenyuan.setPassword("123456");
        peisongrenyuanService.insert(peisongrenyuan);

            return R.ok();
        }else {
            return R.error(511,"账户或者配送人员手机号或者配送人员身份证号已经被使用");
        }
    }

}
