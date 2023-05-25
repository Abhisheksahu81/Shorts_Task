# YouTube Shorts App

## Description
YouTube Shorts App is an Android application that allows users to discover and watch short videos. It provides a clean user interface and utilizes the Retrofit library to fetch data from the API endpoint: [https://internship-service.onrender.com/videos?page=2](https://internship-service.onrender.com/videos?page=2). The app implements pagination to fetch data in chunks, enhancing the browsing experience for users.

## Demo
Video Link : https://drive.google.com/file/d/1hD2Nj4rArF1ZDHv4ROwzzyiRbzwVB_P3/view?usp=share_link

## Features

1. **Retrofit Library for Data Fetching**: The app leverages the Retrofit library to interact with the API and retrieve video data. The API endpoint used for data retrieval is [https://internship-service.onrender.com/videos?page=2](https://internship-service.onrender.com/videos?page=2). This allows the app to efficiently fetch and display videos.

2. **Pagination**: The app implements pagination to load data in chunks, enhancing performance and reducing data transfer. Pagination ensures a smooth browsing experience by loading additional videos as the user scrolls.

3. **Clean User Interface**: The app provides a clean and intuitive user interface, offering an enjoyable browsing experience. The UI design focuses on simplicity and ease of use, allowing users to navigate through videos effortlessly.

4. **Thumbnail Activity**: The app's initial activity is the Thumbnail Activity. Here, users are presented with a collection of video thumbnails displayed in a RecyclerView. Pagination is implemented, enabling the loading of more videos as the user scrolls.

5. **Video Activity**: The Video Activity is the second activity in the app. It eliminates the need for an extra API call as it receives all the necessary data through the intent from the Thumbnail Activity. Users can seamlessly watch videos without interruption.

6. **Vertical Scrolling with ViewPager2**: In the Video Activity, a ViewPager2 is implemented along with a RecyclerView to enable vertical scrolling through videos. This feature allows users to view one video after another effortlessly.

7. **ExoPlayer for Video Playback**: The app utilizes ExoPlayer, a powerful media playback library, to fetch and play videos from the provided URLs. With ExoPlayer, users can enjoy a smooth and high-quality video streaming experience within the app.

## Requirements

- Android device running Android 5.0 (Lollipop) or higher.
- Internet connection to fetch video data and stream videos.

## Installation
Download APK file from here : https://github.com/Abhisheksahu81/Shorts_Task/blob/master/app-debug.apk
OR
1. Clone the repository from [GitHub](https://github.com/your-repository-link).
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

## Credits
- Retrofit: [https://square.github.io/retrofit/](https://square.github.io/retrofit/)
- ExoPlayer: [https://exoplayer.dev/](https://exoplayer.dev/)

