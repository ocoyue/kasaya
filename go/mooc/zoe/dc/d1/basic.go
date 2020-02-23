package main

import "fmt"

func main() {
	fmt.Println("hello world")
	variable()
}

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

}
