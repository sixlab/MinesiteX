
由于`GitHub`国内访问不畅，所以两个 Git 仓库作同步：

码云：https://gitee.com/PatrickRoot/MinesiteX

GitHub：https://github.com/PatrickRoot/MinesiteX

# MinesiteX
基于 Spring Cloud 微服务框架开发的插件式网站。

精简 Spring Boot 版地址： [Minesite·Github](https://github.com/PatrickRoot/Minesite)、[Minesite·Gitee码云](https://gitee.com/PatrickRoot/Minesite) 


### MinesiteX 需求
开发这个项目的主要目的是为了满足自己的以下几个需求：

- 个人网站，暂不考虑集群（应该是可扩充的，Minesite 稳定之后，会考虑集群的可能性）
- 个人网站，不需要复杂的用户管理，一个账号即可（应该是可扩充的，Minesite 稳定之后，会考虑复杂的用户管理）
- 一个简易的博客，可以发布、更新、查看文章，简单的文章流量统计等
- 页面管理，可以添加、修改、删除页面
- 方便添加一些额外的新功能，不影响原有系统及功能的使用
 
### MinesiteX 模块
  各模块如下：

- MinesiteX 是 parent 模块，管理依赖和所有模块
- msx-lib-XXX 是一些公用模块
    - msx-lib-core 是基本模块，含一些基本的 bean 和 util 类，一般 eureka client 都需要依赖这个模块
- msx-base-config 是 Spring Cloud Config 配置中心，需要第一个启动
- msx-base-eureka 是 Spring Cloud Eureka Server 注册中心，需要第二个启动
- msx-plugin-XXX[-ui] 是 eureka client，作为一个实现自己任务的 Plugin，Eureka Server 启动完成后再启动
- msx-base-zuul 也是 eureka client，主要包含 Zuul 路由和登录校验，所有 Plugin 启动完后最后启动

![拓扑图](/doc/server.png?raw=true)

### MinesiteX 原则

- 为方便部署，msx-base-config 暂时使用本地配置文件
- 每个 Plugin 自行处理数据
- 一个 Plugin 可能需要调用其他 Plugin 的服务
- msx-plugin-XXX-ui 主要是负责返回页面的，msx-plugin-XXX 主要提供 RESTful接口
- 需求比较简单，尽量不用数据库，实在需要用到数据库的，Plugin 内部解决好了

# 技术栈

- Spring Cloud Eureka
- Spring Cloud Config
- Spring Cloud Zuul
- Spring Cloud Feign
- Spring Cloud Ribbon
- ~~Spring Boot Security~~
- ~~Spring Boot Data JPA~~
- ~~MySQL~~
- Thymeleaf
- MongoDB

# 版本规划

- [X] V0.1.0 完成基本的初始化
- [ ] V0.2.0 完成登录功能及其页面
- [ ] V0.3.0 完成博客文章的管理
- [ ] V0.4.0 完成博客页面的管理
- [ ] V0.5.0 完成博客菜单的管理
- [ ] V1.0.0 基本博客功能完成

