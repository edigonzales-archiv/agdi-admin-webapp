package ch.so.agi.gdi.agdi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.so.agi.gdi.agdi.model.gdi_knoten.DataSet;
import ch.so.agi.gdi.agdi.service.DataSetService;

@Controller
public class DataSetController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataSetService dataSetService;

	@GetMapping("/data_sets")
	public ModelAndView listDataSets(@RequestParam(value = "sort", required = false) String sort) {
		
		log.info(sort);
		
		Iterable<DataSet> dataSets = dataSetService.findAll(sort);
		
		ModelAndView mv = new ModelAndView("data_sets");
		mv.addObject("dataSets", dataSets);
		
		return mv;
	}
}
