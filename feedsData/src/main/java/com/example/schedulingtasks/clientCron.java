package com.example.schedulingtasks;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;




public class clientCron {
	
	long timer;
	
	public clientCron() {
	}
	
	public void sendInfo() {

		try {
			String command = "curl localhost:8080/feed/url -d  url="+java.net.URLEncoder.encode("http://feeds.nos.nl/nosjournaal?format=xml", "UTF-8");
			Process process = Runtime.getRuntime().exec(command);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
		
	
	public void timerInfo() {		
		final ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
		TimeUnit time = TimeUnit.SECONDS;	
		time.convert(timer,TimeUnit.SECONDS);		
        ses.scheduleWithFixedDelay(new Runnable() {
            public void run() {
                System.out.println(new Date());
                sendInfo();
            }
        }, 0, timer, time);	
	}
	
	

}
