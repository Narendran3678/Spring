package com.springboot.restcontrollers;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.customException.CourseNotFoundException;
import com.springboot.entity.Courses;

@RestController
public class HomeRestController 
{
	
	@Autowired
	MessageSource messageSource;
	Courses courses = new Courses();
	
	
	@RequestMapping("/")
	public String getIndexPage()
	{
		return "<h1>Welcome to Index Page</h1>";
	}
	@GetMapping("/courses")
	public List<Courses> getCourseList()
	{
		return courses.getListUser();
	}

	@GetMapping("/getWelcomeMessage")
	public String getInternationalized(@RequestHeader(name="Accept-Language",required=false) Locale locale)
	{
		String message = messageSource.getMessage("welcome.message",null,locale);
		System.out.println("Message -"+message);
		return message;
	}
	/*@GetMapping("/courses/{id}")
	public Courses getPathVariable(@PathVariable long id)
	{
		if(((int)id)>courses.getListUser().size())
		{
			throw new CourseNotFoundException("Course Not Found");
		}
		return courses.getListUser().get((int)id);
	}*/
	@GetMapping("/courses/{id}")
	public EntityModel<Courses> getHATEOAS(@PathVariable long id)//Hypermedia as the engine of Application State
	{
		if(((int)id)>courses.getListUser().size())
		{
			throw new CourseNotFoundException("Course Not Found");
		}
		Courses cs = courses.getListUser().get((int)id);
		EntityModel<Courses> resource = EntityModel.of(courses.getListUser().get((int)id));
		
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getCourseList());
		resource.add(linkTo.withRel("all-courses"));
		return resource;
	}
	@PostMapping("/courses")
	public Courses saveUser(@Valid @RequestBody Courses courses)
	{
		System.out.println(courses.toString());
		this.courses.getListUser().add(courses);
		return courses;
	}
}
