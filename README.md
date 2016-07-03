机智云开源框架App工程
==================

    使用机智云开源APP之前，需要先在机智云开发平台创建您自己的产品和应用。

    开源App需要使用您申请的AppId、AppSecret以及您自己的产品ProductKey才能正常运行。

    具体申请流程请参见：http://docs.gizwits.com/hc/。

    上述信息申请好之后，在代码中请找到"your_app_id"、"your_app_secret"、"your_product_key"字符串做相应的替换。

    使用QQ帐号登录、百度或极光推送功能之前，需要您先到相应网站申请QQ登录的AppID、百度或极光推送的AppKey，在代码中作相应的替换。


GizWifiSDK 版本号

    2.01.01


功能介绍

    本文档为机智云物联网开源基础App套件使用说明，旨在为机智云物联网开发者提供一个快速开发模板，可在此工程基础上进行快速开发或参考相关代码进行开发。

    目录结构说明：

    ▪	Lib：包括 GizWifiSDK 在内的的第三方库目录

    ▪	GizOpenSourceModules：组成模块

        |---- CommonModule // 公共方法类、资源文件 及 自定义 Cell

        |---- ConfigModule // 设备配置模块，包含 AirLink 及 SoftAP

        |---- DeviceModule // 设备模块，包含 设备列表

        |---- ControlModule // 设备控制模块，开发者可在此添加自己的控制功能

        |---- UserModule // 用户模块，包含 用户登录、用户注册、找回密码、QQ登录

        |---- SettingsModule // 设置模块，包含 设置菜单 及其 包含的子菜单项（关于等）

        |---- PushModule // 推送模块，包含 极光 和 百度 推送SDK的集成


GoKit硬件依赖

    需要有调试设备的支持，您可以使用虚拟设备或者实体设备搭建调试环境。

    ▪	虚拟设备
        机智云官网提供GoKit虚拟设备的支持，链接地址：
        http://site.gizwits.com/developer/product/631/virtualdevice

    ▪	实体设备
        GoKit开发板。您可以在机智云官方网站上免费预约申请（限量10000台），申请地址：
        http://gizwits.com/zh-cn/gokit

    GoKit开发板提供MCU开源代码供智能硬件设计者参考，请去此处下载：https://github.com/gizwits/gokit-mcu



问题反馈

您可以给机智云的技术支持人员发送邮件，反馈您在使用过程中遇到的任何问题。
邮箱：janel@gizwits.com
