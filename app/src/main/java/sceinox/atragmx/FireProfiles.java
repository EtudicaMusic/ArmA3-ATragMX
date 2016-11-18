package sceinox.atragmx;


public class FireProfiles {
    //represents fireprofiles A,B,C,D from activity_Main
    private static Profile a = new Profile();
    private static Profile b = new Profile();
    private static Profile c = new Profile();
    private static Profile d = new Profile();

    private static Profile selectedProfile = a;

    //region Getter's and Setter's
    public static Profile getA() {
        return a;
    }

    public static void setA(Profile a) {
        FireProfiles.a = a;
    }

    public static Profile getB() {
        return b;
    }

    public static void setB(Profile b) {
        FireProfiles.b = b;
    }

    public static Profile getC() {
        return c;
    }

    public static void setC(Profile c) {
        FireProfiles.c = c;
    }

    public static Profile getD() {
        return d;
    }

    public static void setD(Profile d) {
        FireProfiles.d = d;
    }

    public static Profile getSelectedProfile() {
        return selectedProfile;
    }

    public static void setSelectedProfile(Profile selectedProfile) {
        FireProfiles.selectedProfile = selectedProfile;
    }

    public static void setSelectedProfileToA() {
        FireProfiles.selectedProfile = FireProfiles.a;
    }

    public static void setSelectedProfileToB() {
        FireProfiles.selectedProfile = FireProfiles.b;
    }

    public static void setSelectedProfileToC() {
        FireProfiles.selectedProfile = FireProfiles.c;
    }

    public static void setSelectedProfileToD() {
        FireProfiles.selectedProfile = FireProfiles.d;
    }
    //endregion



    static class Profile{
        //gun data
        private double boreHeight = 3.81;
        private double bulletWeight = 27;
        private double bulletDiameter = 1.04;
        private double c1Coefficient = 0.389;
        private double rifleTwist = 33.02;
        private double muzzleVelocity = 910;
        private double zeroRange = 100;

        //atmosphere data
        private double temperature = 12;
        private double altitude = 2664;
        private double barometricPressure = 1028;
        private double humidity = 78;

        //target data
        private double latitude = 0;
        private double dirOfFire = 134;
        private double windSpeed = 4.4;
        private double windSpeed2 = 0;
        private double windDirection = 11;
        private double inclinationAngleDegree = 0.98;
        private double inclinationAngleCosine = -11;
        private double targetSpeed = 0;
        private double targetRange = 1600;

        //region c'tors
        public Profile() {
            //sets standard values
            // TODO: update gunStatistic.xml
            //this.setGun(null);

            this.temperature = 23;
            this.altitude = 1200;
            this.barometricPressure = 1028;
            this.humidity = 78;

            this.latitude = 39;
            this.dirOfFire = 0;
            this.windSpeed = 0;
            this.windSpeed2 =0;
            this.windDirection = 0;
            this.setInclinationAngleFromDegree(-10);
            this.targetSpeed = 0;
            this.targetRange = 1000;
        }
        //endregion

        //region Getter

        public double getBoreHeight() {
            return boreHeight;
        }

        public double getBulletWeight() {
            return bulletWeight;
        }

        public double getBulletDiameter() {
            return bulletDiameter;
        }

        public double getC1Coefficient() {
            return c1Coefficient;
        }

        public double getRifleTwist() {
            return rifleTwist;
        }

        public double getMuzzleVelocity() {
            return muzzleVelocity;
        }

        public double getZeroRange() {
            return zeroRange;
        }

        public double getTemperature() {
            return temperature;
        }

        public double getAltitude() {
            return altitude;
        }

        public double getBarometricPressure() {
            return barometricPressure;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getDirOfFire() {
            return dirOfFire;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public double getWindSpeed2() {
            return windSpeed2;
        }

        public double getWindDirection() {
            return windDirection;
        }

        public double getInclinationAngleDegree() {
            return inclinationAngleDegree;
        }

        public double getInclinationAngleCosine() {
            return inclinationAngleCosine;
        }

        public double getTargetSpeed() {
            return targetSpeed;
        }

        public double getTargetRange() {
            return targetRange;
        }

        //endregion

        //region Setter
        public void setBoreHeight(double boreHeight) {
            this.boreHeight = boreHeight;
        }

        public void setBulletWeight(double bulletWeight) {
            this.bulletWeight = bulletWeight;
        }

        public void setBulletDiameter(double bulletDiameter) {
            this.bulletDiameter = bulletDiameter;
        }

        public void setC1Coefficient(double c1Coefficient) {
            this.c1Coefficient = c1Coefficient;
        }

        public void setRifleTwist(double rifleTwist) {
            this.rifleTwist = rifleTwist;
        }

        public void setMuzzleVelocity(double muzzleVelocity) {
            this.muzzleVelocity = muzzleVelocity;
        }

        public void setZeroRange(double zeroRange) {
            this.zeroRange = zeroRange;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public void setAltitude(double altitude) {
            this.altitude = altitude;
        }

        public void setBarometricPressure(double barometricPressure) {
            this.barometricPressure = barometricPressure;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public void setDirOfFire(double dirOfFire) {
            this.dirOfFire = dirOfFire;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public void setWindSpeed2(double windSpeed2) {
            this.windSpeed2 = windSpeed2;
        }

        public void setWindDirection(double windDirection) {
            this.windDirection = windDirection;
        }

        //changes both inclinationAngels equivalent
        public void setInclinationAngleFromDegree(double inclinationAngleDegree) {
            this.inclinationAngleDegree = inclinationAngleDegree;
            //TODO check rightness
            //is this method working with negative inclinations?
            this.inclinationAngleCosine = Math.cos(Math.toRadians(inclinationAngleDegree));
        }

        //changes both inclinationAngels equivalent
        public void setInclinationAngleFromCosine(double inclinationAngleCosine) {
            this.inclinationAngleCosine = inclinationAngleCosine;
            //TODO check rightness
            //is this method working with negative inclinations?
            this.inclinationAngleDegree = Math.toDegrees(Math.acos(inclinationAngleCosine));
        }

        public void setTargetSpeed(double targetSpeed) {
            this.targetSpeed = targetSpeed;
        }

        public void setTargetRange(double targetRange) {
            this.targetRange = targetRange;
        }

        //sets all gun related values to the from a String-Array, intended for gunstatistics.xml
        public void setGun(String[] gun){
            this.boreHeight=Double.parseDouble(gun[0]);
            this.bulletWeight=Double.parseDouble(gun[1]);
            this.bulletDiameter=Double.parseDouble(gun[2]);
            this.c1Coefficient=Double.parseDouble(gun[3]);
            this.rifleTwist=Double.parseDouble(gun[4]);
            this.muzzleVelocity=Double.parseDouble(gun[5]);
            this.zeroRange=Double.parseDouble(gun[6]);
        }
        //endregion

        public String toString(){
            String out;
            out="boreHeight = "+boreHeight+"; bulletWeight = "+bulletWeight+"; bulletDiameter = "+bulletDiameter+"; c1Coefficient = "+c1Coefficient+
                    "; rifleTwist = "+rifleTwist+"; muzzleVelocity = "+muzzleVelocity+"; zeroRange = "+zeroRange+"; temperature = "+temperature+
                    "; altitude = "+altitude+"; barometricPressure = "+barometricPressure+"; humidity = "+humidity+"; latitude = "+latitude+
                    "; dirOfFire = "+dirOfFire+"; windSpeed = "+windSpeed+"; windSpeed2 = "+windSpeed2+"; windDirection = "+windDirection+"; inclinationAngleDegree = "+
                    inclinationAngleDegree+"; inclinationAngleCosine = "+inclinationAngleCosine+"; targetSpeed = "+targetSpeed+"; targetRange = "+targetRange;
            return out;
        }

    }

}
