package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

import payroll.Employee;

import payroll.PaymentClassification;
import payroll.PaymentMethod;
import payroll.PayrollDatabase;
import payroll.Transaction;
import payroll.classification.HourlyClassification;
import payroll.classification.SalariedClassification;
import payroll.method.HoldMethod;
import payroll.trans.AddHourlyEmployeeTransaction;
import payroll.trans.AddSalariedEmployeeTransaction;

public class AddEmployeeTest {

	@Test
	public void testAddHourlyEmployeeTransaction() {
		int empId=1001;
		String name="Bill";
		String address="Home";
		double hourlyRate=12.5;
		Transaction t=new AddHourlyEmployeeTransaction(empId,name,address,hourlyRate);
		t.execute();
		//验证执行结果
		Employee e=PayrollDatabase.getEmployee(empId);//根据雇员编号读取雇员记录
		assertNotNull(e);//雇员存在
		assertEquals(empId,((Employee) e).getEmpId());
		assertEquals(name,e.getName());
		assertEquals(address,e.getAddress());
		PaymentClassification pc=e.getPaymentClassification();
		assertTrue(pc instanceof HourlyClassification);//中点工
		HourlyClassification hc=(HourlyClassification)pc;
		assertEquals(hourlyRate,hc.getHourlyRate(),0.01);//小时工资正确
		PaymentMethod pm=e.getPaymentMethod();
		assertTrue(pm instanceof HoldMethod);//支付方式
	}
	@Test
	public void testAddSalariedEmployeeTransaction() {
		int empId=1002;
		String name="Bill";
		String address="Home";
		double salary=2410.0;
		Transaction t=new AddSalariedEmployeeTransaction(empId,name,address,salary);
		t.execute();
		
		Employee e=PayrollDatabase.getEmployee(empId);//根据雇员编号读取雇员记录
		assertNotNull(e);//雇员存在
		
		assertEquals(name,e.getName());
		assertEquals(address,e.getAddress());
		PaymentClassification pc=e.getPaymentClassification();
		assertTrue(pc instanceof SalariedClassification);//月薪方式
		SalariedClassification sc=(SalariedClassification)pc;
		assertEquals(salary,sc.getSalary(),0.01);//月薪正确
		PaymentMethod pn=e.getPaymentMethod();
		assertTrue(pn instanceof HoldMethod);//支付方式
	}

	@Test
	public void testAddCommissionedEmployeeTransaction() {
		int empId=1001;
		String name="Bill";
		String address="Home";
		double salary=741.0;
		double commissionRate=0.02;
		Transaction t=new AddCommissionedEmployeeTransaction(empId,name,address,hourlyRate);
		t.execute();
		//验证执行结果
		Employee e=PayrollDatabase.getEmployee(empId);//根据雇员编号读取雇员记录
		assertNotNull(e);//雇员存在
		assertEquals(empId,((Employee) e).getEmpId());
		assertEquals(name,e.getName());
		assertEquals(address,e.getAddress());
		PaymentClassification pc=e.getPaymentClassification();
		assertTrue(pc instanceof CommissionedClassification);//中点工
		CommissionedClassification sc=(CommissionedClassification)pc;
		assertEquals(salary,sc.getSalary(),0.01);//小时工资正确
	
		assertEquals(commissionRate,sc.getCommissionRate(),0.0001);
	}
}
