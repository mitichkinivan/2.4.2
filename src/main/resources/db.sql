CREATE TABLE user(
                     id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(255),
                     surName VARCHAR(255),
                     username VARCHAR(255),
                     password VARCHAR(255)
);
#
# alter table user
#     add constraint APP_USER_PK primary key (id);

# alter table user
#     add constraint APP_USER_UK unique (name);


CREATE TABLE role(
                     id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                     name VARCHAR(255)
);

# alter table role
#     add constraint APP_ROLE_PK primary key (id);

CREATE TABLE user_role(
                          id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
                          user_id int NOT NULL,
                          role_id int NOT NULL,

                          FOREIGN KEY (user_id) REFERENCES user (id),
                          FOREIGN KEY (role_id) REFERENCES role (id),

                          UNIQUE (user_id, role_id)
);

# alter table user_role
#     add constraint USER_ROLE_PK primary key (id);
#
# alter table user_role
#     add constraint USER_ROLE_UK unique (user_id, role_id);

INSERT INTO user VALUES (1,'1','1','1','1');
INSERT INTO user VALUES (2,'2','2','2','2');
INSERT INTO user VALUES (3,'Q','W','test1','12345');
INSERT INTO user VALUES (4,'Qq','WW','test2','12345');
INSERT INTO user VALUES (5,'Qqq','Www','test3','12345');

INSERT INTO role VALUES (1, 'ROLE_USER');
INSERT INTO role VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_role VALUES (1, 1, 2);
INSERT INTO user_role VALUES (2, 2, 1);
INSERT INTO user_role VALUES (3, 3, 1);
INSERT INTO user_role VALUES (4, 4, 1);
INSERT INTO user_role VALUES (5, 5, 1);
