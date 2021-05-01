package com.learning.onlinebank.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
    @RequestMapping("/Home")
    public String displayPLTHomePageNew(ModelMap model,HttpServletRequest req, HttpServletResponse res) {
    	  HttpSession session = req.getSession(false);
    	  System.out.println("Helllo");
  

	      return "home";
    
    }

	/*@Autowired
	private MySQLDAO mysqldao;


    
@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getEmployeeDetails")
public ResponseEntity<List<Employee>> getEmployeeDetails(@RequestParam String empid) {
  try {
	 
	List<Employee> employee = mysqldao.getEmployeeData(empid);
	  System.out.println("Emp No"+employee.get(0).getEmp_no());
	  System.out.println("Birth date"+employee.get(0).getBirth_date());
	  System.out.println("First name"+employee.get(0).getFirst_name());
	  System.out.println("Last name"+employee.get(0).getLast_name());
	  System.out.println("Gender"+employee.get(0).getGender());
	  System.out.println("Hire date"+employee.get(0).getHire_date());
    if (employee.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(employee, HttpStatus.OK);
		}
   catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getAllEmployeeDetails")
public ResponseEntity<List<Employee>> getEmployeeDetails() {
  try {
	 
	List<Employee> employee = mysqldao.getAllEmployeeData();

    if (employee.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	  System.out.println("Total Employee Count"+employee.size());
    return new ResponseEntity<>(employee, HttpStatus.OK);
		}
   catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getManagerEmployeeDetails")
public ResponseEntity<List<Employee>> getmanagerEmployeeDetails(@RequestParam String empid) {
  try {
	 
	List<Employee> employee = mysqldao.getmanagerEmployeeData(empid);

    if (employee.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	  System.out.println("Total Employee Count"+employee.size());
    return new ResponseEntity<>(employee, HttpStatus.OK);
		}
   catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getEmployeeSearch")
public ResponseEntity<List<Employee>> getEmployeesearch(@RequestParam String first_name,@RequestParam String last_name,String emp_no,String email,String phone,String department) {
	
  try {
	  
	  if(first_name ==null|| first_name.length()==0)
	  {
		  first_name="";
	  }
	 
	  
	  
	  if(last_name ==null|| last_name.length()==0)
	  {
		  last_name="";
	  }
	  
	  if(emp_no ==null|| emp_no.length()==0)
	  {
		  emp_no="";
	  }
	  
	  if(email ==null|| email.length()==0)
	  {
		  email="";
	  }
	  
	  if(phone ==null|| phone.length()==0)
	  {
		  phone="";
	  }
	  
	  if(department ==null|| department.length()==0)
	  {
		  department="";
	  }
	List<Employee> employee = mysqldao.getSearchEmployeeData(first_name,last_name,emp_no,email,phone,department);

    if (employee.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	  System.out.println("Total Employee Count"+employee.size());
    return new ResponseEntity<>(employee, HttpStatus.OK);
		}
   catch (Exception e) {
    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}

@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/updateDirectory")
public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
  try {
	  System.out.println("Update Employee"+employee.getEmp_no());
	int result=mysqldao.updateEmployee(employee);

	 if(result==1)
	 {
		 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
		
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}

/*@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/updateleave")
public ResponseEntity<String> updateLeaveDetails(@RequestBody Leave leaveobj) {
  try {
	  System.out.println("Update Leave"+leaveobj.getLeave_id());
	int result=mysqldao.updateleave(leaveobj);

	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/submitleave")
public ResponseEntity<String> insertLeaveDetails(@RequestBody Leave leaveobj) {
  try {
	  System.out.println("Submitting leave for"+leaveobj.getEmp_no());
	int result=mysqldao.insertleave(leaveobj);
	 System.out.println("result"+result);
	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getPendingleaves")
public ResponseEntity<List<Leave>> getLeaveDetails(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch leaves for"+emp_no);
	  List<Leave> leave=mysqldao.getleaves(emp_no,"Pending");
	
	 return new ResponseEntity<>(leave, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}

@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getleavedetails")
public ResponseEntity<List<Leave>> getAllLeaveDetails(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch leaves for"+emp_no);
	  List<Leave> leave=mysqldao.getAllLeaves(emp_no);
	
	 return new ResponseEntity<>(leave, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}

@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/submitexpense")
public ResponseEntity<String> insertExpenseDetails(@RequestBody Expense expense) {
  try {
	  System.out.println("Submitting leave for"+expense.getEmp_no());
	int result=mysqldao.insertExpense(expense);
	 System.out.println("result"+result);
	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/updateexpense")
public ResponseEntity<String> updateExpenseDetails(@RequestBody Expense expenseobj) {
  try {
	  System.out.println("Update expense"+expenseobj.getApprover_id());
	int result=mysqldao.updateexpense(expenseobj);

	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}



@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getPendingexpense")
public ResponseEntity<List<Expense>> getpendingexpense(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch Expenses for"+emp_no);
	  List<Expense> expense=mysqldao.getpendingExpense(emp_no,"Pending");
	
	 return new ResponseEntity<>(expense, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}

@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getAllexpense")
public ResponseEntity<List<Expense>> getAllExpense(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch Expenses for"+emp_no);
	  List<Expense> expense=mysqldao.getAllExpense(emp_no,"Pending");
	
	 return new ResponseEntity<>(expense, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}



@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/submitperformance")
public ResponseEntity<String> insertPerformanceDetails(@RequestBody Performance performance) {
  try {
	  System.out.println("Submitting performance for"+performance.getEmp_no());
	int result=mysqldao.insertPerformance(performance);
	 System.out.println("result"+result);
	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getPendingperformance")
public ResponseEntity<List<Performance>> getpendingPerformance(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch performance for"+emp_no);
	  List<Performance> performance=mysqldao.getpendingPerformance(emp_no,"Pending");
	
	 return new ResponseEntity<>(performance, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getlastyearperformance")
public ResponseEntity<List<Performance>> getLastYearPerformance(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch performance for"+emp_no);
	  List<Performance> performance=mysqldao.getlastyearPerformance(emp_no, "Pending");
	
	 return new ResponseEntity<>(performance, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/updateperformance")
public ResponseEntity<String> updatePerformaceDetails(@RequestBody Performance performance) {
  try {
	  System.out.println("Update expense"+performance.getApprover_id());
	int result=mysqldao.updateperformance(performance);

	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}

@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/submitTimesheet")
public ResponseEntity<String> insertPerformanceDetails(@RequestBody Timesheet timesheet) {
  try {
	  System.out.println("Submitting timesheet for"+timesheet.getEmp_no());
	int result=mysqldao.insertTimesheet(timesheet);
	 System.out.println("result"+result);
	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@PostMapping("/api/updatetimesheet")
public ResponseEntity<String> updateTimesheet(@RequestBody Timesheet timesheet) {
  try {
	  System.out.println("Update expense"+timesheet.getApprover_id());
	int result=mysqldao.updateTimesheet(timesheet);

	 if(result==1)
	 {
	 return new ResponseEntity<>("Success", HttpStatus.OK);
	 }
	 else
	 {
		 return new ResponseEntity<>("Fail", HttpStatus.OK);
	 }
		}
   catch (Exception e) {
	   return new ResponseEntity<>("Error", HttpStatus.OK);
  }
}



@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getPendingtimesheet")
public ResponseEntity<List<Timesheet>> getpendingTimesheet(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch getPendingtimesheet for"+emp_no);
	  List<Timesheet> timesheet=mysqldao.getpendingTimesheet(emp_no, "Pending");
	
	 return new ResponseEntity<>(timesheet, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}


@CrossOrigin(origins = {"http://localhost:4200","http://oneworkforcesiteaws.s3-website-us-west-1.amazonaws.com","https://dema01w2nk1xa.cloudfront.net"})
@GetMapping("/api/getAlltimesheet")
public ResponseEntity<List<Timesheet>> getalltimesheet(@RequestParam String emp_no) {
  try {
	  System.out.println("Fetch getAlltimesheet for"+emp_no);
	  List<Timesheet> timesheet=mysqldao.getAllTimesheet(emp_no, "Pending");
	
	 return new ResponseEntity<>(timesheet, HttpStatus.OK);
	 

		}
   catch (Exception e) {
	   return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
  }
}

    
*/}
