package com.asynctaskdemo;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

/**  
 * 生成该类的对象，并调用execute方法之后  
 * 首先执行的是onProExecute方法  
 * 其次执行doInBackgroup方法  
 */  

public class ProgressBarAsyncTask extends AsyncTask<Integer, Integer, String>{

	private TextView textView;  
    private ProgressBar progressBar;
	
     public ProgressBarAsyncTask(TextView textview,ProgressBar progressBar){
    	 super();
    	 this.textView=textview;
    	 this.progressBar=progressBar;
     }
    
     /**  
      * 这里的Integer参数对应AsyncTask中的第一个参数   
      * 这里的String返回值对应AsyncTask的第三个参数  
      * 该方法并不运行在UI线程当中，主要用于异步操作，所有在该方法中不能对UI当中的空间进行设置和修改  
      * 但是可以调用publishProgress方法触发onProgressUpdate对UI进行操作  
      */  
     
	@Override
	protected String doInBackground(Integer... params) {
		NetOperator netOperator=new NetOperator();
		int i=0;
		for(i=10;i<100;i++){
			netOperator.operator();
			publishProgress(i);
		}
		Log.i("params==============",params+"");
		Log.i("params[0].intValue()===============", params[0].intValue() + "");
		return i+"";
	}
	
	

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		Log.i("result================",result+"");
		textView.setText("异步操作执行结束"+result);
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();
		textView.setText("开始执行异步线程");
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
		int value=values[0];
		Log.i("value================",value+"");
		progressBar.setProgress(value);
	}
	
	

}
