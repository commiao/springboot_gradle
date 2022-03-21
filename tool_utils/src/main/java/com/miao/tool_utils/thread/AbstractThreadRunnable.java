package com.miao.tool_utils.thread;

/**
 * CreateDate:2016年11月14日上午9:45:39
 *
 * @version V1.0
 * @Description: 线程任务基类
 * @author:hehch
 */
public abstract class AbstractThreadRunnable implements Runnable {

	private long overTime;

	private long threadTimeOut = 30000;

	public AbstractThreadRunnable() {
		this.overTime = threadTimeOut + System.currentTimeMillis();
	}

	@Override
	public void run() {
		if (this.overTime < System.currentTimeMillis()) {

		}
		internalRun();
	}

	public abstract void internalRun();
}
