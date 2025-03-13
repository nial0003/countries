package kea.iabr.countries.repository;

import kea.iabr.countries.model.Country;
import kea.iabr.countries.model.CountryRowMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CountryRepository {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    private final JdbcTemplate jdbcTemplate;

    public CountryRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate= jdbcTemplate;
    }

    public List<Country> findAll(){
        String sql =  "SELECT * FROM countries";
        return jdbcTemplate.query(sql, new CountryRowMapper());
    }
}







