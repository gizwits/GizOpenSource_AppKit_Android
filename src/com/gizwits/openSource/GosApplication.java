package com.gizwits.openSource;

import com.gizwits.gizwifisdk.api.GizWifiSDK;
import com.gizwits.gizwifisdk.enumration.GizLogPrintLevel;
import com.gizwits.gizwifisdk.enumration.GizPushType;
import com.gizwits.openSource.CommonModule.GosConstant;
import com.gizwits.openSource.PushModule.GosPushManager;
import android.app.Application;

public class GosApplication extends Application {

	GosPushManager gosPushManager;

	public void onCreate() {
		super.onCreate();

		// 启动SDK
		GizWifiSDK.sharedInstance().startWithAppID(getApplicationContext(), GosConstant.App_ID);

		// 设置日志打印级别 （默认all且生成文件至SD卡）
		GizWifiSDK.sharedInstance().setLogLevel(GizLogPrintLevel.GizLogPrintAll);

		// 只能选择支持其中一种
		// gosPushManager=new GosPushManager(GizPushType.GizPushBaiDu,
		// this);//百度推送
		gosPushManager = new GosPushManager(GizPushType.GizPushJiGuang, this);// 极光推送

	};
}
