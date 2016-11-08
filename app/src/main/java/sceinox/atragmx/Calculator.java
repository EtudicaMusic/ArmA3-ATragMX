package sceinox.atragmx;

import android.view.View;

class Calculator {

    //region private static fields
    private static double gun_bore_height;
    private static double gun_bullet_weight;
    private static double gun_ballistic_coefficient;
    private static double gun_muzzle_velocity;
    private static double gun_zero_range;

    private static double atmsphr_temperature;
    private static double atmsphr_barometric_pressure;
    private static double atmsphr_relative_humidity;

    private static double target_wind_strength;
    private static double target_wind_direction;
    private static double target_inclination_angle;
    private static double target_target_speed;
    private static double target_target_range;
    //endregion

    //region public getters
    public static void setGun_bore_height(double gun_bore_height) {
        Calculator.gun_bore_height = gun_bore_height;
    }

    public static void setGun_bullet_weight(double gun_bullet_weight) {
        Calculator.gun_bullet_weight = gun_bullet_weight;
    }

    public static void setGun_ballistic_coefficient(double gun_ballistic_coefficient) {
        Calculator.gun_ballistic_coefficient = gun_ballistic_coefficient;
    }

    public static void setGun_muzzle_velocity(double gun_muzzle_velocity) {
        Calculator.gun_muzzle_velocity = gun_muzzle_velocity;
    }

    public static void setGun_zero_range(double gun_zero_range) {
        Calculator.gun_zero_range = gun_zero_range;
    }

    public static void setAtmsphr_temperature(double atmosphere_temperature) {
        Calculator.atmsphr_temperature = atmosphere_temperature;
    }

    public static void setAtmsphr_barometric_pressure(double atmosphere_barometric_pressure) {
        Calculator.atmsphr_barometric_pressure = atmosphere_barometric_pressure;
    }

    public static void setAtmsphr_relative_humidity(double atmsphr_relative_humidity) {
        Calculator.atmsphr_relative_humidity = atmsphr_relative_humidity;
    }

    public static void setTarget_wind_strength(double target_wind_strength) {
        Calculator.target_wind_strength = target_wind_strength;
    }

    public static void setTarget_wind_direction(double target_wind_direction) {
        Calculator.target_wind_direction = target_wind_direction;
    }

    public static void setTarget_inclination_angle(double target_inclination_angle) {
        Calculator.target_inclination_angle = target_inclination_angle;
    }

    public static void setTarget_target_speed(double target_target_speed) {
        Calculator.target_target_speed = target_target_speed;
    }

    public static void setTarget_target_range(double target_target_range) {
        Calculator.target_target_range = target_target_range;
    }
    //endregion

    //region c'tors

    /*
    this c'tor is only used for unit tests.
    ToDo: Implement JUnit4 test suite
     */
    public Calculator(double gun_bore_height, double gun_bullet_weight, double gun_ballistic_coefficient, double gun_muzzle_velocity, double gun_zero_range,
                      double atmsphr_temperature, double atmsphr_barometric_pressure, double atmsphr_relative_humidity,
                      double target_wind_strength, double target_wind_direction, double target_inclination_angle, double target_target_speed, double target_target_range) {
        Calculator.gun_bore_height = gun_bore_height;
        Calculator.gun_bullet_weight = gun_bullet_weight;
        Calculator.gun_ballistic_coefficient = gun_ballistic_coefficient;
        Calculator.gun_muzzle_velocity = gun_muzzle_velocity;
        Calculator.gun_zero_range = gun_zero_range;

        Calculator.atmsphr_temperature = atmsphr_temperature;
        Calculator.atmsphr_barometric_pressure = atmsphr_barometric_pressure;
        Calculator.atmsphr_relative_humidity = atmsphr_relative_humidity;

        Calculator.target_wind_strength = target_wind_strength;
        Calculator.target_wind_direction = target_wind_direction;
        Calculator.target_inclination_angle = target_inclination_angle;
        Calculator.target_target_speed = target_target_speed;
        Calculator.target_target_range = target_target_range;
    }

    public Calculator(View view){

    }
    //endregion
}
