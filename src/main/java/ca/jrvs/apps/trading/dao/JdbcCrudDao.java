package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.dto.Entity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public abstract class JdbcCrudDao<E extends Entity, ID> implements CrudRepository {
    abstract public JdbcTemplate getJdbcTemplate();

    abstract public SimpleJdbcInsert simpleJdbcInsert();

    abstract String getTableName();

    abstract String getName();

    abstract Class getEntityClass();

    @Override
    public Object save(Object entity) {
        return null;
    }

    @Override
    public Object findById(Object o) {
        return null;
    }

    //Helper method
    public E findById(String idName, ID id, boolean forUpdate, Class clazz) {
        return null;
    }

    @Override
    public boolean existsById(Object o) {
        return false;
    }

    @Override
    public void deleteById(Object o) {

    }

    //Helper function
    public void deleteById(String idName, ID id) {

    }
}
