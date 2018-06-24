package ch.so.agi.agdi.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.so.agi.agdi.admin.model.DataSource;
import ch.so.agi.agdi.admin.repository.DataSourceRepository;

@Service
public class DataSourceServiceImpl implements DataSourceService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataSourceRepository repository;

	@Override
	public Iterable<DataSource> findAll() {
		return repository.findAll();
	}

}
