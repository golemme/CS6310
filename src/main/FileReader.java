package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Adapted from provided project code
 * Source: Sethuraman, Amudha exemplary project from Resources
 * @author Mark Arita
 *
 */
public class FileReader 
{
	
	/**
	 * Reads basic input files about Students, Courses, and Course pre-requisites
	 */
	public static void ReadFiles()
	{
		InputData.studentPreferredSchedule = ReadStudentScheduleFile(InputData.path_StudentScheduleFile);
		InputData.courseHashMap = ReadCourseFile(InputData.path_Courses);
		InputData.preRequisiteHashMap = ReadPrerequisiteFile(InputData.path_PrerequisiteFile);
	}
	
	/**
	 * Reads Course file, containing all available courses and their titles
	 * @param path: Path to the Course file
	 * @return
	 */
	private static Map<Integer, String> ReadCourseFile(String path)
	{
		
		Map<Integer, String> result = new HashMap<Integer, String>();
		try 
		{
			FileInputStream fileStream = new FileInputStream(path);
			InputStreamReader in = new InputStreamReader(fileStream, "UTF-8");
			BufferedReader reader = new BufferedReader(in);
			
			String line = null;
			while ((line = reader.readLine()) != null) 
			{				
								
				if(line.startsWith("%")){ continue; }
				line = line.trim();
				
				String[] tokens = line.split(":");
				
				//only get lines with Course information
				int key; String value;
				if(tokens.length >= 2)
				{
					key = Integer.parseInt(tokens[0].trim());
					value = tokens[1].toString();
					result.put(key,  value);
				}												
			}
			reader.close();					
						
		} 
		catch (IOException x) 
		{
			System.err.format("IOException: %s%n", x);
		}
		
		return result;
	}
	
	/**
	 * Reads the Student file, containing information about all students and their desired courses
	 * @param path: Path to the file containing information about students
	 * @return
	 */
	private static ArrayList<ArrayList<Integer>> ReadStudentScheduleFile(String path) 
	{
		//Student is a list of integers of the Courses they want to take
		//We have a list of Students (lists)
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		try 
		{
			FileInputStream fileStream = new FileInputStream(path);
			InputStreamReader in = new InputStreamReader(fileStream, "UTF-8");
			BufferedReader reader = new BufferedReader(in);

			String line = null;
			while ((line = reader.readLine()) != null) 
			{
				
				if(line.startsWith("%")){ continue; }
				
				line = line.replace(".", "");
				line = line.trim();
				
				String[] tokens = line.split(" ");
				
				ArrayList<Integer> list = new ArrayList<Integer>();
				
				//Get all of the Courses for this student
				for(String token : tokens)
				{
					if(token.equals(""))continue;
					list.add(Integer.parseInt(token));
				}
				
				if(!list.isEmpty())
				{
					result.add(list);
				}									
			}
			reader.close();
		} 
		catch (IOException x) 
		{
			System.err.format("IOException: %s%n", x);
		}			
		
	    return result;
	}
	
	/**
	 * Reads all of the Course pre-requisites
	 * @param path: Path to the pre-requisites file
	 * @return
	 */
	 private static Map<Integer, ArrayList<Integer>> ReadPrerequisiteFile(String path)
	 {
			
		Map<Integer, ArrayList<Integer>> result = new HashMap<Integer, ArrayList<Integer>>();
		 
		try 
		{
			FileInputStream fileStream = new FileInputStream(path);
			InputStreamReader in = new InputStreamReader(fileStream, "UTF-8");
			BufferedReader reader = new BufferedReader(in);
			
			String line = null;
			while ((line = reader.readLine()) != null) 
			{
				if(line.startsWith("%")){ continue; }
				line = line.trim();
				
				String[] tokens = line.split(" ");
				
				//Get all of the pre-requisites for each Courses
				int key = 0;
				ArrayList<Integer> value = new ArrayList<Integer>();
				for(String token : tokens)
				{
					if(token.equals(""))
					{
						continue;
					}
					
					else if(token.contains(":"))
					{
						key = Integer.parseInt(token.replace(":", ""));
					}
					else
					{
						value.add(Integer.parseInt(token));
					}
				}
				
				result.put(key, value);	
			}
			
			reader.close();
			
		} 
		catch (IOException x) 
		{
			System.err.format("IOException: %s%n", x);
		}			
			
		return result;
	}

}
