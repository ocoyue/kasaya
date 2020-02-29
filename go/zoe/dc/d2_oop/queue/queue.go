package queue

import "fmt"

/**
@author: Zoé
@date: 2020/2/29  下午8:42
@describe: 定义别名的方式，对原型进行扩展
*/

type ZoeQueue []string

func (q *ZoeQueue) PushQueue(str string) {
	*q = append(*q, str)
}

func (q *ZoeQueue) PopQueue() string {
	head := (*q)[0]
	*q = (*q)[1:]
	return head
}

func (q *ZoeQueue) IsEmpty() bool {
	return len(*q) == 0
}
func private_fuction() {
	fmt.Println("public方法 调用内部 private 方法")
}
