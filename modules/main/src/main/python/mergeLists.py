#!/usr/local/bin/python

import sys

usage = """        Find square root of a give number

        Usage: findSquareRoot.py <number>
        Example: findSquareRoot.py 16"""

def main(argv):
    """
    Executes the main() flow
    @param argv: Command-line arguments
    @type argv: array of strings
    """
    a = [1, 5, 10, 13]
    b = [4, 11, 12, 17, 19]
    o = mergeArrays(a, b)
    print 'Output: ', o

def mergeArrays(a, b):
    """
    Merges two sorted arrays
    @param a: Array of ints
    @param b: Array of ints
    @type a: integer
    @type b: integer
    """
    i = 0
    j = 0
    o = []
    aLen = len(a)
    bLen = len(b)

    # go over the array from lower to higher
    while i < aLen and j < bLen:
      if a[i] < b[j]:
        o.append(a[i])
        i += 1
      elif b[j] < a[i]:
        o.append(b[j])
        j += 1
      else:
        # equals a[i] and b[j]
        o.append(a[i])
        i += 1
        j += 1

    # append the rest
    while i < aLen:
      o.append(a[i])
      i += 1

    while j < bLen:
      o.append(b[j])
      j += 1

    return o

if __name__ == "__main__":
    main(sys.argv[1:])