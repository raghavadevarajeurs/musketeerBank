package com.sjsu.musketeerbank.model;

public class Employee {

	private String emp_no; 
	private String birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	private String hire_date;
	private String email;
	private String managerflag;
	private String fullname;
	private String department;
	private String theatre;
	private String phone;
	private String hrflag;
	public String getHrflag() {
		return hrflag;
	}
	public void setHrflag(String hrflag) {
		this.hrflag = hrflag;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTheatre() {
		return theatre;
	}
	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getManagerflag() {
		return managerflag;
	}
	public void setManagerflag(String managerflag) {
		this.managerflag = managerflag;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}

	private String managername;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	private String password;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	
	public Employee(String emp_no,String birth_date,String first_name,String last_name,String gender,String hire_date,String email,String password,String address1,String address2,String city,String state,String zip,String department,String fullname,String theatre,String phone,String managername)
	{
		
		this.emp_no=emp_no;
		this.birth_date=birth_date;
		this.first_name=first_name;
		this.last_name=last_name;
		this.gender=gender;
		this.hire_date=hire_date;
		this.email=email;
		this.password=password;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.department=department;
		this.fullname=fullname;
		this.theatre=theatre;
		this.phone=phone;
		this.managername=managername;
		
	}
	public Employee()
	{
		
	}
}
