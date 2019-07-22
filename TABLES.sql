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
  play_style_id int(4) ,
  play_style_name varchar(100)  NOT NULL,
  PRIMARY KEY (`play_style_id`)
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  birthdate DATE NOT NULL,
  height float  NOT NULL,
  weight float  NOT NULL,
  Experience int  NOT NULL,
  Status tinyint NOT NULL,
  Position_ID int  NOT NULL,
  team_id int(4)  NOT NULL,
  PRIMARY KEY (`player_id`),
 FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
  
  -- SEASON  TABLE

DROP TABLE IF EXISTS season;
CREATE TABLE season (
  season_id int(11) NOT NULL,
  champions_id int(11)  NOT NULL,
  finals_mvp_id int(11) NOT NULL,
  mvp_id int(11) NOT NULL,
  PRIMARY KEY (`season_id`),
 FOREIGN KEY (`champions_id`) REFERENCES `team` (`team_id`),
 FOREIGN KEY (`finals_mvp_id`) REFERENCES `player` (`player_id`),
 FOREIGN KEY (`mvp_id`) REFERENCES `player` (`player_id`)
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- COACH  TABLE

DROP TABLE IF EXISTS coach;
CREATE TABLE coach (
  coach_id int(11) NOT NULL,
  coach_name varchar(100)  NOT NULL,
  birthdate DATE NOT NULL,
  offensive_grade int  NOT NULL,
  defensive int  NOT NULL,
  num_COTY_awards int NOT NULL,
  play_style_id int(4) NOT NULL,
  PRIMARY KEY (`coach_id`),
 FOREIGN KEY (`play_style_id`) REFERENCES `pLay_style` (`play_style_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
  
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
  
  
    -- INJURY TABLE

DROP TABLE IF EXISTS INJURY;
CREATE TABLE INJURY (
  injury_id int(11) NOT NULL,
  injury_name varchar(100) NOT NULL,
  severity int(1) NOT NULL,
    PRIMARY KEY (`injury_id`)
  )ENGINE=InnoDB DEFAULT CHARSET=latin1;  
  
  
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

-- AWARD TABLE
 DROP TABLE IF EXISTS award;
CREATE TABLE award (
  award_id int(11) NOT NULL,
  award_name varchar(50) NOT NULL,
  PRIMARY KEY (`award_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


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



-- SEASON_STATS TABLE
 DROP TABLE IF EXISTS season_stats;
CREATE TABLE season_stats (
  season_id int(11) NOT NULL,
  player_id int(11) NOT NULL,
  team_id int(11) NOT NULL,
  games_started int(11) NOT NULL,
  games_played int(11) NOT NULL,
  minutes int(11) NOT NULL,
  points FLOAT NOT NULL,
  assists FLOAT NOT NULL,
  rebounds FLOAT NOT NULL,
  blocks FLOAT NOT NULL,
  steals FLOAT NOT NULL,
  turnovers FLOAT NOT NULL,
  fouls_committed FLOAT NOT NULL,
  fouls_drawn FLOAT NOT NULL,
  fg_PER FLOAT NOT NULL,
  3p_PER FLOAT NOT NULL,
  ft_PER FLOAT NOT NULL,
  ft_attempted FLOAT NOT NULL,
  3p_attempted FLOAT NOT NULL,
  double_doubles int(11) NOT NULL,
  triple_doubles int(11) NOT NULL,
  games_suspended int(11) NOT NULL,
  fines int(11) NOT NULL,
  amount_fined FLOAT NOT NULL,
  technical_fouls INT(11) NOT NULL,
  salary FLOAT NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;



-- PlayoffStats TABLE
 DROP TABLE IF EXISTS PlayoffStats;
CREATE TABLE PlayoffStats (
  season_id int(11) NOT NULL,
  player_id int(11) NOT NULL,
  team_id int(11) NOT NULL,
  games_started int(11) NOT NULL,
  games_played int(11) NOT NULL,
  minutes int(11) NOT NULL,
  points FLOAT NOT NULL,
  assists FLOAT NOT NULL,
  rebounds FLOAT NOT NULL,
  blocks FLOAT NOT NULL,
  steals FLOAT NOT NULL,
  turnovers FLOAT NOT NULL,
  fouls_committed FLOAT NOT NULL,
  fouls_drawn FLOAT NOT NULL,
  fg_PER FLOAT NOT NULL,
  3p_PER FLOAT NOT NULL,
  ft_PER FLOAT NOT NULL,
  ft_attempted FLOAT NOT NULL,
  3p_attempted FLOAT NOT NULL,
  double_doubles int(11) NOT NULL,
  triple_doubles int(11) NOT NULL,
  games_suspended int(11) NOT NULL,
  fines int(11) NOT NULL,
  amount_fined FLOAT NOT NULL,
  technical_fouls INT(11) NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;




-- ADVANCE_STATS TABLE
 DROP TABLE IF EXISTS Advance_Stats;
CREATE TABLE Advance_Stats (
  season_id int(11) NOT NULL,
  player_id int(11) NOT NULL,
  team_id int(11) NOT NULL,
  offrtg FLOAT NOT NULL,
  defrtg FLOAT NOT NULL,
  netrtg FLOAT NOT NULL,
  ts_PER FLOAT NOT NULL,
  usg_PER FLOAT NOT NULL,
  ws FLOAT NOT NULL,
  bpm FLOAT NOT NULL,
  FOREIGN KEY (`season_id`) REFERENCES `season` (`season_id`),
  FOREIGN KEY (`team_id`) REFERENCES `team` (`team_id`),
  FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`)
)ENGINE=InnoDB DEFAULT CHARSET=latin1;


SHOW TABLES;