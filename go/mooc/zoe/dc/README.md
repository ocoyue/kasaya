[TOC]

# 正文
## 大纲

1. 基本语法

   1.1 变量

   1.2 选择，循环

   1.3 指针，数组，容器

2. 面向接口

   2.1 结构体

   2.2 duck typing的概念

   2.3 组合的思想

3. 函数式编程

   3.1 闭包的概念

4. 工程化

   4.1 资源管理、错误处理

   4.2 测试和文档

   4.3 性能调优

5. 并发编程

   5.1 goroutine、channel

   5.2 调度器

6. 项目：
 单体-》并发-》分布式

### 一、 基本语法

#### 1. 变量variable

##### 1.1 变量类型

- 整型：(u)int[8/16/32/64],  uintptr

- bool string

- byte rune(golang中的char)

- 浮点型：float[32/64]

- 复数：complex[64/128]  $ i = \sqrt{-1} $
  
  $\left|3+4i \right| = \sqrt{3^2+4^2} = 5 $
  
  $ i^2 = -1,i^3 = -i,i^4 = 1,... $

##### 1.2 类型转换

只有强制类型转换，没有隐式转换

- 



#### 2. 选择，判断，循环

if, 在判断之前，可以后接变量定义语句

没有while

switch/case，和java相反，每一项会自动break，除非使用fallthrough

#### 3. 指针，数组，容器

##### 3.1 函数function

- 返回值类型 在后面
- 返回多个值
- 函数作为参数传递
- 可选参数列表

##### 3.2 指针 point

- 函数参数传递：

  值传递 & 引用传递

  golang在定义类型的时候，就要考虑要作为指针用还是值用

- *，&

  类型前面*，代表某类型的指针

  变量前面&，代表某变量的地址

##### 3.3 容器

3.3.1 数组

- 定义

  ``` go
  var arr [5]int
  arr := [3]int{1,2,3}
  arr := [...]int{3,4,5}
  var grid [4][5]int
  ```
  
- 传值类型：值类型，和其他不同

- [10]int 和 [20]int 是不同类型

- 调用func f(arr [10]int) 会<u>***拷贝***</u>数组

3.3.2 slice

- slice本身并没有数据，是对底层array的一个view

- 左闭，右开

	```
	arr := [...]int{0,1,2,3,4,5,6,7,8,9}
	slice1 := arr[2:6]
	// s是arr的一个view(视窗)，相当于指针
	slice2 := s1[3:5]
	```
	
	s1显示：2，3，4，5
	
	s2显示：5，6      	// 此处涉及slice的长度与容量，长度之外容量之内暂且称为阴影部分

- array转换slice：``` slice := arrar[:]```

- slice可以向后扩展，不可以向前扩展。
- s[i] 不可以超越len[s]，向后扩展不可以超过底层原生数组cap(s)

![3GXb8A.png](https://s2.ax1x.com/2020/02/24/3GXb8A.png)

![3GzwRJ.png](https://s2.ax1x.com/2020/02/24/3GzwRJ.png)

- 添加元素时如果超越cap，系统会重新分配更大的底层数组

- 由于值传递的关系，必须接收append的返回值

  ```  s = append(s,val) ```

- 注意：底版数组取view的slice，更改slice也会更改底版arr

  ​		   slice使用append扩容之后，更改slice不会影响原底版

``` go
slice := make([]int,长度,容量)
copy(s2,slice) 	// 拷贝值
```
















### 二、 面向接口

### 三、 函数式编程

### 四、 工程化

### 五、 并发编程








# 附录
### 快捷键
##### Typora

显示源码 		cmd  / 
侧边栏 			Shift cmd L 
有序列表 		opt cmd o
无序列表 		opt cmd u
任务列表 		opt cmd x
加粗				 cmd b
倾斜				 cmd i
下划				 cmd u
清除样式		 cmd  \

##### IDEA

###### 快捷键

快速纠正		opt return

自动赋值		variable ：cmd opt V 或.var

###### LiveTemplates

这真的是个好东西。。

：，err，for, forr....





### Markdown 语法

##### LaTex

$\alpha \in A$

$\sqrt{2}$

$[w]$

$\left| 3 \right|$

# 草稿
### 项目结构

- yanlib
  - kasaya
    - go ja cv kg nlp bc note