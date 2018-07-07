CREATE TABLE user(
  userid VARCHAR(100) primary key,
  name VARCHAR(100) not null,
  password VARCHAR(100) not null
);

CREATE TABLE friends(
  id VARCHAR(100) primary key,
  userid VARCHAR(100),
  name VARCHAR(100) not null,
  sex VARCHAR(10),
  age INT,
  qq VARCHAR(30),
  telphone VARCHAR(100),
  email VARCHAR(100),
  address VARCHAR(100),
  foreign key(userid) references user(userid)
);