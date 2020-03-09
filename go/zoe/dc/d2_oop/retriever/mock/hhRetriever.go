package mock

import "fmt"

/**
@author: Zoé
@date: 2020/3/4  下午6:52
@describe: TODO
*/
var Int1 = 0
type HHRetriever struct {
	Contents string
}

func (p *HHRetriever)  Get(s string) string {
	fmt.Println(	fmt.Sprint("假装implement接口"))
	return p.Contents
}

func (p *HHRetriever) Post(url string, form map[string]string) string {
	p.Contents = form["contents"]
	return "ok"
}
