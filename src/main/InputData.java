package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Data class for containing global static information about Students and Courses
 * Adapted from provided project code
 * Source: Sethuraman, Amudha exemplary project from Resources
 * @author Mark Arita
 *
 */
public class InputData 
{
	//File paths
	final static String path_StudentScheduleFile = "resources/student_schedule.txt";
	final static String path_PrerequisiteFile = "resources/Prerequisites.txt";
	final static String path_Courses = "resources/course.txt";
		
	public static ArrayList<ArrayList<Integer>> studentPreferredSchedule;
	public static Map<Integer, String> courseHashMap = new HashMap<Integer, String>();
	public static Map<Integer, ArrayList<Integer>> preRequisiteHashMap;
	
	final static int TotalSemesterCount = 12; 
	final static int MaxCoursePerSemester = 2; 
	final static String FirstSemester = "Spring";	
}
