package com.twit.tweet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.twit.tweet.TweetModel;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class TweetDAOImpl implements TweetDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int add(TweetModel tweet) {
        String username = getUsername();
        String sql = "INSERT INTO tweets (tweet, user_username)" + " VALUES (?, ?)";
        try {
            return jdbcTemplate.update(sql, tweet.getTweet(), username);
        }
        catch (DataIntegrityViolationException e) {
            return 0;
        }
    }

    @Override
    public List<TweetModel> searchTweets(String search) {
        String sql = "SELECT * FROM tweets WHERE tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
        List<TweetModel> listTweets = jdbcTemplate.query(sql, new RowMapper<TweetModel>() {

            @Override
            public TweetModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            TweetModel tweet = new TweetModel();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_id(rs.getString("user_id"));

            return tweet;
            }
        });

        return listTweets;
    }

    @Override
    public List<TweetModel> searchUserTweets(String username, String search) {
        String sql = "SELECT * FROM tweets WHERE user_username = '"+ username+"' AND tweet LIKE '%" + search + "%' ORDER BY tweet_id DESC";
        List<TweetModel> listTweets = jdbcTemplate.query(sql, new RowMapper<TweetModel>() {

            @Override
            public TweetModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            TweetModel tweet = new TweetModel();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_id(rs.getString("user_username"));

            return tweet;
            }
        });

        return listTweets;
    }

    public String getUsername() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }

}