package com.carlos.sign.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.carlos.sign.service.ScheduleTask;

@Component
public class ScheduleTaskImpl implements ScheduleTask {

	

	@Scheduled(cron = "")
	public void task1() {
		System.out.println("Hola");
	}
	
	scheduler.schedule(task, new CronTrigger("0 15 9-17 * * MON-FRI"));
}
