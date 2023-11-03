public class Employee {
    private String employeeName;
    private String Department;
    private String employeeID;
    private double incrementPercentage;
    private double overtimeperHour;
    private double salary; 

    public Employee(String employeeName,String Department ,String employeeID, double incrementPercentage, double salary, double overtimeHours) {
        this.employeeName = employeeName;
        this.Department= Department;
        this.employeeID = employeeID;
        this.incrementPercentage = incrementPercentage;
        this.salary = salary;
        this.overtimeperHour = overtimeHours;
    } 
    public String calculateEmployeeinceremnt(Employee[] employees, String employeeID, int overtime) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getEmployeeID().equals(employeeID)) {
                double Percentageofovertimehour = (double) overtime / 1920;
                double annualincrement = employees[i].getIncrementPercentage() * employees[i].getSalary();
                double annualincrementofovertime = Percentageofovertimehour * annualincrement;
                double totalannualincrement = annualincrement + annualincrementofovertime;
                double totalovertime = (employees[i].getOvertimeperHour() * overtime);
                return "The total annual increment for "+ employees[i].getEmployeeName() +" it will be: "+totalannualincrement+", and the total Overtime pay is: "+totalovertime+"\n";          
            }
        }
        return "Employee doesn't exist"+"\n";
    }
	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getDepartment() {
		return Department;
	}

	public double getIncrementPercentage() {
		return incrementPercentage;
	}

	public double getOvertimeperHour() {
		return overtimeperHour;
	}

	public double getSalary() {
		return salary;
	}
}

