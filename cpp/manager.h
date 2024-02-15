/**
 * @file manager.h
 * @brief Definition of the Manager class.
*/
#ifndef MANAGER_H
#define MANAGER_H
#include <string>
#include <iostream>
#include <memory>
#include <map>
#include "film.h"
#include "photo.h"
#include "group.h"
using namespace std;
/**
 * @class Manager
 * @brief This class is used to manage the multimedia objects and the groups of multimedia objects.
*/
class Manager {
public:
    Manager();
    ~Manager();
    shared_ptr<Photo> createPhoto(const string& name,const string& pathname,int latitude,int longitude);
    shared_ptr<Video> createVideo(const string& name,const string& pathname,int duration);
    shared_ptr<Film> createFilm(const string& name,const string& pathname,int duration,int numberOfChapters,shared_ptr<int> durationOfChapters);
    shared_ptr<Group> createGroup(const string& name);
    void search(const string& name);
    string searchAndGet(const string& name);
    void play(const string& name);
    string playAndGet(const string& name);
    string remove(const string& name);
private:
    map<string,shared_ptr<Multimedia>> tableMultimedia;
    map<string,shared_ptr<Group>> tableGroup;
};
#endif