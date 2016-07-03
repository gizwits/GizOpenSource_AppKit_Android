package com.gizwits.openSource.SettingsModule;

import com.gizwits.openSource.appkit.R;
import com.gizwits.gizwifisdk.api.GizWifiSDK;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class GosAboutActivity extends Activity {

	/** The tv SDKVersion. */
	TextView tv_SDKVersion;

	/** the tv appCode */
	TextView tv_AppVersion;

	/** The ActionBar */
	ActionBar actionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gos_about);
		// 设置ActionBar
		setActionBar(true, true, R.string.about);

		initView();

	}

	/**
	 * Inits the view.
	 */
	private void initView() {
		tv_SDKVersion = (TextView) findViewById(R.id.versionCode);
		tv_AppVersion = (TextView) findViewById(R.id.appCode);
	}

	@Override
	public void onResume() {
		super.onResume();
		tv_SDKVersion.setText("V" + GizWifiSDK.sharedInstance().getVersion().toString());
		tv_AppVersion.setText(getAppVersionName(this));
	}

	/** 
	 * 返回当前程序版本名 
	 */  
	public static String getAppVersionName(Context context) {  
	    String versionName = "";  
	    try {  
	        // ---get the package info---  
	        PackageManager pm = context.getPackageManager();  
	        PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);  
	        versionName = pi.versionName;
	        if (versionName == null || versionName.length() <= 0) {  
	            return "";  
	        }  
	    } catch (Exception e) {  
	        Log.e("Apptest", "Exception", e);  
	    }  
	    return versionName;  
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
