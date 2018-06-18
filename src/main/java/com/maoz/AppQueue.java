package com.maoz;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppQueue implements Runnable{

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private BlockingQueue<Integer> queue;
	
	public AppQueue(BlockingQueue<Integer> queue) {
		this.queue = queue;
		
	}

	
	@Override
	public void run() {
		while (true) {
			
			try {
				if(!queue.isEmpty()) {
					Integer number = queue.take();
					Date date = new Date();
					log.info("taking from {} queue at {}", number,date);
				}
				
				Thread.sleep(500L);
				
			} catch (InterruptedException e) {
				log.info(e.getMessage());
				e.printStackTrace();
			}
			
		}
	}
	
}
