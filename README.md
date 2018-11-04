#bbs=====================================
spring boot , sc 学习


#host配置==================================

127.0.0.1 eureka9001.com

127.0.0.1 eureka9002.com





#模块端口分配===============================

bbs-eureka-server:9001          #eureka集群

bbs-eureka-server-second:9002   #eureka集群

bbs-admin:8888                  #后台管理

bbs-forum:9011                  #版块

bbs-user:9021                   #系统用户
    
bbs-log:9031                    #系统日志

bbs-notice:9041                 #系统公告

bbs-post:9051                   #帖子

bbs-reply:9061                  #帖子回复

bbs-web:9071                    #前端

bbs-sso:9081                    #单点登录

bbs-gateway:9091                #系统网关

