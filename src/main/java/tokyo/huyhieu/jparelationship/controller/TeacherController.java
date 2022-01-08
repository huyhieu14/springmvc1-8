package tokyo.huyhieu.jparelationship.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tokyo.huyhieu.jparelationship.model.Teacher;
import tokyo.huyhieu.jparelationship.service.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	private static final Logger LOG = LoggerFactory.getLogger(TeacherController.class);

	@Autowired
	private TeacherService teacherService;

	@GetMapping("/list")
	public String listTeachers(Model theModel) {
		List<Teacher> theTeachers = teacherService.getTeachers();
		theModel.addAttribute("teachers", theTeachers);
		return "list-teachers";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show student-form handler method");
		Teacher theTeacher = new Teacher();
		theModel.addAttribute("teacher", theTeacher);
		return "teacher-form";
	}

	@PostMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher theTeacher) {
		teacherService.saveTeacher(theTeacher);
		return "redirect:/teacher/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("teacherId") Long theId, Model theModel) {
		Teacher theTeacher = teacherService.getTeacher(theId);
		theModel.addAttribute("teacher", theTeacher);
		return "teacher-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("teacherId") Long theId) {
		teacherService.deleteTeacher(theId);
		return "redirect:/teacher/list";
	}

	
}
