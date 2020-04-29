package selfTest;

public class Engineer extends Employee{
	private String workZone;
	private String project;
	
	public Engineer(String name, int employeeNum, String workZone, String project) {
		/* Write the code */
		super(name, employeeNum);
		this.workZone = workZone;
		this.project = project;
	}
	
	public boolean equals(Object obj) {
		/* Write the code */
		if(obj == null)
			return false;
		else if(this.getClass() != obj.getClass())
			return false;
		else {
			Engineer tmp = (Engineer) obj;
			return (super.equals(tmp)) && (this.workZone.equals(tmp.workZone)) && (this.project.equals(tmp.project));
		}
	}
	
	public String toString() {
		/* Write the code */
		return super.toString() + "\nlocation : " + this.getDepartment() + ", " + this.workZone;
	}
}
