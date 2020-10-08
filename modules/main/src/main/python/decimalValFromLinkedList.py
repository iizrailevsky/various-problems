#!/usr/local/bin/python

import sys

usage = """ Find square root of a give number

        Usage: findSquareRoot.py <number>
        Example: findSquareRoot.py 16"""

def main(argv):
    """
    Executes the main() flow
    @param argv: Command-line arguments
    @type argv: array of strings
    """
    l = ListNode(1, ListNode(0, ListNode(1, ListNode(1, ListNode(0)))))
    s = Solution()
    print('Decimal: ', s.getDecimalValue(l))

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Input: Linked list with 1 or 0
# Output: Decimal representation from binary
# Example: [1, 0, 0] would be 4
# Option 1: Go over linked list, create array and add numbers
# to front of array. Then go over array and multiple with power
# of index.
# Time: O(N), Space: O(N)
class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        # error checking
        if head is None:
            return -1

        decimal = 0
        arr = []

        # go over the linked list and insert to front of array
        node = head
        while (node is not None):
            arr.insert(0, node.val)
            node = node.next

        # multiply results
        i = 0
        n = len(arr)
        while i < n:
            if arr[i] == 1:
                decimal += pow(2, i)
            i += 1

        return decimal


if __name__ == "__main__":
    main(sys.argv[1:])