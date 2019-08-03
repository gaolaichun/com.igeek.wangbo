package com.sm.util;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTest {
	
	public static void main(String[] args) {
		String msg = "wudidewo";
		String say = "duingomejjjjimo";
		timer1(msg,say);
		System.out.println("wo xian jie shu ma?");
		
	}

	public static void timer1(String msg,String say){
       Timer nTimer = new Timer();
        nTimer.schedule(new TimerTask() {
            public void run() {
	          	
            	System.out.println("msg=="+msg);
            	System.out.println("say==="+say);
            	//过24小时执行
            	//预借的订单是否还是待借阅
            	System.out.println("=======================");
            }
        },1000*30,1000*10);
        
    }
}
