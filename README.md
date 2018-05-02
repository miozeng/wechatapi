## 关于wechat 公众号java开发说明
### 1.api参考
启动项目前请先配置自己的微信公众号配置到wechat.properties  
启动项目后请访问 http://localhost:8081/swagger-ui.html
可以查看目前已经开发过的wechat公众号api接口，
接口详细说明请参考页面以及微信公众号官网https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432

### 2.wechat开发项目生成方式
2.1 通过swagger的方式生成项目
可以通过调研project-builder-controller  的 /build/createProject 方法生成项目
/``` json
{
  "artifactId": "gzhtest",//项目artifactId
  "groupId": "com.arba",//项目groupId
  "packageName": "com.arba.gzhtest",//项目包路径
  "port": 8081,//项目端口
  "projectName": "gzhtest",//项目名称
  "useAccount": true,//是否引入wechat账号管理模块
  "useAi": true,//是否引入wechat智能接口模块
  "useDataAnalysis": true,//是否引入wechat数据分析模块
  "useJsJdk": true,//是否引入wechatJsJDK模块
  "useMaterial": true,//是否引入wechat素材管理模块
  "useMenu": true,//是否引入wechat菜单管理模块
  "useSendAll": true,//是否引入wechat群发消息模块
  "useUser": true,//是否引入wechat用户管理模块
  "useDb": true,//是否包含数据库链接
  "dbConfig": {
    "dbType": "string",//数据库类型 mysql or  sqlserver
    "password": "string",//登录密码
    "url": "string",//连接地址
    "username": "string"//用户名
  },
  "wechat": {//wechat相关配置
    "aesKey": "xxxx",
    "appId": "xxx",
    "jsurl": "http://s5d4xb.natappfree.cc",//如果引入jsjdk请填写wechat配置的安全域名
    "secret": "xxxxx",
    "token": "miotest"//
  }
}

/```

2.2也可以通过访问com.arba.wechat.gzh.build.util.VelocityUtil 的main方法自动生成项目


### 3.说明
此项目接口并未实现所有wechatapi的接口，如有需要后期会再加
