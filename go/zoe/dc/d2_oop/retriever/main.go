package main

import (
	mock "./mock"
	real "./real"
	"fmt"
	"time"
)

/**
@author: Zoé
@date: 2020/3/4  下午6:45
@describe: TODO
*/
func main() {
	transfer()
}

const url  = "http://www.imooc.com"

type Retriever interface {
	Get (s string) string
}

func download(r Retriever,str string) string {
	return r.Get(str)
}

type Poster interface {
	Post (url string ,form map[string]string) string
}

func post(poster Poster)  {
	poster.Post(url,
		map[string]string{
			"name":"zoe",
			"course":"go language",
		})
}

type RetrieverPoster interface {
	Retriever
	Poster
}

func Session(rp RetrieverPoster) string {
	rp.Post(url, map[string]string{
		"contents" : "another faked imooc.com",
	})

	return rp.Get(url)
}


func inerfaceDemo()  {
	var r Retriever

	r = &mock.HHRetriever{"哈哈哈"}
	inspect(r)

	// r = mock.HHRetriever{"mock 的HHRetriever 初始值"}

	rr := real.RRetrivever{
		UserAgent: "Mozilla/5.0",
		TimeOut: time.Minute,
	}
	rr.Str1 = "00"

	r = &rr
	// s := download(r, "http://www.im" +
	// 	"ooc.com")

	inspect(r)
	// fmt.Println(s)
	// fmt.Println(download(r,"使用者 r.Get "))

	// . type assertion
	if rRetrivever, ok := r.(*real.RRetrivever);ok{
		fmt.Printf("rRetriever: %T %v\n",rRetrivever,rRetrivever)
	}
}

func interfaceDemo2() {
	r := &mock.HHRetriever{"哈哈哈 mock a fake imooc.com"}
	fmt.Println(Session(r))
}

func inspect(r Retriever) {
	fmt.Printf("%T %v\n",r,r)
	switch v := r.(type) {
	case *mock.HHRetriever:
		fmt.Println(" 值： ", v.Contents)
	case *real.RRetrivever:
		fmt.Println(" 值： ", v.UserAgent)

	}
}

func transfer() {
	interfaceDemo2()
	fmt.Println("end")
}
