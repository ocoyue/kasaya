[TOC]
# Docker

### Docker基础
- https://www.runoob.com/docker/docker-run-command.html

#### Docker 生命周期管理
##### run   
`docker run [OPTIONS] IMAGE [COMMAND] [ARG...]`     
-d 后台运行，并返回容器ID；    
-i 交互式运行   
-P 随机端口映射     
-p 指定端口映射，格式为 `宿主机端口:容器端口`   
--name="hahaha": 为容器指定名称；   
--dns 8.8.8.8 指定容器使用DNS服务器
```
docker run --name haha -d nginx:latest
```
##### start/stop/restart
##### kill   
杀掉一个运行中的容器。 
-s :向容器发送一个信号  
`docker kill -s KILL mynginx`
##### rm 
删除容器
```
# 强制删除容器db01、db02
docker rm -f db01 db02
# 移除容器nginx01对容器db01的连接，连接名db
docker rm -l db 
#删除容器nginx01,并删除容器挂载的数据卷
docker rm -v nginx01
```
##### pause/unpause
```
# 暂停数据库容器db01提供服务。
docker pause db01
# 恢复数据库容器db01提供服务。
docker unpause db01
```
##### exec      
```
# 在容器 mynginx 中以交互模式执行容器内 /root/runoob.sh 脚本:
runoob@runoob:~$ docker exec -it 容器名 /bin/sh /root/runoob.sh
http://www.runoob.com/
#在容器 mynginx 中开启一个交互模式的终端:
runoob@runoob:~$ docker exec -i -t  mynginx /bin/bash
root@b1a0703e41e7:/#
```

#### Docker 容器操作

##### ps

`docker ps [OPTIONS]`   

-a :显示所有的容器，包括未运行的。
-f :根据条件过滤显示的内容。
--format :指定返回值的模板文件。
-l :显示最近创建的容器。
-n :列出最近创建的n个容器。
--no-trunc :不截断输出。
-q :静默模式，只显示容器编号。
-s :显示总的文件大小。

```
# 列出所有在运行的容器信息。
runoob@runoob:~$ docker ps
# 列出最近创建的5个容器信息。
runoob@runoob:~$ docker ps -n 5
# 列出所有创建的容器ID。
runoob@runoob:~$ docker ps -a -q
```
##### logs
查看容器mynginx从2016年7月1日后的最新10条日志。     
`docker logs --since="2016-07-01" --tail=10 mynginx`

##### 其他
- top
- attach
- events
- wait
- export
- port

#### 镜像仓库
##### pull
##### search
从Docker Hub查找所有镜像名包含java，并且收藏数大于10的镜像    
`docker search -s 10 java`
##### 其他
- push
- login/logout

#### 镜像管理
##### images
-a :列出本地所有的镜像（含中间映像层，默认情况下，过滤掉中间映像层）；    
--digests :显示镜像的摘要信息； 
-f :显示满足条件的镜像；    
--format :指定返回值的模板文件；    
--no-trunc :显示完整的镜像信息；    
-q :只显示镜像ID。  
`docker images -q  ubuntu`

##### rmi 
- -f 强制   
`docker rmi -f runoob/ubuntu:v4`

##### 其他
- build     
    此打包要注意`.`是上下文，不是当前目录
- history
- save
- load
- import

#### docker info/versoin
#### rootfs


### Dockerfile
- 参见https://github.com/docker-library
- 实例 https://github.com/docker-library/tomcat/blob/master/7/jdk8/openjdk/Dockerfile

### DockerCompose
- 子网掩码026




### 经验
- 一条命令实现停用并删除容器：    
`docker stop $(docker ps -q) & docker rm $(docker ps -aq)`
- 其他
```
s
docker images 查询镜像；    
docker system df 体积      
虚悬镜像；      
中间层镜像；    
docker rmi aaa;
docker ps查询 正在运行的容器    
守护态运行
docker run -p 8080:8080 -d tomcat   
-d 守护态运行   
-p 宿主机端口:容器端口      
docker stop     
docker run -p 8080:8080 --name tomcat7 -d tomcat    
docker exec -it id/name /bin/bash
docker container prune 停止所有
htts://k7da99jp.mirror.aliyuncs.com
```



 
 
 
 
 