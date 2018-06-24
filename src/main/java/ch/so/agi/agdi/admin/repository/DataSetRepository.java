package ch.so.agi.agdi.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ch.so.agi.agdi.admin.model.DataSet;

@Repository
public interface DataSetRepository extends PagingAndSortingRepository<DataSet, Long> {

}
