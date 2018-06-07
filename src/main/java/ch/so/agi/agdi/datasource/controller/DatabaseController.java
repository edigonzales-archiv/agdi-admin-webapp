package ch.so.agi.agdi.datasource.controller;

import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.so.agi.agdi.datasource.dao.JDBCPostgresDataSourceEntityDAO;
import ch.so.agi.agdi.datasource.entity.PostgresDataSourceEntity;

@Controller
public class DatabaseController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private Connection connection;
	
	@ResponseBody
	@GetMapping("/data_sets/tables")
	public List<PostgresDataSourceEntity> listDataSourceTables(@RequestParam(value = "dburl", required = true) String dbUrl,
	//public void listDataSourceTables(@RequestParam(value = "dburl", required = true) String dbUrl,
			@RequestParam(value = "dbusr", required = true) String dbUsr,
			@RequestParam(value = "dbpwd", required = true) String dbPwd,
			@RequestParam(value = "query", required = true) String query) {
		
		JDBCPostgresDataSourceEntityDAO dao = new JDBCPostgresDataSourceEntityDAO();

		return dao.findByQuery(dbUrl, dbUsr, dbPwd, query);		
	}
	
	@ResponseBody
	@GetMapping("/data_sets/gaga")
	public void fubar() {
		System.out.println("adfasdfasdfasdfasd");
	}
}
