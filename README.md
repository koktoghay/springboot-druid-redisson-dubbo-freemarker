## 基于spring-boot框架的简单整合
### 1.本地创建测试数据库，执行项目中V18_04_13_1__demo.sql脚本创建一个t_user表，并插入测试数据
### 2.启动本地zookeeper和redis服务
### 3.在根目录下执行编译命令：mvn clean install -Dmaven.test.skip=true
### 4.通过mvn spring-boot:run命令，先执行完成service后，再执行frontend
### 5.浏览器输入：[http://localhost:8092/test/jumpToUserListPage?id=1](http://localhost:8092/test/jumpToUserListPage?id=1)进行测试

