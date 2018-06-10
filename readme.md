# 描述：

| 分支 | 框架 | 备注 |
| :- | :- | :- |
| 通用 | bootstrap jquery | 实现页面布局前后端交互 |
| master分支 | jsp/servlet mybatis springmvc | 前台/传统jsp渲染为主 |
| manager分支| springmvc mybatis vue.js | 后台管理/前后端分离使用ajax为通信手段 |
| springbootMQ分支 | springboot activemq | 消息中间件实现邮件和短信的发送 |

# 使用：
1. 执行sql脚本在mysql数据库中创建对应的数据库
2. 将对应的src中对应的jdbc.property和applicationContext.xml配置文件的数据库账号密码修改即可
3. 如需使用消息中间件请自行安装activemq在本地，并在applicationContext.xml中修改brokerURL为你指定ip和端口