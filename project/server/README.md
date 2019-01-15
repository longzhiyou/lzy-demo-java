


### 命名约定
- 数据表名：单数，下划线分隔单词（例如 book_club）
- 模型类名：单数，每个单词的首字母大写（例如 BookClub）
- 控制器:   PhotoController
- 文件命名全部采取首字母大写

## Restful为核心进行设计
- [REST-API-Design-Guide](https://github.com/NationalBankBelgium/REST-API-Design-Guide/wiki/REST-Constraints)
- [使用Spring构建RESTful的Web服务](https://rest-with-spring.gaospot.com)

### 参考
| HTTP 方法| URI| 作用|参数|返回码|返回值|
| ----- |-------------|-----|----|----|---|
|HTTP 方法|/meter|获取指定仪表的读数|如：|200|
|URI|/meter|获取指定仪表的读数|如：|200|
|POST|/meter|获取指定仪表的读数|如：|200|
|POST|/meter|获取指定仪表的读数|如：|200|

### 参考rails routes
| Prefix| Verb| URI Pattern|前端路由|Controller#Action|备注|
| ------------- |-------------|-----|----|----|----|
|articles|GET| /articles(.:format)|articles#index|index|
|articles| POST |/articles(.:format) |articles#create|create|
|new_article|GET|/articles/new(.:format)|articles#new|后端不需要|
|edit_article| GET|/articles/:id/edit(.:format)|articles#edit|后端不需要|
|article|GET  | /articles/:id(.:format)|articles#show|show|
|article|PUT|/articles/:id(.:format)|articles#update|update|
|article|DELETE|/articles/:id(.:format)|articles#destroy|destroy|


### 返回结果
- GET /collection：返回资源对象的列表（数组）
- GET /collection/resource：返回单个资源对象
- POST /collection：返回新生成的资源对象
- PUT /collection/resource：返回完整的资源对象
- PATCH /collection/resource：返回完整的资源对象
- DELETE /collection/resource：返回一个空文档
### 返回状态码
- 200 OK - for plain GET requests.
- 201 Created - for POST and PUT requests that create new resources.
- 204 No Content - for PUT, PATCH, and DELETE requests if the configuration is set to not return response bodies 
    for resource updates (RepositoryRestConfiguration.returnBodyOnUpdate). If the configuration value is set to include responses for PUT, 200 OK will be returned for updates, 201 Created will be returned for resource created through PUT.

### 过滤信息（Filtering）
- ?limit=10：指定返回记录的数量
- ?offset=10：指定返回记录的开始位置。
- ?page=2&per_page=100：指定第几页，以及每页的记录数。
- ?sortby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
- ?photo_type_id=1：指定筛选条件


### 状态码（Status Codes）
- 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
- 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
- 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
- 204 NO CONTENT - [DELETE]：用户删除数据成功。
- 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
- 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
- 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
- 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
- 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
- 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
- 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
- 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。

### ACL
- 用户有几个角色
- 一个角色包含不同的权限
- user:role:permission

### 安全
- [REST Security Insecure direct object references 不安全的直接对象引用](https://github.com/NationalBankBelgium/REST-API-Design-Guide/wiki/REST-Security-Insecure-direct-object-references)

### 工具
- [ASCII文字，SpringBoot自定义启动Banner在线生成工具](http://www.bootschool.net/ascii)
## tcp
### 参考
- [Netty——高级内置解码器、编码器、ByteBuf](http://www.cnblogs.com/lemon-flm/p/7813854.html)

### 日志相关
- [Spring Boot干货系列：（七）默认日志框架配置](http://blog.csdn.net/gebitan505/article/details/70142155?locationNum=1&fps=1)


### [物资管理](http://wiki.mbalib.com/wiki/%E7%89%A9%E8%B5%84%E7%AE%A1%E7%90%86)
- [物资计划制订](http://wiki.mbalib.com/wiki/%E7%89%A9%E8%B5%84%E8%AE%A1%E5%88%92)
- [物资采购]()
- [物资使用]
- [物资储备](http://wiki.mbalib.com/wiki/%E7%89%A9%E8%B5%84%E5%82%A8%E5%A4%87)

## Restful为核心进行设计

### 参考
| HTTP 方法| 路径| 控制器#动作|作用|备注|
| ------------- |-------------|-----|----|----|
|GET|/photos| photos#index|显示所有图片||
|GET| /photos/:id | photos#show |显示指定的图片||
|POST|/photos|photos#create|新建图片||
|PUT | /photos/:id|photos#update|更新指定的图片||
|DELETE| /photos/:id | photos#destroy|删除指定的图片||
|GET|/photos/new|photos#new|显示新建图片的表单|前端作为路由控制时不适用|
|GET|/photos/:id/edit|photos#edit|显示新建图片的表单|前端作为路由控制时不适用|

### 参考rails routes
| Prefix| Verb| URI Pattern|前端路由|Controller#Action|备注|
| ------------- |-------------|-----|----|----|----|
|articles|GET| /articles(.:format)|articles#index|index|
|articles| POST |/articles(.:format) |articles#create|create|
|new_article|GET|/articles/new(.:format)|articles#new|后端不需要|
|edit_article| GET|/articles/:id/edit(.:format)|articles#edit|后端不需要|
|article|GET  | /articles/:id(.:format)|articles#show|show|
|article|PUT|/articles/:id(.:format)|articles#update|update|
|article|DELETE|/articles/:id(.:format)|articles#destroy|destroy|


### 返回结果
- GET /collection：返回资源对象的列表（数组）
- GET /collection/resource：返回单个资源对象
- POST /collection：返回新生成的资源对象
- PUT /collection/resource：返回完整的资源对象
- PATCH /collection/resource：返回完整的资源对象
- DELETE /collection/resource：返回一个空文档

### 过滤信息（Filtering）
- ?limit=10：指定返回记录的数量
- ?offset=10：指定返回记录的开始位置。
- ?page=2&per_page=100：指定第几页，以及每页的记录数。
- ?sortby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
- ?photo_type_id=1：指定筛选条件

### 状态码（Status Codes）
- 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
- 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
- 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
- 204 NO CONTENT - [DELETE]：用户删除数据成功。
- 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
- 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
- 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
- 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
- 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
- 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
- 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
- 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
### 参考API
- [paypal](https://developer.paypal.com/docs/api/)

### 命名约定
- 数据表名：单数，下划线分隔单词（例如 book_club）
- 模型类名：单数，每个单词的首字母大写（例如 BookClub）
- 控制器:   PhotoController
- 文件命名全部采取首字母大写

## DDD
- 控制器接收领域模型
- 领域服务接收领域模型，并分解为实体类
- 由仓库接口相互配置保存对应的实体类。
### 查询
- [mybatis @Select注解中当参数为空则不添加该参数的判断](https://segmentfault.com/q/1010000006875476)
## 数据仓库及相关
- 星型结构
    - 度量值(measure)
    - 度量维度(dimension)
- 雪花型结构
- 参考
    - **非常重要的概念** [商业智能实现的三个层次：数据报表、多维数据分析和数据挖掘](http://www.cnitpm.com/pm/8181.html)
    - [数据仓库之星型结构和雪花型结构](http://blog.csdn.net/ecjtuxuan/article/details/6273983)
    - [多维分析之概念准备篇](http://www.cnblogs.com/jinspire/archive/2011/11/23/2259718.html)
    - [星型数据仓库olap工具kylin介绍](http://blog.csdn.net/ruiyiin/article/details/50688598)

## 数据建模相关
### 思想
- 利用继承
- 通用关系由程序进行控制
### party
- party
    - person(ON DELETE CASCADE)
    - organization(ON DELETE CASCADE)
- role_type
    - party_role_type(ON DELETE CASCADE)

- party_role
    - 角色表,party与role_type的关系表包括(客户,职员,供应商等)(party+ party_role_type)
### product

### 相关技术
- [restangular](https://github.com/mgonto/restangular)
- [spring boot 1.4默认使用 hibernate validator](http://www.cnblogs.com/softidea/p/6043879.html)
- jpa
    - [jpa概述](http://www.cnblogs.com/holbrook/archive/2012/12/30/2839842.html)
    - [Hibernate之jpa实体映射的三种继承关系](http://www.cnblogs.com/shangxiaofei/p/5704321.html)
    - [JPA One-To-One Shared Primary Key Relationship Mapping Example with Spring Boot](https://hellokoding.com/jpa-one-to-one-shared-primary-key-relationship-mapping-example-with-spring-boot-hsql/)
    - [JpaTreeDao](http://members.chello.at/fritz.ritzberger/downloads/jpatreedao/JpaTreeDao.html)
    - [JPA-NestedSet](https://github.com/romanb/JPA-NestedSet)
    - [Baobaba library applying the nested set model](http://baobab.sideralis.org/)
    - [Spring BootとSpring Data JPAで検索アプリケーションを開発してCircleCIでビルドする](http://qiita.com/rubytomato@github/items/7551b02abc34054301c0)
### 参考
1. [RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)
1.  [Rails 路由全解](http://guides.ruby-china.org/routing.html)
### 参考
1. [RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)
1. [Rails 路由全解](http://guides.ruby-china.org/routing.html)
1. [Exception Handling in Spring MVC](http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
1. [postman中 form-data、x-www-form-urlencoded、raw、binary的区别](http://blog.csdn.net/ye1992/article/details/49998511)
1. [ ionic 通过PouchDB ＋ SQLite来实现app的本地存储（Local Storage）](http://www.cnblogs.com/ailen226/p/ionic.html)
1. [LokiJS 是一个内存中的 JavaScript 数据库](http://www.oschina.net/p/lokijs)
1. [cordova-plugin-local-notifications](https://github.com/katzer/cordova-plugin-local-notifications)
1. [新年彩蛋：Spring Boot自定义Banner](http://blog.csdn.net/baochanghong/article/details/54286422)


### 参考文章
1. [paypal](https://developer.paypal.com/docs/api/)
1. [RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)
1. [Rails 路由全解](http://guides.ruby-china.org/routing.html)
1. [RESTful API 设计指南](http://www.ruanyifeng.com/blog/2014/05/restful_api.html)
1. [Rails 路由全解](http://guides.ruby-china.org/routing.html)
1. [Exception Handling in Spring MVC](http://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc)
1. [mybatis @Select注解中如何拼写动态sql](http://blog.csdn.net/qq_32786873/article/details/78297551)

