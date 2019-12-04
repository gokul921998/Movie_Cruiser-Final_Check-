USE movie_cruiser;

/* script to insert data into movie table - TYUC001 */
INSERT INTO movie VALUES(DEFAULT, 'Avatar', 2787965087, 'Yes', '2017/03/15', 'Science Fiction', 'Yes'),
                            (DEFAULT, 'The Avengers', 1518812988, 'Yes', '2017/12/23', 'SuperHero', 'No'),
                            (DEFAULT, 'Titanic', 2187463944, 'No', '2017/08/21', 'Romance', 'No'),
                            (DEFAULT, 'Jurassic World', 1671713208, 'Yes', '2017/07/02', 'Science Fiction', 'Yes'),
                            (DEFAULT, 'Avengers: End Game', 2750760348, 'Yes', '2022/11/02', 'SuperHero', 'Yes');

/* script to fetch data from movie table for admin- TYUC001 */
SELECT * FROM movie;

/* script to fetch data from movie table for customer- TYUC002 */
SELECT mo_id AS 'Id', mo_title AS 'Title', mo_has_teaser AS 'Has Teaser', mo_box_office AS 'Box Office', mo_genre AS 'Genre' FROM movie WHERE mo_active = 'Yes' AND mo_date_of_launch <= now();

/* script to fetch data from movie table - TYUC003 */
SELECT * FROM movie WHERE mo_id = 3;

/* script to update data in movie table - TYUC003 */
UPDATE movie SET mo_title='Hugo', mo_box_office='1548963258', mo_date_of_launch='2018/03/28' WHERE mo_id = 4;

/* script to add data into user table - TYUC004 */
INSERT INTO user VALUES (DEFAULT, 'Gokul'),
                        (DEFAULT, 'Logesh');

/* script to add data into favorites table - TYUC004 */
INSERT INTO favorites VALUES (DEFAULT, 1, NULL), 
                        (DEFAULT, 2, 1),
                        (DEFAULT, 2, 2),
                        (DEFAULT, 2, 4);
                        
/* script to get all movies in user's favorites - TYUC005*/
SELECT movie.mo_id AS 'Id', movie.mo_title AS 'Title', movie.mo_has_teaser AS 'Has Teaser', movie.mo_box_office AS 'Box Office', movie.mo_genre AS 'Genre'
 FROM movie INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id WHERE favorites.fa_us_id = 2;

/* script to get number of favorites in user's favorites - TYUC005*/
SELECT COUNT(*) AS 'Numer of favorites' FROM movie INNER JOIN favorites ON movie.mo_id = favorites.fa_mo_id WHERE favorites.fa_us_id = 1;

/* script to remove movie from user's favorites - TYUC006*/
DELETE FROM favorites WHERE  fa_us_id = 2 AND fa_mo_id = 1;