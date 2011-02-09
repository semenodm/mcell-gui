dataSource {
	pooled = true
	driverClassName = "org.hsqldb.jdbcDriver"
	username = "sa"
	password = ""
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}
mcellFunctionalDatasource{
	driverClassName = "net.sourceforge.jtds.jdbc.Driver"
	url = "jdbc:jtds:sqlserver://omt.mpc-ua.com:39505/mcell3_9_sdo"
	//dbCreate = "validate"
	username = "sap"
	password = "sap"

	autocommit = false
	dialect=org.hibernate.dialect.SQLServerDialect
}
// environment specific settings
environments {
	functional{ dataSource = mcellFunctionalDatasource }
	development {
		dataSource {
			dbCreate = "create-drop" // one of 'create', 'create-drop','update'
			url = "jdbc:hsqldb:mem:devDB"
		}
	}
	test {
		dataSource {
			dbCreate = "update"
			url = "jdbc:hsqldb:mem:testDb"
		}
	}
	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:hsqldb:file:prodDb;shutdown=true"
		}
	}
}
