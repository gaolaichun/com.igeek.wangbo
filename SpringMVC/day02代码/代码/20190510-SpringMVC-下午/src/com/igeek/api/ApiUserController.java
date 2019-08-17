package com.igeek.api;

import com.igeek.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * @author Administrator
 * @create 2019/05/10
 */
@Controller
@RequestMapping("/api/user")
@ResponseBody //声明该类下的所有方法都是返回json数据格式,而不经过视图解析器
public class ApiUserController {

    @RequestMapping("/list")
    //@ResponseBody //将返回值直接以JSON格式输出,不会经过视图解析器
    public List<User> list(){
        //调用业务层获取用户列表
        List<User> users = new ArrayList<>();
        users.add(new User("张三",11,"江苏无锡","13838383338",new Date()));
        users.add(new User("李四",12,"江苏无锡","13838383366",new Date()));
        users.add(new User("王五",13,"江苏无锡","13838383666",new Date()));
        users.add(new User("赵六",14,"江苏无锡","13838386666",new Date()));

        return users;
    }

    //http://localhost:8086/springmvc/register?name=张三&age=12&address=无锡

    //RequestBody:接收请求中的json数据
    @RequestMapping("/register")
    public Map<String,Object> register(@RequestBody User user){
        System.out.println(user);
        Map<String,Object> result = new HashMap<>();
        result.put("result",1);//{result:1}
        return result;
    }

    /*根据id查询用户*/
    /*@RequestMapping("/get")
    public Map<String,String> get(String id){
        Map<String,String> map = new HashMap<>();
        map.put("message","需要查询的id :"+id);
        return map;
    }*/

    @RequestMapping("/get/{id}")  //{id} 占位符
    public Map<String,String> get(@PathVariable() String id){  //@PathVariable接收占位符中的实际值 传给id
        Map<String,String> map = new HashMap<>();
        map.put("message","需要查询的id :"+id);
        return map;
    }

    /*如果占位符变量名与参数名不一致的时候 可以在@PathVariable(name = "uid")指定*/
    @RequestMapping("/delete/{uid}")  //{id} 占位符
    public Map<String,String> delete(@PathVariable(name = "uid") String id){  //@PathVariable接收占位符中的实际值 传给id
        Map<String,String> map = new HashMap<>();
        map.put("message","需要删除的id :"+id);
        return map;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public Map<String,String> add(User user){  //@PathVariable接收占位符中的实际值 传给id
        Map<String,String> map = new HashMap<>();
        map.put("message","新增用户");
        return map;
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public Map<String,String> update(User user){  //@PathVariable接收占位符中的实际值 传给id
        Map<String,String> map = new HashMap<>();
        map.put("message","更新用户");
        return map;
    }


}
