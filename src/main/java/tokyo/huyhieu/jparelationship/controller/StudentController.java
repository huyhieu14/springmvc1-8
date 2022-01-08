package tokyo.huyhieu.jparelationship.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tokyo.huyhieu.jparelationship.model.Student;
import tokyo.huyhieu.jparelationship.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	private static final Logger LOG = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String listStudents(Model theModel) {
		List<Student> theStudents = studentService.getStudents();
		theModel.addAttribute("students", theStudents);
		return "list-students";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show student-form handler method");
		Student theStudent = new Student();
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}

	@PostMapping("/saveStudent")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public String saveStudent(@ModelAttribute("student") Student theStudent) {
		studentService.saveStudent(theStudent);
		return "redirect:/student/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("studentId") Long theId, Model theModel) {
		Student theStudent = studentService.getStudent(theId);
		theModel.addAttribute("student", theStudent);
		return "student-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") Long theId) {
		studentService.deleteStudent(theId);
		return "redirect:/student/list";
	}

	@InitBinder
    public void init(WebDataBinder webDataBinder){
        //What format is specified and what format is transmitted by the front desk
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class,new CustomDateEditor(simpleDateFormat,false));
    }
}
