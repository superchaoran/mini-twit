package com.twit.follow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class FollowDAOImpl implements FollowDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int follow(FollowModel followModel) {
        String sql = "INSERT INTO follows (user_id, follower_user_id)" + " VALUES (?, ?)";
        try {
            return jdbcTemplate.update(sql, followModel.getUser_id(), followModel.getFollower_user_id());
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }

    @Override
    public int unfollow(FollowModel followModel){
        String sql = "DELETE FROM follows WHERE user_id = ? AND follower_user_id = ?";
        try {
            return jdbcTemplate.update(sql, followModel.getUser_id(), followModel.getFollower_user_id());
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }

    @Override
    public List<UserDao> listAllUsers(int user_id){
    	String sql = "SELECT id FROM user WHERE NOT id = " + user_id + " ORDER BY id ASC";
        List<UserDao> listUsers = jdbcTemplate.query(sql,new RowMapper<UserDao>(){
        	@Override
            public UserDao mapRow(ResultSet rs, int rowNum) throws SQLException {
        		UserDao user = new UserDao();
        		user.setId(Integer.parseInt(rs.getString("id")));
        		String sql_aux = "SELECT EXISTS(SELECT 1 FROM follows WHERE user_id = " + user.getId() + " AND follower_user_id = " + user_id + " LIMIT 1)";
                int result = jdbcTemplate.queryForObject(sql_aux, Integer.class);
                if (result==1) {
                    user.setFollowed(true);
                }
                else {
                    user.setFollowed(false);
                }

                return user;
        	}
        });
		return listUsers;
    }
    
    
    @Override
    public List<Integer> listFollowing(int user_id){
        String sql = "SELECT user_id FROM follows WHERE follower_user_id = " + user_id + " ORDER BY user_id ASC";
        List<Integer> listFollowing = jdbcTemplate.query(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            	return Integer.parseInt(rs.getString("user_id"));
            }
        });

        return listFollowing;
    }

    @Override
    public List<Integer> listFollowers(int user_id){
        String sql = "SELECT follower_user_id FROM follows WHERE user_id = " + user_id + " ORDER BY follower_user_id ASC";
        List<Integer> listFollowers = jdbcTemplate.query(sql, new RowMapper<Integer>() {

            @Override
            public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {

            	return Integer.parseInt(rs.getString("follower_user_id"));

            }
        });

        return listFollowers;
    }


}
