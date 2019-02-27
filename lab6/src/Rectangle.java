public class Rectangle extends Polygon
{

    private double height;

    private double width;

    /**
     * Rectangle constructor. A rectangle is a specific type of polygon that has
     * 4 parallel sides
     *
     * The Rectangle should pass information to the Polygon's super constructor
     *
     * @param id
     *            The shape's name identifier, as defined in Shape.java.
     * @param height
     *            The height of the rectangle.
     * @param width
     *            The width of the rectangle.
     */

    public Rectangle(String id, double height, double width)
    {
        super(id);
        this.height = height;
        this.width = width;
        sideLengths.add(height);
        sideLengths.add(width);
        sideLengths.add(height);
        sideLengths.add(width);
    }

    /**
     * Calculates and returns the area of the rectangle.
     *
     * @return The area of the rectangle: width * height
     */

    public double getArea()
    {
        double rectArea = 0.0;
        rectArea = width * height;
        return rectArea;

    }

    /**
     * Gets the type of the shape.
     *
     * @return The string "Rectangle"
     */
    public String getShapeType()
    {
        return "Rectangle";
    }
}