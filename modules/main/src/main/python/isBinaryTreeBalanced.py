#!/usr/local/bin/python

import sys

usage = """        Find square root of a give number

        Usage: findSquareRoot.py <number>
        Example: findSquareRoot.py 16"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        # error checking
        if root is None:
            return True

        # calculate max height of left and right subtrees
        leftHeight = self.getHeight(root.left, 1)
        rightHeight = self.getHeight(root.right, 1)

        if abs(leftHeight - rightHeight) <= 1:
            return self.isBalanced(root.left) and self.isBalanced(root.right)

        return False

    def getHeight(self, root: TreeNode, height: int) -> int:
        if root is None:
            return height

        return max(self.getHeight(root.left, height + 1), self.getHeight(root.right, height + 1))


def main(argv):
    """
    Executes the main() flow
    @param argv: Command-line arguments
    @type argv: array of strings
    """
    if (len(argv) != 1):
        print usage
        sys.exit(2)
    num = float(argv[0])
    print 'Input number: ', num
    squareRoot = getSquareRoot(num)
    print 'Square root: ', squareRoot


if __name__ == "__main__":
    main(sys.argv[1:])