-- TABLE FOLLOWERS
CREATE TABLE follows
(
	user_id INT(11) NOT NULL,
	follower_user_id INT(11) NOT NULL,
	PRIMARY KEY(user_id,follower_user_id)
);

-- CONSTRAINTS
ALTER TABLE follows ADD CONSTRAINT follows_fk1 FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE follows ADD CONSTRAINT follows_fk2 FOREIGN KEY (follower_user_id) REFERENCES user(id);
