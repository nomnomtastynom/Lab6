import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter. Implicitly tests that the comparators are
 * implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
    /**
     * Test that shapes are added correctly.
     */
    @Test
    public void AddShapeTest()
    {
        ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 3, 3);
        Shape b = new EquilateralTriangle("test2", 4);
        Shape c = new Square("test3", 3);
        Shape d = new Circle("test4", 1.5);

        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);

        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
    }

    /**
     * Tests sorting via the default ordering.
     */
    @Test
    public void SortShapesDefaultTest()
    {
        // TODO: complete this...
        ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 3, 3); // 9 12
        Shape b = new EquilateralTriangle("test2", 4);// 16 * sqrt(3)/4 = 6.93
        Shape c = new Square("test3", 2); // 4 8
        Shape d = new Circle("test4", 1.5); // 2.25 * Math.Pi = 7.07

        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);

        sorter.sortShapes();

        Assert.assertEquals("Shapes sorting via default ordering incorrectly.", sorter.shapes.get(0), c);
        Assert.assertEquals("Shapes sorting via default ordering incorrectly.", sorter.shapes.get(1), b);
        Assert.assertEquals("Shapes sorting via default ordering incorrectly", sorter.shapes.get(2), d);
        Assert.assertEquals("Shapes sorting via default ordering incorrectly", sorter.shapes.get(3), a);
    }

    /**
     * Tests sorting by area ordering.
     */
    @Test
    public void SortShapesAreaTest()
    {
        // TODO: complete this...
        ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 3, 3); // 9 12
        Shape b = new EquilateralTriangle("test2", 4);// 16 * sqrt(3)/4 = 6.93
        Shape c = new Square("test3", 2); // 4 8
        Shape d = new Circle("test4", 1.5); // 2.25 * Math.Pi = 7.07

        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);

        sorter.sortShapes(new ShapeAreaComparator());

        Assert.assertEquals("Shapes sorting via area ordering incorrectly.", sorter.shapes.get(0), c);
        Assert.assertEquals("Shapes sorting via area ordering incorrectly.", sorter.shapes.get(1), b);
        Assert.assertEquals("Shapes sorting via area ordering incorrectly.", sorter.shapes.get(2), d);
        Assert.assertEquals("Shapes sorting via area ordering incorrectly.", sorter.shapes.get(3), a);
    }

    /**
     * Tests sorting by perimeter ordering.
     */
    @Test
    public void SortShapesPerimeterTest()
    {
        // TODO: complete this...
        ShapeSorter sorter = new ShapeSorter();

        Shape a = new Rectangle("test", 3, 3); // 12
        Shape b = new EquilateralTriangle("test2", 5);// 15
        Shape c = new Square("test3", 2); // 8
        Shape d = new Circle("test4", 1.5); // 9.42

        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);

        sorter.sortShapes(new ShapePerimeterComparator());

        Assert.assertEquals("Shapes sorting via perimeter ordering incorrectly.", sorter.shapes.get(0), c);
        Assert.assertEquals("Shapes sorting via perimeter ordering incorrectly.", sorter.shapes.get(1), d);
        Assert.assertEquals("Shapes sorting via perimeter ordering incorrectly.", sorter.shapes.get(2), a);
        Assert.assertEquals("Shapes sorting via perimeter ordering incorrectly.", sorter.shapes.get(3), b);
    }

    /**
     * Tests the toString.
     */
    @Test
    public void ToStringTest()
    {
        // TODO: complete this...
        ShapeSorter sorter = new ShapeSorter();

        Shape square = new Square("Square1", 3.0); // 9.0 9.0
        Shape rectangle = new Rectangle("Rectangle1", 3.0, 3.0); // 9.0 9.0
        Shape equilTriangle = new EquilateralTriangle("Equilateral Triangle1", 5.0); // 10.83
                                                                                     // 15.000

        sorter.addShape(square);
        sorter.addShape(rectangle);
        sorter.addShape(equilTriangle);

        String expected = "Square:\t ID = Square1\t area = 9.000\t perimeter = 12.000"
                + "Rectangle:\t ID = Rectangle1\t area = 9.000\t perimeter = 12.000"
                + "EquilateralTriangle:\t ID = Equilateral Triangle1\t area = 10.825\t perimeter = 15.000";

        Assert.assertEquals("ToString() done incorrectly", expected, sorter.toString());
    }
}
