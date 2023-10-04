public class PointCPD3 extends PointCPD5{


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
    public PointCPD5 convertStorageToPolar() {
        return new PointCPD2(getRho(),getTheta());
    }

    @Override
    public PointCPD5 convertStorageToCartesian() {
        return new PointCPD3(getX(),getY());
    }

    @Override
    public String toString() {
        return "Cartesian  (" + getX() + "," + getY() + ")";
    }
}
