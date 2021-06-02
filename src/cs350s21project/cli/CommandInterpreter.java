package cs350s21project.cli;

import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.misc.CommandMiscExit;
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
    A_Command theCommand;


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

			String lat2 = words[8];
			String lat3 = words[9].substring(0, words[9].length()-1);

			String long1 = words[10].substring(1);
			String long2 = words[11];
			String long3 = words[12].substring(0, words[12].length()-1);



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
    	public void CommandSensorDefineSonarActive(String cmd) {

    	}

    	//define sensor sonar passive id with sensitivity sensitivity
    	public void CommandSensorDefineSonarPassive(String cmd) {

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

		Time time;

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
    		this.time = time;
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
