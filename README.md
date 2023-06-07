Project to learn about Spring Boot and React as well as full stack applications in general

Data to initially populate the database was taken from kaggle from the following sources:

Game Summaries, User Reviews, Genres:
https://www.kaggle.com/datasets/arnabchaki/popular-video-games-1980-2023

Sales Data and General Information like release date:
https://www.kaggle.com/datasets/devrimtuner/top-100-video-games

Links to Trailers and Images were compiled myself from various random sources

Version:
Spring Boot 3.1.0
Java 17
npm 9.5.1
node 18.16.0

Everything runs on localhost for now at least

# How to Run:
## Database
First clone the repository and the enter repositories top level directory. Then run the following:
 - `cd bestselling_videogame_data`
 - `psql -U <username> -f init_db.sql` (You'll be prompted for your PostgreSQL password)

A database has been created and populated with data from the csv files. The database is named `gamesales` so if you have another database named the same way, there may be issues. Inside the `gamesales` database, there will be 4 tables corresponding each csv file. The tables are named `bestselling`, `images`, `genres`, and `reviews`. 

NOTE: The `images` table only stores the name of the images, the actual images are kept inside the following directory: `backend/game_sales/src/main/resources/game_images`

You will need to specify the port that your PostgreSQL database is running on (as well as username and password) inside `backend/game_sales/src/main/resources/.env` follow the `.env.example` for help.

That should conclude database setup

## Backend
 - This will be updated once complete

## Frontend
