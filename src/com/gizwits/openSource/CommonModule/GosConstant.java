package com.gizwits.openSource.CommonModule;

import java.util.List;

public class GosConstant {

	// 在机智云开发者账号下申请的App_ID
	public static final String App_ID = "your_gizwits_app_id";

	// 在机智云开发者账号下申请的App_Screct(必须与上述App_ID对应)
	public static final String App_Screct = "your_gizwits_app_secret";

	// 在机智云开发者账号下创建的产品ProductKey
	public static final String device_ProductKey = "your_device_product_key";

	// Gokit设备热点默认前缀
	public static final String SoftAP_Start = "XPG-GAgent";

	// Gokit设备热点默认密码
	public static final String SoftAP_PSW = "123456789";

	// 存储器默认名称
	public static final String SPF_Name = "set";

	// 在腾讯开发者帐号下申请的用于QQ登录的APP_ID
	public static final String Tencent_APP_ID = "your_tencent_app_id";

	// 在百度开发者帐号下申请的用于百度推送的AppKey
	public static final String BaiDuPush_AppKey = "your_baidu_push_app_key";
	
	// 待过滤的设备ProductKey列表(此变量用于全局访问，开发者不需要修改)
	public static List<String> ProductKeyList = null;
}
