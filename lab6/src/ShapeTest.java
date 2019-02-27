import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
    // ==================================================================================================================
    // Basic Shape Testing:
    // ==================================================================================================================
    /**
     * Tests for the square class.
     */
    @Test
    public void SquareTest()
    {
        Shape sqr = new Square("Square1", 3.0);
        Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
        Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
        Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
    }

    /**
     * Tests for the rectangle class.
     */
    @Test
    public void RectangleTest()
    {
        // TODO: complete this...
        Shape rect = new Rectangle("Rectangle1", 4.0, 2.0);
        Assert.assertEquals("Rectangle area incorrect.", 8.0, rect.getArea(), 0.0001);
        Assert.assertEquals("Rectangle perimeter incorrect.", 12.0, rect.getPerimeter(), 0.0001);
        Assert.assertEquals("Rectangle type incorrect.", "Rectangle", rect.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Rectangle1", rect.getId());
    }

    /**
     * Tests for the EquilateralTriangle class.
     */
    @Test
    public void TriangleTest()
    {
        // TODO: complete this...
        Shape triangl = new EquilateralTriangle("EquilateralTriangle1", 5.0);
        Assert.assertEquals("Equilateral Triangle area incorrect.", 10.825, triangl.getArea(), 0.001);
        Assert.assertEquals("Equilateral Triangle perimeter incorrect.", 15.0, triangl.getPerimeter(), 0.0001);
        Assert.assertEquals("Equilateral Triangle type incorrect.", "EquilateralTriangle", triangl.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "EquilateralTriangle1", triangl.getId());
    }

    /**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
    @Test
    public void TrapezoidTest()
    {
        // TODO: complete this...
        Shape trapez = new Trapezoid("Trapezoid1", Math.sqrt(33), 5.0, 10.0, 13.0);
        Assert.assertEquals("Trapezoid area incorrect.", 57.468, trapez.getArea(), 0.0001);
        Assert.assertEquals("Trapezoid perimeter incorrect.", 33.744, trapez.getPerimeter(), 0.001);
        Assert.assertEquals("Trapezoid type incorrect.", "Trapezoid", trapez.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Trapezoid1", trapez.getId());
    }

    /**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
    @Test
    public void EllipseTest()
    {
        Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
        Assert.assertEquals("Ellipse area incorrect.", Math.PI * 3.0 * 3.0, circ.getArea(), 0.0001);
        Assert.assertEquals("Ellipse perimeter incorrect.",
                2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2), circ.getPerimeter(), 0.0001);
        Assert.assertEquals("Ellipse type incorrect.", "Ellipse", circ.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

        Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
        Assert.assertEquals("Ellipse area incorrect.", Math.PI * 3 * 5, circs.getArea(), 0.0001);
        Assert.assertEquals("Ellipse perimeter incorrect.",
                2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2), circs.getPerimeter(), 0.0001);
        Assert.assertEquals("Ellipse type incorrect.", "Ellipse", circs.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
    }

    /**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
    @Test
    public void CircleTest()
    {
        // TODO: complete this...
        Shape circl = new Circle("Circle1", 2.0);
        Assert.assertEquals("Circle area incorrect.", Math.PI * 2.0 * 2.0, circl.getArea(), 0.0001);
        Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 2.0, circl.getPerimeter(), 0.0001);
        Assert.assertEquals("Circle type incorrect.", "Circle", circl.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Circle1", circl.getId());

        Shape circl2 = new Circle("Circle2", 3.0);
        Assert.assertEquals("Circle area incorrect.", Math.PI * 3.0 * 3.0, circl2.getArea(), 0.0001);
        Assert.assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 3.0, circl2.getPerimeter(), 0.0001);
        Assert.assertEquals("Circle type incorrect.", "Circle", circl2.getShapeType());
        Assert.assertEquals("Shape ID incorrect.", "Circle2", circl2.getId());

        Assert.assertEquals("Circle radius incorrect", 3.0, ((Ellipse) circl2).getMinorAxis(), 0.0001);
    }

    /**
     * Tests for Shape's toString().
     */
    @Test
    public void ShapeToStringTest()
    {
        // TODO: complete this...
        Shape square = new Square("Square1", 3.0);

        String expectedOutput = "Square:\t ID = Square1\t area = 9.000\t perimeter = 12.000";

        Assert.assertEquals(expectedOutput, square.toString());
    }

    // ==================================================================================================================
    // Comparisons:
    // ==================================================================================================================
    /**
     * Tests for the Shape Area Comparator class.
     */
    @Test
    public void CompareAreaTest()
    {
        // Test equals:
        Shape rect = new Rectangle("R1", 3.0, 3.0);
        Shape sqr = new Square("S1", 3.0);
        ShapeAreaComparator sc = new ShapeAreaComparator();
        Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
        Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

        // Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
    }

    /**
     * Tests for the Shape Perimter Comparator class.
     */
    @Test
    public void ComparePerimeterTest()
    {
        // TODO: complete this...
        Shape rect = new Rectangle("R1", 3.0, 3.0);
        Shape sqr = new Square("S1", 3.0);
        ShapePerimeterComparator sc = new ShapePerimeterComparator();
        Assert.assertEquals("ShapePerimeterComparator should find shapes equal.", 0, sc.compare(rect, sqr));
        Assert.assertTrue("ShapePerimeterComparator should find shapes equal.", sc.equals(rect, sqr));

        // Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 2.0, 9.0); // 22
        Shape sqr2 = new Square("S2", 5.0); // 20
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", 1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapePerimeterComparator gave incorrect ordering.", -1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapePerimeterComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
    }

    /**
     * Tests the natural ordering of shapes (compareTo in shape)
     */
    @Test
    public void NaturalCompareTest()
    {
        // TODO: complete this...
        Shape rect1 = new Rectangle("R2", 3.0, 5.0); // 15.0
        Shape rect2 = new Rectangle("R1", 2.0, 4.0); // 8.0
        Assert.assertEquals("Shape's compareTo() has sorted incorrectly.", 1, rect1.compareTo(rect2));
        Assert.assertEquals("Shape's compareTo() has sorted incorrectly.", -1, rect2.compareTo(rect1));

        Shape sqr1 = new Square("Sq2", 5.0); // 25.0
        Shape sqr2 = new Square("Sq1", 4.0); // 36.0
        Assert.assertEquals("Shape's compareTo() has sorted incorrectly.", 1, sqr1.compareTo(sqr2));

        Shape sqr3 = new Square("Sq3", 4.0); // 16.0 -- 16
        Shape rect3 = new Rectangle("R3", 2.0, 8.0); // 16.0 -- 20
        Assert.assertEquals("Shape's compareTo() has sorted incorrectly.", 1, rect3.compareTo(sqr3));
        Assert.assertEquals("Shape's compareTo() has sorted incorrectly.", -1, sqr3.compareTo(rect3));

        Shape sqr4 = new Square("Sq4", 3);// 9 and 12
        Shape rect4 = new Rectangle("R4", 3.0, 3.0); // 9 and 12
        Assert.assertEquals("Shape's compareTo() has sorted incorrectly.", 0, sqr4.compareTo(rect4));
    }
}
