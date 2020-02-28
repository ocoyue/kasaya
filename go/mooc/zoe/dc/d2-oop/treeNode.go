package main

import "fmt"

func main() {
	transfer()
}

// declarat struct 声明/定义 结构体
type treeNode struct {
	value       int
	left, right *treeNode
}

// treeNode 的专属函数
func (x *treeNode) setValue(i int) {
	x.value = i
}

func struct_demo() {

	nodes := []treeNode{
		{value: 3},
		{},
		{6, nil, &treeNode{value: 8}},
	}
	fmt.Println(nodes)

	// 实例化结构体 init struct
	var root treeNode

	root = treeNode{value: 3}
	root.left = &treeNode{}
	root.right = &treeNode{5, nil, nil}
	root.right.left = new(treeNode)
	root.left.right = factoryNode(2)
	root.right.left.setValue(4)

	root.traverseTree()
	fmt.Println(root)

	r := treeNode{value: 0}
	r.left = &treeNode{value: 1}
	r.right = &treeNode{2, nil, nil}

	r.left.left = &treeNode{value: 3}
	r.left.right = &treeNode{value: 4}

	r.right.left = &treeNode{value: 5}
	r.right.right = &treeNode{value: 6}

	r.traverseTree()

}

// 工厂 factory struct
func factoryNode(i int) *treeNode {
	return &treeNode{value: i}
	/* 附：此处返回的是局部变量的地址给函数外界，
	在CPP中是典型常见错误，但是golang中允许这样传递
	*/
}

// 遍历 traverse
func (p *treeNode) traverseTree() {
	if p == nil {
		return
	}

	// 中序遍历，左 -> 中 -> 右
	p.left.traverseTree()
	fmt.Println(p.value)
	p.right.traverseTree()

}

func transfer() {
	struct_demo()
}
