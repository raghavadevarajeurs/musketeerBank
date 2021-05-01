package com.learning.onlinebank;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class OnlineBankServiceTestEmployee {/*
	@Autowired
	private MySQLDAO mysqldao;
	
	@LocalServerPort
	private int port;
	private static final Logger LOGGER = LoggerFactory.getLogger(OneworforceServiceTestEmployee.class);

	@Test
	@Rollback(false)
	public void testGetEmployee() {
		String empNo = "10002";
		List<Employee> empDetails= mysqldao.getEmployeeData(empNo);
		assertNotNull(empDetails);
		assertEquals(empNo, empDetails.get(0).getEmp_no());
		for (Employee employee : empDetails) {
			LOGGER.info(employee.toString());
		}
	}
	
	@Test
	@Rollback(false)
	public void testGetAllEmployees() {
		List<Employee> employees = mysqldao.getAllEmployeeData();
		assertNotNull(employees);
		LOGGER.info("total size is " + employees.size());
		for (Employee employee : employees) {
			LOGGER.info(employee.toString());
		}
		
	}
	
	@Test
	@Rollback(false)
	public void testUpdateEmployee() throws JsonParseException, JsonMappingException, IOException {
		File file = new File(
		        this.getClass().getClassLoader().getResource("testEmployee.json").getFile()
		    ); 
		ObjectMapper mapper = new ObjectMapper();
		Employee employee = mapper.readValue(file, Employee.class);
		int returnCode = mysqldao.updateEmployee(employee);
		assertEquals(1, returnCode);
	}
	
	@Test
	@Rollback(false)
	public void testGetManagerEmployeeData() {
		String empNo = "10002";
		List<Employee> empMgrDetails= mysqldao.getmanagerEmployeeData(empNo);
		assertNotNull(empMgrDetails);
	}
*/}
