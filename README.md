## EXERCISE 1 - Problem Statement on Design patterns

  #### Two use cases to demonstrate two behavioural design pattern.

  **>Observer (Youtube channel and Subscriber)**
  
  **>Strategy (Sorting of students based on Name,Age and marks)**
  
  #### Two use cases to demonstrate two creational design pattern.

  **>Factory (Creation of Pdf and word document objects)**
  
  **>Singleton (Database connection)**
  
  #### Two use cases to demonstrate two structural design pattern.
  
  **>Adaptor (Payment processor)**
  
  **>Composite (Computer and its components)**

  ## EXERCISE 2: 1) Astronaut Daily Schedule Organizer

**The Astronaut Daily Scheduler is an application that helps astronauts plan and manage their daily activities. It ensures tasks do not overlap in time and allows viewing, adding, removing, editing, and filtering tasks by priority.**

**Classes:**

**>AstronautScheduleSystem(Observer)**

**>Task**

**>TaskFactory(Factory)**

**>ScheduleManager(Singleton + System)**

**>Main**

**Interface:**

**>SchedulerSystem**

**>Observer**

**Enum:**

**>TaskStatus**

**Exception classes:**

**>TaskException**

**>InvalidTaskException**

**>TaskConflictException**

**>TaskNotFoundException**

**>TaskExistException**

**Pattern Used: Singleton pattern,Factory pattern ,Observer pattern**

## Features

**>Add new Task**

**>View task**

**>Remove task**

**>Check overlapping conflicts while adding new task**

**>Sort tasks by startTime**

## Additional Features

**>Edit task**

**>View task by Priority**

### Adding a New Task

<img width="926" height="383" alt="image" src="https://github.com/user-attachments/assets/a141576d-79c3-432e-a777-f43bebba27ef" />

### View Scheduled Tasks

<img width="918" height="256" alt="image" src="https://github.com/user-attachments/assets/88db15f7-9538-488a-9a93-572209210cbe" />

### Remove a Task

<img width="981" height="145" alt="image" src="https://github.com/user-attachments/assets/a2581eb5-71c4-4d0a-96b7-f4e52eb9a2f8" />

### Detect Conflict while adding a New Task

<img width="1000" height="142" alt="image" src="https://github.com/user-attachments/assets/f93e4948-11b6-4326-bbfd-d04f55222a19" />

### Edit a Task

<img width="960" height="212" alt="image" src="https://github.com/user-attachments/assets/4cc44518-dc3d-4162-9d79-8a7e14818372" />

### View Task by specified priority

<img width="986" height="402" alt="image" src="https://github.com/user-attachments/assets/2a43be7f-db97-4524-b0e7-70ff834b04f9" />

### Removal of a Non Existing task

<img width="1027" height="268" alt="image" src="https://github.com/user-attachments/assets/f7fdad24-82ba-415c-b788-fe07794043a8" />

### Invalid Time input

<img width="960" height="128" alt="image" src="https://github.com/user-attachments/assets/c21018a7-8f32-4c71-a0f3-ace918f7cc6a" />

### Invalid Input Cases

<img width="972" height="132" alt="image" src="https://github.com/user-attachments/assets/0df1668f-79e6-44fa-b098-4b97e9f13611" />

<img width="980" height="140" alt="image" src="https://github.com/user-attachments/assets/d70a56cc-0f80-4028-a5ec-6fb70c6c0eed" />

### Unknown Command

<img width="1087" height="122" alt="image" src="https://github.com/user-attachments/assets/d165736c-9476-4146-944a-296292f803cb" />

### Exit the Application

<img width="618" height="127" alt="image" src="https://github.com/user-attachments/assets/4c6768cf-d8e7-497c-afe6-e6eb59b58a55" />






