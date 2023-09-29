public class PointCPD3 extends PointCP{


    /**
     * Constructs a coordinate object, with a type identifier.
     *
     * @param xOrRho
     * @param yOrTheta
     */
    public PointCPD3(double xOrRho, double yOrTheta) {
        super(xOrRho, yOrTheta);
    }

    @Override
    public double getX() {
        return xOrRho;
    }

    @Override
    public double getY() {
        return yOrTheta;
    }

    @Override
    public double getRho() {
        return (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
    }

    @Override
    public double getTheta() {
        return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    }

    @Override
    public String toString() {
        return "Cartesian  (" + getX() + "," + getY() + ")";
    }
}
