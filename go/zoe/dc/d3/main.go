package main

import (
	"fmt"
)

func main() {
	// h.PrintHello()
	f1()

}

func f1() {
	var sli = []string{"a", "b", "c", "d"}
	f2(sli)
	fmt.Println(sli)
	// 附：[]int 原生slice是view,append之后，就变了

}

func f2(sli []string) []string {
	sli = append(sli, "x")
	return sli
}

type Queue struct {
	sli []string
}

func (q Queue) f1(s string) {
	q.sli[3] = s
}

func f3() {
	q := Queue{sli: []string{"a", "b", "c", "d"}}
	fmt.Println(q)
	q.f1("yy")
	fmt.Println(q)

}
