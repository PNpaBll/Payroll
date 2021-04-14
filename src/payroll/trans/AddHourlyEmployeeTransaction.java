package payroll.trans;

import payroll.Transaction;

public class AddHourlyEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double hourlyRate;

	public AddHourlyEmployeeTransaction(int empId, String name, String address, double hourlyRate) {
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public void execute() {
		//ÐÂ½¨¹ÍÔ±
		Employee employee=new Employee(empId,name,address);
		
		
		
		
	}

}
