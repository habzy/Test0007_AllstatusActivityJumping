package com.habzy.jumping;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AllstatusActivityJumpingActivity extends TabActivity {
	private static final String TAG = "AllstatusActivityJumpingActivity";
	private static final int STATUSBAR_SIP_ID = 5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		notifyStatusbar(this, "AllstatusActivityJumpingActivity",
				"Here is AllstatusActivityJumpingActivity",
				R.drawable.ic_launcher);

		Intent firstIntent = new Intent(this, FirstTabActivity.class);
		Intent secondIntent = new Intent(this, SecondTabActivity.class);
		Intent thirdIntent = new Intent(this, ThirdTabActivity.class);

		addSubTab("First", R.drawable.tab_dialer, firstIntent);
		addSubTab("Second", R.drawable.tab_history, secondIntent);
		addSubTab("Third", R.drawable.tab_settings, thirdIntent);

	}

	@Override
	protected void onPause() {
		Log.d(TAG, "onPause()");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "onStop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy()");
		((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE))
				.cancel(STATUSBAR_SIP_ID);
		super.onDestroy();
	}

	/**
	 * 
	 * @param labelId
	 *            The table title's string id.
	 * @param icon
	 *            The icon for table's title.
	 * @param intent
	 *            The intent for start this table.
	 */
	private void addSubTab(String label, int icon, Intent intent) {
		TabHost tabHost = getTabHost();
		Log.d(TAG, "add subtab: " + label);

		TabSpec tabspec = tabHost.newTabSpec(label).setContent(intent);
		tabspec.setIndicator(label, getResources().getDrawable(icon));
		tabHost.addTab(tabspec);
	}

	/**
	 * 
	 * @param context
	 * @param contentTitle
	 * @param iconId
	 *            The icon for update the status bar icon.
	 */
	private static void notifyStatusbar(Context context,
			CharSequence contentTitle, CharSequence contentText, int iconId) {
		Log.d(TAG, "notifyStatusbar:" + contentTitle);

		long when = System.currentTimeMillis();
		CharSequence tickerText = context.getResources().getString(
				R.string.app_name);
		Notification notification = new Notification(iconId, tickerText, when);

		Intent intent = new Intent();
		{
			intent.setAction(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_LAUNCHER);
			intent.setClass(context, AllstatusActivityJumpingActivity.class);
		}

		notification.setLatestEventInfo(context, contentTitle, contentText,
				PendingIntent.getActivity(context, 0, intent, 0));

		((NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE)).notify(
				STATUSBAR_SIP_ID, notification);
	}

}