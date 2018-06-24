package ch.so.agi.agdi.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.so.agi.agdi.admin.service.DataSourceService;

@Controller
public class DataSourceController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DataSourceService dataSourceService;

	@RequestMapping(value= "/dataSource", method=RequestMethod.GET)
	public ModelAndView listDataSets() {
		ModelAndView mv = new ModelAndView("dataSource/index");
		mv.addObject("dataSources", dataSourceService.findAll());
		
//		Iterable<DataSource> dataSources = dataSourceService.findAll();
//		for (DataSource ds: dataSources) {
//			log.info(ds.getConnection());
//			log.info(String.valueOf(ds.getGdiOid()));
//		}
		
		return mv;
	}
}
