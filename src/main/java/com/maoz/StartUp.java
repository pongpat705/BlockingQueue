package com.maoz;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class StartUp{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	BlockingQueue<Integer> queue1;
	AppQueue appQue1;
	
	BlockingQueue<Integer> queue2;
	AppQueue appQue2;

	
	@PostConstruct
	public void init() {
		queue1 = new LinkedBlockingQueue<>();
		appQue1 = new AppQueue(queue1);
		
		queue2 = new LinkedBlockingQueue<>();
		appQue2 = new AppQueue(queue2);
		
		log.info("starting queue");
		Thread th1 = new Thread(appQue1);
		th1.start();
		
		Thread th2 = new Thread(appQue2);
		th2.start();
		
	}
	
	public void addQueue(Integer integer) {
		
		log.info("adding {} to queue", integer);
		if(queue1.size() > 50) {
			queue1.add(integer);
		} else {
			queue2.add(integer);
		}
		
		
	}

}
