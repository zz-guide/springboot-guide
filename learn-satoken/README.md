# 学习sa-token
- [sa-token example](https://sa-token.cc/doc.html#/start/example)

## roadmap
- [x] 登录
- [x] 校验登录信息和状态
- [x] 注销登录，踢人下线
- [x] 权限校验
- [x] 注解校验(需要添加路由拦截器)
- [x] 业务redis与token redis分离
- [x] 自定义token生成规则
- [x] 集成jwt
- [x] 参数签名(随机字符串+时间戳+参数+签名参数)

## 测试
- [登录](http://localhost:8999/learn_satoken/user/login?username=zz123&password=123456)
- [校验登录状态](http://localhost:8999/learn_satoken/user/checkLogin)
- [查询是否登录](http://localhost:8999/learn_satoken/user/isLogin)
- [token info](http://localhost:8999/learn_satoken/user/tokenInfo)
- [注销登录](http://localhost:8999/learn_satoken/user/logout?userId=10001)
- [踢人下线](http://localhost:8999/learn_satoken/user/kikout?userId=10001)
- [测试登录权限](http://localhost:8999/learn_satoken/search/t1)


## 场景
- 同一个账号使用同一个token,有一方退出登录就退出登录
- 同一个账号多个token, 有一方退出登录不影响另一个人
- 同一个账号，同设备
- 同一个账号，不同设备