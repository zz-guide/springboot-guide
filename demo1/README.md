# 配置文件
- [x] 多环境配置文件
- properties配置文件读取
- yaml 配置文件读取
- 自定义和默认application文件读取

# Mybatis
- [x] 简单的curd
- [x] 声明式事务-注解
- [x] 编程式事务-手动写


# MybatisPlus [不推荐]

# Redis
- [x] 整合了redis,学会了简单使用StringRedisTemplate

# 日志
框架默认使用slf4j+logback

# 数据校验
- get,post等参数接收并校验

# 待解决
- [] Autowired 不推荐属性注入，需要替换
- [] validation fast fail
- [] 日期时间类型字段如何对应
- [] 创建时间默认填充

## 注意的点
- @Autowired 建议替换成构造函数注入方式，或者使用@Resource