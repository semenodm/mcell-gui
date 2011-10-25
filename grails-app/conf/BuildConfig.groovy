grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
	//pom true
	//inherit Grails' default dependencies
	inherits("global") {
		// uncomment to disable ehcache
		// excludes 'ehcache'
	}
	log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
	repositories {
		grailsPlugins()
		grailsHome()
		grailsCentral()

		// uncomment the below to enable remote dependency resolution
		// from public Maven repositories
		mavenLocal()
		mavenCentral()
		mavenRepo "http://snapshots.repository.codehaus.org"
		mavenRepo "http://repository.codehaus.org"
		mavenRepo "http://download.java.net/maven/2/"
		mavenRepo "http://repository.jboss.com/maven2/"
	}
	dependencies {
		// specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

		// runtime 'mysql:mysql-connector-java:5.1.13'
		compile 'com.extjs.gxt.ui:expander:1.0.1-SNAPSHOT'

		runtime 'net.sourceforge.jtds:jtds:1.2.4'

		test 'org.seleniumhq.selenium:selenium-firefox-driver:latest.release'
		test 'org.seleniumhq.selenium:selenium-chrome-driver:latest.release'
		test 'org.seleniumhq.selenium:selenium-ie-driver:latest.release'
		test('org.seleniumhq.selenium:selenium-htmlunit-driver:latest.release') { exclude 'xml-apis' }

		test 'org.codehaus.geb:geb-spock:0.6.0'
		test('org.codehaus.groovy.modules.http-builder:http-builder:0.5.0') { excludes "commons-logging", "xml-apis", "groovy" }
		//test 'org.codehaus.geb:geb-junit3:latest.release'
		//test 'org.seleniumhq.webdriver:webdriver-chrome:latest.release'
	}
}
