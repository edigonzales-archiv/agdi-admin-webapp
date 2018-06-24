package ch.so.agi.agdi.admin.service;

import ch.so.agi.agdi.admin.model.DataSource;

public interface DataSourceService {
	Iterable<DataSource> findAll();
}
