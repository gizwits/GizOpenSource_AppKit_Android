package com.gizwits.openSource.SettingsModule;

import com.gizwits.openSource.appkit.R;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class GosSettiingsActivity extends Activity implements OnClickListener {

	/** The ll About */
	private LinearLayout llAbout;

	/** The Intent */
	Intent intent;

	/** The ActionBar */
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gos_settings);
		// 设置ActionBar
		setActionBar(true, true, R.string.site);

		initView();
		initEvent();
	}

	private void initView() {
		llAbout = (LinearLayout) findViewById(R.id.llAbout);
	}

	private void initEvent() {
		llAbout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.llAbout:
			intent = new Intent(GosSettiingsActivity.this, GosAboutActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

	/**
	 * 设置ActionBar（工具方法*开发用*）
	 * 
	 * @param HBE
	 * @param DSHE
	 * @param Title
	 */
	protected void setActionBar(Boolean HBE, Boolean DSHE, int Title) {

		actionBar = getActionBar();// 初始化ActionBar
		actionBar.setHomeButtonEnabled(HBE);
		actionBar.setIcon(R.drawable.back_bt);
		actionBar.setTitle(Title);
		actionBar.setDisplayShowHomeEnabled(DSHE);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
