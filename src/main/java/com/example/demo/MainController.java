package com.example.demo;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.Calendar;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Controller
public class MainController {

@Autowired
CommunityRepository repository;

@RequestMapping(value="/hawks", method=RequestMethod.GET)
public ModelAndView hawks(ModelAndView mv) {
List<Community>customers = repository.findAll();
mv.addObject("customers",customers);
mv.setViewName("baseball1");
return mv;
}

@RequestMapping(value="/hawks", method=RequestMethod.POST)
public ModelAndView hawks(@ModelAttribute("formModel")
Community community, ModelAndView mv) {
	Calendar cl = Calendar.getInstance();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 (E) HH時mm分");

community.setTime(sdf.format(cl.getTime()));
repository.saveAndFlush(community);
return new ModelAndView("redirect:/hawks");
	
}

@RequestMapping(value="/", method=RequestMethod.GET)
public ModelAndView indexGet(ModelAndView mv) {
List<Community> customers = repository.findAll();
mv.addObject("customers",customers);
mv.setViewName("baseball");
return mv;
}

@RequestMapping(value="/", method=RequestMethod.POST)
public ModelAndView indexPost(@ModelAttribute("formModel") 
Community community, ModelAndView mv) {	
	Calendar cl = Calendar.getInstance();

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 (E) HH時mm分");

community.setTime(sdf.format(cl.getTime()));
repository.saveAndFlush(community);
return new ModelAndView("redirect:/");
}


@RequestMapping(value="/mypage1/", method = RequestMethod.GET) 
public ModelAndView mypage(@ModelAttribute Community community, ModelAndView mv){
List<Community> user = repository.findByIdIsNotNullOrderByIdDesc();
mv.addObject("user", user); mv.setViewName("mypage1"); return mv; }
 
@RequestMapping(value="/mypage1/{id}", method = RequestMethod.GET)
public ModelAndView mypageGet(@ModelAttribute Community community, ModelAndView mv,
@PathVariable long id){
Optional<Community> user = repository.findById(id);
mv.addObject("community", user.get());
mv.setViewName("mypage1"); 
return mv; 
}
@RequestMapping(value="/mypage1/", method = RequestMethod.POST)
public ModelAndView mypagePost(@ModelAttribute Community community, ModelAndView mv) {
repository.saveAndFlush(community);
return new  ModelAndView("redirect:/hawks");
}
@RequestMapping(value="/delete/", method = RequestMethod.POST)
public ModelAndView delete(@RequestParam("id")
long id, ModelAndView mv) {
repository.deleteById(id);
return new ModelAndView("redirect:/hawks");
}
}