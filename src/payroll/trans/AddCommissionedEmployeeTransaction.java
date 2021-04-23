package payroll.trans;

import payroll.PaymentClassification;

public class AddCommissionedEmployeeTransaction extends AddEmployeeTransaction {

	public AddCommissionedEmployeeTransaction(int empId, String name, String address, double salary,
			double commissionRate) {
		super(empId,name,address);
	}

	@Override
	protected PaymentClassification getPaymentClassification() {
		// TODO Auto-generated method stub
		return null;
	}

}
