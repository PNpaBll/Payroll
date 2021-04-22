package payroll.trans;

import payroll.Transaction;

public class AddSalariedEmployeeTransaction implements Transaction {

	private int empId;
	private String name;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		this.empId = empId;
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
