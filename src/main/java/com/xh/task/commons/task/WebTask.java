package com.xh.task.commons.task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * <p>Title: 定时器</p>
 * <p>Description: </p>
 * 
 * @author H.Yang
 * @QQ 1033542070
 * @date 2018年3月8日
 */
@Component
public class WebTask {

	private final Logger LOGGER = LogManager.getLogger(getClass());

	/**
	 * <p>Title: 上次任务结束后再次执行 </p>
	 * <p>Description: 执行一些需要周期性(有一定的循环规律)执行的代码,每隔指定 秒就会被调用，指定秒的间隔是指从上一次调用的完成之时开始算起。</p>
	 * 
	 * @author H.Yang
	 * @date 2018年3月8日
	 *
	 */
	@Scheduled(fixedDelay = 1000 * 3)
	public void print() {
		// try {
		// TimeUnit.SECONDS.sleep(5);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LOGGER.info(sdf.format(new Date()) + "*********A任务  周期性   每3秒执行一次");
	}

	/**
	 * <p>Title: 固定时间执行一次</p>
	 * <p>Description: 执行一些需要定期执行的代码,每隔 5 秒就会被调用,此时的 5 秒就是从上一次调用之始开始算起了。</p>
	 * 
	 * @author H.Yang
	 * @date 2018年3月8日
	 *
	 */
	@Scheduled(fixedRate = 1000 * 3)
	public void doSomething() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LOGGER.info(sdf.format(new Date()) + "*********B任务  定期  每3秒执行一次");
	}

	/**
	 * <p>Title: 定时更改</p>
	 * <p>Description: </p>
	 * 
	 * @author H.Yang
	 * @date 2018年3月8日
	 *
	 */
	@Scheduled(cron = "0/3 * * * * ? ") // 间隔5秒执行
	public void taskCycle() {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LOGGER.info(sdf.format(new Date()) + "*********C任务  间隔  每3秒执行一次");
	}
}
