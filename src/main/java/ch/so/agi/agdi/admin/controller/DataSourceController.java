package ch.so.agi.agdi.admin.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.so.agi.agdi.admin.model.DataSource;
import ch.so.agi.agdi.admin.service.DataSourceService;

@Controller
public class DataSourceController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataSourceService dataSourceService;

	@RequestMapping(value= "/dataSource", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("dataSource/index");
		mv.addObject("dataSources", dataSourceService.findAll());
		
		/*
		Iterable<DataSource> dataSources = dataSourceService.findAll();
		for (DataSource ds: dataSources) {
			log.info(ds.getConnection());
			log.info(String.valueOf(ds.getGdiOid()));
		}
		*/
		
		return mv;
	}
	
	@RequestMapping(value= "/dataSource/create", method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("dataSource", new DataSource());		
		return "/dataSource/create";
	}
	
	@RequestMapping(value= "/dataSource/create", method=RequestMethod.POST)
	public String formSubmit(@Valid DataSource dataSource, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "/dataSource/create";
		}
		
		/*
		log.info(dataSource.getName());
		log.info(dataSource.getDescription());
		log.info(dataSource.getConnection());
		log.info(String.valueOf(dataSource.getConnectionType()));
		log.info(dataSource.getName());
		log.info(dataSource.getPassword());
		*/
		
		dataSourceService.save(dataSource);

		return "redirect:/dataSource";
	}	
	
	@RequestMapping(value= "/dataSource/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model) {
		log.info("*****************");
		log.info(String.valueOf(id));

		Optional<DataSource> dataSourceOptional = dataSourceService.findOne(Integer.toUnsignedLong(id));
		
		if(!dataSourceOptional.isPresent()) {
			log.error("DataSource not found. id="+id);
			return "redirect:/dataSource";
		}
		
		DataSource dataSource = dataSourceOptional.get();
		model.addAttribute("dataSource", dataSource);		
		return "/dataSource/create";

		// TODO: how to deal w/ passwords?
		// wiederverwenden von create.html?
		// update -> save only
		// close -> exit w/o save
		//return "redirect:/dataSource";
	}

	// DELETE
}
