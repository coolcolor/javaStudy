package cn.cool.springboot.dao;

import cn.cool.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        String sql = "insert into user(id,username,password,birthday) values(?,?,?,?)";
        return this.jdbcTemplate.update(sql, user.getId(), user.getUsername(), user.getPassword(), user.getBirthday());
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from user where id=?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(User user) {
        String sql = "update user password=? where id=?";
        return jdbcTemplate.update(sql, user.getPassword(), user.getId());
    }

    @Override
    public User getById(Integer id) {
        String sql = "select * from user where id=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setBirthday(resultSet.getDate("birthday"));
                return user;
            }
        }, id);
    }
}
