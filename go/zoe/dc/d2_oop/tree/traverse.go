package tree

/**
@author: Zoé
@date: 2020/2/29  下午8:42
@describe: TODO
*/
import "fmt"

// 中序遍历  traverse
func (p *TreeNode) TraverseTree() {
	if p == nil {
		return
	}

	// 中序遍历，左 -> 中 -> 右
	p.Left.TraverseTree()
	fmt.Println(p.Value)
	p.Right.TraverseTree()

}

// 后序遍历 post order traverse
func (p *myTreeNode) postOrderTraverse() {

	if p == nil || p.node == nil {
		return
	}

	// 左 右 中
	left := myTreeNode{node: p.node.Left}
	right := myTreeNode{node: p.node.Right}

	left.postOrderTraverse()
	right.postOrderTraverse()
	fmt.Println(p.node.Value)

}
