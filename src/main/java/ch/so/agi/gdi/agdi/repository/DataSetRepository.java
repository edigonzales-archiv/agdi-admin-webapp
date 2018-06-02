package ch.so.agi.gdi.agdi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.so.agi.gdi.agdi.model.gdi_knoten.DataSet;

@Repository
public interface DataSetRepository extends PagingAndSortingRepository<DataSet, Long> {

}
