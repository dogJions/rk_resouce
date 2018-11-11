package com.fym.controller;

import com.fym.entity.SysUser;
import com.fym.entity.userLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController{


    /**
     *  登录实现
     * @param name 用户名
     * @param psw 密码
     * @param cip IP
     * @param cname  详细地点
     * @return
     */
    @RequestMapping("/login")
    public Map<String,Object> login(String name, String psw, String cip, String cname, HttpSession session){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日  HH时mm分ss秒");
        Map<String,Object> map=new HashMap<>();
        //用户密码密钥
        UsernamePasswordToken token=new UsernamePasswordToken(name,psw);
        //获取主体
        Subject subject= SecurityUtils.getSubject();

        try {
            subject.login(token);
            if(subject.isAuthenticated()) {
                map.put("status", 1);
                map.put("msg", "登录成功");
                //获取登录用户的所有数据
                SysUser user=suService.selectByName(name);
                session.setAttribute("user",user);
                //设置登录日志
                userLog ul=new userLog();
                ul.setUserId(user.getId());
                ul.setAddTime(new Date());
                ul.setIp(cip);
                ul.setAddress(cname);
                String ct=name+"用户在"+sdf.format(new Date())+"登录,ip地址【"+cip+"】,登录区域在"+cname;
                ul.setContent(ct);
                ulService.add(ul);
            }
        } catch (UnknownAccountException e) {
            map.put("status", 0);
            map.put("msg", "用户名密码错误1");
        } catch (IncorrectCredentialsException e) {
            map.put("status", 0);
            map.put("msg", "用户名密码错误2");
        }

        return map;
    }
}
