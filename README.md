# MusicWiki

### 	Reflexion AI Assignment



### NAME OF THE APP
MovieWiki <br/>
App Demo Video - https://drive.google.com/file/d/1kK_bDdyPTqa585BppV68y0WKpW-mbP9B/view?usp=drivesdk <br/>
Download App Link - https://drive.google.com/file/d/1kGm7F_4qPUJPoDohhUbAIViob3Rdz5fm/view?usp=drivesdk

### DESCRIPTION

MovieWiki contains information about different movies so that user can get the imformation about movie.
form MovieWiki user can watch the trailer of all movies


### How to use API Data to build app 
### Poster Image
"Movie Poster": "https://picsum.photos/1280/720"
Movie poster image url is same url for all movies ,but for every refresh of url is change the image
so to solve this problem i use need to refresh the image url in Glide using signature method
```
 Glide.with(context)
            .load(movie.Movie_Poster)
            .apply(RequestOptions.fitCenterTransform()
                .placeholder(R.drawable.place_holder)
                .signature(ObjectKey(System.currentTimeMillis())))
            .into(holder.movie_poster)
```

### Youtube Trailer Video
Every movies contian the "YouTube Trailer": "rlZ5MG-E2Ls" this is the youtube Trailer code of movie so i replace this youtube url
```
https://www.youtube.com/watch?v=YouTube Trailer
```
and start new intent
```
 var intent:Intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v="+movie_Data.YouTube_Trailer));
            startActivity(intent)
```

### Dependencies Used
```
    // retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

// GSON
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// coroutine
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2'
    
// ViewModel
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.1'
    
//room
    implementation "androidx.room:room-runtime:2.2.4"
    kapt "androidx.room:room-compiler:2.2.4"
    implementation "androidx.room:room-ktx:2.2.5"

//    glide
    implementation 'com.github.bumptech.glide:glide:4.4.0'
    kapt 'com.github.bumptech.glide:compiler:4.4.0'

    //expandable text
    implementation 'com.ms-square:expandableTextView:0.1.4'
    
//circleimage
    implementation 'de.hdodenhof:circleimageview:3.1.0'
```


### ARCHITECTURE
 - MVVM Architecture

 
 ### Technologies Used
Kotlin	<br/>
XML	<br/>
Retrofit	<br/>
http://task.auditflo.in/2.json API <br/>




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




