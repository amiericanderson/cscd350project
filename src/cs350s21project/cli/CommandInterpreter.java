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

    //define ship id1 with munition[s] (idn+)
    public void CommandActorDefineShip(AgentID idn) {
    }

    //create actor id1 from id2 at coordinates with course course speed speed

    //set id course course
    public void CommandActorSetCourse(Course course) {
	this.course = course;
    }

     //set id speed speed
     public void CommandActorSetSpeed(Groundspeed speed) {
	this.speed = speed;
     }

     //set id altitude|depth altitude
     public void CommandActorSetAltitudeDepth(Altitude altitude) {
	this.altitude = altitude;
     }

     //set id1 deploy munition id2
     public void CommandActorDeployMunition(AgentID id2) {

     }

     //define sensor sonar active id with power power sensitivity sensitivity
     public void CommandSensorDefineSonarActive(Sensitivity sensitivity) {

     }

     //define sensor sonar passive id with sensitivity sensitivity
     public void CommandSensorDefineSonarPassive(Sensitivity sensitivity) {

     }

     //set update time
     public void CommandMiscSetUpdate(Time time) {
	this.time = time;
     }

}
