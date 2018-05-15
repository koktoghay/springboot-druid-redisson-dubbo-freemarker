```笔记说明
基于springboot的框架整合，项目可运行和启动
```
### 1.找到项目中V18_04_13_1__demo.sql，可以直接在本地mysql库中创建数据库并执行该sql
### 2.启动本地zk和redis
### 3.在根目录下执行编译命令：mvn clean install -Dmaven.test.skip=true
### 4.分别在service和frontend目录下执行mvn spring-boot:run(service启动成功后再启动frontend) 
### 5.浏览器输入：http://localhost:8092/test/jumpToUserListPage?id=1进行测试


