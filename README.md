# spring-multi-datasource
Spring Boot multi datasource with jpa-hibernate

Because of EntityManager its a bit different to create multi-datasource spring boot applications. They have to be separated by default packages and these packages must be defined in the list of `scanned packages`. Otherwise it doesn't work. 

If you are only using JdbcTemplate then creating datasource with different identifier is enough. Different JdbcTemplate instances can be used in the same package or even class and can be imported like `(@mainDb JdbcTemplate jdbcMain, @secondDb JdbcTemplate jdbcSecond)`.
