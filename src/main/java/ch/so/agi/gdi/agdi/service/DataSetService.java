package ch.so.agi.gdi.agdi.service;

import java.util.Optional;

import ch.so.agi.gdi.agdi.model.gdi_knoten.DataSet;

public interface DataSetService {
	Iterable<DataSet> findAll(); 
	
	Optional<DataSet> findOne(Long id);
	
	DataSet save(DataSet dataSet);
	
	void delete(Long id);
}
