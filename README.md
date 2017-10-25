
# 提醒自己

- 不要重复造轮子
- 做自己擅长的，或者有可能学以致用的
- 尽量不尝试过于小众的解决方案
- 想好再做，不要像以前和这次，半途而废或改来改去，浪费时间

由于`GitHub`国内访问不畅，所以两个 Git 仓库作同步：

码云：[https://gitee.com/PatrickRoot/MinesiteX][gitee-minesitex]

GitHub：[https://github.com/PatrickRoot/MinesiteX][github-minesitex]

# MinesiteX

基于 Spring Cloud 微服务框架开发的插件式网站。

精简 Spring Boot 版也在开发中地址： [Minesite·Github][github-minesite]、[Minesite·Gitee码云][gitee-minesite] 

### MinesiteX 需求

开发这个项目的主要目的是为了满足自己的以下几个需求：

- 个人网站，暂不考虑集群（应该是可扩充的，MinesiteX 稳定之后，会考虑集群的可能性）
- 个人网站，不需要复杂的用户管理，简单管理即可（应该是可扩充的，MinesiteX 稳定之后，会考虑复杂的用户管理）
- 页面管理，可以添加、修改、删除页面
- 方便添加一些额外的新功能，不影响原有系统及功能的使用
 
### MinesiteX 模块

  各模块如下：

- MinesiteX 是 parent 模块，管理依赖和所有模块
- msx-libs 下是一些公用模块：
    - msx-lib-base 是基本模块，含一些基本的 Model 和 util 类，一般 eureka client 都需要依赖这个模块
- msx-entity 下是实体类
- msx-base-config 是 Spring Cloud Config 配置中心，需要第一个启动
- msx-base-eureka 是 Spring Cloud Eureka Server 注册中心，需要第二个启动
- Eureka client 微服务模块，在 Eureka Server 后，Zuul 前启动：
    - msx-data 下实现不同的数据操作，不含业务
    - msx-plugins 下实现不同的业务，作为插件
- msx-base-zuul 是包含 Zuul 的 eureka client，主要包含 Zuul 路由和登录校验，所有微服务模块启动完后最后启动

![拓扑图](/doc/server.png?raw=true)

### MinesiteX 原则

- 为方便部署，msx-base-config 暂时使用本地配置文件
- 每个 Plugin 自行处理数据
- 一个 微服务 可能需要调用其他 微服务 的服务
- msx-plugin-XXX-ui 主要是负责返回页面的，msx-plugin-XXX 主要提供 RESTful接口

# 技术栈

- Spring Cloud Eureka
- Spring Cloud Config
- Spring Cloud Zuul
- Spring Cloud Feign
- Spring Cloud Ribbon
- Spring Boot Security
- Spring Data MongoDb
- Spring Data JPA
- Thymeleaf
- MongoDB
- MySQL
- Redis

# 版本规划

- [X] V0.1.0 完成基本的初始化
- [ ] V0.2.0 完成登录功能及其页面
- [ ] V0.3.0 完成页面的管理
- [ ] V1.0.0 基本功能完成


[github-minesitex]: https://github.com/PatrickRoot/MinesiteX
[gitee-minesitex]: https://gitee.com/PatrickRoot/MinesiteX

[github-minesite]: https://github.com/PatrickRoot/Minesite
[gitee-minesite]: https://gitee.com/PatrickRoot/Minesite