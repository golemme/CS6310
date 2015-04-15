package main;



/**
 * Interface to Gurobi Solver
 * Adapted from provided project code
 * Source: Sethuraman, Amudha exemplary project from Resources
 * @author Mark Arita
 *
 */
public interface Solver 
{
	/**
	 * Solver method to Gurobi
	 * @param program: Program object containing Student, Course, and Semester information
	 * @throws Exception 
	 */
	public void Solve(Program program) throws Exception;

}
