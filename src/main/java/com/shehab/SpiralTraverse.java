package com.shehab;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


/**
 * 
 *
  Write a function that takes in an n x m two-dimensional array (that can be 
  square-shaped when n == m) and returns a one-dimensional array of all the
  array's elements in spiral order.
  
  Spiral order starts at the top left corner of the two-dimensional array, goes
  to the right, and proceeds in a spiral pattern all the way until every element
  has been visited.
  
  Sample Input
  
  array    = [
			  [1,   2,  3, 4],
			  [12, 13, 14, 5],
			  [11, 16, 15, 6],
			  [10,  9,  8, 7],
	         ]

Sample output 

[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16] 

  
 * @author Mohamed Shehab
 *
 */
public class SpiralTraverse {

	enum Direction {
		LeftToRight, TopToBottom, RightToLeft, BottomToTop
	}

	// Time and Space Complexity
	// O(n) time | O(n) space - where n is the total number of elements in the array
	public static List<Integer> spiralTraverse(int[][] array) {
		// Write your code here.

		ArrayList<Integer> result = new ArrayList<Integer>();
		Direction direction = Direction.LeftToRight;

		int top = 0;
		int bottom = array.length - 1; // Rows Length
		int left = 0;
		int right = array[0].length - 1; // Columns Length

		// Right & Left
		int colsBegin = 0;
		int colsLength = array[0].length - 1;

		// Top & Bottom
		int rowsBegin = 0;
		int rowsLength = array.length - 1;

		while( top <= bottom && left <= right) {
			// 1) Left to Right
			// One row is decreased
			if(direction == Direction.LeftToRight) {
				for(int i = colsBegin; i <= colsLength; i++) {
					System.out.print(array[left][i] + " ");
					result.add(array[left][i]);
				}
				rowsBegin++;
				direction = Direction.TopToBottom;
			}

			// 2) Top to Bottom
			// One column is decreased
			else if(direction == Direction.TopToBottom) {
				for(int i = rowsBegin; i <= rowsLength; i++) {
					System.out.print(array[i][right] + " ");
					result.add(array[i][right]);
				}
				if(rowsBegin <= rowsLength) {
					colsLength--;
					right--;
					direction = Direction.RightToLeft;
				}
				else
					break;
			}

			// ---------------------- 3) Right to Left -----------------
			else if(direction == Direction.RightToLeft) {
				for(int i = colsLength; i >= colsBegin; i--) {
					System.out.print(array[bottom][i] + " ");
					result.add(array[bottom][i]);
				}
				rowsLength--;
				bottom--;
				direction = Direction.BottomToTop;
			}

			// --------------- 4) Bottom to Top --------------
			else if(direction == Direction.BottomToTop) {
				for(int i = rowsLength; i >= rowsBegin; i--) {
					System.out.print(array[i][top] + " ");
					result.add(array[i][top]);
				}
				colsBegin++;
				left++;
				top++;
				direction = Direction.LeftToRight;
			}
		}
		return result;
	}

	@Test
	public void TestCase1() {
		int[][] input =
				new int[][] {
			{1,  2,  3,  4},
			{12, 13, 14, 5},
			{11, 16, 15, 6},
			{10, 9,  8,  7},
		};
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
		List<Integer> actual = spiralTraverse(input);
		assertTrue(expected.equals(actual));
	}

	@Test
	public  void TestCase2() {
		System.out.println("\n=======================================");
		int[][] input =
				new int[][] {
			{1,  2,  3,  4},
			{10, 11, 12, 5},
			{9,  8,  7,  6}
		};
		List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		List<Integer> actual = spiralTraverse(input);
		assertTrue(expected.equals(actual));
	}

}
