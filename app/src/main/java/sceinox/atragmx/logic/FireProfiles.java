package sceinox.atragmx.logic;

import android.content.Context;

public class FireProfiles {
    public static final int MEASUREMENT_SYSTEM_METER = 0;
    public static final int MEASUREMENT_SYSTEM_IMPERIAL = 1;
    public static final int MEASUREMENT_SYSTEM_DUAL = 2;

    //represents fireprofiles A,B,C,D from activity_Main
    private static Profile a = new Profile();
    private static Profile b = new Profile();
    private static Profile c = new Profile();
    private static Profile d = new Profile();

    private static Profile selectedProfile = a;
    private static int MeasurementSystem = MEASUREMENT_SYSTEM_METER;

    private static Context context;


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

    public static int getMeasurementSystem() {
        return MeasurementSystem;
    }

    public static void setMeasurementSystem(int measurementSystem) {
        MeasurementSystem = measurementSystem;
    }

    //endregion

    //region c'tors
    public FireProfiles(Context context) {
        FireProfiles.context = context;
    }
    //endregion

    public static void setStartWeapon() {
        FireProfiles.getA().setGun("408 CheyTac");
        FireProfiles.getB().setGun("408 CheyTac");
        FireProfiles.getC().setGun("408 CheyTac");
        FireProfiles.getD().setGun("408 CheyTac");
    }

    static public class Profile {
        //gun data
        private String weaponName;
        private double boreHeight;
        private double bulletWeight;
        private double bulletDiameter;
        private double c1Coefficient;
        private double rifleTwist;
        private double muzzleVelocity;
        private double zeroRange;

        //atmosphere data
        private double temperature;
        private double altitude;
        private double barometricPressure;
        private double humidity;

        //target data
        private double latitude;
        private double dirOfFire;
        private double windSpeed;
        private double windSpeed2;
        private double windDirection;
        private double inclinationAngleDegree;
        private double inclinationAngleCosine;
        private double targetSpeed;
        private double targetRange;

        //region c'tors
        Profile() {
            //sets standard values
            this.boreHeight = -1;
            this.bulletWeight = -1;
            this.bulletDiameter = -1;
            this.c1Coefficient = -1;
            this.rifleTwist = -1;
            this.muzzleVelocity = -1;
            this.zeroRange = -1;

            this.temperature = 23;
            this.altitude = 1200;
            this.barometricPressure = 1028;
            this.humidity = 78;

            this.latitude = 39;
            this.dirOfFire = 0;
            this.windSpeed = 0;
            this.windSpeed2 = 0;
            this.windDirection = 0;
            this.setInclinationAngleFromDegree(-10);
            this.targetSpeed = 0;
            this.targetRange = 1000;
        }
        //endregion

        //region Getter

        public String getWeaponName() {
            return weaponName;
        }

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

        public void setWeaponName(String weaponName) {
            this.weaponName = weaponName;
        }

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

        //sets all gun related values from SQL DB by weaponName
        public void setGun(String weaponName) {
            DatabaseHelper dbHelp = new DatabaseHelper(context);
            String[] gun = dbHelp.getGunAsArrayByName(weaponName);

            this.weaponName = gun[1];
            this.boreHeight = Double.parseDouble(gun[2]);
            this.bulletWeight = Double.parseDouble(gun[3]);
            this.bulletDiameter = Double.parseDouble(gun[4]);
            this.c1Coefficient = Double.parseDouble(gun[5]);
            this.rifleTwist = Double.parseDouble(gun[6]);
            this.muzzleVelocity = Double.parseDouble(gun[7]);
            this.zeroRange = Double.parseDouble(gun[8]);
        }
        //endregion


        public String toString() {
            String out;
            out = "Profile:: weaponName = " + weaponName + "; boreHeight = " + boreHeight + "; bulletWeight = " + bulletWeight + "; bulletDiameter = " + bulletDiameter + "; c1Coefficient = " + c1Coefficient +
                    "; rifleTwist = " + rifleTwist + "; muzzleVelocity = " + muzzleVelocity + "; zeroRange = " + zeroRange + "; temperature = " + temperature +
                    "; altitude = " + altitude + "; barometricPressure = " + barometricPressure + "; humidity = " + humidity + "; latitude = " + latitude +
                    "; dirOfFire = " + dirOfFire + "; windSpeed = " + windSpeed + "; windSpeed2 = " + windSpeed2 + "; windDirection = " + windDirection + "; inclinationAngleDegree = " +
                    inclinationAngleDegree + "; inclinationAngleCosine = " + inclinationAngleCosine + "; targetSpeed = " + targetSpeed + "; targetRange = " + targetRange;
            return out;
        }

    }

}
