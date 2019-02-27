
public class Square extends Rectangle
{

    /**
     * Square constructor. A square is a specific type of rectangle that has all
     * equal sides;
     *
     * The Square should pass information to the Rectangle's super constructor
     *
     * @param id
     *            The shape's name identifier, as defined in Shape.java.
     * @param size
     *            The length of a side of the square.
     */
    public Square(String id, double size)
    {
        super(id, size, size);

    }

    /**
     * Gets the type of the shape.
     *
     * @return The string "Square"
     */
    public String getShapeType()
    {
        return "Square";
    }

}