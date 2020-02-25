package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"math"
	"os"
)

// 包变量
var (
	globalVariable = -3
)

// 常量
const (
	i = iota
	_
	j
	k
	l = 9
	m
	n
)

func main() {
	transfer()
}

func transfer() {
	sli := []int {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}

	delete_slice(4,sli)
	fmt.Println("函数外sli",sli)


}

// delete 删除 slice
func delete_slice(i int, sli []int)  {
	fmt.Printf("delete 删除第 %d 个元素\n",i)
	sli = append(sli[:i],sli[i+2:]...)
	fmt.Println("函数内删除后slice",sli)

	// return sli
}

// copy 拷贝 slice
func copy_slice() {
	sli := []int {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}
	sli2 := make([]int, 3, 5)
	sli3 := make([]int, 30, 60)
	copy(sli2,sli)
	copy(sli3,sli)
	fmt.Println(sli)
	fmt.Println(sli2)
	fmt.Println(sli3)
}


// slice修改只有对原底版的影响
func slice_test1() {
	arr := [...]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}

	slice := arr[:]
	slice[0] = -99
	fmt.Printf("arr is \n%d \nslice is \n%d \n", arr, slice)

	arr2 := [...]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
	slice2 := arr2[:]
	fmt.Println("slice2 len ",len(slice2))
	fmt.Println("slice2 cap ",cap(slice2))

	slice2 = append(slice2, 41, 51, 61, 71, 81, 91, 101,102, 103,104,105,106)
	slice2[0] = -98
	fmt.Println("do")
	fmt.Printf("arr is \n%d \nslice is \n%d \n", arr2, slice2)

}

func slice_question() {
	arr := [...]int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	s1 := arr[2:6]
	s2 := s1[3:5]
	fmt.Println(s1)
	fmt.Println(s2)
	fmt.Printf("s1 %s,\n s1长度为%d,\n s1容量为%d", s1, len(s1), cap(s1))
}

func slice_test() {
	arr := [...]int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
	s := arr[2:6]
	fmt.Println("arr[2:6] is ", s)
}

func app(cc ...func() int) string {
	result := 0
	for k, v := range cc {
		valueOfv := v()
		fmt.Println(k, valueOfv)
		result += valueOfv
	}
	fmt.Sprintf("最后结果为：%d", result)
	return fmt.Sprintf("最后结果为：%d", result)
}

func hello1() int {
	fmt.Println("hello 666")
	return 666
}
func hello2() int {
	fmt.Println("hello 888")
	return 888
}

// for
func scanner() {
	file, err := os.Open("./go/mooc/zoe/dc/README.md")
	if err != nil {
		fmt.Println(err)
	}
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		fmt.Println(scanner.Text())
	}
	fmt.Println("scanner close")
}

// 强制类型转换
func variableTransfer() {
	a边长 := 3
	b边长 := 4
	斜边 := math.Sqrt(float64(a边长*a边长 + b边长*b边长))
	fmt.Println(斜边)
}

// if
func demoForIf() {
	// 不同的目录下，执行这个go程序，找寻目录是不同的。
	contents, err := ioutil.ReadFile("./go/mooc/zoe/dc/README.md")
	if err != nil {
		fmt.Println(err)
	} else {
		fmt.Printf("%s \n", contents)
	}
}

// 变量
func variable() {
	// 	variable zero value
	var a, b int
	var str string
	fmt.Println("variable zero value")
	fmt.Println(a, b, str)
	fmt.Printf("%d %d %q \n", a, b, str) // %q 可把空字符串带引号打印

	// 	variable initial value
	var c, d int = 3, 4
	var str1 string = "str1"
	fmt.Println("variable initial value")

	fmt.Println(c, d, str1)

	// 	variable type deduction
	var e, f, str2, bool2 = 5, 6, "七", false
	fmt.Println("variable type deduction")
	fmt.Println(e, f, str2, bool2)

	// 	variable shorter
	fmt.Println("variable shorter")
	i7, bool3, str3 := 7, true, "str h"
	fmt.Println(i7, bool3, str3)

	//  global variable  compared with local variable
	globalVariable = 200
	fmt.Println(globalVariable)

}
