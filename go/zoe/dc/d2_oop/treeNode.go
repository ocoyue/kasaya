package d2_oop

import "fmt"

// declarat struct 声明/定义 结构体
type TreeNode struct {
	Value       int
	Left, Right *TreeNode
}

// treeNode 的专属函数
func (p *TreeNode) setValue(i int) {
	p.Value = i
}

func structDemo() {

	nodes := []TreeNode{
		{Value: 3},
		{},
		{6, nil, &TreeNode{Value: 8}},
	}
	fmt.Println(nodes)

	// 实例化结构体 init struct
	var root TreeNode

	root = TreeNode{Value: 3}
	root.Left = &TreeNode{}
	root.Right = &TreeNode{5, nil, nil}
	root.Right.Left = new(TreeNode)
	root.Left.Right = factoryNode(2)
	root.Right.Left.setValue(4)

	root.TraverseTree()
	fmt.Println(root)

	r := TreeNode{Value: 0}
	r.Left = &TreeNode{Value: 1}
	r.Right = &TreeNode{2, nil, nil}

	r.Left.Left = &TreeNode{Value: 3}
	r.Left.Right = &TreeNode{Value: 4}

	r.Right.Left = &TreeNode{Value: 5}
	r.Right.Right = &TreeNode{Value: 6}

	r.TraverseTree()

}

// 工厂 factory struct
func factoryNode(i int) *TreeNode {
	return &TreeNode{Value: i}
	/* 附：此处返回的是局部变量的地址给函数外界，
	在CPP中是典型常见错误，但是golang中允许这样传递
	*/
}

// 遍历 traverse
func (p *TreeNode) TraverseTree() {
	if p == nil {

		return
	}

	// 中序遍历，左 -> 中 -> 右
	p.Left.TraverseTree()
	fmt.Println(p.Value)
	p.Left.TraverseTree()

}

func Transfer() {
	structDemo()
}
