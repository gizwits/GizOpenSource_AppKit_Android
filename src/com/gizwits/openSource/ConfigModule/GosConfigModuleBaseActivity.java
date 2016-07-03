package com.gizwits.openSource.ConfigModule;

import java.util.Timer;

import com.gizwits.openSource.appkit.R;
import com.gizwits.gizwifisdk.api.GizWifiSDK;
import com.gizwits.gizwifisdk.enumration.GizWifiErrorCode;
import com.gizwits.gizwifisdk.listener.GizWifiSDKListener;
import com.gizwits.openSource.CommonModule.GosBaseActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;

public class GosConfigModuleBaseActivity extends GosBaseActivity {

	private GizWifiSDKListener gizWifiSDKListener = new GizWifiSDKListener() {

		/** 用于Soft_AP配置 */
		public void didSetDeviceOnboarding(GizWifiErrorCode result, String mac, String did, String productKey) {
			GosConfigModuleBaseActivity.this.didSetDeviceOnboarding(result, mac, did, productKey);
		};

	};

	/**
	 * Soft_AP配置回调
	 * 
	 * @param error
	 * @param device
	 */
	protected void didSetDeviceOnboarding(GizWifiErrorCode result, String mac, String did, String productKey) {
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 每次返回activity都要注册一次sdk监听器，保证sdk状态能正确回调
		GizWifiSDK.sharedInstance().setListener(gizWifiSDKListener);
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

	// 退出提示
	protected void quitAlert(Context context) {
		String title, message, nbtext, pbtext;
		title = (String) getText(R.string.prompt);
		message = (String) getText(R.string.cancel_besure);
		nbtext = (String) getText(R.string.no);
		pbtext = (String) getText(R.string.besure);
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setNegativeButton(nbtext, null);
		builder.setPositiveButton(pbtext, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		builder.show();
	}

	// 退出提示
	protected void quitAlert(Context context, final Timer timer) {
		String title, message, nbtext, pbtext;
		title = (String) getText(R.string.prompt);
		message = (String) getText(R.string.cancel_besure);
		nbtext = (String) getText(R.string.no);
		pbtext = (String) getText(R.string.besure);
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setNegativeButton(nbtext, null);
		builder.setPositiveButton(pbtext, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (timer != null) {
					timer.cancel();
				}
				finish();
			}
		});
		builder.show();
	}

}
