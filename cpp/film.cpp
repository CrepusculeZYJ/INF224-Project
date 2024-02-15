/**
 * @file film.cpp
 * @brief Implementation of the Film class.
 * 
 * This code uses smart pointers instead of normal ones, but the way to do the normal ones is written in the comments.
*/
#include <iostream>
#include <string>
#include "film.h"
using namespace std;
/**
 * @brief Default constructor of the Film class.
*/
Film::Film ( ) {
    durationOfChapters=nullptr;
    numberOfChapters=0;
}
/**
 * @brief Constructor of the Film class.
 * @param name Name of the film.
 * @param pathname Pathname of the film.
 * @param duration Duration of the film.
 * @param numberOfChapters Number of chapters of the film.
 * @param durationOfChapters Duration of the chapters of the film.
*/
Film::Film (string name,string pathname,int duration,int numberOfChapters,shared_ptr<int> durationOfChapters) : Video(name,pathname,duration) {
    this->numberOfChapters=numberOfChapters;
    this->durationOfChapters=shared_ptr<int>(new int[numberOfChapters]);
    
    int* durationOfChaptersPtr=durationOfChapters.get();
    int* thisDurationOfChaptersPtr=this->durationOfChapters.get();
    for (int i=0;i<numberOfChapters;i++) {
        thisDurationOfChaptersPtr[i]=durationOfChaptersPtr[i];
    }

    /*
    If using normal pointers:

    this->numberOfChapters=numberOfChapters;
    this->durationOfChapters=new int[numberOfChapters];

    for (int i=0;i<numberOfChapters;i++) {
        this->durationOfChapters[i]=durationOfChapters[i];
    }
    */
}
/**
 * @brief Destructor of the Film class.
*/
Film::~Film ( ) {
    /*
    If using normal pointers:

    delete[] durationOfChapters;
    */
}
/**
 * @brief Get the duration of the chapters of the film.
 * @return The duration of the chapters of the film.
*/
shared_ptr<int> Film::getDurationOfChapters ( ) const {
    return durationOfChapters;
}
/**
 * @brief Get the number of chapters of the film.
 * @return The number of chapters of the film.
*/
int Film::getNumberOfChapters ( ) const {
    return numberOfChapters;
}
/**
 * @brief Set the duration of the chapters of the film.
 * @param numberOfChapters Number of chapters of the film.
 * @param durationOfChapters Duration of the chapters of the film.
*/
void Film::setDurationOfChapters (int numberOfChapters,shared_ptr<int> durationOfChapters) {
    if (this->numberOfChapters!=numberOfChapters) {
        this->numberOfChapters=numberOfChapters;
        this->durationOfChapters=shared_ptr<int>(new int[numberOfChapters]);
    }
    int* durationOfChaptersPtr=durationOfChapters.get();
    int* thisDurationOfChaptersPtr=this->durationOfChapters.get();
    for (int i=0;i<numberOfChapters;i++) {
        thisDurationOfChaptersPtr[i]=durationOfChaptersPtr[i];
    }

    /*
    If using normal pointers:

    if (this->numberOfChapters!=numberOfChapters) {
        this->numberOfChapters=numberOfChapters;
        delete[] this->durationOfChapters;
        this->durationOfChapters=new int[numberOfChapters];
    }
    for (int i=0;i<numberOfChapters;i++) {
        this->durationOfChapters[i]=durationOfChapters[i];
    }
    */
}
/**
 * @brief Overload of the operator= for the Film class.
 * @param film Film to copy.
*/
Film& Film::operator= (const Film& film) {
    Video::operator=(film);
    setDurationOfChapters(film.numberOfChapters,film.durationOfChapters);
    return *this;
}
/**
 * @brief Print the information of the film.
 * @param out Output stream where the information is printed.
*/
void Film::print (ostream& out) const {
    Video::print(out);
    out<<"Number of chapters: "<<numberOfChapters<<endl;
    out<<"Duration of chapters: ";
    int* durationOfChaptersPtr=durationOfChapters.get();
    for (int i=0;i<numberOfChapters;i++) {
        out<<durationOfChaptersPtr[i]<<" ";
    }
    out<<endl;

    /*
    If using normal pointers:

    Video::print(out);
    out<<"Number of chapters: "<<numberOfChapters<<endl;
    out<<"Duration of chapters: ";
    for (int i=0;i<numberOfChapters;i++) {
        out<<durationOfChapters[i]<<" ";
    }
    out<<endl;
    */
}
/**
 * @brief Get the information of the film.
 * @return The information of the film.
*/
string Film::getInfo ( ) {
    string info="";
    info+=Video::getInfo()+" ; ";
    info+="Number of chapters: "+to_string(numberOfChapters)+" ; ";
    info+="Duration of chapters: ";
    int* durationOfChaptersPtr=durationOfChapters.get();
    for (int i=0;i<numberOfChapters;i++) {
        info+=to_string(durationOfChaptersPtr[i])+" ";
    }

    /*
    If using normal pointers:

    info+=Video::getInfo()+" ; ";
    info+="Number of chapters: "+to_string(numberOfChapters)+" ; ";
    info+="Duration of chapters: ";
    for (int i=0;i<numberOfChapters;i++) {
        info+=to_string(durationOfChapters[i])+" ";
    }
    */
    return info;
}