package com.asynctaskdemo;

public class NetOperator {

	//模拟网络环境
	public void operator(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
