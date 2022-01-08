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

import tokyo.huyhieu.jparelationship.model.Course;
import tokyo.huyhieu.jparelationship.model.Teacher;
import tokyo.huyhieu.jparelationship.service.CourseService;
import tokyo.huyhieu.jparelationship.service.TeacherService;


@Controller
@RequestMapping("/course")
public class CourseController {
	private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherService teacherService;

	@ModelAttribute("teachers")
	public List<Teacher> teachers(){
		return teacherService.getTeachers();
	}
	
	@GetMapping("/list")
	public String listCourses(Model theModel) {
		List<Course> theCourses = courseService.getCourses();
		theModel.addAttribute("courses", theCourses);
		return "list-courses";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
	LOG.debug("inside show course-form handler method");
		Course theCourse = new Course();
		theModel.addAttribute("course", theCourse);
		return "course-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("course") Course theCourse) {
		courseService.saveCourse(theCourse);
		return "redirect:/course/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("courseId") Long theId, Model theModel) {
		Course theCourse = courseService.getCourse(theId);
		theModel.addAttribute("course", theCourse);
		return "course-form";
	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("courseId") Long theId) {
		courseService.deleteCourse(theId);
		return "redirect:/course/list";
	}

}
