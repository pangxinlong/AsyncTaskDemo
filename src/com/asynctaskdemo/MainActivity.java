package com.asynctaskdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView textciew;
	private ProgressBar progressbar;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				ProgressBarAsyncTask ProgressBarAsyncTask = new ProgressBarAsyncTask(
						textciew, progressbar);
				// execute参数将传给doInBackgroundInteger... params)
				ProgressBarAsyncTask.execute(1000);
			}
		});

	};

	protected void init() {
		textciew = (TextView) findViewById(R.id.textciew);
		progressbar = (ProgressBar) findViewById(R.id.progressBar);
		button = (Button) findViewById(R.id.button);
	}
}
