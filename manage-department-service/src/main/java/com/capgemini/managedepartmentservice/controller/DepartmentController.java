package com.capgemini.managedepartmentservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.managedepartmentservice.service.impl.MessageListener;
import com.capgemini.managedepartmentservice.model.DepartmentModel;
import com.capgemini.managedepartmentservice.service.DepartmentService;

@RestController
@RequestMapping("/ManageDepartment")
@CrossOrigin
public class DepartmentController {
	
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;


	@GetMapping(value = "/HelloTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> helloTest() {
		logger.info("Department Hellotest has been accessed");
			return ResponseEntity.ok("Owner Department Login Successful");
	}
	
	@PostMapping(value = "/adddepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentModel> addDepartment(@RequestBody DepartmentModel department) {
		logger.info("Add Department has been accessed");
		return ResponseEntity.ok(departmentService.addDepartmentService(department));
	}
	
	@PutMapping(value="/updatedepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentModel> updateDepartment(@RequestBody DepartmentModel department){
		logger.info("Update Department has been accessed");
		return ResponseEntity.ok(departmentService.updateDepartmentService(department));
	}
	
	@DeleteMapping(value = "/deletedepartment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteDepartment(@PathVariable int id) {
		logger.info("Delete has been accessed");
		return ResponseEntity.ok(departmentService.deleteDepartmentService(id));
	}
	
	@GetMapping(value = "/viewdepartment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DepartmentModel> findDepartmentByName(@RequestBody DepartmentModel department) {
		logger.info("View Department has been accessed");
		return ResponseEntity.ok(departmentService.viewDepartmentByName(department.getName()));
		
	}
	@GetMapping(value = "/viewall", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<DepartmentModel>> viewAll() {
		logger.info("All Department has been accessed");
		return ResponseEntity.ok(departmentService.viewAll());
		
	}
	@GetMapping(value = "/notification", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <List<String>> getnNotification() {
		logger.info("Notification has been accessed");
		return ResponseEntity.ok (MessageListener.getMessageList());

}
	
}