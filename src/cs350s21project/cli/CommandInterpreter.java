package cs350s21project.cli;

import cs350s21project.controller.command.*;
import cs350s21project.controller.command.misc.CommandMiscExit;
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
    FieldOfView fov;
    AgentID id;
    Latitude latitude;
    Longitude longitude;
    Power power;
    Sensitivity sensitivity ;
    int size;
    Groundspeed speed;
    Time time;
    static A_Command theCommand;


    public static class Create{

		public static void evaluateCreateCommand(String cmd) {
			if( cmd.contains("window") && cmd.contains("top") && cmd.contains("view") && cmd.contains("with")) {
				CommandViewCreateWindowTop(cmd);
			}
			else if(cmd.contains("delete") && cmd.contains("window")) {
				CommandViewDeleteWindow(cmd);
			}

		}

    	//define ship id1 with munition[s] (idn+)
    	public void CommandActorDefineShip(AgentID idn) {

    	}

    	public static void CommandViewCreateWindowTop(String cmd) {
			String[] words = cmd.split(" ");
			AgentID id = new AgentID(words[2]);
			int topViewSize = Integer.parseInt(words[6]);

			String lat1 = words[7].substring(1);
			String[] lat1Split1 = lat1.split("//*");
			int lat1Degrees = Integer.parseInt(lat1Split1[0]);
			String[] lat1Split2 = lat1Split1[1].split("//'");
			int lat1Minutes = Integer.parseInt(lat1Split2[0]);
			String[] lat1Split3 = lat1Split2[1].split("//");
			double lat1Seconds = Double.valueOf(lat1Split3[0]);
			Latitude latitude1 = new Latitude(lat1Degrees, lat1Minutes, lat1Seconds);

			String lat2 = words[8];
			String[] lat2Split1 = lat2.split("//*");
			int lat2Degrees = Integer.parseInt(lat2Split1[0]);
			String[] lat2Split2 = lat2Split1[1].split("//'");
			int lat2Minutes = Integer.parseInt(lat2Split2[0]);
			String[] lat2Split3 = lat2Split2[1].split("//");
			double lat2Seconds = Double.valueOf(lat2Split3[0]);
			Latitude latitude2 = new Latitude(lat2Degrees, lat2Minutes, lat2Seconds);

			String lat3 = words[9].substring(0, words[9].length()-1);
			String[] lat3Split1 = lat3.split("//*");
			int lat3Degrees = Integer.parseInt(lat3Split1[0]);
			String[] lat3Split2 = lat3Split1[1].split("//'");
			int lat3Minutes = Integer.parseInt(lat3Split2[0]);
			String[] lat3Split3 = lat3Split2[1].split("//");
			double lat3Seconds = Double.valueOf(lat3Split3[0]);
			Latitude latitude3 = new Latitude(lat3Degrees, lat3Minutes, lat3Seconds);


			String long1 = words[10].substring(1);
			String[] long1Split1 = long1.split("//*");
			int long1Degrees = Integer.parseInt(long1Split1[0]);
			String[] long1Split2 = long1Split1[1].split("//'");
			int long1Minutes = Integer.parseInt(long1Split2[0]);
			String[] long1Split3 = long1Split2[1].split("//");
			double long1Seconds = Double.valueOf(long1Split3[0]);
			Longitude longitude1 = new Longitude(long1Degrees, long1Minutes, long1Seconds);

			String long2 = words[11];
			String[] long2Split1 = long2.split("//*");
			int long2Degrees = Integer.parseInt(long2Split1[0]);
			String[] long2Split2 = long2Split1[1].split("//'");
			int long2Minutes = Integer.parseInt(long2Split2[0]);
			String[] long2Split3 = long2Split2[1].split("//");
			double long2Seconds = Double.valueOf(long2Split3[0]);
			Longitude longitude2 = new Longitude(long2Degrees, long2Minutes, long2Seconds);

			String long3 = words[12].substring(0, words[12].length()-1);
			String[] long3Split1 = long3.split("//*");
			int long3Degrees = Integer.parseInt(long3Split1[0]);
			String[] long3Split2 = long3Split1[1].split("//'");
			int long3Minutes = Integer.parseInt(long3Split2[0]);
			String[] long3Split3 = long3Split2[1].split("//");
			double long3Seconds = Double.valueOf(long3Split3[0]);
			Longitude longitude3 = new Longitude(long3Degrees, long3Minutes, long3Seconds);

			theCommand = new CommandViewCreateWindowTop(null, cmd, id, topViewSize, latitude1, latitude2, latitude3, longitude1, longitude2, longitude3);
			//Window window = new Window()

		}

		public static void CommandViewDeleteWindow(String cmd) {

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

		}

    	//define sensor sonar active id with power power sensitivity sensitivity
    	public static void CommandSensorDefineSonarActive(String cmd) {

    	}

    	//define sensor sonar passive id with sensitivity sensitivity
    	public static void CommandSensorDefineSonarPassive(String cmd) {

    	}

    	public static void CommandMunitionDefineBomb(String cmd) {

		}

		public static void CommandMunitionDefineShell(String cmd) {

		}

		public static void CommandSensorDefineRadar(String cmd) {

		}

		public static void CommandSensorDefineThermal(String cmd) {

		}

    }//end of DefineAndUndefine class

    public static class Set {

    	Groundspeed speed;
		Course course;
		Altitude altitude;

		public static void evaluateSetCommand(String cmd) {
			if(cmd.contains("load munition")) {
				CommandActorLoadMunition(cmd);
			}

		}

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

    	public static void CommandActorLoadMunition(String cmd) {

		}

    }//end of set class

    public static class Misc {

		static Time time;

    	public static void evaluateMiscCommand(String cmd) {
    		if(cmd.contains("@load")) {
    			CommandMiscLoad(cmd);
			}
    		else if(cmd.contains("@pause")) {
    			CommandMiscPause(cmd);
			}
    		else if(cmd.contains("@exit")) {
				CommandMiscExit(cmd);
			}
		else if(cmd.contains("@set update")) {
			CommandMiscSetUpdate(cmd);
			}

		}

		//set update time
    	public static void CommandMiscSetUpdate(String cmd) {
    		time = time;
    	}

    	public static void CommandMiscLoad(String cmd) {

		}

		public static void CommandMiscPause(String cmd) {

		}

		public static void CommandMiscExit(String cmd) {

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


	//create actor id1 from id2 at coordinates with course course speed speed

}
