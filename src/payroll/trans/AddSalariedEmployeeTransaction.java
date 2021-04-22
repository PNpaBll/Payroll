package payroll.trans;

import payroll.Employee;
import payroll.PayrollDatabase;
import payroll.Transaction;

public class AddSalariedEmployeeTransaction implements Transaction {

	private int empId;
	private String name;
	private String address;
	private double salary;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		this.empId = empId;
		// TODO Auto-generated constructor stub
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	@Override
	public void execute() {
		Employee employee=new Employee(empId,name,address);
		employee.setPaymentClassification(new SalariedClassification(salary));
		employee.setPaymentMethod(new HoldMethod());
		PayrollDatabase.save(employee);
	}

}
