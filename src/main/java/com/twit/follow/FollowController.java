package com.twit.follow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.twit.account.model.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FollowController {
	@Autowired
	private FollowDAO followDAO;
	 
    @RequestMapping(value = "/users/follow", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity followUser(@ModelAttribute("unfollowForm") User user, HttpServletRequest request) {
    	int userId = (int) request.getSession().getAttribute("userId");
    	int result = followDAO.follow(new FollowModel(user.getId(), userId));
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }

    @RequestMapping(value = "/users/unfollow", method = RequestMethod.POST, produces = {"application/json","application/xml"})
    @ResponseBody
    public ResponseEntity unfollowUser(@ModelAttribute("unfollowForm") User user, HttpServletRequest request) {
    	int userId = (int) request.getSession().getAttribute("userId");
        int result = followDAO.unfollow(new FollowModel(user.getId(), userId));
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Success!\"}");
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error!\"}");
        }
    }
    
    // Following as XML or JSON
    @RequestMapping(value = "/following", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<Integer> following_XML_JSON(HttpServletRequest request) {
    	int userId = (int) request.getSession().getAttribute("userId");
        List<Integer> listFollowing = followDAO.listFollowing(userId);
        return listFollowing;
    }

    // Followers as XML or JSON
    @RequestMapping(value = "/followers", method = RequestMethod.GET, produces = {"application/json","application/xml"})
    @ResponseBody
    public List<Integer> followers_XML_JSON(HttpServletRequest request) {
    	int userId = (int) request.getSession().getAttribute("userId");
        List<Integer> listFollowers = followDAO.listFollowers(userId);
        return listFollowers;
    }
    
    // FOLLOW PAGE
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView followPage(ModelAndView model, HttpServletRequest request) {
        UserDao followForm = new UserDao();
        UserDao unfollowForm = new UserDao();
        model.addObject("followForm", followForm);
        model.addObject("unfollowForm", unfollowForm);
        int userId = (int) request.getSession().getAttribute("userId");
        List<UserDao> listUsers = followDAO.listAllUsers(userId);
        model.addObject("listUsers", listUsers);

        model.setViewName("follow/Follow");
        return model;
    }
}