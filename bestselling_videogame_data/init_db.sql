CREATE DATABASE gamesales;

\connect gamesales;

CREATE TABLE bestselling(titleId BIGSERIAL NOT NULL PRIMARY KEY,titleName TEXT,sales INT,series TEXT,platform TEXT,initialReleaseDate DATE,developer TEXT,publisher TEXT,artwork TEXT,video TEXT,summary TEXT);
\copy bestselling(titleName, sales, series, platform, initialreleasedate, developer, publisher, artwork, video, summary) FROM 'bestselling.csv' DELIMITER ',' CSV HEADER;

CREATE TABLE images(imageid BIGSERIAL NOT NULL PRIMARY KEY, titleId BIGINT, imagename TEXT, CONSTRAINT fk_title FOREIGN KEY(titleId) REFERENCES bestselling(titleId));
\copy images(titleId, imagename) FROM 'game-images.csv' DELIMITER ',' CSV HEADER;

CREATE TABLE genres(genreid BIGSERIAL NOT NULL PRIMARY KEY, titleId BIGINT, genre TEXT, CONSTRAINT fk_title FOREIGN KEY(titleId) REFERENCES bestselling(titleId));
\copy genres(titleId, genre) FROM 'genres.csv' DELIMITER ',' CSV HEADER;

CREATE TABLE reviews(reviewid BIGSERIAL NOT NULL PRIMARY KEY, titleId BIGINT, review TEXT, CONSTRAINT fk_title FOREIGN KEY(titleId) REFERENCES bestselling(titleId));
\copy reviews(titleId, review) FROM 'game-reviews.csv' DELIMITER ',' CSV HEADER;