# Data Structures Assignment # 1

```
1.Submit your HWs ONLINE before the due time and date  

2.HW reports should contain:  
a.The description of the problem and proposed solution  
b.The program code  
c.Any program outputs   

3.Submitted codes should be well-commented.   Problem Define a CourseRegisration class that keeps track of number of students registered for a given  course.  The  class  should  have  fields  for  the course name, number of registered students, maximum class size,  and  accessor  methods  for  accessing  and  printing  these fields.  The  class  will  also  have  a register   method  for  updating  (increment/decrement) number of registered students. Students should not be allowed to register and a warning message should be displayed when maximum class size is reached. Also don’t forget to check that number of students is always greater than or equal to zero.     Implement    two    subclasses, UndergradCourse    and GradCourse,    for    the CourseRegisration class:  •register method  of UndergradCourse class  should  allow  registration  of undergraduate students only.  •GradCourse  class  should  have  a quota  for  registration  of  undergraduate students. register method of GradCourse class should allow registration of undergraduates until this quota is filled. Write  a  test  code, 
TestRegistration,  to  show  that  different  registration  scenarios  areproducing correct outputs: 

Scenario 1: Undergrad  course of  max size 20; attempt to register 10 undergrads, then 3 grads, then 15 undergrads, then unregister 7 undergrads 

Scenario  2:  Grad  course  of  max  size  10,  undergrad  quota  4;  attempt  to  register  5 undergrads, then 6 grads, then unregister 1 undergrad, then register 4 grads 
```
