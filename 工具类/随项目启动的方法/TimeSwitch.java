package com.sm.service;

import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.sm.model.Package;

@Component
public class TimeSwitch implements ApplicationContextAware, ServletContextAware,
        ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private PackageService packageService;
 
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        System.out.println("1 => StartupListener.setApplicationContext");
        
//        long current = System.currentTimeMillis();// 当前时间毫秒数
//		Calendar calendar = Calendar.getInstance();
//		calendar.add(Calendar.DAY_OF_MONTH, 1);
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		calendar.set(Calendar.MILLISECOND, 0);
//		long tomorrowzero = calendar.getTimeInMillis();
//		long tomorrowzeroSeconds = (tomorrowzero - current);
		
//		System.out.println("当前时间毫秒数："+current);
//		System.out.println("不知道是啥"+tomorrowzero);
//		System.out.println("现在到今晚12点的毫秒数："+tomorrowzeroSeconds);
		
        Timer nTimer = new Timer();
	    nTimer.schedule(new TimerTask() {
	        public void run() {
	        	//查询所有次日置满状态为1的套餐
            	List<Package> packages = packageService.selectPackageByOpen(1);
            	for (Package pack : packages) {
            		//遍历所有套餐。将库存设置为最大库存
					pack.setCurrentStock(pack.getMaxStock());
					//通过套餐对象修改次日至满库存
					packageService.updateByPrimaryKeySelective(pack);
				}
	        }
	    },1000*30,1000*30);
    }
 
    @Override
    public void setServletContext(ServletContext context) {
        System.out.println("2 => StartupListener.setServletContext");
        
    }
 
    @Override
    public void onApplicationEvent(ContextRefreshedEvent evt) {
        System.out.println("4.1 => MyApplicationListener.onApplicationEven");
		    
        if (evt.getApplicationContext().getParent() == null) {
            System.out.println("4.2 => MyApplicationListener.onApplicationEvent");
        }
	 
    }	
}
