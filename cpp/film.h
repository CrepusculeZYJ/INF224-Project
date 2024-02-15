/**
 * @file film.h
 * @brief Definition of the Film class.
*/
#ifndef FILM_H
#define FILM_H
#include <string>
#include <iostream>
#include <memory>
#include "video.h"
using namespace std;
/**
 * @class Film
 * @brief This class is a derived class from the Video class. It can be used to store the information of a film.
*/
class Film : public Video {
public:
    Film();
    Film(string name,string pathname,int duration,int numberOfChapters,shared_ptr<int> durationOfChapters);
    virtual ~Film();
    shared_ptr<int> getDurationOfChapters() const;
    int getNumberOfChapters() const;
    void setDurationOfChapters(int numberOfChapters,shared_ptr<int> durationOfChapters);
    Film& operator=(const Film& film);
    virtual void print(ostream& stream) const;
    virtual string getInfo();
private:
    shared_ptr<int> durationOfChapters;
    int numberOfChapters;
};
#endif