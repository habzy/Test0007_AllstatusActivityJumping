package com.habzy.jumping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondTabActivity extends Activity implements OnClickListener {

	private Button openSubActivityButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);

		openSubActivityButton = (Button) findViewById(R.id.opensubactivity);
		openSubActivityButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.opensubactivity: {
			Intent intent = new Intent(this, NotInTheTabActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			break;
		}
		default:
			break;
		}
	}
}
