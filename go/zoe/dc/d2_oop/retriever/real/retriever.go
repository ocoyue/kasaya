/**
@author: Zoé
@date: 2020/3/4  下午7:43
@describe: TODO
*/
package real

import (
	"net/http"
	"net/http/httputil"
	"time"
)

type RRetrivever struct {
	UserAgent string
	TimeOut time.Duration
	Str1 string
}

func (r *RRetrivever) Get(url string) string {

	resp, err := http.Get(url)
	if err != nil {
		panic(err)
	}

	result, err := httputil.DumpResponse(resp, true)
	if err != nil {
		panic(err)
	}

	resp.Body.Close()
	return string(result)
}

