package com.learning.onlinebank.dao;


import org.springframework.stereotype.Repository;
@Repository
public class MySQLDAO {

/*	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	private static final Logger LOGGER = LoggerFactory.getLogger(MySQLDAO.class);
	
	
public List<Employee> getSearchEmployeeData(String first_name,String last_name, String emp_no,String email, String phone, String department){
		

		String shiptocountry=null;
		DataSource dataSource;
		Connection connection=null;
		List<Employee> employeedetails = new ArrayList<>();
		//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
		String selectquery="select emp.*,dept.dept_name,CONCAT(emp.first_name, ' ',emp.last_name) as fullname,(select CONCAT(first_name, ' ',last_name) from employees where emp_no=emp.manager_id) as managername from employees emp,dept_emp demp,departments dept where emp.emp_no=demp.emp_no and demp.dept_no=dept.dept_no and (emp.first_name=? or emp.last_name=? or emp.emp_no=? or emp.email=? or dept.dept_name=?)";
	
			try
		{
				  long startTime = System.nanoTime();
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if(null == dataSource){
				
			}

			connection = dataSource.getConnection();
			
			if(null == connection){
			
			}
			


	                 employeedetails=jdbcTemplate.query(
			    			selectquery,
			    			 new Object[] { first_name,last_name,emp_no,email,department }, 
			                (rs, rowNum) ->
			                        new Employee(
			                                rs.getString("emp.emp_no"),
			                                rs.getString("emp.birth_date"),
			                                rs.getString("emp.first_name"),
			                                rs.getString("emp.last_name"),
			                                rs.getString("emp.gender"),
			                                rs.getString("emp.hire_date"),
			                                rs.getString("emp.email"),
			                                rs.getString("emp.password"),
			                                rs.getString("emp.address1"),
			                                rs.getString("emp.address2"),
			                                rs.getString("emp.city"),
			                                rs.getString("emp.state"),
			                                rs.getString("emp.zip"),
			                                rs.getString("dept.dept_name"),
			                                rs.getString("fullname"),
			                                rs.getString("emp.theatre"),
			                                rs.getString("emp.phone"),
			                                rs.getString("managername")
			                        ));
			    	
			
			 
		}
		   catch (EmptyResultDataAccessException e) {
			   LOGGER.error(e.getMessage());
			   LOGGER.error("An error occurred while getting  employees info.", e);
	   } 
		   catch (SQLException e) {
			   LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while getting employees info.", e);
				
			
		}
			finally
			{
				try {
					connection.close();
				   } 
				catch (SQLException e) {
					
					LOGGER.error(e.getMessage());
					LOGGER.error("An error occurred while closing connection.", e);
					
					//e.printStackTrace();
				}
			}
			
			 return employeedetails;
	
				}
	
	public List<Employee> getAllEmployeeData(){
		

		
		String shiptocountry=null;
		DataSource dataSource;
		Connection connection=null;
		List<Employee> employeedetails = new ArrayList<>();
		//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
		String selectquery="select emp.*,dept.dept_name,CONCAT(emp.first_name, ' ',emp.last_name) as fullname,(select CONCAT(first_name, ' ',last_name) from employees where emp_no=emp.manager_id) as managername from employees emp,dept_emp demp,departments dept where emp.emp_no=demp.emp_no and demp.dept_no=dept.dept_no";
	
			try
		{
				  long startTime = System.nanoTime();
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if(null == dataSource){
				
			}

			connection = dataSource.getConnection();
			
			if(null == connection){
			
			}
			


	                 employeedetails=jdbcTemplate.query(
			    			selectquery,
			                (rs, rowNum) ->
			                        new Employee(
			                                rs.getString("emp.emp_no"),
			                                rs.getString("emp.birth_date"),
			                                rs.getString("emp.first_name"),
			                                rs.getString("emp.last_name"),
			                                rs.getString("emp.gender"),
			                                rs.getString("emp.hire_date"),
			                                rs.getString("emp.email"),
			                                rs.getString("emp.password"),
			                                rs.getString("emp.address1"),
			                                rs.getString("emp.address2"),
			                                rs.getString("emp.city"),
			                                rs.getString("emp.state"),
			                                rs.getString("emp.zip"),
			                                rs.getString("dept.dept_name"),
			                                rs.getString("fullname"),
			                                rs.getString("emp.theatre"),
			                                rs.getString("emp.phone"),
			                                rs.getString("managername")
			                        ));
			    	
			
			 
		}
		   catch (EmptyResultDataAccessException e) {
			   LOGGER.error(e.getMessage());
			   LOGGER.error("An error occurred while getting  employees info.", e);
	   } 
		   catch (SQLException e) {
			   LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while getting employees info.", e);
				
			
		}
			finally
			{
				try {
					connection.close();
				   } 
				catch (SQLException e) {
					
					LOGGER.error(e.getMessage());
					LOGGER.error("An error occurred while closing connection.", e);
					
					//e.printStackTrace();
				}
			}
			
			 return employeedetails;
	
				}
	
public List<Employee> getEmployeeData(String parameter){
		

	  System.out.println("Hello here");
		DataSource dataSource;
		Connection connection=null;
		String hrflag;
		List<Employee> employeedetails = new ArrayList<>();
		String emp_no=null;
		if(parameter.contains("@"))
		{
			String empnoquery = "select emp_no from  employees  where email=?";
			emp_no=jdbcTemplate.queryForObject(empnoquery,new Object[] {parameter},String.class);
		}
		else
		{
			emp_no=parameter;
		}
		
		//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
		 String selectquery="select emp.*,dept.dept_name,CONCAT(emp.first_name, ' ',emp.last_name) as fullname,(select CONCAT(first_name, ' ',last_name) from employees where emp_no=emp.manager_id) as managername from employees emp,dept_emp demp,departments dept where emp.emp_no=demp.emp_no and demp.dept_no=dept.dept_no and emp.emp_no="+emp_no;
		
		  String to_date="9999-01-01";
		  String countmanagerquery = "select role_id from  employees  where emp_no=?";
		  //String dep_noquery = "select manager_id from  employees  where emp_no=?";
		  //String managernamequery = "select CONCAT(first_name, ' ',last_name) as manager from  employees  where emp_no=(select manager_id from employees where emp_no=?)";
		  
		  int count=jdbcTemplate.queryForObject(countmanagerquery,new Object[] {emp_no},Integer.class);
		  System.out.println("count"+count);
		  String  dept_no=null;
		
		  String  managerflag=null;
		  if(count==1)
		  {
			  managerflag="Y";
			  hrflag="N";
		  }
		  else if(count==2)
		  {
			  managerflag="N";
			  hrflag="Y";
		  }
		  else 
		  {
		      managerflag="N";
	    	  hrflag="N";
		  }
		  
	
			try
		{
				  long startTime = System.nanoTime();
			dataSource = jdbcTemplate.getDataSource();
			connection = null;
			if(null == dataSource){
				
			}

			connection = dataSource.getConnection();
			
			if(null == connection){
			
			}
			
			long endTime = System.nanoTime();
			  System.out.println("Time taken to establish MySQL connection "+(endTime-startTime)/1000000);

	                 employeedetails=jdbcTemplate.query(
			    			selectquery,
			                (rs, rowNum) ->
			                        new Employee(
			                                rs.getString("emp.emp_no"),
			                                rs.getString("emp.birth_date"),
			                                rs.getString("emp.first_name"),
			                                rs.getString("emp.last_name"),
			                                rs.getString("emp.gender"),
			                                rs.getString("emp.hire_date"),
			                                rs.getString("emp.email"),
			                                rs.getString("emp.password"),
			                                rs.getString("emp.address1"),
			                                rs.getString("emp.address2"),
			                                rs.getString("emp.city"),
			                                rs.getString("emp.state"),
			                                rs.getString("emp.zip"),
			                                rs.getString("dept.dept_name"),
			                                rs.getString("fullname"),
			                                rs.getString("emp.theatre"),
			                                rs.getString("emp.phone"),
			                                rs.getString("managername")
			                        ));
	                 
	                 employeedetails.get(0).setManagerflag(managerflag);
	                 employeedetails.get(0).setHrflag(hrflag);
		}
		   catch (EmptyResultDataAccessException e) {
			   LOGGER.error(e.getMessage());
			   LOGGER.error("An error occurred while getting  employees info.", e);
	   } 
		   catch (SQLException e) {
			   LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while getting employees info.", e);
				
			
		}
			finally
			{
				try {
					connection.close();
				   } 
				catch (SQLException e) {
					
					LOGGER.error(e.getMessage());
					LOGGER.error("An error occurred while closing connection.", e);
					
				}
			}
			
			 return employeedetails;
	
				}



public List<Employee> getmanagerEmployeeData(String emp_no){
	

	System.out.println("Here");

	DataSource dataSource;
	Connection connection=null;
	List<Employee> employeedetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	 
	  String countmanagerquery = "select role_id from  employees  where emp_no=?";
	  String dep_noquery = "select dept_no from  dept_manager  where emp_no=? and to_date=?";
	  String to_date="9999-01-01";
		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}
		
		 int count=jdbcTemplate.queryForObject(countmanagerquery,new Object[] {emp_no},Integer.class);
		 
		 System.out.println("count"+count);
		 if(count==1)
		 {
			 
			 String dept_no =jdbcTemplate.queryForObject(dep_noquery,new Object[] {emp_no,to_date},String.class);
			 System.out.println("dept_no"+dept_no);
			 String selectquery="select emp.*,dept.dept_name,CONCAT(emp.first_name, ' ',emp.last_name) as fullname,(select CONCAT(first_name, ' ',last_name) from employees where emp_no=emp.manager_id) as managername from employees emp, dept_emp demp,departments dept where demp.dept_no=dept.dept_no and emp.emp_no=demp.emp_no and demp.dept_no=?";

                 employeedetails=jdbcTemplate.query(
                			selectquery,
  		    			  new Object[] { dept_no }, 
  		                (rs, rowNum) ->
		                        new Employee(
		                                rs.getString("emp.emp_no"),
		                                rs.getString("emp.birth_date"),
		                                rs.getString("emp.first_name"),
		                                rs.getString("emp.last_name"),
		                                rs.getString("emp.gender"),
		                                rs.getString("emp.hire_date"),
		                                rs.getString("emp.email"),
		                                rs.getString("emp.password"),
		                                rs.getString("emp.address1"),
		                                rs.getString("emp.address2"),
		                                rs.getString("emp.city"),
		                                rs.getString("emp.state"),
		                                rs.getString("emp.zip"),
		                                rs.getString("dept.dept_name"),
		                                rs.getString("fullname"),
		                                rs.getString("emp.theatre"),
		                                rs.getString("emp.phone"),
		                                rs.getString("managername")
		                        ));
		    	
		 }
		 
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getting  employees info.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getting employees info.", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
				//e.printStackTrace();
			}
		}
		
		 return employeedetails;

			}

public int updateEmployee(Employee employee)
{
	try{
		
	 String UPDATE_QUERY  = "update employees set email=?,first_name=?,last_name=?,address1=?,address2=?,city=?,state=?,zip=?,theatre=?,phone=? where emp_no=?";
	 
	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(UPDATE_QUERY , employee.getEmail(),employee.getFirst_name(),employee.getLast_name(),employee.getAddress1(),employee.getAddress2(),employee.getCity(),employee.getState(),employee.getZip(),employee.getTheatre(),employee.getPhone(),Integer.parseInt(employee.getEmp_no()));
	}
	catch(Exception e)
	{
		System.out.println("Exception while Updating Employee"+e);
		return 0;
		
}
	
}

public int insertleave(Leave leave)
{
	try{
	 String INSERT_QUERY = "insert into leaves (leave_type,emp_no,created_date,from_date,to_date,reason,approval_status,approver_id,approval_date) values (?, ?,?, ?,?, ?,?, ?,?)";
	 
	  
	    
	    Date fromdate=new SimpleDateFormat("yyyy-MM-dd").parse(leave.getFrom_date());  
	    Date todate=new SimpleDateFormat("yyyy-MM-dd").parse(leave.getTo_date()); 
	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),new Date(),fromdate,todate,leave.getReason(),leave.getApproval_status(),null,null);
	}
	catch(Exception e)
	{
		System.out.println("Exception while submitting leave"+e);
		return 0;
		
}
	
}


public int insertExpense(Expense expense)
{
	try{
	 String INSERT_QUERY = "insert into expense (emp_no,expense_type,description,amount,status,approver_id,created_date,approve_date) values (?, ?,?, ?,?, ?,?, ?)";

	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(INSERT_QUERY, Integer.parseInt(expense.getEmp_no()),expense.getExpense_type(),expense.getDescription(),expense.getAmount(),"Pending",null,new Date(),null);
	}
	catch(Exception e)
	{
		System.out.println("Exception while submitting expense"+e);
		return 0;
		
}
	
}

public int updateexpense(Expense expense)
{
	try{
		
	 String UPDATE_QUERY  = "update expense set status=?,approver_id=?,approve_date=? where expense_id=?";
	 
	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(UPDATE_QUERY , expense.getStatus(),expense.getApprover_id(),new Date(),Integer.parseInt(expense.getExpense_id()));
	}
	catch(Exception e)
	{
		System.out.println("Exception while Updating expense"+e);
		return 0;
		
}
	
}

public int updateleave(Leave leave)
{
	try{
		
	 String UPDATE_QUERY  = "update leaves set approval_status=?,approver_id=?,approvercomments=?,approval_date=? where leave_id=?";
	 
	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(UPDATE_QUERY , leave.getApproval_status(),leave.getApprover_id(),leave.getApprovercomments(),new Date(),Integer.parseInt(leave.getLeave_id()));
	}
	catch(Exception e)
	{
		System.out.println("Exception while Updating leave"+e);
		return 0;
		
}
	
}

public  List <Leave>getleaves(String empno, String status)
{

	DataSource dataSource;
	Connection connection=null;
	List<Leave> leavedetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	//String selectquery="select lea.* from leaves lea,dept_emp demp where lea.emp_no=demp.emp_no and demp.dept_no=? and lea.approval_status=? and ";
	
	String selectquery1="select lea.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from leaves lea,employees emp where lea.emp_no=emp.emp_no and emp.manager_id=? and lea.approval_status=?";
	
	System.out.println(selectquery1);

		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}
		
		long endTime = System.nanoTime();
		  System.out.println("Time taken to establish MySQL connection "+(endTime-startTime)/1000000);
		

	    	  
	      
		  
		  leavedetails=jdbcTemplate.query(
				  selectquery1,
		    			  new Object[] { empno, status }, 
		                (rs, rowNum) ->
		                        new Leave(
		                                rs.getString("leave_id"),
		                                rs.getInt("emp_no"),
		                                rs.getString("created_date"),
		                                rs.getString("leave_type"),
		                                rs.getString("from_date"),
		                                rs.getString("to_date"),
		                                rs.getString("approval_status"),
		                                rs.getString("reason"),
		                                rs.getString("approval_date"),
		                                rs.getInt("approver_id"),
		                                rs.getString("approvercomments"),
		                                rs.getString("empname")
		                        ));
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getleaves.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getleaves", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return leavedetails;
	
}


public  List <Leave>getAllLeaves(String empno)
{

	DataSource dataSource;
	Connection connection=null;
	List<Leave> leavedetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	String selectquery="select lea.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from leaves lea, employees emp where emp.emp_no=lea.emp_no and emp.emp_no=?";
	
	System.out.println(selectquery);

		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}
				  
		  leavedetails=jdbcTemplate.query(
		    			selectquery,
		    			  new Object[] { empno }, 
		                (rs, rowNum) ->
		                        new Leave(
		                                rs.getString("leave_id"),
		                                rs.getInt("emp_no"),
		                                rs.getString("created_date"),
		                                rs.getString("leave_type"),
		                                rs.getString("from_date"),
		                                rs.getString("to_date"),
		                                rs.getString("approval_status"),
		                                rs.getString("reason"),
		                                rs.getString("approval_date"),
		                                rs.getInt("approver_id"),
		                                rs.getString("approvercomments"),
		                                rs.getString("empname")
		                        ));
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getleaves.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getleaves", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return leavedetails;
	
}
public  List <Expense>getpendingExpense(String empno, String status)
{
	DataSource dataSource;
	Connection connection=null;
	List<Expense> expensedetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	String selectquery="select exp.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from expense exp,employees emp where exp.emp_no=emp.emp_no and  emp.manager_id=? and exp.status=? ";
	
	System.out.println(selectquery);

	System.out.println("empno"+empno);
		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}

	    	  expensedetails=jdbcTemplate.query(
		    			selectquery,
		    			  new Object[] { empno, status }, 
		                (rs, rowNum) ->	    			
		                        new Expense(
		                                rs.getString("expense_id"),
		                                rs.getString("emp_no"),
		                                rs.getString("expense_type"),
		                                rs.getString("description"),
		                                rs.getString("amount"),
		                                rs.getString("status"),
		                                rs.getString("approver_id"),
		                                rs.getString("created_date"),
		                                rs.getString("approve_date"),
		                                rs.getString("empname")
		                        ));
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getleaves.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getleaves", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return expensedetails;
	
}

public  List <Expense>getAllExpense(String empno, String status)
{
	DataSource dataSource;
	Connection connection=null;
	List<Expense> expensedetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	String selectquery="select exp.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from expense exp,employees emp where exp.emp_no=emp.emp_no and exp.emp_no=? ";
	
	System.out.println(selectquery);

	System.out.println("empno"+empno);
		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}

	    	  expensedetails=jdbcTemplate.query(
		    			selectquery,
		    			  new Object[] { empno }, 
		                (rs, rowNum) ->	    			
		                        new Expense(
		                                rs.getString("expense_id"),
		                                rs.getString("emp_no"),
		                                rs.getString("expense_type"),
		                                rs.getString("description"),
		                                rs.getString("amount"),
		                                rs.getString("status"),
		                                rs.getString("approver_id"),
		                                rs.getString("created_date"),
		                                rs.getString("approve_date"),
		                                rs.getString("empname")
		                        ));
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getleaves.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getleaves", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return expensedetails;
	
}

public int insertPerformance(Performance performance)
{
	try{
	 String INSERT_QUERY = "insert into performance (emp_no,year,development_goals,strengths,accomplishments,responsibilities,created_date,approval_date,status,approver_comments,approver_id) values (?, ?,?, ?,?, ?,?, ?,?,?,?)";

	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(INSERT_QUERY, Integer.parseInt(performance.getEmp_no()),performance.getYear(),performance.getDevelopment_goals(),performance.getStrengths(),performance.getAccomplishments(),performance.getResponsibilities(),new Date(),null,"Pending",null,null);
	}
	catch(Exception e)
	{
		System.out.println("Exception while submitting expense"+e);
		return 0;
		
}
	
}


public  List <Performance>getpendingPerformance(String empno, String status)
{
	DataSource dataSource;
	Connection connection=null;
	List<Performance> perdetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	String selectquery="select per.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from performance per,employees emp where per.emp_no=emp.emp_no and emp.manager_id=? and per.status=? ";
	
	//String selectquery="select * from performance";
	System.out.println(selectquery);

	System.out.println("empno"+empno);
		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}
		      
		  
	    	  perdetails=jdbcTemplate.query(
		    			selectquery,
		    			  new Object[] { empno, status }, 
		                (rs, rowNum) ->	    			
		                        new Performance(
		                                rs.getString("performance_id"),
		                                rs.getString("emp_no"),
		                                rs.getString("year"),
		                                rs.getString("development_goals"),
		                                rs.getString("strengths"),
		                                rs.getString("accomplishments"),
		                                rs.getString("responsibilities"),
		                                rs.getString("created_date"),
		                                rs.getString("approval_date"),
		                                rs.getString("status"),
		                                rs.getString("approver_comments"),
		                                rs.getString("approver_id"),
		                                rs.getString("empname")
		                        ));
	    	  System.out.println("perdetails"+perdetails.size());
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getleaves.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getleaves", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return perdetails;
	
}

public  List <Performance>getlastyearPerformance(String empno, String status)
{
	DataSource dataSource;
	Connection connection=null;
	List<Performance> perdetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	String selectquery="select per.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from performance per,employees emp where per.emp_no=emp.emp_no and emp.emp_no=? and per.status!=? ORDER BY per.performance_id DESC LIMIT 1";
	
	//String selectquery="select * from performance";
	System.out.println(selectquery);

	System.out.println("empno"+empno);
		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}
		      
		  
	    	  perdetails=jdbcTemplate.query(
		    			selectquery,
		    			  new Object[] { empno, status }, 
		                (rs, rowNum) ->	    			
		                        new Performance(
		                                rs.getString("performance_id"),
		                                rs.getString("emp_no"),
		                                rs.getString("year"),
		                                rs.getString("development_goals"),
		                                rs.getString("strengths"),
		                                rs.getString("accomplishments"),
		                                rs.getString("responsibilities"),
		                                rs.getString("created_date"),
		                                rs.getString("approval_date"),
		                                rs.getString("status"),
		                                rs.getString("approver_comments"),
		                                rs.getString("approver_id"),
		                                rs.getString("empname")
		                        ));
	    	  System.out.println("perdetails"+perdetails.size());
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getleaves.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getleaves", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return perdetails;
	
}

public int updateperformance(Performance performance)
{
	try{
		
	 String UPDATE_QUERY  = "update performance set status=?,approver_id=?,approval_date=?,approver_comments=? where performance_id=?";
	 
	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(UPDATE_QUERY , performance.getStatus(),performance.getApprover_id(),new Date(),performance.getApprover_comments(),Integer.parseInt(performance.getPerformance_id()));
	}
	catch(Exception e)
	{
		System.out.println("Exception while Updating performance"+e);
		return 0;
		
}
	
}

public int insertTimesheet(Timesheet timesheet)
{
	try{
		
	    Date timesheetdate=new SimpleDateFormat("dd/MM/yyyy").parse(timesheet.getTimesheet_date());  
	    
	 String INSERT_QUERY = "insert into timesheet (emp_no,timesheet_date,timesheet_hours,tasks,created_date,approver_id,approval_date,approver_comments,status) values (?, ?,?, ?,?, ?,?, ?,?)";

	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(INSERT_QUERY, Integer.parseInt(timesheet.getEmp_no()),timesheetdate,timesheet.getTimesheet_hours(),timesheet.getTasks(),new Date(),null,null,null,"Pending");
	}
	catch(Exception e)
	{
		System.out.println("Exception while submitting timesheet"+e);
		return 0;
		
}
	
}

public int updateTimesheet(Timesheet timesheet)
{
	try{
		
	 String UPDATE_QUERY  = "update timesheet set status=?,approver_id=?,approval_date=?,approver_comments=? where timesheet_id=?";
	 
	 //return jdbcTemplate.update(INSERT_QUERY, leave.getLeave_type(),leave.getEmp_no(),leave.getCreated_date(),leave.getFrom_date(),leave.getTo_date(),leave.getReason(),leave.getApproval_status(),leave.getApprover_id(),leave.getApproval_date());
	 return jdbcTemplate.update(UPDATE_QUERY , timesheet.getStatus(),timesheet.getApprover_id(),new Date(),timesheet.getApprover_comments(),Integer.parseInt(timesheet.getTimesheet_id()));
	}
	catch(Exception e)
	{
		System.out.println("Exception while Updating performance"+e);
		return 0;
		
}
	
}

public  List <Timesheet>getpendingTimesheet(String empno, String status)
{
	DataSource dataSource;
	Connection connection=null;
	List<Timesheet> timesheetdetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	String selectquery="select time.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from timesheet time,employees emp where time.emp_no=emp.emp_no and emp.manager_id=? and time.status=?";
	
	//String selectquery="select * from performance";
	System.out.println(selectquery);

	System.out.println("empno"+empno);
		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}
		
		
  
	    	  timesheetdetails=jdbcTemplate.query(
		    			selectquery,
		    			  new Object[] { empno, status }, 
		                (rs, rowNum) ->	    			
		                        new Timesheet(
		                                rs.getString("timesheet_id"),
		                                rs.getString("emp_no"),
		                                rs.getString("timesheet_date"),
		                                rs.getString("timesheet_hours"),
		                                rs.getString("tasks"),
		                                rs.getString("created_date"),
		                                rs.getString("approver_id"),
		                                rs.getString("approval_date"),
		                                rs.getString("approver_comments"),
		                                rs.getString("status"),
		                                rs.getString("empname")
		                        ));
	    	  System.out.println("perdetails"+timesheetdetails.size());
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getpendingTimesheet.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getpendingTimesheet", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return timesheetdetails;
	
}

public  List <Timesheet>getAllTimesheet(String empno, String status)
{
	DataSource dataSource;
	Connection connection=null;
	List<Timesheet> timesheetdetails = new ArrayList<>();
	//String selectquery="select top 1 SHIP_TO_COUNTRY from  LEGAL_DB.LEGAL_DFI_BR.BV_CMPL_PLT_SERIAL_NUMBER  where LOWER_BP_SERIAL_NUMBER=? and CARTON_ID=? and LOWER_ITEM_SERIAL_NUMBER=?";
	String selectquery="select time.*,CONCAT(emp.first_name, ' ',emp.last_name) as empname from timesheet time,employees emp where time.emp_no=emp.emp_no and emp.emp_no=?";
	
	//String selectquery="select * from performance";
	System.out.println(selectquery);

	System.out.println("empno"+empno);
		try
	{
			  long startTime = System.nanoTime();
		dataSource = jdbcTemplate.getDataSource();
		connection = null;
		if(null == dataSource){
			
		}

		connection = dataSource.getConnection();
		
		if(null == connection){
		
		}
		
		
  
	    	  timesheetdetails=jdbcTemplate.query(
		    			selectquery,
		    			  new Object[] { empno }, 
		                (rs, rowNum) ->	    			
		                        new Timesheet(
		                                rs.getString("timesheet_id"),
		                                rs.getString("emp_no"),
		                                rs.getString("timesheet_date"),
		                                rs.getString("timesheet_hours"),
		                                rs.getString("tasks"),
		                                rs.getString("created_date"),
		                                rs.getString("approver_id"),
		                                rs.getString("approval_date"),
		                                rs.getString("approver_comments"),
		                                rs.getString("status"),
		                                rs.getString("empname")
		                        ));
	    	  System.out.println("perdetails"+timesheetdetails.size());
	      
	}
	   catch (EmptyResultDataAccessException e) {
		   LOGGER.error(e.getMessage());
		   LOGGER.error("An error occurred while getpendingTimesheet.", e);
   } 
	   catch (SQLException e) {
		   LOGGER.error(e.getMessage());
			LOGGER.error("An error occurred while getpendingTimesheet", e);
			
		
	}
		finally
		{
			try {
				connection.close();
			   } 
			catch (SQLException e) {
				
				LOGGER.error(e.getMessage());
				LOGGER.error("An error occurred while closing connection.", e);
				
			}
		}
		
		 return timesheetdetails;
	
}
*/
	}
