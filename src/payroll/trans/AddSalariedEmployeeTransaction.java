package payroll.trans;

import payroll.Transaction;

public class AddSalariedEmployeeTransaction implements Transaction {

	private int empId;

	public AddSalariedEmployeeTransaction(int empId, String name, String address, double salary) {
		this.empId = empId;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
