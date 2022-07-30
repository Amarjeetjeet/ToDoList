## Android Project: ToDoList 

## MVVM + Hilt + Flow + RoomDatabase + Navigation Component + Clean Architecture

## App Screenshots
<table>
  <tbody><tr>
    <td>Dashboard</td>
     <td>DatePicker in Add Task</td>
     <td>TimePicker in Add Task</td>
     <td>Add Task</td>
  </tr>
  <tr>
    <td valign="top">
      <a target="_blank" rel="noopener noreferrer" href="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/1.png">
        <img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/1.png" style="max-width: 100%;">
      </a>
    </td>
    <td valign="top"><a target="_blank" rel="noopener noreferrer" href="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/2.png">
      <img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/2.png" style="max-width: 100%;">
      </a>
    </td>
    <td valign="top"><a target="_blank" rel="noopener noreferrer" href="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/3.png">
      <img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/3.png" style="max-width: 100%;">
      </a>
    </td>
     <td valign="top">
       <a target="_blank" rel="noopener noreferrer" href="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/4.png">
         <img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/4.png" style="max-width: 100%;">
       </a>
    </td>
  </tr>
    <tr>
    <td>View Task</td>
     <td>Update Task</td>
  </tr>
   <tr>
    <td valign="top"><a target="_blank" rel="noopener noreferrer" href="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/5.png"><img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/5.png" style="max-width: 100%;">
      </a></td>
    <td valign="top"><a target="_blank" rel="noopener noreferrer" href="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/6.png"><img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/6.png" style="max-width: 100%;"></a></td>
  </tr>
  </tbody></table>


## 💡 Tech stack & Modern Library Tools
<ul dir="auto">
<li><a href="https://developer.android.com/kotlin/coroutines" rel="nofollow">Kotlin, Coroutines + Flow for asynchronous</a></li>
<li><a href="https://developer.android.com/training/dependency-injection/hilt-android" rel="nofollow">Dependency injection with Hilt</a></li>
<li><a href="https://developer.android.com/guide/navigation/" rel="nofollow">Jetpack Navigation</a></li>
<li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel" rel="nofollow">ViewModel - UI related data holder, lifecycle aware</a></li>
<li><a href="https://developer.android.com/training/data-storage/room" rel="nofollow">Room Persistence - local database</a></li>
<li><a href="https://developer.android.com/topic/libraries/view-binding" rel="nofollow">MVVM Architecture (View - DataBinding - ViewModel - Model)</a></li>
<li><a href="https://github.com/bumptech/glide">Glide - loading images</a></li>
<li><a href="https://square.github.io/retrofit/" rel="nofollow">Retrofit2 &amp; OkHttp3 - construct the REST APIs and paging network data</a></li>
<li><a href="https://github.com/google/gson">Gson - JSON representation</a></li>
<li><a href="https://material.io/design" rel="nofollow">Material-Components - Material design components</a></li>
</ul>

## 💡 Features
- Task Add
- Task Edit
- Task Delete
- Task Update
- Task View

## 💡 What is Clean Architecture?
Clean architecture is a category of software design pattern for software architecture that follows the concepts of clean code and implements SOLID principles

It’s essentially a collection of best practice design principles that help you keep business logic, or domain logic, together and minimize the dependencies within the system.

Clean architecture is a method of software development in which you should be able to identify what a program performs merely by looking at its source code. Robert C. Martin, also known as Uncle Bob, came up with the Clean Architecture concept in the year 2012.

<img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/clean_architecture_software.jpg" style="max-width: 100%;">

## 💡 Why Clean Architecture?
Separation of Concerns — Separation of code in different modules or sections with specific responsibilities making it easier for maintenance and further modification. Loose coupling — flexible code anything can be easily be changed without changing the system Easily Testable

<img src="https://github.com/Amarjeetjeet/ToDoList/blob/main/result/clean_arch.png" style="max-width: 100%;">
We have not used Use cases because it will too much overkill for small project
  
## 💡 Layers of clean architecture
<ul>
  <li>
    Presentation or UI: A layer that interacts with the UI, mainly Android Stuff like Activities, Fragments, ViewModel, etc. It is dependent on Use Cases.
  </li>
   <li>
Domain: Contains the business logic of the application. It is the individual and innermost module.
  </li>
   <li>
Data: It includes the domain layer. It would implement the interface exposed by domain layer and dispenses data to app.
  </li>
  </ul>
  
  ## 💡 Advantages of Using Clean Architecture
<ul>
  <li>
Easily testable.
  </li>
   <li>
Scalable.
  </li>
   <li>
Your team can add new features even more quickly.
  </li>
  <li>
    The project is even easier to maintain.
  </li>
  </ul>
  

  
