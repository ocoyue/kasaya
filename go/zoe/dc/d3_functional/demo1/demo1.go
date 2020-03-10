/**
@author: Zoé
@date: 2020/3/10  下午8:26
@describe: TODO
*/
package main

import (
	"fmt"
)

func main() {
	transfer()
}
func adder() func(v int)int {
	sum := 0
	return func(v int) int {
		sum += v
		return sum
	}
}


func demo1()  {
	// add := adder()
	// for i := 0; i<10; i++  {
	// 	fmt.Println(add(i))
	// }

	add2 := adder2(0)
	for i := 0; i < 10; i++ {
		// fmt.Printf("%T ",add2)
		var sum int
		sum, add2 = add2(i)
		fmt.Println(i, sum)
	}

}

type iAdder func(int) (int,iAdder) 	//返回加完的值，和下一个函数

func adder2(basic int) iAdder  {
	return func(v int) (int, iAdder) {
		return basic+v,adder2(basic+v)
	}
}

func transfer() {
	demo1()
}
