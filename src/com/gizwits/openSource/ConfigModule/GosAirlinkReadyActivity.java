package com.gizwits.openSource.ConfigModule;

import com.gizwits.openSource.appkit.R;
import com.gizwits.openSource.view.GifView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class GosAirlinkReadyActivity extends GosConfigModuleBaseActivity implements OnClickListener {

	/** The cb Select */
	CheckBox cbSelect;

	/** The tv Select */
	TextView tvSelect;

	/** The ll Next */
	LinearLayout llNext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actvity_gos_airlink_ready);
		// 设置ActionBar
		setActionBar(true, true, R.string.airlink_ready_title);

		initView();
		initEvent();
	}

	private void initView() {
		cbSelect = (CheckBox) findViewById(R.id.cbSelect);
		tvSelect = (TextView) findViewById(R.id.tvSelect);
		llNext = (LinearLayout) findViewById(R.id.llNext);

		/** 加载Gif */
		GifView gif = (GifView) findViewById(R.id.softreset);
		gif.setMovieResource(R.drawable.airlink);

	}

	private void initEvent() {
		llNext.setOnClickListener(this);
		tvSelect.setOnClickListener(this);
		llNext.setClickable(false);
		llNext.setBackgroundResource(R.drawable.button_shape_gray);

		cbSelect.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					llNext.setBackgroundResource(R.drawable.button_shape);
					llNext.setClickable(true);
				} else {
					llNext.setBackgroundResource(R.drawable.button_shape_gray);
					llNext.setClickable(false);
				}

			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.llNext:
			Intent intent = new Intent(this, GosAirlinkConfigCountdownActivity.class);
			startActivity(intent);
			finish();
			break;

		case R.id.tvSelect:
			if (cbSelect.isChecked()) {
				cbSelect.setChecked(false);
			} else {
				cbSelect.setChecked(true);
			}
			break;

		default:
			break;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, GosAirlinkChooseDeviceWorkWiFiActivity.class);
			startActivity(intent);
			overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
			this.finish();
			break;
		}
		return true;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		Intent intent = new Intent(this, GosAirlinkChooseDeviceWorkWiFiActivity.class);
		startActivity(intent);
		overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
		this.finish();
		return true;
	}

}
