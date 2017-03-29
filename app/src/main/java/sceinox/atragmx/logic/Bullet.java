package sceinox.atragmx.logic;

import java.util.Vector;

/**
 * Created by etudicamusic on 3/28/2017.
 */

public class Bullet {
    private double airFriction;
    private double caliber;
    private double bulletLength;
    private double bulletMass;
    private Vector<Double> ballisticCoefficients;
    private Vector<Double> velocityBoundaries;
    private String atmosphereModel;
    private Integer dragModel;//TODO: enum
    private Vector<Double> muzzleVelocities;
    private Vector<Double> barrelLengths;
    private double stabilityFactor;
    private double twistDirection;
    private double transonicStabilityCoef;
    private double muzzleVelocity;
    private Vector<Double> origin;
    private double latitdue;
    private double temperature;
    private double altitude;
    private double humidity;
    private double overcast;
    private double startTime;
    private double lastFrame;
    private double bcDegradation;
    private Integer randSeed;


}
