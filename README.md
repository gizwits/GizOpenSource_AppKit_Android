# 机智云开源框架App工程
==================

    使用机智云开源APP之前，需要先在机智云开发平台创建您自己的产品和应用。

    开源App需要使用您申请的AppId、AppSecret以及您自己的产品ProductKey才能正常运行。

    具体申请流程请参见：http://docs.gizwits.com/hc/。

    开源框架工程可通过修改配置文件配置开发者的个人应用信息，请参考使用说明中的 第5节 配置文件说明 进行替换。

    使用QQ、微信登录或百度或极光推送功能之前，需要您先到相应网站申请对应的应用信息，在配置文件中作相应的替换。


# GizWifiSDK 版本号

    2.04.04

# 功能介绍

    本文档为机智云物联网开源基础App套件使用说明，旨在为机智云物联网开发者提供一个快速开发模板，可在此工程基础上进行快速开发或参考相关代码进行开发。

## 目录结构说明：

    > libs：包括 GizWifiSDK 在内的的第三方库目录

    > assets: 包含 UIConfig.json 配置文件

    > GizOpenSourceModules：组成模块

    >> GosApplication.java // SDK 在此启动

    >> CommonModule // 公共方法类、资源文件读取类 
    
    >> ConfigModule // 设备配置模块，包含 AirLink 及 SoftAP
    
    >> UserModule // 用户模块，包含 用户登录、用户注册、找回密码
    
    >> DeviceModule // 设备模块，包含 设备列表

    >> ControlModule // 控制模块，包含 控制示例
    
    >> SettingsModule // 设置模块，包含 设置菜单 及其 包含的子菜单项（关于等）

    >> PushModule // 推送模块，包含 百度和极光的推送SDK 集成封装

    >> ThirdAccountModule // 第三方登录模块， 包含 第三方登录（QQ、微信等）

    >> view // 自定义控件

    >> utils // 工具类

    >> wxapi // 微信集成包

    >> zxing // 扫描二维码


  
    
***

# 使用说明：

## 1. 默认程序入口

    默认程序入口在 UserModule 中的 GosUserLoginActivity。

## 2. 更改启动后的载入界面

    如果要启动程序直接进入设备列表，可在 AndroidManifest.xml 文件中将 GosUserLoginActivity 的 <intent-filter> 属性调整到 GosDeviceListActivity 中：

						<intent-filter>
							 <action android:name="android.intent.action.MAIN" />

							 <category android:name="android.intent.category.LAUNCHER" />
						</intent-filter>


## 3. 加载控制界面

    代码位于 GosDeviceListActivity 文件中的 handleMessage 方法 case TOCONTROL 中:

						case TOCONTROL:
							intent = new Intent(GosDeviceListActivity.this, GosDeviceControlActivity.class);
							Bundle bundle = new Bundle();
							bundle.putParcelable("GizWifiDevice", (GizWifiDevice) msg.obj);
							intent.putExtras(bundle);
							startActivity(intent);
						break;

    修改 GosDeviceControlActivity 类为开发者自己编写的控制界面的类即可。

## 4. 设置界面

    设置界面位于 SettingsModule 中的 GosSettiingsActivity，在 activity_gos_settings.xml 文件中添加相应布局后，再回到 GosSettiingsActivity 中实现交互事件即可：

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

## 5. 配置文件说明

    配置文件位置：assets/UIConfig.json

    配置文件可对程序样式及机智云appid等进行配置。

    可配置参数有：

	app_id：机智云 app id
	app_secret：机智云 app secret
	product_key：机智云 product key
	wifi_type_select：默认配置模块wifi模组选择功能是否开启
	tencent_app_id：qq登录 app id
	wechat_app_id：微信登录 app id
	wechat_app_secret：微信登录 app secret
	push_type：推送类型 【0：关闭，1：极光，2：百度】
	bpush_app_key：百度推送 app key
	openAPI_URL：openAPI 域名及端口，格式：“api.gizwits.com:80”，不写端口默认80
	site_URL：site 域名及端口，格式：“site.gizwits.com:80”，不写端口默认80
	push_URL：推送绑定服务器 域名及端口，格式：“push.gizwits.com:80”，不写端口默认80
	buttonColor：按钮颜色
	buttonTextColor：按钮文字颜色
	navigationBarColor：导航栏颜色
	navigationBarTextColor：导航栏文字颜色
	configProgressViewColor：配置中界面 progress view 颜色
	addDeviceTitle：添加设备界面 导航栏标题文字
    
              需要注意:
              1.极光推送的appid需要在AndroidManifest.xml 中填写见243行。
              2.微信登录需要进行在腾讯api中设置自己的md5值否者无法正常运行
              3.QQ的appkey需要在AndroidManifest.xml中89行填写
    
    具体细节可以参考【开源框架工程使用文档】：http://docs.gizwits.com/hc/kb/article/186638/

# GoKit硬件依赖

    需要有调试设备的支持，您可以使用虚拟设备或者实体设备搭建调试环境。

    ▪	虚拟设备
        机智云官网提供GoKit虚拟设备的支持，链接地址：
        http://site.gizwits.com/developer/product/631/virtualdevice

    ▪	实体设备
        GoKit开发板。您可以在机智云官方网站上免费预约申请（限量10000台），申请地址：
        http://gizwits.com/zh-cn/gokit

    GoKit开发板提供MCU开源代码供智能硬件设计者参考，请去此处下载：https://github.com/gizwits/gokit-mcu


# 问题反馈

    您可以给机智云的技术支持人员发送邮件，反馈您在使用过程中遇到的任何问题。
    邮箱：club@gizwits.com
    
