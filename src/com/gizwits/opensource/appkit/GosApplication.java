package com.gizwits.opensource.appkit;

import java.util.concurrent.ConcurrentHashMap;
import com.gizwits.gizwifisdk.api.GizWifiSDK;
import com.gizwits.gizwifisdk.enumration.GizEventType;
import com.gizwits.gizwifisdk.enumration.GizLogPrintLevel;
import com.gizwits.gizwifisdk.enumration.GizWifiErrorCode;
import com.gizwits.gizwifisdk.listener.GizWifiSDKListener;
import com.gizwits.opensource.appkit.CommonModule.GosDeploy;
import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

public class GosApplication extends Application {

	public static int flag = 0;

	GosDeploy gosDeploy;

	ConcurrentHashMap<String, Object> cloudServiceMap = new ConcurrentHashMap<String, Object>();

	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {

			// 设置日志打印级别 （默认all且生成文件至SD卡）
			GizWifiSDK.sharedInstance().setLogLevel(GizLogPrintLevel.GizLogPrintAll);

			cloudServiceMap = GosDeploy.setCloudService();

			if (!cloudServiceMap.isEmpty()) {
				// 设置云端服务
				GizWifiSDK.sharedInstance().setCloudService(cloudServiceMap);
			}

		};
	};

	GizWifiSDKListener gizWifiSDKListener = new GizWifiSDKListener() {

		public void didNotifyEvent(com.gizwits.gizwifisdk.enumration.GizEventType eventType, Object eventSource,
				com.gizwits.gizwifisdk.enumration.GizWifiErrorCode eventID, String eventMessage) {
			if (GizEventType.GizEventSDK == eventType && GizWifiErrorCode.GIZ_SDK_START_SUCCESS == eventID) {

			} else {
				Log.e("Apptest", "SDK UN OPEN/n" + eventMessage);
			}
		};

		public void didGetCurrentCloudService(GizWifiErrorCode result,
				java.util.concurrent.ConcurrentHashMap<String, String> cloudServiceInfo) {

			if (GizWifiErrorCode.GIZ_SDK_SUCCESS != result) {
				Log.e("Apptest", "CloudService Error: " + result.toString());
			}
		};
	};

	public void onCreate() {
		super.onCreate();

		// 读取配置文件
		gosDeploy = new GosDeploy(this);
		String AppID = GosDeploy.setAppID();
		String AppSecret = GosDeploy.setAppSecret();

		if (TextUtils.isEmpty(AppID) || AppID.contains("your_app_id") || TextUtils.isEmpty(AppSecret)
				|| AppSecret.contains("your_app_secret")) {
			if (flag == 0) {
			
			}
			flag++;
		} else {

			// 启动SDK
			GizWifiSDK.sharedInstance().startWithAppID(getApplicationContext(), AppID);

			// 设置日志等级和云端服务
			handler.sendEmptyMessageDelayed(0, 3000);

		}
	};

}
