package ch.so.agi.agdi.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.so.agi.agdi.admin.model.DataSource;

@Repository
public interface DataSourceRepository extends JpaRepository<DataSource, Long> {

}
