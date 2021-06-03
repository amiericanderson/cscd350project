package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.*;
import cs350s21project.controller.command.actor.*;
import cs350s21project.controller.command.misc.*;
import cs350s21project.controller.command.munition.*;
import cs350s21project.controller.command.sensor.*;
import cs350s21project.controller.command.view.A_CommandViewCreate;
import cs350s21project.controller.command.view.CommandViewCreateWindowTop;
import cs350s21project.controller.command.view.CommandViewDeleteWindow;
import cs350s21project.datatype.*;

import java.awt.*;

public class CommandInterpreter {

    Altitude altitude;
    AttitudeYaw azimuth;
    CoordinateWorld3D coordinates;
    Course course;
    DistanceNauticalMiles distance;
    AttitudePitch elevation;
    String filename;
    static FieldOfView fov;
    AgentID id;
    Latitude latitude;
    Longitude longitude;
    Power power;
    Sensitivity sensitivity ;
    int size;
    Groundspeed speed;
    Time time;
    static A_Command theCommand;
    static CommandManagers managers = CommandManagers.getInstance();

	public static class Create{

		public static void evaluateCreateCommand(String cmd) {
			if( cmd.contains("window") && cmd.contains("top") && cmd.contains("view") && cmd.contains("with")) {
				CommandViewCreateWindowTop(cmd);
			}
			else if(cmd.contains("delete") && cmd.contains("window")) {
				CommandViewDeleteWindow(cmd);
			}
			else if(cmd.contains("create actor") && cmd.contains("course") && cmd.contains("speed")) {
				CommandActorCreateActor(cmd);
			}

		}



    	public static void CommandViewCreateWindowTop(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[2]);
			int topViewSize = Integer.parseInt(words[6]);

			String lat1 = words[7].substring(1);
			String[] lat1Split1 = lat1.split("\\*");
			int lat1Degrees = Integer.parseInt(lat1Split1[0]);
			String[] lat1Split2 = lat1Split1[1].split("'");
			int lat1Minutes = Integer.parseInt(lat1Split2[0]);
			String[] lat1Split3 = lat1Split2[1].split("\"");
			double lat1Seconds = Double.valueOf(lat1Split3[0].substring(0,lat1Split3[0].length()-1));
			Latitude latitude1 = new Latitude(lat1Degrees, lat1Minutes, lat1Seconds);

			String lat2 = words[8];
			String[] lat2Split1 = lat2.split("\\*");
			int lat2Degrees = Integer.parseInt(lat2Split1[0]);
			String[] lat2Split2 = lat2Split1[1].split("'");
			int lat2Minutes = Integer.parseInt(lat2Split2[0]);
			String[] lat2Split3 = lat2Split2[1].split("\"");
			double lat2Seconds = Double.valueOf(lat2Split3[0].substring(0,lat2Split3[0].length()-1));
			Latitude latitude2 = new Latitude(lat2Degrees, lat2Minutes, lat2Seconds);

			String lat3 = words[9].substring(0, words[9].length()-1);
			String[] lat3Split1 = lat3.split("\\*");
			int lat3Degrees = Integer.parseInt(lat3Split1[0]);
			String[] lat3Split2 = lat3Split1[1].split("'");
			int lat3Minutes = Integer.parseInt(lat3Split2[0]);
			String[] lat3Split3 = lat3Split2[1].split("\"");
			double lat3Seconds = Double.valueOf(lat3Split3[0].substring(0,lat3Split3[0].length()-1));
			Latitude latitude3 = new Latitude(lat3Degrees, lat3Minutes, lat3Seconds);


			String long1 = words[10].substring(1);
			String[] long1Split1 = long1.split("\\*");
			int long1Degrees = Integer.parseInt(long1Split1[0]);
			String[] long1Split2 = long1Split1[1].split("'");
			int long1Minutes = Integer.parseInt(long1Split2[0]);
			String[] long1Split3 = long1Split2[1].split("\"");
			double long1Seconds = Double.valueOf(long1Split3[0].substring(0,long1Split3[0].length()-1));
			Longitude longitude1 = new Longitude(long1Degrees, long1Minutes, long1Seconds);

			String long2 = words[11];
			String[] long2Split1 = long2.split("\\*");
			int long2Degrees = Integer.parseInt(long2Split1[0]);
			String[] long2Split2 = long2Split1[1].split("'");
			int long2Minutes = Integer.parseInt(long2Split2[0]);
			String[] long2Split3 = long2Split2[1].split("\"");
			double long2Seconds = Double.valueOf(long2Split3[0].substring(0,long2Split3[0].length()-1));
			Longitude longitude2 = new Longitude(long2Degrees, long2Minutes, long2Seconds);

			String long3 = words[12].substring(0, words[12].length()-1);
			String[] long3Split1 = long3.split("\\*");
			int long3Degrees = Integer.parseInt(long3Split1[0]);
			String[] long3Split2 = long3Split1[1].split("'");
			int long3Minutes = Integer.parseInt(long3Split2[0]);
			String[] long3Split3 = long3Split2[1].split("\"");
			double long3Seconds = Double.valueOf(long3Split3[0].substring(0,long3Split3[0].length()-1));
			Longitude longitude3 = new Longitude(long3Degrees, long3Minutes, long3Seconds);

			theCommand = new CommandViewCreateWindowTop(managers, cmd, id, topViewSize, latitude1, latitude2, latitude3, longitude1, longitude2, longitude3);

		}

		public static void CommandViewDeleteWindow(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[2]);
			theCommand = new CommandViewDeleteWindow(managers, cmd, id);
		}

		public static void CommandActorCreateActor(String cmd) {
		String[] words = cmd.split(" ");
		AgentID id1 = new AgentID(words[1]);
		AgentID id2 = new AgentID(words[4]);

		String[] coor = words[4].split("/");
		String lat = coor[0];
		int degrees = Integer.parseInt(lat.split("\\*")[0]);
		lat = lat.split("\\*")[1];
		int minutes = Integer.parseInt(lat.split("'")[0]);
		lat = lat.split("'")[1];
		double seconds = Double.parseDouble(lat.split("\"")[0]);
		Latitude latitude = new Latitude(degrees, minutes, seconds);

		lat = coor[1];
		degrees = Integer.parseInt(lat.split("\\*")[0]);
		lat = lat.split("\\*")[1];
		minutes = Integer.parseInt(lat.split("'")[0]);
		lat = lat.split("'")[1];
		seconds = Double.parseDouble(lat.split("\"")[0]);
		Longitude longitude = new Longitude(degrees, minutes, seconds);

		Altitude altitude = new Altitude(Double.parseDouble(coor[2]));
		CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude);
		Course course = new Course(Double.parseDouble(words[7]));
		Groundspeed speed = new Groundspeed(Double.parseDouble(words[9]));
		theCommand = new CommandActorCreateActor(managers, cmd, id1, id2, position, course, speed);
	}

    }//end of Create class

    public static class DefineAndUndefine {

		public static void evaluateDefineCommand(String cmd) {
			if(cmd.contains("munition") && cmd.contains("bomb")) {
				CommandMunitionDefineBomb(cmd);
			}
			else if(cmd.contains("munition") && cmd.contains("shell")) {
				CommandMunitionDefineShell(cmd);
			}
			else if(cmd.contains("sensor") && cmd.contains("radar") && cmd.contains("with field of view")) {
				CommandSensorDefineRadar(cmd);
			}
			else if(cmd.contains("sensor thermal") && cmd.contains("with field of view")) {
				CommandSensorDefineThermal(cmd);
			}
			else if(cmd.contains("sensor sonar") && cmd.contains("active") && cmd.contains("with power")) {
				CommandSensorDefineSonarActive(cmd);
			}
			else if(cmd.contains("sensor sonar") && cmd.contains("passive") && cmd.contains("with sensitivity")) {
				CommandSensorDefineSonarPassive(cmd);
			}
			else if(cmd.contains("sensor acoustic")) {
				CommandSensorDefineAcoustic(cmd);
			}
			else if(cmd.contains("sensor depth")) {
				CommandSensorDefineDepth(cmd);
			}
			else if(cmd.contains("sensor distance")) {
				CommandSensorDefineDistance(cmd);
			}
			else if(cmd.contains("sensor time")) {
				CommandSensorDefineTime(cmd);
			}
			else if(cmd.contains("munition depth_charge")) {
				CommandMunitionDefineDepthCharge(cmd);
			}
			else if(cmd.contains("munition torpedo")) {
				CommandMunitionDefineTorpedo(cmd);
			}
			else if(cmd.contains("munition missile")) {
				CommandMunitionDefineMissile(cmd);
			}
			else if(cmd.contains("define ship") && cmd.contains("with munition")) {
				CommandActorDefineShip(cmd);
			}
		}


    	//define sensor sonar active id with power power sensitivity sensitivity
    	public static void CommandSensorDefineSonarActive(String cmd) {
    		String[] words = cmd.split(" ");
    		AgentID id = new AgentID(words[3]);
    		Power power = new Power(Double.valueOf(words[10]));
    		Sensitivity sensitivity = new Sensitivity(Double.parseDouble(words[6]));
    		theCommand = new CommandSensorDefineSonarActive(managers, cmd, id, power, sensitivity);
    	}

	//define sensor sonar passive id with sensitivity sensitivity
    	public static void CommandSensorDefineSonarPassive(String cmd) {
    		String[] words = cmd.split(" ");
    		AgentID id = new AgentID(words[3]);
    		Sensitivity sensitivity = new Sensitivity(Double.parseDouble(words[6]));
    		theCommand = new CommandSensorDefineSonarPassive(managers, cmd, id, sensitivity);
    	}

    	public static void CommandMunitionDefineBomb(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[3]);
			theCommand = new CommandMunitionDefineBomb(managers, cmd, id);
		}

		public static void CommandMunitionDefineShell(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[3]);
			theCommand = new CommandMunitionDefineShell(managers, cmd, id);
		}

		public static void CommandSensorDefineRadar(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[3]);
			AngleNavigational angle = new AngleNavigational(Double.valueOf(words[8]));
			fov = new FieldOfView(angle);
			Power power = new Power(Double.valueOf(words[10]));
			Sensitivity sensitivity = new Sensitivity(Double.valueOf(words[12]));
			theCommand = new CommandSensorDefineRadar(managers, cmd, id, fov, power, sensitivity);
		}

		public static void CommandSensorDefineThermal(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[3]);
			AngleNavigational angle = new AngleNavigational(Double.valueOf(words[8]));
			fov = new FieldOfView(angle);
			Sensitivity sensitivity = new Sensitivity(Double.valueOf(words[10]));
			theCommand = new CommandSensorDefineThermal(managers, cmd, id, fov, sensitivity);
		}

		public static void CommandMunitionDefineDepthCharge(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idMunition = new AgentID(words[3]);
			AgentID idFuze = new AgentID(words[6]);
			theCommand = new CommandMunitionDefineDepthCharge(managers, cmd, idMunition, idFuze);
		}

		public static void CommandMunitionDefineTorpedo(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idMunition = new AgentID(words[3]);
			AgentID idSensor = new AgentID(words[6]);
			AgentID idFuze = new AgentID(words[8]);
			Time time = new Time(Double.parseDouble(words[11]));
			theCommand = new CommandMunitionDefineTorpedo(managers, cmd, idMunition, idSensor, idFuze, time);
		}

		public static void CommandMunitionDefineMissile(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idMunition = new AgentID(words[3]);
			AgentID idSensor = new AgentID(words[6]);
			AgentID idFuze = new AgentID(words[8]);
			DistanceNauticalMiles distance = new DistanceNauticalMiles(Double.parseDouble(words[11]));
			theCommand = new CommandMunitionDefineMissile(managers, cmd, idMunition, idSensor, idFuze, distance);
		}

		public static void CommandSensorDefineAcoustic(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idSensor = new AgentID(words[3]);
			Sensitivity sensitivity = new Sensitivity(Double.parseDouble(words[6]));
			theCommand = new CommandSensorDefineAcoustic(managers, cmd, idSensor, sensitivity);
		}

		public static void CommandSensorDefineDepth(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idSensor = new AgentID(words[3]);
			Altitude depth = new Altitude(Double.parseDouble(words[7]));
			theCommand = new CommandSensorDefineDepth(managers, cmd, idSensor, depth);
		}

		public static void CommandSensorDefineDistance(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idSensor = new AgentID(words[3]);
			DistanceNauticalMiles distance = new DistanceNauticalMiles(Double.parseDouble(words[7]));
			theCommand = new CommandSensorDefineDistance(managers, cmd, idSensor, distance);
		}

		public static void CommandSensorDefineTime(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idSensor = new AgentID(words[3]);
			Time time = new Time(Double.parseDouble(words[7]));
			theCommand = new CommandSensorDefineTime(managers, cmd, idSensor, time);
		}

		//define ship id1 with munition[s] (idn+)
    		public static void CommandActorDefineShip(String cmd) {
    			String[] words = cmd.split(" ");
    			AgentID id1 = new AgentID(words[1]);
    			AgentID idn = new AgentID(words[4]);
    			theCommand = new CommandActorDefineShip(managers, cmd, id1, null);
    		}

    }//end of DefineAndUndefine class

    public static class Set {

		public static void evaluateSetCommand(String cmd) {
			if(cmd.contains("load munition")) {
				CommandActorLoadMunition(cmd);
			}
			else if(cmd.contains("deploy munition") && cmd.contains("at azimuth")) {
				CommandActorDeployMunitionShell(cmd);
			}
			else if(cmd.contains("set") && cmd.contains("course")) {
            			CommandActorSetCourse(cmd);
            		}
            		else if(cmd.contains("set") && cmd.contains("speed")) {
            			CommandActorSetSpeed(cmd);
            		}
            		else if(cmd.contains("set") && cmd.contains("altitude") && cmd.contains("depth")) {
            			CommandActorSetAltitudeDepth(cmd);
            		}
			else if(cmd.contains("set") && cmd.contains("deploy munition")) {
				CommandActorDeployMunition(cmd);
			}

		}


	//set id course course
    	public static void CommandActorSetCourse(String cmd) {
    		String[] words = cmd.split(" ");
    		AgentID id = new AgentID(words[1]);
    		Course course = new Course(Double.parseDouble(words[7]));
    		theCommand = new CommandActorSetCourse(managers, cmd, id, course);
    	}

    	//set id speed speed
    	public static void CommandActorSetSpeed(String cmd) {
    		String[] words = cmd.split(" ");
    		AgentID id = new AgentID(words[1]);
    		Groundspeed speed = new Groundspeed(Double.parseDouble(words[9]));
    		theCommand = new CommandActorSetSpeed(managers, cmd, id, speed);
    	}

    	//set id altitude|depth altitude
    	public static void CommandActorSetAltitudeDepth(String cmd) {
    		String[] words = cmd.split(" ");
    		AgentID id = new AgentID(words[1]);
    		Altitude altitude = new Altitude(Double.parseDouble(words[7]));
    		theCommand = new CommandActorSetAltitudeDepth(managers, cmd, id, altitude);	
    	}

    	//set id1 deploy munition id2
    	public static void CommandActorDeployMunition(String cmd) {
    		String[] words = cmd.split(" ");
    		AgentID id1 = new AgentID(words[1]);
    		AgentID id2 = new AgentID(words[4]);
    		theCommand = new CommandActorDeployMunition(managers, cmd, id1, id2);
    	}

    	public static void CommandActorLoadMunition(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id1 = new AgentID(words[1]);
			AgentID id2 = new AgentID(words[4]);
			theCommand = new CommandActorLoadMunition(managers, cmd, id1, id2);
		}

		public static void CommandActorDeployMunitionShell(String cmd) {
			String[] words = cmd.split(" ");
			AgentID idActor = new AgentID(words[1]);
			AgentID idMunition = new AgentID(words[4]);
			AttitudeYaw azimuth = new AttitudeYaw(Double.parseDouble(words[7]));
			AttitudePitch elevation = new AttitudePitch(Double.parseDouble(words[11]));
			theCommand = new CommandActorDeployMunitionShell(managers, cmd, idActor, idMunition, azimuth, elevation);
		}

    }//end of set class

    public static class Misc {

    	public static void evaluateMiscCommand(String cmd) {
    		if(cmd.contains("@load")) {
    			CommandMiscLoad(cmd);
			}
    		else if(cmd.contains("@pause")) {
    			CommandMiscPause(cmd);
			}
		else if(cmd.contains("@resume")) {
			CommandMiscResume(cmd);
			}
    		else if(cmd.contains("@wait")) {
    			CommandMiscWait(cmd);
			}
    		else if(cmd.contains("@exit")) {
				CommandMiscExit(cmd);
			}
		else if(cmd.contains("@set update")) {
			CommandMiscSetUpdate(cmd);
			}
		else if(cmd.contains("@force")) {
			CommandActorSetState(cmd);
			}

		}

	//set update time
    	public static void CommandMiscSetUpdate(String cmd) {
    		String[] words = cmd.split(" ");
    		Time time = new Time(Double.parseDouble(words[1]));
    		theCommand = new CommandMiscSetUpdate(managers,cmd, time);
    	}

    	public static void CommandMiscLoad(String cmd) {
			String[] words = cmd.split(" ");
			String filename = words[1].substring(1, words[1].length()-1);
			theCommand = new CommandMiscLoad(managers, cmd, filename);
		}

		public static void CommandMiscPause(String cmd) {
			theCommand = new CommandMiscPause(managers, cmd);
		}

		public static void CommandMiscResume(String cmd) {
			theCommand = new CommandMiscResume(managers, cmd);
		}

		public static void CommandMiscWait(String cmd) {
			String[] words = cmd.split(" ");
			Time time = new Time(Double.parseDouble(words[1]));
    		theCommand = new CommandMiscWait(managers, cmd, time);
		}

		public static void CommandActorSetState(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[1]);

			String[] coor = words[4].split("/");
			String lat = coor[0];
			int degrees = Integer.parseInt(lat.split("\\*")[0]);
			lat = lat.split("\\*")[1];
			int minutes = Integer.parseInt(lat.split("'")[0]);
			lat = lat.split("'")[1];
			double seconds = Double.parseDouble(lat.split("\"")[0]);
			Latitude latitude = new Latitude(degrees, minutes, seconds);

			lat = coor[1];
			degrees = Integer.parseInt(lat.split("\\*")[0]);
			lat = lat.split("\\*")[1];
			minutes = Integer.parseInt(lat.split("'")[0]);
			lat = lat.split("'")[1];
			seconds = Double.parseDouble(lat.split("\"")[0]);
			Longitude longitude = new Longitude(degrees, minutes, seconds);

			Altitude altitude = new Altitude(Double.parseDouble(coor[2]));

			CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude);
			Course course = new Course(Double.parseDouble(words[7]));
			Groundspeed speed = new Groundspeed(Double.parseDouble(words[9]));
			theCommand = new CommandActorSetState(managers, cmd, id, position, course, speed);
		}

		public static void CommandMiscExit(String cmd) {
			theCommand = new CommandMiscExit(managers, cmd);
		}

    }//end of misc class


	public void evaluate(String command) throws RuntimeException {

    	String[] commands = command.split(";");

    	for(int i = 0; i < commands.length; i++) {
    		String oneCommand = commands[i];
			String[] cmd = oneCommand.split(" ");
			if (cmd[0].equals("create") || cmd[0].equals("delete")) {
				Create.evaluateCreateCommand(oneCommand);
			} else if (cmd[0].equals("define") || cmd[0].equals("undefine")) {
				DefineAndUndefine.evaluateDefineCommand(oneCommand);
			} else if (cmd[0].equals("set")) {
				Set.evaluateSetCommand(oneCommand);
			} else {
				Misc.evaluateMiscCommand(oneCommand);
			}
		}
	}

}
