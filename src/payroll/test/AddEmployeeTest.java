package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.Employee;

import payroll.PaymentClassification;
import payroll.PaymentMethod;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.HourlyClassification;
import payroll.method.HoldMethod;
import payroll.trans.AddHourlyEmployeeTransaction;

public class AddEmployeeTest {

	@Test
	public void testAddHourlyEmployeeTransaction() {
		int empId=1001;
		String name="Bill";
		String address="Home";
		double hourlyRate=12.5;
		Transaction t=new AddHourlyEmployeeTransaction(empId,name,address,hourlyRate);
		t.execute();
		//��ִ֤�н��
		Employee e=PayrollDatabase.getEmployee(empId);//���ݹ�Ա��Ŷ�ȡ��Ա��¼
		assertNotNull(e);//��Ա����
		assertEquals(empId,((Employee) e).getEmpId());
		assertEquals(name,e.getName());
		assertEquals(address,e.getAddress());
		PaymentClassification pc=e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);//�е㹤
		HourlyClassification hc=(HourlyClassification)pc;
		assertEquals(hourlyRate,hc.getHourlyRate(),0.01);//Сʱ������ȷ
		PaymentMethod pm=e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);//֧����ʽ
	}
	@Test
	public void testAddSalariedEmployeeTransaction() {
		int empId=1002;
		String name="Bill";
		String address="Home";
		double salary=2410.0;
		Transaction t=new AddSalariedEmployeeTransaction(empId,name,address,salary);
		t.execute();
		
		Employee e=PayrollDatabase.getEmployee(empId);//���ݹ�Ա��Ŷ�ȡ��Ա��¼
		assertNotNull(e);//��Ա����
		
		assertEquals(name,e.getName());
		assertEquals(address,e.getAddress());
		PaymentClassification pc=e.getPaymentClassification();
		assertTrue(pc instanceof SalariedClassification);//�е㹤
		
	}

}
