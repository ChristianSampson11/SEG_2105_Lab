public class PointCPD2 extends PointCP{
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
    public String toString() {
        return "Polar [" + getRho() + "," + getTheta() + "]";
    }
}
