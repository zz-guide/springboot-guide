# 配置文件
- [x] 多环境配置文件
- [x] properties配置文件读取
- [x] yaml 配置文件读取
- [x] 自定义和默认application文件读取
- [x] 拦截器
- [x] 静态文件服务
- [x] 跨域

# Redis
- [x] 整合了redis,学会了简单使用StringRedisTemplate

# 日志
框架默认使用slf4j+logback

# 数据校验
- [x] get,post等参数接收并校验

# 待解决
- [] Autowired 不推荐属性注入，建议使用构造注入或者@Resource替代
- [] validation fast fail
- [] 日期时间类型字段如何对应
- [] 创建时间默认填充
- [] get请求参数实体类接收，如何设置别名
- [] 懒加载情况下关联查询结果集不能直接当做结果从接口返回，序列化错误; 
- [] mapstruct plus 使用，转换对象
- [] 动态查询字段