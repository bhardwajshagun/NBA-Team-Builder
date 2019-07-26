DROP DATABASE IF EXISTS nba;
CREATE DATABASE  IF NOT EXISTS nba;
USE nba;


-- POSITION TABLE
DROP TABLE IF EXISTS position;
CREATE TABLE position (
  position_id int(4),
  position_name varchar(100)  NOT NULL,
  abbrevation varchar(3) NOT NULL,
  PRIMARY KEY (`position_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
  INSERT INTO POSITION VALUES
(1, 'POINT GUARD', 'PG'),
(2, 'SHOOTING GUARD', 'SG'),
(3, 'POWER FORWARD ', 'PF'),
(4, 'CENTER', 'C'),
(5, 'SMALL FORWARD', 'SF');




-- CITY TABLE
DROP TABLE IF EXISTS city;
CREATE TABLE city (
  city_id int(4) ,
  city_name varchar(100)  NOT NULL,
  market_size enum('Large', 'Medium', 'Small') NOT NULL,
  climate enum('Warm', 'Cold') NOT NULL,
  PRIMARY KEY (`city_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
INSERT INTO city values
(1, 'Atlanta', 'Small', 'Warm'),
(2, 'Boston', 'Large', 'Cold'),
(3, 'Brooklyn', 'Small', 'Cold'),
(4, 'Charlotte', 'Small', 'Warm'),
(5, 'Chicago', 'Medium', 'Cold'),
(6, 'Cleveland', 'Large', 'Cold'),
(7, 'Dallas', 'Medium', 'Warm'),
(8, 'Denver', 'Small', 'Cold'),
(9, 'Detroit', 'Small', 'Cold'),
(10, 'Houston', 'Medium', 'Warm'),
(11, 'Indianapolis', 'Small', 'Warm'),
(12, 'Los Angeles', 'Large', 'Warm'),
(13, 'Memphis', 'Small', 'Warm'),
(14, 'Miami', 'Large', 'Warm'),
(15, 'Milwaukee', 'Medium', 'Cold'),
(16, 'Minneapolis', 'Small', 'Cold'),
(17, 'New Orleans', 'Medium', 'Warm'),
(18, 'New York City', 'Large', 'Cold'),
(19, 'Oklahoma City', 'Medium', 'Cold'),
(20, 'Orlando', 'Large', 'Warm'),
(21, 'Philadelphia', 'Medium', 'Cold'),
(22, 'Phoenix', 'Medium', 'Warm'),
(23, 'Portland', 'Large', 'Cold'),
(24, 'Sacramento', 'Small', 'Warm'),
(25, 'Salt Lake City', 'Medium', 'Warm'),
(26, 'San Antonio', 'Large', 'Warm'),
(27, 'San Francisco', 'Large', 'Warm'),
(28, 'Toronto', 'Medium', 'Cold'),
(29, 'Washington, D.C.', 'Large', 'Cold');

-- STADIUM TABLE
DROP TABLE IF EXISTS stadium;
CREATE TABLE stadium (
  stadium_id int(4) ,
  stadium_name varchar(100)  NOT NULL,
  capacity enum('Large', 'Medium', 'Small') NOT NULL,
  crowd_noise enum('Loud', 'Medium') NOT NULL,
  city_id int(4) ,
  PRIMARY KEY (`stadium_id`),
  FOREIGN KEY (`city_id`) REFERENCES `city` (`city_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
INSERT INTO stadium values
(1, 'American Airlines Arena', 'Large', 'Medium', 14),
(2, 'American Airlines Center', 'Medium', 'Medium', 7),
(3, 'Amway Center', 'Medium', 'Medium', 20),
(4, 'AT&T Center', 'Medium', 'Medium', 26),
(5, 'Bankers Life Fieldhouse', 'Small', 'Loud', 11),
(6, 'Barclays Center', 'Small', 'Medium', 3),
(7, 'Capital One Arena', 'Large', 'Medium', 3),
(8, 'Chase Center', 'Medium', 'Loud', 27),
(9, 'Chesapeake Energy Arena', 'Medium', 'Loud', 19),
(10, 'FedExForum', 'Small', 'Loud', 13),
(11, 'Fiserv Forum', 'Small', 'Medium', 15),
(12, 'Golden 1 Center', 'Small', 'Loud', 24),
(13, 'Little Caesars Arena', 'Large', 'Medium', 9),
(14, 'Madison Square Garden', 'Large', 'Loud', 18),
(15, 'Moda Center', 'Medium', 'Loud', 23),
(16, 'Pepsi Center', 'Large', 'Loud', 8),
(17, 'Rocket Mortgage FieldHouse', 'Large', 'Medium', 6),
(18, 'Scotiabank Arena', 'Large', 'Medium', 28),
(19, 'Smoothie King Center', 'Small', 'Medium', 17),
(20, 'Spectrum Center', 'Medium', 'Medium', 4),
(21, 'Staples Center', 'Medium', 'Loud', 12),
(22, 'State Farm Arena', 'Medium', 'Medium', 1),
(23, 'Talking Stick Resort Arena', 'Small', 'Medium', 22),
(24, 'Target Center', 'Medium', 'Medium', 16),
(25, 'TD Garden', 'Medium', 'Loud', 2),
(26, 'Toyota Center', 'Small', 'Medium', 10),
(27, 'United Center', 'Large', 'Loud', 5),
(28, 'Vivint Smart Home Arena', 'Medium', 'Loud', 25),
(29, 'Wells Fargo Center', 'Large', 'Medium', 21);

-- PLAYSTYLE TABLE
DROP TABLE IF EXISTS play_style;
CREATE TABLE play_style (
  play_style_id int(4) not null ,
  play_style_name varchar(100)  NOT NULL,
  PRIMARY KEY (`play_style_id`)
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO PLAY_STYLE VALUES
(1, 'PACE AND SPACE'),
(2, 'BALANCED'),
(3, 'DEFENCE'),
(4, 'GRIT AND GRIND'),
(5, 'SEVEN SECONDS');

    -- TEAM TABLE
DROP TABLE IF EXISTS team;
CREATE TABLE team (
  team_id int(4) ,
  team_name varchar(100)  NOT NULL,
  championships_won int(3) DEFAULT NULL,
  stadium_id int(4),
  most_recent_playoff_season_id int(4) DEFAULT NULL,
  PRIMARY KEY (`team_id`),
  FOREIGN KEY (`stadium_id`) REFERENCES `Stadium` (`stadium_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
INSERT INTO team values
(1, 'Atlanta Hawks', 1, 1, 2017),
(2, 'Boston Celtics', 17, 2, 2019), 
(3, 'Brooklyn Nets', 0, 3, 2019),
(4, 'Charlotte Hornets', 0, 4, 2016),
(5, 'Chicago Bulls', 6, 5, 2017),
(6, 'Cleveland Cavaliers', 1, 6, 2018),
(7, 'Dallas Mavericks', 1, 7, 2016),
(8, 'Denver Nuggets', 0, 8, 2019),
(9, 'Detroit Pistons', 3, 9, 2019),
(10, 'Golden State Warriors', 6, 27, 2019),
(11, 'Houston Rockets', 2, 10, 2019),
(12, 'Indiana Pacers', 0, 11, 2019),
(13, 'LA Clippers', 0, 12, 2019),
(14, 'LA Lakers', 16, 12, 2013),
(15, 'Memphis Grizzlies', 0, 13, 2017),
(16, 'Miami Heat', 3, 14, 2018),
(17, 'Milwaukee Bucks', 1, 15, 2019),
(18, 'Minnesota Timberwolves', 0, 16, 2018),
(19, 'New Orleans Hornets', 0, 17, 2016),
(20, 'New York Knicks', 2, 18, 2013),
(21, 'Oklahoma City Thunder', 1, 19, 2019),
(22, 'Orlando Magic', 0, 20, 2019),
(23, 'Philadelphia 76ers', 3, 21, 2019),
(24, 'Phoenix Suns', 0, 22, 2010),
(25, 'Portland Trail Blazers', 1, 23, 2019), 
(26, 'Sacramento Kings', 1, 24, 2006),
(27, 'San Antonio Spurs', 5, 26, 2019),
(28, 'Toronto Raptors', 1, 28, 2019),
(29, 'Utah Jazz', 0, 25, 2019),
(30, 'Washington Wizards', 1, 29, 2018);

-- PLAYER  TABLE

DROP TABLE IF EXISTS player;
CREATE TABLE player (
  player_id int(11) NOT NULL,
  player_name varchar(100)  NOT NULL,
  age int(3) NOT NULL,
  height varchar(7)  NOT NULL,
  weight float  NOT NULL,
  Experience int  NOT NULL,
  Status tinyint NOT NULL,
  Position_ID int  NOT NULL,
  team_id int(4)  NOT NULL,
  PRIMARY KEY (`player_id`),
 FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\players_11.csv"
INTO TABLE player
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
ESCAPED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

SHOW VARIABLES LIKE "secure_file_priv";



  -- SEASON  TABLE

DROP TABLE IF EXISTS season;
CREATE TABLE season (
  season_id int(11) NOT NULL,
  season INT(20) not null,
  champions_id int(11)  NOT NULL,
  finals_mvp_id int(11) NOT NULL,
  mvp_id int(11) NOT NULL,
  PRIMARY KEY (`season_id`),
 FOREIGN KEY (`champions_id`) REFERENCES `team` (`team_id`),
 FOREIGN KEY (`finals_mvp_id`) REFERENCES `player` (`player_id`),
 FOREIGN KEY (`mvp_id`) REFERENCES `player` (`player_id`)
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;
  
  
 INSERT INTO SEASON VALUES
 (1,2001,14,535,538),
(2,2002,14,535,533),
(3,2003,27,533,533),
(4,2004,9,534,536),
(5,2005,27,533,537),
(6,2006,16,148,537),
(7,2007,27,481,131),
(8,2008,2,532,531),
(9,2009,14,531,331),
(10,2010,14,531,331),
(11,2011,7,131,120),
(12,2012,16,331,331),
(13,2013,16,331,331),
(14,2014,27,296,305),
(15,2015,10,19,455),
(16,2016,6,331,455),
(17,2017,10,305,434),
(18,2018,10,305,222),
(19,2019,28,296,180);

SELECT* FROM SEASON;
-- COACH  TABLE

DROP TABLE IF EXISTS coach;
CREATE TABLE coach (
  coach_id int(11) NOT NULL,
  coach_name varchar(100)  NOT NULL,
  age int(3) NOT NULL,
  offensive_grade varchar(3)  NOT NULL,
  defensive varchar(3)  NOT NULL,
  num_COTY_awards int NOT NULL,
  play_style_id int(4) NOT NULL,
  PRIMARY KEY (`coach_id`),
 FOREIGN KEY (`play_style_id`) REFERENCES `play_style` (`play_style_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
  INSERT into coach values
(1,'Lloyd Pierce',43,'C','B+',0,1),
(2,'Brad Stevens',42,'A','A',0,1),
(3,'Kenny Atkinson',52,'C+','C+',0,1),
(4,'James Borrego',41,'B','C',0,1),
(5,'Jim Boylen',54,'A','B',0,1),
(6,'John Beilein',66,'B+','C',0,1),
(7,'Rick Carlisle',59,'B','B+',0,1),
(8,'Michael Malone',47,'B','B',0,1),
(9,'Dwane Casey',62,'B+','B+',1,1),
(10,'Steve Kerr',53,'A+','A+',1,1),
(11,'Mike DAntoni',68,'A+','B',2,1),
(12,'Nate McMillan',54,'B','C',0,1),
(13,'Doc Rivers',57,'B','C',1,1),
(14,'Frank Vogel',46,'C','B',0,1),
(15,'Taylor Jenkins',34,'B','B',0,1),
(16,'Erik Spoelstra',48,'B+','B+',0,1),
(17,'Mike Budenholzer',49,'C','A',2,1),
(18,'Ryan Saunders',33,'B+','C+',0,1),
(19,'Alvin Gentry',64,'C+','D',0,1),
(20,'David Fizdale',45,'B+','B',0,1),
(21,'Billy Donovan',54,'C','B+',0,1),
(22,'Steve Clifford',57,'C','B',0,1),
(23,'Brett Brown',58,'C','A-',1,1),
(24,'Monty Williams',47,'C','B',0,1),
(25,'Terry Stotts',61,'B+','C+',0,1),
(26,'Luke Walton',39,'C','C+',0,1),
(27,'Gregg Popovich',70,'A+','A+',3,1),
(28,'Nick Nurse',51,'B','B+',0,1),
(29,'Quin Snyder',52,'C','A',0,1),
(30,'Scott Brooks',53,'B+','B',1,1);

  
   -- COACH-SEASON  TABLE

DROP TABLE IF EXISTS COACH_SEASON;
CREATE TABLE COACH_SEASON (
  coach_id int(11) NOT NULL,
  team_id int(11) NOT NULL,
  season_id int(11) NOT NULL,
  FOREIGN KEY (`coach_id`) REFERENCES `COACH` (`coach_id`),
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;  


INSERT INTO COACH_SEASON VALUES
(1,1,19),
(2,2,19),
(3,3,19),
(4,4,19),
(5,5,19),
(6,6,19),
(7,7,19),
(8,8,19),
(9,9,19),
(10,10,19),
(11,11,19),
(12,12,19),
(13,13,19),
(14,14,19),
(15,15,19),
(16,16,19),
(17,17,19),
(18,18,19),
(19,19,19),
(20,20,19),
(21,21,19),
(22,22,19),
(23,23,19),
(24,24,19),
(25,25,19),
(26,26,19),
(27,27,19),
(28,28,19),
(29,29,19),
(30,30,19);

  
  
    -- INJURY TABLE

DROP TABLE IF EXISTS INJURY;
CREATE TABLE INJURY (
  injury_id int(11) NOT NULL,
  injury_name varchar(100) NOT NULL,
  severity int(1) NOT NULL,
    PRIMARY KEY (`injury_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
  
  
  INSERT INTO INJURY VALUES
  (1,'Abdomen',1),
(2,'Achilles',2),
(3,'Ankle',5),
(4,'Back',3),
(5,'Coachs Decision',1),
(6,'Elbow',4),
(7,'Finger',1),
(8,'Foot',2),
(9,'Groin',5),
(10,'Hamstring',3),
(11,'Heel',1),
(12,'Hip',4),
(13,'INJURY',1),
(14,'Knee',2),
(15,'Kneecap',5),
(16,'Leg',3),
(17,'Lower Leg',1),
(18,'Rest',4),
(19,'Shoulder',1),
(20,'Thigh',2),
(21,'Thumb',5),
(22,'Toe',3),
(23,'Wrist',1);

  
  -- PLAYER INJURY TABLE
  DROP TABLE IF EXISTS player_injury;
CREATE TABLE player_injury (
  player_id int(11) NOT NULL,
  injury_id int(11) NOT NULL,
  season_id int(11) NOT NULL,
  surgery_requried tinyint NOT NULL,
  games_missed int(3) NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`injury_id`) REFERENCES `injury` (`injury_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  

INSERT INTO player_injury VALUES
(2,4,19,0,0),
(14,14,19,1,0),
(37,1,19,1,0),
(39,14,19,1,0),
(52,18,19,0,0),
(108,3,19,0,0),
(120,4,19,1,0),
(151,8,19,1,0),
(202,3,19,0,0),
(232,12,19,0,0),
(260,23,19,0,0),
(279,8,19,1,0),
(284,1,19,0,0),
(305,2,19,0,0),
(406,19,19,1,0),
(475,17,19,1,0),
(507,14,19,0,0),
(514,23,19,1,0);



-- AWARD TABLE
 DROP TABLE IF EXISTS award;
CREATE TABLE award (
  award_id int(11) NOT NULL,
  award_name varchar(50) NOT NULL,
  PRIMARY KEY (`award_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
INSERT INTO AWARD VALUES
(1,'KIA NBA MOST VALUABLE PLAYER'),			
(2,'KIA NBA ROOKIE OF THE YEAR'),			
(3,'KIA NBA SIXTH MAN AWARD'),			
(4,'KIA NBA DEFENSIVE PLAYER OF THE YEAR'),			
(5,'KIA NBA MOST IMPROVED PLAYER'),			
(6,'TWYMAN-STOKES TEAMMATE OF THE YEAR AWARD'),			
(7,'NBA SPORTSMANSHIP AWARD'),			
(8,'HUSTLE AWARD');		


-- PLAYER_AWARD TABLE
 DROP TABLE IF EXISTS player_award;
CREATE TABLE player_award (
  player_id int(11) NOT NULL,
  award_id int(11) NOT NULL,
  season_id int(11) NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`award_id`) REFERENCES `award` (`award_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO PLAYER_AWARD VALUES
(180,1,19),
(337,2,19),
(335,3,19),
(433,4,19),
(399,5,19),
(369,6,19),
(369,7,19),
(351,8,19);


SELECT* FROM SEASON;
-- SEASON_STATS TABLE
 DROP TABLE IF EXISTS season_stats;
CREATE TABLE season_stats (
  season_id int(11) NOT NULL,
  player_id int(11) NOT NULL,
  team_id int(11) NOT NULL,
  games_played int(11) NOT NULL,
  minutes int(11) NOT NULL,
  points FLOAT NOT NULL,
  FGM FLOAT NOT NULL,
  FGA FLOAT NOT NULL,
  FG_PER FLOAT NOT NULL,
  THREE_PM FLOAT NOT NULL,
  THREE_PA FLOAT NOT NULL,
  THREE_P_PER FLOAT NOT NULL,
  FTM FLOAT NOT NULL,
  FTA FLOAT NOT NULL,
  FT_PER FLOAT NOT NULL,
  OREB FLOAT NOT NULL,
  DREB FLOAT NOT NULL,
  REB FLOAT NOT NULL,
  AST FLOAT NOT NULL,
  TOV FLOAT NOT NULL,
  STL FLOAT NOT NULL,
  BLK FLOAT NOT NULL,
  PF FLOAT NOT NULL,
  FP FLOAT NOT NULL,
  DD2 FLOAT NOT NULL,
  TD3 int NOT NULL,
  SALARY int(11) NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

 LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\SEASON_STATS.csv"
INTO TABLE SEASON_STATS
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
ESCAPED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

select * from season_stats;

-- PlayoffStats TABLE
 DROP TABLE IF EXISTS Playoff_Stats;
CREATE TABLE Playoff_Stats (
  season_id int(11) NOT NULL,
  player_id int(11) NOT NULL,
  team_id int(11) NOT NULL,
  games_played int(11) NOT NULL,
  minutes int(11) NOT NULL,
  points FLOAT NOT NULL,
  FGM FLOAT NOT NULL,
  FGA FLOAT NOT NULL,
  FG_PER FLOAT NOT NULL,
  3PM FLOAT NOT NULL,
  3PA FLOAT NOT NULL,
  3P_PER FLOAT NOT NULL,
  FTM FLOAT NOT NULL,
  FTA FLOAT NOT NULL,
  FT_PER FLOAT NOT NULL,
  OREB FLOAT NOT NULL,
  DREB FLOAT NOT NULL,
  REB FLOAT NOT NULL,
  AST FLOAT NOT NULL,
  TOV FLOAT NOT NULL,
  STL FLOAT NOT NULL,
  BLK FLOAT NOT NULL,
  PF FLOAT NOT NULL,
  FP FLOAT NOT NULL,
  DD2 FLOAT NOT NULL,
  TD3 int NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\PLAYOFFS.csv"
INTO TABLE PLAYOFF_STATS
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
ESCAPED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;



-- ADVANCE_STATS TABLE
 DROP TABLE IF EXISTS Advance_Stats;
CREATE TABLE Advance_Stats (
  season_id int(11) NOT NULL,
  player_id int(11) NOT NULL,
  team_id int(11) NOT NULL,
  offrtg FLOAT NOT NULL,
  defrtg FLOAT NOT NULL,
  netrtg FLOAT NOT NULL,
  ast_per FLOAT NOT NULL,
  OREB_PER FLOAT NOT NULL,
  DREB_PER FLOAT NOT NULL,
  reb_per FLOAT NOT NULL,
  EFG_PER FLOAT NOT NULL,
  ts_PER FLOAT NOT NULL,
  usg_PER FLOAT NOT NULL,
  PACE FLOAT NOT NULL,
  PIE DECIMAL(10,3) NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

 LOAD DATA INFILE "C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\ADVANCE_STATS.csv"
INTO TABLE ADVANCE_STATS
COLUMNS TERMINATED BY ','
OPTIONALLY ENCLOSED BY '"'
ESCAPED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;

SHOW TABLES;