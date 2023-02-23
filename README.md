Employee Data Upload App
---------------------------

Welcome to Employees Data File Uploader! This application consists of two parts: a client-side app written in React and server-side app written in Java. The client-side app allows users to upload CSV files to the server, while the server-side app stores the files on the server.

## Installation
To install the application, you will need to clone this repository and install the nesessary dependecies for both the client-side and server-side apps;

## Client-side
To install the client-side app:

1. Navigate to the 'fileUploaderApp' directory.
2. Run in the system console 'npm install' to install necessary dependencies:
  <br><code>npm install bootstrap</code>
  <code>npm install Dropzone</code>
3. Once the dependecies are installed, you can run the app locally by running the command:
  <br><code>npm start</code>

1. Download file uploader web application from ./fileUploaderApp to your local 
2.. Download the data uploader server-side app from ./datauploader directory and run

## Server-side
To install the server-side app:

1. Navigate to the 'fileUploaderApp' directory
2. Run the command:
  <br><code>mvn clean package</code> to build the project and create the jar file.
3. Once the build is complete, you can run the app locally by runnin the command:
  <br><code>java jar target/datauploader-0.0.1-SNAPSHOT.jar</code>
  
# Running H2 Server-side with Java Database
To run H2 server-side with a Java database:
1. Open the H2 console by navigating to <b>http://localhost:8080</b> in your browser.
2. In the JDBC URL field, enter: <code>jdbc:h2:mem:testdb</code> to connect the H2 database. Use default user name: <code>sa</code> and <b>NO PASSWORD</b> as a default (this is just for testing purpose).
3. Click the Connect button to connect to the database.
4. You can then view the content of database using SQL commands.

## CSV file format
To upload correctly data to the server-side app, the CSV file should have the following format in with the <b>exact order<b>:
<br><br><code>name,surname,email,gender,deparment</code>
<br>
<strong>You can use <b>MOCK_DATA.csv</b> example file from the <b>datauploader/src/main/resources/</b> for testing purpose.</strong>
  
## Usage
To use the application:
1. Open your browser and navigate to: <b>http://localhost:3000/</b> to acces the client-side app.
2. You can then select a CSV file to upload and submit the form to upload the file to the server by draggin file to the dropzone field or simply by clicking the field and selecting file from you local storage.
3. You can then check from the H2 DataBase console the result of the uploaded records.

# FUTURE FEATURES
The additional display of H2 Database table records will be added soon to the client-side app.

## ADDITIONAL INFORMATIONS:
This application was made using:
- Java OpenJDK 19 and language level 19.
- React version used for this project: 18.2.0
