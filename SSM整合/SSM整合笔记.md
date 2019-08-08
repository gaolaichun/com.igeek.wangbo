---
typora-root-url: img
---

# SSM整合

### 1. 新建Web项目

### 2. 添加jar包

### 3. 通过逆向工程，生成相对应的实体与映射文件以及接口如下图

![](/逆向工程生成的文件.png)

### 4. 创建配置文件

>spring配置文件

(1) applicationContext-dao.xml	  (dao层配置文件)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!--加载外部属性配置文件-->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>

    <!--数据源-->
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="url" value="${druid.url}"></property>
        <property name="username" value="${druid.username}"></property>
        <property name="password" value="${druid.password}"></property>
        <property name="driverClassName" value="${druid.driverClassName}"></property>
        <property name="initialSize" value="${druid.initialSize}"></property>
        <property name="minIdle" value="${druid.minIdle}"></property>
        <property name="maxActive" value="${druid.maxActive}"></property>
    </bean>

    <!--配置sqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!--配置mybatis配置文件-->
        <property name="configLocation" value="classpath:mybatis/sqlMapConfig.xml"></property>
        <!--配置数据源对象-->
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!--配置mapper的代理对象
        this.sqlSessionFactory.openSession().getMapper(UserMapper.class)
    -->
    <!--单独配置每一个mapper接口(也可以一次性批量配置)-->
    <!--<bean id="userMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
        &lt;!&ndash;配置sqlSessionFactroy对象&ndash;&gt;
        <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
        &lt;!&ndash;配置接口&ndash;&gt;
        <property name="mapperInterface" value="com.igeek.ssm.mapper.UserMapper"></property>
    </bean>-->

    <!--<bean id="itemMapper" class="org.mybatis.spring.mapper.MapperFactoryBean">
        &lt;!&ndash;配置sqlSessionFactroy对象&ndash;&gt;
        <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
        &lt;!&ndash;配置接口&ndash;&gt;
        <property name="mapperInterface" value="com.igeek.ssm.mapper.ItemMapper"></property>
    </bean>-->

    <!--一次性批量配置mapper接口:
    通过mapper扫描器,扫描某个包下的所有mapper接口,批量加载配置
    -->
    <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--设置需要扫描的包-->
        <property name="basePackage" value="com.igeek.ssm.mapper"></property>
        <!--配置sqlSessionFactory对象-->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
    </bean>

</beans>

```

(2)applicationContext-service.xml（service层配置文件）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!--扫描service包，将service包下添加@Service注解的类添加到容器中-->
    <context:component-scan base-package="com.igeek.ssm.service"></context:component-scan>

</beans>
```

(3)applicationContext-tx.xml（事务支持配置文件）

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
        http://www.springframework.org/schema/tx
        http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!--配置事务管理器-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"></property>
    </bean>

    <!--配置通知-->
    <!--以下面name开头的方法需要事务的支持。配置read-only="true"的是不支持事务的-->
    <tx:advice id="tx_advice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="insert*" propagation="REQUIRED" isolation="DEFAULT"/>
            <tx:method name="add*"></tx:method>
            <tx:method name="update*"></tx:method>
            <tx:method name="modify*"></tx:method>
            <tx:method name="delete*"></tx:method>
            <tx:method name="remove*"></tx:method>
            <tx:method name="get*" read-only="true"></tx:method>
            <tx:method name="select*" read-only="true"></tx:method>
            <tx:method name="query*" read-only="true"></tx:method>
        </tx:attributes>
    </tx:advice>

    <!--配置切面-->
    <aop:config>
        <aop:advisor advice-ref="tx_advice" pointcut="execution(* com.igeek.ssm.service.*.*(..))"></aop:advisor>
    </aop:config>

</beans>
```

> springmvc配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--配置扫描controller包下的所有以@Controller注解修饰的类-->
    <context:component-scan base-package="com.igeek.ssm.controller"></context:component-scan>

    <!--配置注解驱动-->
    <mvc:annotation-driven></mvc:annotation-driven>

    <!--配置试图解析器-->
    <bean id="resourceViewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"></property>
        <property name="suffix" value=".jsp"></property>
    </bean>

    <!--配置文件上传解析器-->
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="maxUploadSize" value="10000000"></property>
    </bean>

</beans>
```

> mybatis配置文件 	(正常在mybatis中配置数据源和事务，但是在上面的配置文件中已经有了就不用配置了)

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

</configuration>
```

> web.xml配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

    <!--配置post提交中文乱码的过滤器-->
    <filter>
        <filter-name>characterEncoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncoding</filter-name>
        <url-pattern>*</url-pattern>
    </filter-mapping>

    <!--给监听器指定初始化参数,用于加载spring配置文件-->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <!--classpath:spring/applicationContext-dao.xml,classpath:spring/applicationContext-tx.xml,classpath:spring/applicationContext-servcie.xml-->
        <param-value>classpath:spring/applicationContext-*.xml</param-value>
    </context-param>

    <!--配置监听器 用于加载spring配置文件 (此监听器应该放在前端控制器上面)-->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <!--配置前端控制器-->
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/springmvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    
</web-app>
```

