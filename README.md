# MusicWiki

### NAME OF THE APP
MusicWiki <br/>
App Demo Video - https://drive.google.com/file/d/1kK_bDdyPTqa585BppV68y0WKpW-mbP9B/view?usp=drivesdk <br/>
Download App Link - https://drive.google.com/file/d/1kGm7F_4qPUJPoDohhUbAIViob3Rdz5fm/view?usp=drivesdk

### DESCRIPTION

MusicWiki contains information about different music genres,
the albums, artists and tracks listed under the genre.

### API

All of the required information for building this app is available in the API provided by last.fm.
You can get more information at https://www.last.fm/api

### REQUIRED API CALLS FOR MUSICWIKI

- tag.getTopTags 
- tag.getInfo
- tag.getTopAlbums
- tag.getTopArtists
- tag.getTopTracks
- album.getInfo
- album.getTopTags
- artist.getInfo
- artist.getTopTags
- artist.getTopAlbums
- artist.getTopTracks

### ARCHITECTURE
 - MVC Architecture
 - Singleton Design Pattern
 
 ### Technologies Used
JAVA	<br/>
XML	<br/>
Retrofit	<br/>
Last.fm API <br/>

### OPERATIONS

#### 1. HOME SCREEN - displays initially 10 genres, can expand list to view all genres
#### OUTPUT

![Untitled design](https://user-images.githubusercontent.com/87861834/218254256-a2f10e46-c3ae-4b5b-acf0-b7c3d8758432.png)


#### 2. GENRE DETAIL SCREEN - display genre information with albums, artists and tracks
#### OUTPUT

![Untitled design (1)](https://user-images.githubusercontent.com/87861834/218254526-b586ae34-5c8c-4533-be99-8f69dc0bd3b0.png)


#### 3. ALBUM DETAIL SCREEN - display album information and genre
#### OUTPUT
![Untitled design (2)](https://user-images.githubusercontent.com/87861834/218254858-263e14b9-31cc-48ac-92c0-3f04db67f13a.png)



#### 4. ARTIST DETAIL SCREEN - display artist information, his top tracks, albums and genres
#### OUTPUT
![Untitled design (3)](https://user-images.githubusercontent.com/87861834/218255083-0b808fa8-ef8b-4ce0-a4fd-7f4ec00d4fed.png)




