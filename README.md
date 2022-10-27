# LIbabry_Managment
#### A Library Management System Project in Java is one of the various systems developed that has numerous functionalities that meet the current requirements of the present-day library system.
- NETBeans IDE is used for UI/UX development. 
- JAVA SWING and JAVA API -JDBC(Java Database Connectivity)used.
- An Executable jar file is added to dict/Library_management.jar [](dist/Library_Management.jar)
#### [NOTE] external library used for the pie-chart and text field to have place holder feature.
#### - to use JDBC created a seperate java file for the database connectivity (src/JFrame/DBConnection.java) change user and password 

#### Using JDBC JAVA API a succesfull CURD(Create- Update-Read-Delete) operation is performed.

## signup Page
### Feature

- if userID is already avaliable will show the avaliable user message
- Used RegX to make sure that the user will provide a valid email-id.

![Screenshot 2022-10-27 192647](https://user-images.githubusercontent.com/108564689/198313919-a305240d-0a62-491d-ac87-51319f4b3bba.png)

## Login Page 
### Feature
- if entered userid not avaliable then will show error after focus removed from user text field.

![Screenshot 2022-10-27 192811](https://user-images.githubusercontent.com/108564689/198314098-f5e520e5-e4d7-4e60-a582-d7e2e8ed3fce.png)

## Home Screen
- contains a well maintained dasboard , to get no of book avaliable, issued, no of students and defaulters
- A Pia-chart to have the visuals of the no of book are avaliable
- 
![Screenshot 2022-10-27 192859](https://user-images.githubusercontent.com/108564689/198314211-c864acfa-db36-42ca-9f71-ab82f06cc9c2.png)


## Manage Book Page
### feature 
- Add , Udate, Delete and Read book details from the database 
- several method used to check wether that particular book is avaliable or not 

![Screenshot 2022-10-27 192926](https://user-images.githubusercontent.com/108564689/198314558-96b9ffef-71af-4a1f-b804-69b19a5e05cb.png)

## Manage Student Page
### feature 
- Add , Udate, Delete and Read student details from the database 
- several method used to check wether that particular student is avaliable or not 

![Screenshot 2022-10-27 192947](https://user-images.githubusercontent.com/108564689/198314679-f30fc4d2-0791-4832-a5bd-1ee962f250da.png)

## Issue Book Page
### feature 
- issue an book to user 
- method to find the student and book , is book already assigned to the user, are book avaliable in the library

![Screenshot 2022-10-27 193045](https://user-images.githubusercontent.com/108564689/198314767-209431ad-afe2-4a7a-876b-5e0211aae72b.png)

## Return Book Page
### feature 
- Return book to user
- methods to check wether the particular book is issued to student or not then return the book

![Screenshot 2022-10-27 193130](https://user-images.githubusercontent.com/108564689/198314871-6cd91da1-1e79-400b-b520-5121313d7e28.png)

## Issue Book Details Page
### feature
-show the deatils of book already issued to the student 

![Screenshot 2022-10-27 193159](https://user-images.githubusercontent.com/108564689/198314986-48e392a2-0c0f-439a-bd5d-dd96d530da95.png)

## Defaulter Page
### feature
- shoe the deatails of student have not retured the book with expired issue due date.
- 
![Screenshot 2022-10-27 193220](https://user-images.githubusercontent.com/108564689/198315084-9d93fdad-17be-41c2-ac10-d186cc6a7d5f.png)
