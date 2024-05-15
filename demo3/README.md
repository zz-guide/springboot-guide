# springboot security
- [security 官网](https://docs.spring.io/spring-security/reference/servlet/configuration/java.html)

## 关于用户名和密码
默认用户名
- user
- 初始密码在控制台

也可以配置文件写死

## 动态链接
如果部署路径不是根路径，动态链接会自行变化，静态的不行

## security默认做了什么
- 保护应用程序，要求进行身份验证
- 程序启动默认生成一个用户: user,密码随机生成在控制台
- 生成默认的登录表单和注销页面，并实现具体逻辑
- 处理跨站请求csrf
- 处理回话劫持攻击

## 底层原理
- Client
- FilterChain
- DelegatingFilterProxy, SecurityFilterChain,SecurityFilter
- BeanFilter
- Filter
- Servlet

- DefaultSecurityFilterChain
- SecurityProperties

## 基于内存的用户认证
## 基于数据库的用户认证（模拟）
查看InMemoryUserDetailsManager源码，把对应实现换成从数据库读取写入即可