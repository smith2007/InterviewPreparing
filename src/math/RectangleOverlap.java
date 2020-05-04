package math;

public class RectangleOverlap {

    /**
     * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates
     * of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.
     *
     * Two rectangles overlap if the area of their intersection is positive.  To be clear,
     * two rectangles that only touch at the corner or edges do not overlap.
     *
     * Given two (axis-aligned) rectangles, return whether they overlap.
     *
     * Example 1:
     *
     * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
     * Output: true
     * Example 2:
     *
     * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
     * Output: false
     * Notes:
     */

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {


        int[] rdiag1 = new int[]{rec1[0], rec1[3], rec1[2], rec1[1]};
        int[] rdiag2 = new int[]{rec2[0], rec2[3], rec2[2], rec2[1]};

        return isOverlap(rec1, rec2) || isOverlap(rec2, rec1)  || isOverlap(rdiag1, rdiag2) || isOverlap(rdiag2, rdiag1);

    }

    private boolean isOverlap(int[] c1, int[] c2) {
        // Similar max and min logic can be used for finding overlapping intervals
        int xstart = Math.max(c1[0], c2[0]);
        int xend = Math.min(c1[2],c2[2] );

        int ystart = Math.max(c1[1], c2[1]);
        int yend = Math.min(c1[3], c2[3]);

        return xstart<xend && ystart<yend;
    }


    /*
    Intuition

If the rectangles do not overlap, then rec1 must either be higher, lower, to the left, or to the right of rec2.

Algorithm

The answer for whether they don't overlap is LEFT OR RIGHT OR UP OR DOWN, where OR is the logical OR,
and LEFT is a boolean that represents whether rec1 is to the left of rec2. The answer for whether they do overlap is the negation of this.

The condition "rec1 is to the left of rec2" is rec1[2] <= rec2[0], that is the right-most x-coordinate
of rec1 is left of the left-most x-coordinate of rec2. The other cases are similar.


  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[2] <= rec2[0] ||   // left
                 rec1[3] <= rec2[1] ||   // bottom
                 rec1[0] >= rec2[2] ||   // right
                 rec1[1] >= rec2[3]);    // top
    }
     */
}
