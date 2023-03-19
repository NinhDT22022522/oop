// Test cases for CharGrid -- a few basic tests are provided.

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class CharGridTest {
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};

		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
	}

	@Test
	public void testGridArea3() {
		char[][] grid = new char[][] {
				{ 'c', 'a', 'x' },
				{ 'b', ' ', 'b' },
				{ ' ', ' ', 'a' }
		};
		CharGrid cg = new CharGrid(grid);

		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(0, cg.charArea('d'));
		assertEquals(1, cg.charArea('x'));
		assertEquals(4, cg.charArea(' '));
	}
	
	//countPlus

	@Test
	public void testCountPlus_BasicCases(){
		char[][] grid = new char[][]{
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', ' ', ' '},
				{' ', ' ', 'p', ' ', ' ', ' ', ' ', 'x', ' '},
				{'p', 'p', 'p', 'p', 'p', ' ', 'x', 'x', 'x'},
				{' ', ' ', 'p', ' ', ' ', 'y', ' ', 'x', ' '},
				{' ', ' ', 'p', ' ', 'y', 'y', 'y', ' ', ' '},
				{'z', 'z', 'z', 'z', 'z', 'y', 'z', 'z', 'z'},
				{' ', ' ', 'x', 'x', ' ', 'y', ' ', ' ', ' '}
		};

		char[][] grid2 = new char[][] {
				{ ' ', 't', ' ', 'x', ' ', ' ', ' '},
				{ 't', 't', 't', 'x', ' ', ' ', ' '},
				{ ' ', 't', ' ', 'x', ' ', ' ', ' '},
				{ 'x', 'x', 'x', 'x', 'x', 'x', 'x'},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '},
				{ ' ', ' ', ' ', 'x', ' ', 'x', ' '},
				{ ' ', ' ', ' ', 'x', ' ', ' ', ' '}
		};

		CharGrid cg1 = new CharGrid(grid);
		CharGrid cg2 = new CharGrid(grid2);

		assertEquals(2,cg1.countPlus());
		assertEquals(2,cg1.countPlus());
	}
	
	
}
