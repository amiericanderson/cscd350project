package cs350s21project.cli;

import cs350s21project.datatype.*;

public class CommandInterpreter {

    Altitude altitude;
    AttitudeYaw azimuth;
    CoordinateWorld3D coordinates;
    Course course;
    DistanceNauticalMiles distance;
    AttitudePitch elevation;
    String filename;
    FieldOfView fov;
    AgentID id;
    Latitude latitude;
    Longitude longitude;
    Power power;
    Sensitivity sensitivity ;
    int size;
    Groundspeed speed;
    Time time;


    public void evaluate(String command) throws RuntimeException {
        System.out.println("hello world");
	    System.out.println("this line is to test commit from teammate.");
	    System.out.println("testing 123");
	    System.out.println("cugel the clever");
    }
}
