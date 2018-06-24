package ch.so.agi.agdi.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.so.agi.agdi.admin.model.DataSource;
import ch.so.agi.agdi.admin.model.DataSource.ConnectionType;
import ch.so.agi.agdi.admin.repository.DataSourceRepository;

@Service
public class BootstrapDataPopulator implements InitializingBean {
    private final Logger LOG = LoggerFactory.getLogger(BootstrapDataPopulator.class);

    @Autowired
    DataSourceRepository dataSourceRepository;
    
    @Override
    @Transactional()
	public void afterPropertiesSet() throws Exception {
        LOG.info("Bootstrapping data...");

//        createSystemUser();
//        createCountryCodes();
        createDataSource();

        LOG.info("...Bootstrapping completed");
	}

    private void createDataSource() {
    	if (dataSourceRepository.count() > 0) {
    		return;
    	}
    	
        LOG.info("... creating datasource");
        LOG.info(String.valueOf(dataSourceRepository.count()));

    	DataSource dataSource01 = new DataSource();
    	dataSource01.setName("GeoDB");
    	dataSource01.setDescription("Unsere GeoDB");
    	dataSource01.setConnection("jdbc:postgresql://192.168.50.6:5432/pub");
    	dataSource01.setUser("ddluser");
    	dataSource01.setPassword("ddluser");
    	dataSource01.setConnectionType(ConnectionType.DATABASE);
    	dataSourceRepository.saveAndFlush(dataSource01);
    	
    	DataSource dataSource02 = new DataSource();
    	dataSource02.setName("SogisDB");
    	dataSource02.setDescription("Asbach uralt");
    	dataSource02.setConnection("jdbc:postgresql://192.168.50.5:5432/sogis");
    	dataSource02.setUser("ddluser");
    	dataSource02.setPassword("ddluser");
    	dataSource02.setConnectionType(ConnectionType.DATABASE);
    	dataSourceRepository.saveAndFlush(dataSource02);    	
    }
}
