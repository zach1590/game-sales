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

### Setup
When you set up your database, you had to create and modify the `.env` file. There is one last field that needs to be set up which is the folder you will be attempting to save and upload images to (`IMAGE_FOLDER`). Copy the images from `bestselling_videogame_data/game_images` to another location on your computer where you have write access or if you would like to just continue using the current location. Set the absolute path of the chosen directory equal to `IMAGE_FOLDER` within the `.env` file.

NOTE 1: Remember the trailing '/' for the directory

NOTE 2: '/' will still work on windows ('\\\\' is uneccessary)

### How to Run
Finally to run the backend:
 - `cd backend`
 - `cd game_sales`
 - `mvn spring-boot:run`

Will start the backend running at localhost:8080

### Endpoints
**games**   
GET `/api/v1/games`: Returns all the general data except genre information for all games in the database  
GET `/api/v1/games/{titleid}`: Returns the general data except genre for a single movie with specified titleid  
GET `/api/v1/games/top`: Returns the data for the top10 bestselling games except for their genres

**genres**  
GET `/api/v1/genres`: Returns a list of all the genres that exist  
GET `/api/v1/genres/bytitle/{titleId}`: Returns a list of the genres for the game corresponding to titleid
GET `/api/v1/genres/{gameGenre}`: Returns the all games corresponding to that specific genre

**images**  
GET `/api/v1/images/bytitle/{titleId}`: Returns a list of image data (imageId, titleId, imageName) for the game corresponding to titleid (This doesn't return an actual displayable image)  
GET `/api/v1/images/{imageId}`: Return a displayable image corresponding to imageId  
GET `/api/v1/images/byname/{imageName}`: Return a displayable image corresponding to imageName  
POST `/upload`: Add a new image for a specific game, the format is FormData with the following expected key-value pairs {imageName: "", image: imageFile , titleId: 0}

**reviews**  
POST `/api/v1/reviews`: Post a new review for a game, the format is a JSON {reviewBody: "", titleId: 0}  
GET `/api/v1/reviews/bytitle/{titleId}`: Returns a list of all reviews for the game corresponding to titleid

## Frontend
