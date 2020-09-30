# User Guide

## Features 

### 1: Add task
Creates a new task and adds it to the list. 
#### Usage

#### Keywords

`todo` - adds todo task  
`event` - adds event task  
`deadline` - adds deadline task  
`/` -  to be put after deadline and event, and date to be entered after the `/`

Example of usage: 

todo read book  
event birthday /tommorow  

Expected outcome:

Got it, I`ve added the task:  
[T][✗] read book  
1 tasks are in the list  

Got it, I`ve added the task:  
[E][✗] birthday /tommorow  
2 tasks are in the list  

### 2: Bye
Saves and exits the program.
#### Usage

#### Keywords

`bye`- exits the program

Example of usage:
`bye`

Expected outcome: 
See you again :)

### 3: List
Shows list of tasks
#### Usage

#### Keywords

`list` - shows list of tasks

Example of usage:
`list`

Expected outcome:  
1[T][✗] read book  
2[E][✗] birthday /tomorrow  

### 4:Save
Saves all tasks  
Note: Saving is automatic when you use the `bye` command.
#### Usage

#### Keywords

`save` - saves tasks

Example of usage:  
`save`  

Expected outcome:  
File has been saved!

### 5:Done
Sets a task to done
#### Usage

#### Keywords

`done` - sets a task to done

Example of usage:  
`done 2` - sets task 2 to done  

Expected outcome:    
Nice, the following task has been marked as done :)  
[E][✓] birthday /tomorrow  

### 6:Delete
Deletes a task
#### Usage

#### Keywords

`delete` - delete a task

Example of usage:  
`delete 2` - deletes task 2  

Expected outcome:  
Task number 2 has been deleted!

### 7: Find
Searches for a string in all task descriptions
#### Usage

#### Keywords

`find` - find a string

Example of usage:  
`find read` - searches for the "read" string  
`find haha`- searches for the "haha" string 

Expected outcome:  
1 tasks found:  
1[T][✗] read book

0 tasks found:


### 8: Help
Show commands
#### Usage

#### Keywords

`help`

Example of usage:
`help`  

Expected outcome:  
inputs are   
list : shows current tasks  
bye : exits the program  
done number : e.g done 2, sets the task at the number to done   
event name/date : e.g event Birthday /tomorrow   
todo name : e.g todo Homework  
deadline name/date : e.g deadline Project /next Sunday  
delete number : e.g delete 2, deletes a task  
find description : e.g find birthday, checks task`s names for description  
save: e.g save, saves the current list  
