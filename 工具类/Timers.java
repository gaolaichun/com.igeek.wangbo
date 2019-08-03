package com.sm.util;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.sm.service.PackageService;
import com.sm.model.Package;

public class Timers implements ServletContextListener  {
	
	@Autowired
	private static PackageService packageService;
	
	private static final int OPEN = 1;//次日置满开关状态为1的
	
	//当Tomcat启动时会执行contextInitialized（） 
    public void contextInitialized(ServletContextEvent e) 
    { 
        new MyThread().start(); 
    } 
    
//    public void test() {
//    	System.out.println("123123");
//    	//查询所有的开启库存置满的套餐
//      	List<Package> packages = packageService.selectPackageByOpen(OPEN);
//      	System.out.println("packages=="+packages);
//      	//遍历这些套餐。
//      	for (Package pack : packages) {
//      		//把这些套餐的库存设置为最大库存
//			pack.setCurrentStock(pack.getMaxStock());
//			//将置满的库存的套餐对象进行修改更新。
//			packageService.updateByPrimaryKeySelective(pack);
//		}
//    }
}

//定义一个线程，并定于相应的线程函数run（）
class MyThread extends Thread { 
	PackageService packageService = new PackageService();
	
	private static final int OPENS = 1;//次日置满开关状态为1的
	
    public void run() { 
    	Timer nTimer = new Timer();
	      nTimer.schedule(new TimerTask() {
	          public void run() {
//	        	Timers ti = new Timers();
//	        	ti.test();
	        	
	          	//查询所有的开启库存置满的套餐
//	          	List<Package> packages = packageService.selectPackageByOpen(OPENS);
//	          	System.out.println("packages=="+packages);
	          	//遍历这些套餐。
//	          	for (Package pack : packages) {
//	          		//把这些套餐的库存设置为最大库存
//					pack.setCurrentStock(pack.getMaxStock());
//					//将置满的库存的套餐对象进行修改更新。
//					packageService.updateByPrimaryKeySelective(pack);
//				}
	          	System.out.println("====="+new Date());
	          }
	      },1000*10,1000*10);
    } 
} 