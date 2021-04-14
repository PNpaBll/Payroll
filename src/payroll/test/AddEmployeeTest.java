package payroll.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddEmployeeTest {

	@Test
	public void testAddHourlyEmployeeTransaction() {
		int empId=1001;
		String name="Bill";
		String address="Home";
		double  hourlyRate=12.5;
		//新建添加钟点工操作，并执行
		Transaction t=new AddHourlyEmployeeTransaction(empId,name,address,hourlyRate);
		t.execute();
		//验证执行结果
		Employee e=PayrollDatabase.getEmployee(empId)//根据雇员编号读取雇员记录
				
	}

}
