# Télécom Paris INF224 Project

## Intruction

In order to launch the project, first you need to go to the ```cpp``` folder:
```
$ cd cpp
```
Then using this command to start the server:
```
$ make run
```

After that, **open a new terminal** and go to the ```swing``` folder:
```
$ cd swing
```
Using this command to open the graphical interface:
```
$ make run
```
To test the project, you first need to click on the **Connect** button. If the connection is successful, you will receive a message telling you this.
After that, you can see the menu on the top of the interface. Try to create a multimedia first, otherwise there is no multimedia in the database!
To test the file in the ```multimedia``` folder, you can simply set the pathname ```../multimedia/$FILENAME$``` when you create it. For example, ```../multimedia/1.mp4```. Then click on the **Play** button to test it.
Have fun!

## Answers of the questions

## C++ Part

### Q4
Pure virtual function.
We put ```virtual``` in the front and ```=0``` in the end of the definition.
We cannot create objects of this class because this function is not well defined. We should create a derived class and override this function in order to have it defined.

### Q5
Polymorphism.
In C++, we need virtual methods and virtual destructor.
The pointers. In Java, there is no problem because the objects are passed by references.

### Q7
If we do the shallow copy, these pointers simply point to the same object. In this case, if we delete one pointer, the pointed object is destructed according to the destructor. Thus, the other pointer point to an address which contains unknown data.
To solve this problem, we need to overload the operator ```=```. We should do the deep copy. That is to say, when copying pointers, we create a new copy to the pointed object and make the pointer point to it.

### Q8
It should be a list of pointers because they need to point to objects of different multimedia types. That's how polymorphism in C++ works.

### Q10
To prevent creating the object with ```new```, we can set the constructor to ```private```.

### Q11
Besides **SEARCH** and **PLAY**, I also added **CREATE** and **DELETE**, which can be used to create or delete a photo/video respectively.

### Q12, Q13 not treated

## Java Swing Part

### Q1
We notice that after many clicks, the text exceeds the window. We can use the ```JScrollPane``` component that adds a vertical and horizontal scrollbar when necessary.