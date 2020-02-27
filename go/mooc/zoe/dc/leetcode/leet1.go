package main

import (
	"fmt"
	"reflect"
	"sort"
	"strings"
)

func main() {
	transfer()
}

func transfer() {
	leet_code1()
}

/*
找寻字符串中，不含有重复字符的最大子串
*/
func leet_code1() {

	s := "abcd888dcba"
	typeOfs := reflect.TypeOf(s)
	fmt.Println(typeOfs)
	fmt.Printf("%T \n",s)

	/*	分两步：
		part1. 找出所有不含有重复字符的子串
		part2. 子串len比大小
	*/

	sli := part1(s)
	result := part2(sli)
	fmt.Printf("子串答案：%v", result)

}

func part2(sli []string) []string {

	max_str_sli := []string{}
	sli_len := []int{}
	for _, v := range sli {
		sli_len = append(sli_len, len(v))
	}
	sort.Ints(sli_len)
	max_len := sli_len[len(sli_len)-1]
	// 根据max_len，找出长度为max_len的子串

	for _, v := range sli {
		if max_len == len(v) {
			max_str_sli = append(max_str_sli, v)
		}
	}
	return max_str_sli
}

func part1(s string) []string {

	sli := []string{}

	for len(s) > 1 {
		s_out := ""
		for _, v := range s {
			if strings.ContainsRune(s_out, v) {
				break
			} else {
				s_out = s_out + string(v)
			}
		}

		sli = append(sli, s_out)
		s = s[1:]
		fmt.Println(s_out)
	}
	return sli
}

// 字符串遍历 traverse string ， UTF-8遍历 Unicode遍历
func traverse_str() {
	str := "abcd"
	fmt.Println("for 循环，UTF-8遍历:")
	// Utf-8 遍历
	for i := 0; i < len(str); i++ {
		fmt.Print(str[i], "    ")
		fmt.Println(reflect.TypeOf(str[i]))
		fmt.Printf("%q \n ", str[i])
	}

	fmt.Println("for range 循环，Unicode 遍历:")
	// Unicode 遍历
	for _, value := range str {
		fmt.Print(value, "    ")
		fmt.Println(reflect.TypeOf(value))
		fmt.Println(string(value))
	}
}

// 字符串值传递
func s_1() {
	str := "abcd"
	s_2(str)
	fmt.Println(str)
}

func s_2(s string) {
	s = "wxyz"
	fmt.Printf("s_2 s is : %v \n", s)
}
