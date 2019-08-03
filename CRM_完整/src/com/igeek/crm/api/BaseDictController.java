package com.igeek.crm.api;

import com.igeek.crm.po.BaseDict;
import com.igeek.crm.service.IBaseDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @create 2019/05/14
 */
@Controller
@ResponseBody
@RequestMapping("/api/base")
public class BaseDictController {

    @Autowired
    private IBaseDictService baseDictService;

    @RequestMapping("/source")
    public List<BaseDict> source(){
        return baseDictService.list("002");
    }

    @RequestMapping("/industry")
    public List<BaseDict> industry(){
        return baseDictService.list("001");
    }

    @RequestMapping("/level")
    public List<BaseDict> level(){
        return baseDictService.list("006");
    }
}
