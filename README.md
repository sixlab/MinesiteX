
# 提醒自己

- 不要重复造轮子
- 做自己擅长的，或者有可能学以致用的
- 尽量不尝试过于小众的解决方案
- **想好再做，不要像以前和这次，半途而废或改来改去，浪费时间**

由于`GitHub`国内访问不畅，所以两个 Git 仓库作同步：

码云：[https://gitee.com/PatrickRoot/MinesiteX][gitee-minesitex]

GitHub：[https://github.com/PatrickRoot/MinesiteX][github-minesitex]

# MinesiteX

基于 Spring Cloud 微服务框架开发的插件式网站，也可抛弃 Spring Cloud 单独以 Spring Boot 来启动服务器。

使用 Spring Cloud 是为了提升自己的技术能力，但是鉴于自己服务器太渣，所以还要能够单独以 Spring Boot 来启动服务器.

之前考虑做两个版本，一个微服务提升技能，一个精简 Spring Boot 版来运行在服务器中，后来研究后发现可以兼容，就放弃了。

之前准备搞的精简 Spring Boot 版，代码已删，差点半途而废搞个 Koa 框架版本，后来发现虽然 Java 版框架不好搭建，但是搭建好之后，还是 Java 用的方便。

精简 Spring Boot 版地址： [Minesite·Github][github-minesite]、[Minesite·Gitee码云][gitee-minesite] 

### MinesiteX 模块

  各模块如下：

- MinesiteX 是 parent 模块，管理所有的依赖版本和所有模块
- msx-api 下是微服务模块间调用的接口（兼容单服务器版内部调用）：
    - msx-api-XXX 是接口，XXX 模块的接口通过这个模块向外部暴露，由其他模块调用，`msx-plugin-XXX`模块的 service 需要实现此模块的接口。
    - msx-api-XXX-feign 是提供给微服务模块使用的，继承了`msx-api-XXX`模块，配置了 feign。微服务模块需要调用 XXX 微服务，需要依赖此模块，但是使用`msx-api-XXX`的接口来调用。
- msx-beans 下是实体类
- msx-data 下是数据访问库，操作关系数据库、非关系数据库等。
- msx-libs 下是一些公用模块：
    - msx-lib-base 是基本库，含一些基本的 Model 和 util 类，依赖了`spring-boot-starter-web`模块。
    - msx-lib-redis 是操作 Redis 的库，需要操作 Redis 的模块要依赖这个模块，依赖`msx-lib-base`模块和`spring-boot-starter-data-redis`。
- msx-plugins 下是微服务模块的具体实现：
    - msx-base-gateway 是 msx-web-zuul 路由模块的实现，主要包含了使用 JWT 进行登录校验的功能。
    - Msx-plugin-XXX 是 msx-service-XXX 微服务实现，需要暴露接口的，需要实现`msx-api-XXX`接口。
- msx-server 下是需要启动服务器的模块：
    - msx-base-config 是 Spring Cloud Config 配置中心，微服务方式启动需要第一个启动，单服务器方式不需要启动
    - msx-base-eureka 是 Spring Cloud Eureka Server 注册中心，微服务方式启动需要第二个启动，单服务器方式不需要启动
    - msx-service-XXX 是 eureka client，微服务方式启动需要在注册中心启动后，路由模块启动前启动，互相之间无顺序，单服务器方式不需要启动
    - msx-web-zuul 是包含 Zuul 的 eureka client，主要包含 Zuul 路由和登录校验，所有微服务模块启动完后最后启动，单服务器方式不需要启动
    - msx-web-aio 是单服务器方式启动的服务器，不含有 Spring Cloud 的功能，使用 Spring Boot 启动。



### 微服务版架构

单服务器版本不需要架构图啦。

![拓扑图](doc/server.png?raw=true)

# 技术栈

- Spring Cloud Eureka
- Spring Cloud Config
- Spring Cloud Zuul
- Spring Cloud Feign
- Spring Cloud Ribbon
- Spring Boot Security
- JWT
- Spring Data JPA
- MySQL
- Spring Data Redis
- Redis
- Thymeleaf
- ~~Spring Data MongoDb~~服务器性能撑不住了，先不用了
- ~~MongoDB~~服务器性能撑不住了，先不用了

# 版本规划

- [x] V0.1.0 完成基本框架的搭建
- [x] V0.2.0 完成微信、电影、电视剧功能的转移
- [ ] V0.3.0 完成登录、注册及其页面
- [ ] 待定


[github-minesitex]: https://github.com/PatrickRoot/MinesiteX
[gitee-minesitex]: https://gitee.com/PatrickRoot/MinesiteX

[github-minesite]: https://github.com/PatrickRoot/Minesite
[gitee-minesite]: https://gitee.com/PatrickRoot/Minesite

