[TOC]
# Linux

## 命令
### 日常命令
常用 mkdir,ls,pwd,cd,      
mkdir -p 递归创建
touch 生成一个空文件    
echo  生成一个有数据的文件，">"覆盖写入，">>"追加写入   
cat 查看; more 翻页查看; head 查看头部; tail 尾部查看;  
cp 拷贝; `cp 1.txt 2.txt`
rm 删除; -r 递归轮巡; -f 不用提醒;  
find 查找文件; `find . -name test.txt`      
grep 查找字段; `cat 1.txt | grep hello`     
ln 软连接; `ln 1.txt 2.txt`     
whereis 定位; `whereis mysql`   
whomai 哈哈，我自己瞎试出来的命令;
### 压缩命令 tar
tar[-cxzjvf]   
tar -c/x -zvf
```
-c 归档(压缩) compress   
-x 解开归档(解压)      
-z/-j 使用gzip/bzip2算法,通常使用-z     
-v 显示过程(View)   
-f 指定归档(压缩)名字   
-tf 查看压缩包(归档文件)内容
```
### 系统管理命令
stat    
who     
hostname    
uname   
top     
ps  
du  
df -h   
free -h     
ifconfig    
ping 心跳检测   
netstat     
clear   

### 账户和组管理
1. 命令
    - useradd 用户名
    - useradd -u (UID号)
    - useradd -p (口令)
    - useradd -g (分组)
    - useradd -s (SHELL)
    - useradd -d (用户目录)

2. 设置root用户密码
`sudo passwd root`

### 文件权限管理 
d      文件类型      d为文件夹-为文件
rwx    用户权限      r读 w写 x执行
r-x    用户所在组的权限    r读 -不可写 x可执行
r-x    其他用户权限

1. 脚本例子
```shell
#!/bin/bash
echo hello ubuntu 
```
无执行权限      
chmod +x test.sh    
2. chmod
change modify   
chmod [who] [+ | - | =] [mode]test.txt
3. chown
change owner
chown [-R] 用户名称 文件或者目录
chown [-R] 用户名称:用户组名称 文件或者目录
4. 数字设定法
0 无 权限    
1 执行 权限  
2 写 权限   
4 读 权限

### 包管理
- 数据源(镜像)
`vi /etc/apt/source.list`

### 部署
#### 安装Java
1. 本地当前目录下haha.heihei文件cp到服务器
`scp haha.heihei root@10.211.55.15:/home/yan007/test007`
2. 解压并放到指定目录
```shell
#解压缩
tar -xzvf jdk**.tar.gz
mkdir -p /usr/local/java
mv jdk /usr/local/java
chown -R root:root /usr/local/java
```
3. 配置环境变量
- 李卫民2.0版P16讲 有待观察 
`vi /etc/environment`
- 我自己的方案  
```
vi .yan007
export JAVA_HOME=这里为java安装目录  
export JRE_HOME=$JAVA_HOME/jre  
export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib  
export PATH=$JAVA_HOME/bin:$PATH 
# 原文链接：https://blog.csdn.net/gao36951/article/details/73321345
vi .bash_profile
source .yan007
# 最后
source .bash_profile
```
#### 安装mysql
```
sudo apt-get install mysql-server
sudo netstat -tap|grep mysql
sudo vim /etc/mysql/debian.cnf
```
略 `systemctl status mysql` 
user     = debian-sys-maint     
password = 7zSfSBnRaSgO2IBb

## Vim
:q 退出
:q! 强制退出
:wq 写入退出
:set number 显示行号
:set nonumber 不显示行号
/  查找字符串
:w file 当前内容保存为某文件

## 目录管理
例子： MySql
my.cnf  -> /etc     
data    -> /var     
command -> /bin

## 服务器 调教
- 虚拟机
只用自己网盘里13.tnt.dmg版本靠谱

#### SSH免密登录服务器
```shell
# scp /root/.ssh/id_rsa.pub root@192.168.1.181:/root/.ssh/authorized_keys
# 笨办法
cd
mkdir .ssh
cd .ssh
touch authorized_keys
# chmod 600 /yan/.ssh/authorized_keys
```
将本地 id_sra.pub 内容粘贴到authorized_keys中   
本地 ssh yan@10.211.55.9

#### 开启允许远程连接
```shell
sudo passwd root
# 设置两次密码
# 切换root
su
vi /etc/ssh/sshd_config
# 命令模式显示行号
set number
# 命令模式找到关键字PermitRootLogin
/PermitRootLogin
# 编辑模式进行编辑
PermitRootLogin yes
# 重启ssh服务
service ssh restart
```
当然，对我来说，只要去root目录下，把SSH免密登录再执行一次就可以了   
或者，cp 这个 authorized_keys到/root/.ssh/

#### oh my zsh(ubuntu)
- 原文
https://dev.to/mskian/install-z-shell-oh-my-zsh-on-ubuntu-1804-lts-4cm4
- 摘抄
    1. 更新
    ```shell
    sudo apt-get update     
    sudo apt upgrade        
    ```
    2. 安装
    ```
    sudo apt install zsh        
    sudo apt-get install powerline fonts-powerline  
    git clone https://github.com/robbyrussell/oh-my-zsh.git ~/.oh-my-zsh
    ```
    3. 配置
    ```
    cp ~/.oh-my-zsh/templates/zshrc.zsh-template ~/.zshrc     
    ZSH_THEME="agnoster" 
    ```
    4. 切换shell
    ```
    chsh -s /bin/zsh 
    ```
    5. 卸载或更新
        - Update & Uninstallation oh-my-zsh Visit    https://github.com/robbyrussell/oh-my-zsh#manual-updates
        ```
        cd .oh-my-zsh
        upgrade_oh_my_zsh
        ```
    6. 高亮 Want Syntax Highlighting? install ZSH Syntax Highlighting for Oh My Zsh
        - Clone the ZSH Syntax Highlighting
        ```
        git clone https://github.com/zsh-users/zsh-syntax-highlighting.git "$HOME/.zsh-syntax-highlighting" --depth 1
        ```
        - Add syntax-highlighting in .zshrc Configuration
        ```
        echo "source $HOME/.zsh-syntax-highlighting/zsh-syntax-highlighting.zsh" >> "$HOME/.zshrc"
        ```
    7. Revert Back to Default Shell
    ```
    chsh -s /bin/bash
    ```

#### mysql
账户 debian-sys-maint
密码 bNsAKe91AGkjiru7

## 经验
查看当前java有多少个已经安装的版本
/usr/libexec/java_home -V

###### MAC 配置java，vim 
https://www.cnblogs.com/zjx2711904647/p/7735556.html

###### 配置zookeeper
https://blog.csdn.net/whereismatrix/article/details/50420099

###### kafka安装和使用
https://blog.csdn.net/yu_meiguang/article/details/77685166

###### zk + kafka
zookeeper-server-start /usr/local/etc/kafka/zookeeper.properties & kafka-server-start /usr/local/etc/kafka/server.properties

