package ch.so.agi.agdi.admin.service;

import java.util.Optional;

import ch.so.agi.agdi.admin.model.DataSource;

public interface DataSourceService {
	Iterable<DataSource> findAll();
	
	Optional<DataSource> findOne(Long id);
	
	DataSource save(DataSource dataSource);
	
	void delete(Long id);
}
