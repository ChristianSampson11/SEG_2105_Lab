public class PointCPD2 extends PointCPD5{
    PointCPD2(double xOrRho, double yOrTheta){
        super( xOrRho, yOrTheta);

    }

    @Override
    public double getX() {
        return (Math.cos(Math.toRadians(yOrTheta)) * xOrRho);
    }

    @Override
    public double getY() {
        return (Math.sin(Math.toRadians(yOrTheta)) * xOrRho);
    }

    @Override
    public double getRho() {
        return xOrRho;
    }

    @Override
    public double getTheta() {
        return yOrTheta;
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
        return "Polar [" + getRho() + "," + getTheta() + "]";
    }
}
