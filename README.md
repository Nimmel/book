# Book
个人在线阅读 非商业用途，仅供学习
###技术总结
springboot  
bootstrap  
thymleaf  
elasticsearch  
scrapy  
...

##前端部分  
使用css和js对页面进行排版 数据交互使用ajax

### 登陆
* 登陆：/user/login
* 注册：/user/register
* 登陆方案  
Cookie  存储客户端状态(小于4KB)  
Session 存储服务端状态(消耗服务端资源)  
Server Side Session,cookie存储sessionId 服务端存储session
Client Side Session,session加密处理后由cookie保存  

* 后期拓展  
令牌认证JWT(Json Web Token 无状态、跨域访问、CSRF攻击 https://blog.csdn.net/KKKun_Joe/article/details/81878231)  
授权登陆OAuth2.0 
权限管理springboot-security  





### 首页 
搜索栏：/search  
导航栏：小说分为玄幻、修真、科幻、都市、其他  
我的书架: 暂时未开发  
热门推荐：根据分类显示热度前4的小说，默认首页则根据热点排名  
推荐列表：根据热度排名5-14的小说  
最近更新小说列表  
最近入库小说列表
### 小说目录页【暂无】
封面图片  
简介
作者  
目录列表  
分页  
### 小说章节显示页面【暂无】
本章内容  
分页


### tips
* JPA启动设置  
create：启动时先删后建，退出时不删   
create-drop： 启动时先删后建，退出删除  
update： 表结构与实体类不一致，那么就修改表使它们一致，数据会保留  
validate： 自动检验，如果表结构与实体类不一致，那么不做任何操作，报错  
 



