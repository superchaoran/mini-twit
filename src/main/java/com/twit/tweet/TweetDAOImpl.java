package com.twit.tweet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import com.twit.account.model.User;
import com.twit.tweet.TweetModel;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class TweetDAOImpl implements TweetDAO {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(TweetModel tweet) {
        String sql = "INSERT INTO tweets (tweet, user_id)" + " VALUES (?, ?)";
        System.out.println(sql+tweet.getTweet()+tweet.getUser_id());
        try {
            return jdbcTemplate.update(sql, tweet.getTweet(), tweet.getUser_id());
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
            tweet.setUser_id(Integer.parseInt(rs.getString("user_id")));
            System.out.println(rs.getString("date_created"));

            return tweet;
            }
        });

        return listTweets;
    }

    @Override
    public List<TweetModel> searchUserTweets(int user_id, String search) {
        String sql = "SELECT * FROM tweets WHERE user_id = "+ user_id+" AND tweet LIKE '%" + search + "%' ORDER BY date_created DESC";
        List<TweetModel> listTweets = jdbcTemplate.query(sql, new RowMapper<TweetModel>() {

            @Override
            public TweetModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            TweetModel tweet = new TweetModel();

            tweet.setId(rs.getInt("tweet_id"));
            tweet.setTweet(rs.getString("tweet"));
            tweet.setUser_id(Integer.parseInt(rs.getString("user_id")));
            /*2016-10-27 14:24:44.0*/
            try {
				tweet.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0").parse(rs.getString("date_created")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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