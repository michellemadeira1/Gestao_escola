package snippet;

public class Snippet {
	#spring.profiles.active=dev
	spring.profiles.active=${APP_PROFILE:test}
	#spring.jpa.defer-datasource-initialization=true
	spring.jpa.open-in-view=false
	
	
	
	#spring.jpa.hibernate.ddl-auto=update
	#spring.datasource.url=jdbc:mysql://localhost/usuario?createDatabaseIfNotExist=true&serverTimezone=UTC&seSSI=false
	#spring.datasource.username=root
	#spring.datasource.password=1234567
	#spring.jpa.show-sql=true
}

