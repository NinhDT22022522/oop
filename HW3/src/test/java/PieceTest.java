import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
    // You can create data to be used in the your test cases like this.
    // For each run of a test method, a new PieceTest object is created
    // and setUp() is called automatically by JUnit.
    // For example, the code below sets up some pyramid and s pieces
    // in instance variables that can be used in tests.
    private Piece pyr1, pyr2, pyr3, pyr4;
    private Piece l1, l2, l3, l4;
    private Piece s, sRotated;

    @Before
    public void setUp() {
        pyr1 = new Piece(Piece.PYRAMID_STR);
        pyr2 = pyr1.computeNextRotation();
        pyr3 = pyr2.computeNextRotation();
        pyr4 = pyr3.computeNextRotation();

        l1 = new Piece(Piece.L1_STR);
        l2 = l1.computeNextRotation();
        l3 = l2.computeNextRotation();
        l4 = l3.computeNextRotation();


        s = new Piece(Piece.S1_STR);
        sRotated = s.computeNextRotation();
    }

    // Here are some sample tests to get you started
    @Test
    public void testSampleSize() {
        // Check size of pyr piece
        assertEquals(3, pyr1.getWidth());
        assertEquals(2, pyr1.getHeight());

        // Now try after rotation
        // Effectively we're testing size and rotation code here
        assertEquals(2, pyr2.getWidth());
        assertEquals(3, pyr2.getHeight());

        // Now try with some other piece, made a different way
        Piece l = new Piece(Piece.STICK_STR);
        assertEquals(1, l.getWidth());
        assertEquals(4, l.getHeight());

        // More test
        assertEquals(3, l1.getHeight());
        assertEquals(2, l1.getWidth());

        assertEquals(2, l2.getHeight());
        assertEquals(3, l2.getWidth());
    }


    // Test the skirt returned by a few pieces
    @Test
    public void testSampleSkirt() {
        // Note must use assertTrue(Arrays.equals(... as plain .equals does not work
        // right for arrays.
        assertTrue(Arrays.equals(new int[]{0, 0, 0}, pyr1.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0, 1}, pyr3.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 0, 1}, s.getSkirt()));
        assertTrue(Arrays.equals(new int[]{1, 0}, sRotated.getSkirt()));

        assertTrue(Arrays.equals(new int[]{0, 1, 1}, l4.getSkirt()));
    }

    @Test
    public void testEquals(){

        assertTrue(pyr4.equals(pyr3.computeNextRotation()));
        assertTrue(s.equals(new Piece(Piece.S1_STR)));
        assertTrue(l1.equals(new Piece(Piece.L1_STR)));
        assertTrue(l3.equals(l2.computeNextRotation()));
        assertTrue(sRotated.equals(s.computeNextRotation()));

        assertFalse(l2.equals(new Piece(Piece.L1_STR)));
        assertFalse(l4.equals(new Piece(Piece.L1_STR)));
    }

    @Test
    public void testFastRotation(){
        Piece[] pieces = Piece.getPieces();
        assertTrue(l2.equals(pieces[Piece.L1].fastRotation()));
        assertTrue(l4.equals(pieces[Piece.L1].fastRotation().fastRotation().fastRotation()));
        assertTrue(pyr3.equals(pieces[Piece.PYRAMID].fastRotation().fastRotation()));
        assertTrue(pyr2.equals(pieces[Piece.PYRAMID].fastRotation()));
        assertTrue(sRotated.equals(pieces[Piece.S1].fastRotation()));
        assertFalse(l2.equals(pieces[Piece.L1].fastRotation().fastRotation().fastRotation()));
    }
}
