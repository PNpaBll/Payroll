package payroll.trans;

import payroll.Employee;
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
		//新建雇员
		Employee employee=new Employee(empId,name,address);
		//设置工资计算方式
		employee.setPaymentClassification(new HourlyClassification(hourlyRate));
		
		
		
	}

}
