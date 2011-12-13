package com.habzy.jumping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThirdTabActivity extends Activity implements OnClickListener {

	private Button openAnotherButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third);

		openAnotherButton = (Button) findViewById(R.id.openanother);
		openAnotherButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.openanother: {
			Intent intent = new Intent(this, AnotherTaskActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			break;
		}
		default:
			break;
		}
	}
}
