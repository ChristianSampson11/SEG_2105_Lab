// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com


public abstract class PointCPD5
{
    //Instance variables ************************************************

    /**
     * Contains C(artesian) or P(olar) to identify the type of
     * coordinates that are being dealt with.
     */


    /**
     * Contains the current value of X or RHO depending on the type
     * of coordinates.
     */
    protected double xOrRho;

    /**
     * Contains the current value of Y or THETA value depending on the
     * type of coordinates.
     */
    protected double yOrTheta;


    //Constructors ******************************************************

    /**
     * Constructs a coordinate object, with a type identifier.
     */
    public PointCPD5(double xOrRho, double yOrTheta)
    {
        this.xOrRho = xOrRho;
        this.yOrTheta = yOrTheta;
    }


    //Instance methods **************************************************


    public abstract double getX();

    public abstract double getY();

    public abstract double getRho();

    public abstract double getTheta();


    /**
     * Converts Cartesian coordinates to Polar coordinates.
     */
    public abstract PointCPD5 convertStorageToPolar();


    /**
     * Converts Polar coordinates to Cartesian coordinates.
     */
    public abstract PointCPD5 convertStorageToCartesian();
    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     *
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(PointCP pointB)
    {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
  /*
  public PointCP rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();

    return new PointCP((Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }*/

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public abstract String toString();
}
