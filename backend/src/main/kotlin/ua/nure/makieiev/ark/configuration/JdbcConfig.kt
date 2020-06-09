package ua.nure.makieiev.ark.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DriverManagerDataSource
import javax.sql.DataSource

@Configuration
class JdbcConfig {

    @Bean
    fun postgresDataSource(): DataSource {
        val dataSource = DriverManagerDataSource()
        dataSource.url = "jdbc:postgresql://ec2-46-137-100-204.eu-west-1.compute.amazonaws.com:5432/dcrivpr15ui6cc"
        dataSource.username = "vjdpcdkxegpjxi"
        dataSource.password = "47ae549a1a3faec44f2be4f0c2ebd893e9c026183e38e98d2fe082a75cf0a080"
        return dataSource
    }

}