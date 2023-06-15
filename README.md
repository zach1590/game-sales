Project to learn about Spring Boot and React as well as full stack applications in general

Data to initially populate the database was taken from kaggle from the following sources:

Game Summaries, User Reviews, Genres:
https://www.kaggle.com/datasets/arnabchaki/popular-video-games-1980-2023

Sales Data and General Information like release date:
https://www.kaggle.com/datasets/devrimtuner/top-100-video-games

Links to Trailers and Images were compiled myself from various random sources

Version:
Java 17
Spring Boot 3.1.0
Apache Maven 3.9.2
npm 9.5.1
node 18.16.0
PostgreSQL 15.3

Everything runs on localhost for now at least

# How to Run:
## Database
First clone the repository and the enter repositories top level directory. Then run the following:
 - `cd bestselling_videogame_data`
 - `psql -U <username> -f init_db.sql` (You'll be prompted for your PostgreSQL password)

A database has been created and populated with data from the csv files. The database is named `gamesales` so if you have another database named the same way, there may be issues. Inside the `gamesales` database, there will be 4 tables corresponding each csv file. The tables are named `bestselling`, `images`, `genres`, and `reviews`. 

NOTE: The `images` table only stores the name of the images, the actual images are kept inside the following directory: `backend/game_sales/src/main/resources/game_images`

You will need to specify the port that your PostgreSQL database is running on (as well as username and password) inside a `.env` file. This file should be located within `backend/game_sales/src/main/resources/` follow the `.env.example` located in the same directory for help.

That should conclude database setup

## Backend
When you set up your database, you had to create and modify the `.env` file. There is one last field that needs to be set up which is the folder you will be attempting to save and upload images to (`IMAGE_FOLDER`). Copy the images from `bestselling_videogame_data/game_images` to another location on your computer where you have write access or if you would like to just continue using the current location. Set the absolute path of the chosen directory equal to `IMAGE_FOLDER` within the `.env` file.

NOTE 1: Remember the trailing '/' for the directory

NOTE 2: '/' will still work on windows ('\\\\' is uneccessary)

Finally to run the backend:
 - `cd backend`
 - `cd game_sales`
 - `mvn spring-boot:run`

Will start the backend running at localhost:8080

## Frontend
