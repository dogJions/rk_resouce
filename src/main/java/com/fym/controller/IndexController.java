package com.fym.controller;

import com.fym.entity.ResouceContent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/index")
public class IndexController extends  BaseController {

   /**
    * 首页
    * @param modelMap
    * @param session
    * @return
    */
   @RequestMapping("/homepage")
   public String homepage(ModelMap modelMap, HttpSession session) {
//       for ( ResouceLable t:rcService.selectindex()) {
//           System.err.println(t);
//       }
      session.setAttribute("LC", lcService.selectAll());
      session.setAttribute("RV", rvService.selectByRecommend().getList());
      session.setAttribute("RL", rlService.selectAll());
      modelMap.put("adConfig", adConfigService.selectAll());
      modelMap.put("active",1);
      return "index";
   }

   /**
    * 文章页
    * @param modelMap
    * @return
    */
   @RequestMapping("/text")
   public String toTxt(ModelMap modelMap){
      modelMap.put("active",2);
      modelMap.put("rCatalog",rCatalogService.selectOneCa(1));
      return "articleList";
   }

   /**
    * 文章详细页
    * @param id 查询详情所需id
    * @param modelMap
    * @return
    */
   @RequestMapping("/text_detailed")
   public  String text(long id,ModelMap modelMap){
       ResouceContent rc= rcService.selectById(id);
       rc.setClickCount(rc.getClickCount()+1);
      rcService.update(rc);

      modelMap.put("text", rc);
      modelMap.put("active",2);
      return "textDetailed";
   }

   /**
    * 视频页
    * @param modelMap
    * @return
    */
   @RequestMapping("/video")
   public String video(ModelMap modelMap){
      modelMap.put("active",3);
      modelMap.put("rCatalog",rCatalogService.selectOneCa(2));
      return "videoList";
   }

   /**
    * 视频详细页
    * @param id 查询详情所需id
    * @param modelMap
    * @return
    */
   @RequestMapping("/video_detailed")
   public  String video_detailed(long id,ModelMap modelMap){
      ResouceContent rc= rcService.selectById(id);
      rc.setClickCount(rc.getClickCount()+1);
      rcService.update(rc);

      modelMap.put("video", rc);
      modelMap.put("active",3);
      return "videoDetail";
   }

    /**
     * 软件页
     * @param modelMap
     * @return
     */
   @RequestMapping("/soft")
   public String soft(ModelMap modelMap){
      modelMap.put("active",4);
      modelMap.put("rCatalog",rCatalogService.selectOneCa(3));
      return "softList";
   }

    /**
     * 软件详情页
     * @param id  查询详情所需id
     * @param modelMap
     * @return
     */
    @RequestMapping("/soft_detailed")
    public  String soft_detailed(long id,ModelMap modelMap){
        ResouceContent rc= rcService.selectById(id);
        rc.setClickCount(rc.getClickCount()+1);
        rcService.update(rc);
        rdfService.selectByCid(rc.getId());

        modelMap.put("soft", rc);
        modelMap.put("rdf", rdfService.selectByCid(rc.getId()));
        modelMap.put("active",4);
        return "softDetailed";
    }

    /**
     *  留言页
     * @param modelMap
     * @return
     */
    @RequestMapping("/to_massage")
    public String massage(ModelMap modelMap){
        modelMap.put("active",5);
        return "message";
    }

    @RequestMapping("/about")
    public String about(ModelMap modelMap){
        modelMap.put("active",6);
        return "about";
    }

    /**
     * 后台登录页
     * @param modelMap
     * @return
     */
    @RequestMapping("/login")
    public String login(ModelMap modelMap){
        return "admin/login";
    }
}

