package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ChangdiguanliyuanEntity;
import com.entity.view.ChangdiguanliyuanView;
import com.service.ChangdiguanliyuanService;
import com.service.TokenService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * 场地管理员
 * 后端接口
 *
 * @author
 * @email
 * @date 2024-05-08 20:55:39
 */
@RestController
@RequestMapping("/changdiguanliyuan")
public class ChangdiguanliyuanController {
    @Autowired
    private ChangdiguanliyuanService changdiguanliyuanService;
    @Autowired
    private TokenService tokenService;

    /**
     * 登录
     */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ChangdiguanliyuanEntity u = changdiguanliyuanService.selectOne(new EntityWrapper<ChangdiguanliyuanEntity>().eq("guanlizhanghao", username));
        if (u == null || !u.getMima().equals(password)) {
            return R.error("账号或密码不正确");
        }

        String token = tokenService.generateToken(u.getId(), username, "changdiguanliyuan", "管理员");
        return R.ok().put("token", token);
    }


    /**
     * 注册
     */
    @IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody ChangdiguanliyuanEntity changdiguanliyuan) {
        //ValidatorUtils.validateEntity(changdiguanliyuan);
        ChangdiguanliyuanEntity u = changdiguanliyuanService.selectOne(new EntityWrapper<ChangdiguanliyuanEntity>().eq("guanlizhanghao", changdiguanliyuan.getGuanlizhanghao()));
        if (u != null) {
            return R.error("注册用户已存在");
        }
        Long uId = new Date().getTime();
        changdiguanliyuan.setId(uId);
        changdiguanliyuanService.insert(changdiguanliyuan);
        return R.ok();
    }


    /**
     * 退出
     */
    @RequestMapping("/logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }

    /**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request) {
        Long id = (Long) request.getSession().getAttribute("userId");
        ChangdiguanliyuanEntity u = changdiguanliyuanService.selectById(id);
        return R.ok().put("data", u);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ChangdiguanliyuanEntity u = changdiguanliyuanService.selectOne(new EntityWrapper<ChangdiguanliyuanEntity>().eq("guanlizhanghao", username));
        if (u == null) {
            return R.error("账号不存在");
        }
        u.setMima("123456");
        changdiguanliyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ChangdiguanliyuanEntity changdiguanliyuan,
                  HttpServletRequest request) {
        EntityWrapper<ChangdiguanliyuanEntity> ew = new EntityWrapper<ChangdiguanliyuanEntity>();

        PageUtils page = changdiguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiguanliyuan), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前台列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, ChangdiguanliyuanEntity changdiguanliyuan,
                  HttpServletRequest request) {
        EntityWrapper<ChangdiguanliyuanEntity> ew = new EntityWrapper<ChangdiguanliyuanEntity>();

        PageUtils page = changdiguanliyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, changdiguanliyuan), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(ChangdiguanliyuanEntity changdiguanliyuan) {
        EntityWrapper<ChangdiguanliyuanEntity> ew = new EntityWrapper<ChangdiguanliyuanEntity>();
        ew.allEq(MPUtil.allEQMapPre(changdiguanliyuan, "changdiguanliyuan"));
        return R.ok().put("data", changdiguanliyuanService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChangdiguanliyuanEntity changdiguanliyuan) {
        EntityWrapper<ChangdiguanliyuanEntity> ew = new EntityWrapper<ChangdiguanliyuanEntity>();
        ew.allEq(MPUtil.allEQMapPre(changdiguanliyuan, "changdiguanliyuan"));
        ChangdiguanliyuanView changdiguanliyuanView = changdiguanliyuanService.selectView(ew);
        return R.ok("查询场地管理员成功").put("data", changdiguanliyuanView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        ChangdiguanliyuanEntity changdiguanliyuan = changdiguanliyuanService.selectById(id);
        return R.ok().put("data", changdiguanliyuan);
    }

    /**
     * 前台详情
     */
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id) {
        ChangdiguanliyuanEntity changdiguanliyuan = changdiguanliyuanService.selectById(id);
        return R.ok().put("data", changdiguanliyuan);
    }


    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChangdiguanliyuanEntity changdiguanliyuan, HttpServletRequest request) {
        if (changdiguanliyuanService.selectCount(new EntityWrapper<ChangdiguanliyuanEntity>().eq("guanlizhanghao", changdiguanliyuan.getGuanlizhanghao())) > 0) {
            return R.error("管理账号已存在");
        }
        changdiguanliyuan.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(changdiguanliyuan);
        ChangdiguanliyuanEntity u = changdiguanliyuanService.selectOne(new EntityWrapper<ChangdiguanliyuanEntity>().eq("guanlizhanghao", changdiguanliyuan.getGuanlizhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        changdiguanliyuan.setId(new Date().getTime());
        changdiguanliyuanService.insert(changdiguanliyuan);
        return R.ok();
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChangdiguanliyuanEntity changdiguanliyuan, HttpServletRequest request) {
        if (changdiguanliyuanService.selectCount(new EntityWrapper<ChangdiguanliyuanEntity>().eq("guanlizhanghao", changdiguanliyuan.getGuanlizhanghao())) > 0) {
            return R.error("管理账号已存在");
        }
        changdiguanliyuan.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
        //ValidatorUtils.validateEntity(changdiguanliyuan);
        ChangdiguanliyuanEntity u = changdiguanliyuanService.selectOne(new EntityWrapper<ChangdiguanliyuanEntity>().eq("guanlizhanghao", changdiguanliyuan.getGuanlizhanghao()));
        if (u != null) {
            return R.error("用户已存在");
        }
        changdiguanliyuan.setId(new Date().getTime());
        changdiguanliyuanService.insert(changdiguanliyuan);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChangdiguanliyuanEntity changdiguanliyuan, HttpServletRequest request) {
        //ValidatorUtils.validateEntity(changdiguanliyuan);
        if (changdiguanliyuanService.selectCount(new EntityWrapper<ChangdiguanliyuanEntity>().ne("id", changdiguanliyuan.getId()).eq("guanlizhanghao", changdiguanliyuan.getGuanlizhanghao())) > 0) {
            return R.error("管理账号已存在");
        }
        changdiguanliyuanService.updateById(changdiguanliyuan);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        changdiguanliyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
