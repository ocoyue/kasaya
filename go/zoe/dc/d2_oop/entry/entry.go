package main

/**
@author: Zoé
@date: 2020/2/29  下午8:42
@describe: 执行入口
*/
import (
	// tree "../tree"
	queue "../queue"
	"fmt"
)

func main() {
	Transfer()
}

func queueDemo() {
	var q queue.ZoeQueue = []string{"a", "b", "c", "d"}
	fmt.Println("1. ", q)

	fmt.Println("Is q empty?  ", q.IsEmpty())
	q.PushQueue("Tom")
	fmt.Println("2. ", q)
	q.PushQueue("Jimy")
	q.PopQueue()
	fmt.Println("3. ", q)
}
func Transfer() {
	queueDemo()
}

