package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.dto.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class QuoteDao implements CrudRepository<Quote, String>{

    private static final String TABLE_NAME = "quote";
    private static final String ID_NAME = "ticker";
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public QuoteDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME);
    }

    @Override
    public Quote save(Quote entity) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(entity);
        simpleJdbcInsert.execute(parameterSource);
        return entity;
    }

    @Override
    public Quote findById(String s) {
        return null;
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void deleteById(String s) {

    }
}
