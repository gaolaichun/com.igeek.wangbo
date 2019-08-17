## ；1.参数绑定

### 1.1 简单类型

在方法形参中直接指定参数类型,但是必须保证表单传递参数名与形参中定义的变量名保持一致
整形：Integer、int
字符串：String
单精度：Float、float
双精度：Double、double
布尔型：Boolean、boolean

```java
@RequestMapping("/login")
public String login(String username,String password){

}
```

### 1.2 pojo对象绑定

必须保证前台传入的参数名称需要与对象的属性名保持一致

```java
//pojo对象绑定
    @RequestMapping("/register")
    public String register(User user){
        System.out.println("user = [" + user + "]");
        return "home";
    }
```

### 1.3  包装类pojo对象绑定

```jsp
<form action="search" method="get">
    查询条件:
    客户姓名:<input type="text" name="user.name">
    客户编号:<input type="text" name="user.no">
    客户所在地:<input type="text" name="user.address">
    订单编号:<input type="text" name="orderNo">

    <input type="submit" value="查询">
</form>
```



```java
@RequestMapping("/search")
    public String search(QueryVo queryVo){
        //获取查询条件进行查询操作
        System.out.println("queryVo = [" + queryVo + "]");
        return "home";
    }
```

### 1.4 参数默认支持的数据类型

如果需要在SpringMVC的Controller中使用Web框架对象的时候(HttpServletRequest HttpServletResponse HttpSession...)

只需要在方法的形参中直接声明,就能使用了

```java
@RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

        
        System.out.println("username = [" + request.getParameter("username") + "], password = [" + request.getParameter("password") + "]");

        System.out.println("sessionID:"+session.getId());
        /*try {
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return "home";
        //request.getParameter("username");
        //request.getParameter("password");
    }

```



但是不能获取ServletContext上下文对象,但是如果需要,可以从request中获取

```java
request.getServletContext()
```



### 1.5 参数绑定有关的常用注解

> 1.@RequestParam

用于处理参数绑定

```
required = true 必传项,如果不传该参数,则返回400状态吗 Bad Request
defaultValue 默认值
name: 当方法形参名与参数名不一致的时候,可以使用name指定绑定哪个参数
```

> 2.@CookieValue 

用于获取Cookie值

```java
//@CookieValue("cookie的name")
    @RequestMapping("/getCookie")
    public String getCookie(@CookieValue("JSESSIONID") String sessionId){
        System.out.println("sessionId = [" + sessionId + "]");
        return "home";
    }
```

> 3.@SessionAttributes

实现不同请求下的数据共享

> 4.@ModelAttribute



### 1.6 域对象相关的对象

> 1.ModelAndView

```java
/**
     * 编写一个处理器,当用户访问 /user/list.action 时 打印用户列表
     *
     * @RequestMapping:指定方法的请求路径
     */
    @RequestMapping("/user/list")
    public ModelAndView userList() {
        //创建模型以及视图对象
        ModelAndView mv = new ModelAndView();
        List<User> users = new ArrayList<>();
        users.add(new User("1", "张三", 20, "1"));
        users.add(new User("2", "张三", 21, "1"));
        users.add(new User("3", "张三", 23, "1"));
        users.add(new User("4", "张三", 25, "1"));
        //设置视图
        mv.setViewName("/WEB-INF/jsp/userList.jsp");//等价于request.getRequestDispatcher("").forward(request,response);
        //设置数据模型
        mv.addObject("users", users);//等价于 request.setAttribute("users",users);
        return mv;
    }

```



> 2.HttpServletRequest

```java
@RequestMapping("/user/list")
    public String userList(HttpServletRequest request) {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "张三", 20, "1"));
        users.add(new User("2", "张三", 21, "1"));
        users.add(new User("3", "张三", 23, "1"));
        users.add(new User("4", "张三", 25, "1"));

        //设置数据模型
        request.setAttribute("users", users);
        return "userList";//返回逻辑视图名
    }
```



> 3.Model/ModelMap/Map

直接在方法形参中声明,方法体中直接使用

```java
@RequestMapping("/user/list01")
    public String userList01(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "张三", 20, "1"));
        users.add(new User("2", "张三", 21, "1"));
        users.add(new User("3", "张三", 23, "1"));
        users.add(new User("4", "张三", 25, "1"));

        //设置数据模型
        model.addAttribute("users",users);//等价于request.setAttribute("users", users);
        return "userList";//返回逻辑视图名
    }

    @RequestMapping("/user/list02")
    public String userList02(ModelMap modelMap) {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "张三", 20, "1"));
        users.add(new User("2", "张三", 21, "1"));
        users.add(new User("3", "张三", 23, "1"));
        users.add(new User("4", "张三", 25, "1"));

        //设置数据模型
        modelMap.addAttribute("users",users);//等价于request.setAttribute("users", users);
        return "userList";//返回逻辑视图名
    }

    @RequestMapping("/user/list03")
    public String userList03(Map<String,Object> map) {
        List<User> users = new ArrayList<>();
        users.add(new User("1", "张三", 20, "1"));
        users.add(new User("2", "张三", 21, "1"));
        users.add(new User("3", "张三", 23, "1"));
        users.add(new User("4", "张三", 25, "1"));

        //设置数据模型
        map.put("users",users);//等价于request.setAttribute("users", users);
        return "userList";//返回逻辑视图名
    }
```



### 1.7 自定义转换器

> 方式一:自定义转换器类

```java
//S:Source 源类型 T:target 目标类型
public class MyDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
```

在springmvc.xml中配置转换器类

```xml
<!-- 配置注解驱动 -->
    <!-- 如果配置此标签,可以不用配置... -->
<mvc:annotation-driven conversion-service="conversionService" />
<!--配置自定义日期转换器-->
    <!-- 转换器配置 -->
<bean id="conversionService" class="org.springframework.format.support.FormattingConversionServiceFactoryBean">
        <property name="converters">
            <set>
                <bean class="com.igeek.converter.MyDateConverter" />
                &lt;!&ndash;可以配置多个转换器&ndash;&gt;
            </set>
        </property>
    </bean>
```

> 方式二: 通过注解的方式

```java
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
```

在配置文件中需要开启注解驱动(springmvc的很多自动配置)

```xml
<mvc:annotation-driven  />
```





补充内容:

前端控制器为/的问题:

```xml
<servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <!--
        * 通配符
        拦截 以.action结尾的请求
        拦截所有  /  包括拦截所有的静态资源文件
        -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```



需要放行静态资源文件:

常规三种方式:

1.前端控制器,不拦截所有,拦截指定后缀 *.action

2.在springmvc.xml中配置放行静态资源文件

```xml
<!--放行静态资源文件-->
    <mvc:default-servlet-handler></mvc:default-servlet-handler>
```

3.

```xml
<mvc:resources mapping="/layui/**" location="/layui/"></mvc:resources>
```





## 2.@RequestMapping

> 作用:用于指定处理器(Handler)的映射规则

```java
/**
     * @RequestMapping 通过该注解指定处理器映射规则(也即当访问哪个url时执行该方法)
     * @return 逻辑视图名
     */
    @RequestMapping(value="/index")
    public String index(){
        return "index";
    }
```

>  @RequestMapping注解常用属性:

(1)value 默认,指定映射的url(数组)

```java
@RequestMapping(value={"/home","/index"})
```

(2)method 指定访问的方式,如果不配置默认都支持



> @RequestMapping作用位置

作用在方法上:

指定handler(方法)的映射规则

作用在类上:

给该类下的所有handler(方法)的映射规则前添加前缀规则

**总结**:handler的完整访问路径:类上的@RequestMapping指定的url+方法上@RequestMapping指定的url



## 3.Handler的返回值

### 3.1 ModelAndView

返回模型视图对象

```java
@RequestMapping("/main")
    public ModelAndView main(){
        //创建ModelAndView对象,模型视图对象(模型数据+视图)
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");//设置逻辑视图名 ,默认跳转方式:转发
        mv.addObject("name","张三");//设值模型数据, 将数据设置在request域对象中
        return mv;
    }
```



### 3.2 String

> 1.返回视图的逻辑视图名(默认),并且是转发实现页面跳转

```java
@RequestMapping("/main")
    public String main(HttpServletRequest request, Model model, ModelMap modelMap, Map<String,Object> map){
        model.addAttribute("name","李四");
        return "main";//默认跳转方式,转发
    }
```

> 2.重定向

```java
@RequestMapping("/main")
    public String main(){
        //假设未登录,需要重定向到登录页面
        return "redirect:login.jsp";//重定向,不会经过视图解析器
    }
```

**返回值不会经过视图解析器** 

补充:重定向如何实现数据共享

```java
@RequestMapping("/main")
    public String main(Model model, HttpSession session){
        //假设未登录,需要重定向到登录页面
        //session.setAttribute("msg","用户名或密码错误"); 完成不同请求的数据共享
        model.addAttribute("msg","用户名或密码错误");//将数据存放在request域对象中,如果类上添加了@SessionAttributes(value = "msg")注解,则该数据也会在session域对象中存放一份
        return "redirect:login.jsp";//重定向,不会经过视图解析器
    }
```

> 3.转发

主要用于转发到其他的请求(**该返回值也不会经过视图解析器**)

```java
 @RequestMapping("/main")
    public String main(Model model, HttpSession session){
        //假设未登录,需要重定向到登录页面
        //session.setAttribute("msg","用户名或密码错误"); 完成不同请求的数据共享
        //model.addAttribute("msg","用户名或密码错误");//将数据存放在request域对象中,如果类上添加了@SessionAttributes(value = "msg")注解,则该数据也会在session域对象中存放一份
        //return "redirect:login.jsp";//重定向,不会经过视图解析器
        //return "home";
        return "forward:home";//转发
    }
```



### 3.3 void

如果返回值为void则会将请求url作为逻辑名进行返回

```java
@RequestMapping("/nothing")
    public void nothing(){
        System.out.println("nothing...");
    }

==> /springmvc/WEB-INF/jsp/nothing1.jsp

```

```java
@RequestMapping("/nothing")
    public void nothing(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("nothing...");

        //转发
        //request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);

        //重定向
        //response.sendRedirect("login.jsp");

        //直接页面输出
        response.getWriter().write("hello world");
    }
```



## 4. 异常处理器



## 5.文件上传

> 1.添加文件上传jar包

commons-io commons-fileuplaod

> 2.配置文件上传解析器(springmvc.xml)

```xml
<!--配置文件上传解析器 id必须为CommonsMultipartResolver-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="defaultEncoding" value="utf-8"></property>
        <!--支持的最大的上传文件大小 单位是:byte  10MB = 10*1024*1024-->
        <property name="maxUploadSize" value="10000000"></property>
    </bean>
```

> 3.编写文件上传表单

```jsp
<%--如果表单需要支持文件上传,需要添加enctype="multipart/form-data"--%>
<form action="upload" method="post" enctype="multipart/form-data">
    文件:<input type="file" name="file">
    <input type="submit" value="提交">
</form>
```

> 4.编写handler

```java
@Controller
public class UploadController {

    private static final String UPLOAD_BASE_PATH = "D:\\files\\";
    /*
    * MultipartFile file 用于绑定前台传过来文件对象 file 形参名 必须与前台表单中的name属性一致
    * */
    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        //获取唯一的标识符作为文件名
        String fileName = UUID.randomUUID().toString();

        //获取文件原始文件名
        //System.out.println(file.getOriginalFilename());//a.b.jpg
        String originalFileName = file.getOriginalFilename();

        //拼接上传文件名
        fileName = fileName + originalFileName.substring(originalFileName.lastIndexOf("."));

        String uploadPath = UPLOAD_BASE_PATH+fileName;
        System.out.println("上传路径:"+uploadPath);


        try {
            //执行上传操作即可
            file.transferTo(new File(uploadPath));
            //将图片路径保存至数据库 http://localhost:8086/pic/c88ba14e-2a4b-4a8c-8516-63bb0f7b8b94.jpg
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

}

```



在tomcat配置文件(server.xml)中新建虚拟路径

使能够通过http://localhost:8086/pic/能够访问到D:\files\下的资源

在server.xml的Host节点下添加以下配置

```xml
<!-- path:配置虚拟路径 docBase:当访问虚拟路径时到哪个目录下找资源  -->
		<Context docBase="D:\files" path="/pic" reloadable="false"/>
```



## 6. SpringMVC对JSON数据处理

> 什么是JSON? 数据格式

```json
[{name:"张三",age:20},{name:"李四",age:22}]
```

JSON数据格式是由键值对组成的,键值对使用:分割

JSON使用{}来描述一个对象

JSON中如果有多个键值对,那么使用,分割

JSON中使用[]来描述一个数组,多个对象之间也使用,分割

> 实际开发业务场景

前后端分离

### 6.1 实现返回JSON数据格式

> 1.添加json转换依赖包

> 2.编写controller返回数据,并且添加@ResponseBody注解

```java
@Controller
@RequestMapping("/api/user")
@ResponseBody //声明该类下的所有方法都是返回json数据格式,而不经过视图解析器
public class ApiUserController {

    @RequestMapping("/list")
    //@ResponseBody //将返回值直接以JSON格式输出,不会经过视图解析器
    public List<User> list(){
        //调用业务层获取用户列表
        List<User> users = new ArrayList<>();
        users.add(new User("张三",11,"江苏无锡","13838383338"));
        users.add(new User("李四",12,"江苏无锡","13838383366"));
        users.add(new User("王五",13,"江苏无锡","13838383666"));
        users.add(new User("赵六",14,"江苏无锡","13838386666"));

        return users;
    }
}
```

### 6.2 接收JSON数据格式

```java
//RequestBody:接收请求中的json数据
    @RequestMapping("/register")
    public Map<String,Object> register(@RequestBody User user){
        System.out.println(user);
        Map<String,Object> result = new HashMap<>();
        result.put("result",1);//{result:1}
        return result;
    }
```



## 7. Restful风格(Rest风格)

新增用户

/api/user/add

/api/user/update

/api/user/get/1

/api/user/delete/1





```java
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
```

