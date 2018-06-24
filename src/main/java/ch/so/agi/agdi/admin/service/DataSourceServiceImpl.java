package ch.so.agi.agdi.admin.service;

import java.util.Optional;

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

	@Override
	public DataSource save(DataSource dataSource) {
		return repository.save(dataSource);
	}

	@Override
	public Optional<DataSource> findOne(Long id) {
		return repository.findById(id);
	}

}
