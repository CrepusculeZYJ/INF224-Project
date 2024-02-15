/**
 * @file manager.cpp
 * @brief Implementation of the Manager class.
*/
#include "manager.h"
using namespace std;
/**
 * @brief Default constructor of the Manager class.
*/
Manager::Manager ( ) {
}
/**
 * @brief Destructor of the Manager class.
*/
Manager::~Manager ( ) {
}
/**
 * @brief Create a photo.
 * @param name Name of the photo.
 * @param pathname Pathname of the photo.
 * @param latitude Latitude of the photo.
 * @param longitude Longitude of the photo.
 * @return The pointer to the photo.
*/
shared_ptr<Photo> Manager::createPhoto (const string& name,const string& pathname,int latitude,int longitude) {
    shared_ptr<Photo> photo(new Photo(name,pathname,latitude,longitude));
    tableMultimedia[name]=photo;
    return photo;
}
/**
 * @brief Create a video.
 * @param name Name of the video.
 * @param pathname Pathname of the video.
 * @param duration Duration of the video.
 * @return The pointer to the video.
*/
shared_ptr<Video> Manager::createVideo (const string& name,const string& pathname,int duration) {
    shared_ptr<Video> video(new Video(name,pathname,duration));
    tableMultimedia[name]=video;
    return video;
}
/**
 * @brief Create a film.
 * @param name Name of the film.
 * @param pathname Pathname of the film.
 * @param duration Duration of the film.
 * @param numberOfChapters Number of chapters of the film.
 * @param durationOfChapters Duration of the chapters of the film.
 * @return The pointer to the film.
*/
shared_ptr<Film> Manager::createFilm (const string& name,const string& pathname,int duration,int numberOfChapters,shared_ptr<int> durationOfChapters) {
    shared_ptr<Film> film(new Film(name,pathname,duration,numberOfChapters,durationOfChapters));
    tableMultimedia[name]=film;
    return film;
}
/**
 * @brief Create a group.
 * @param name Name of the group.
 * @return The pointer to the group.
*/
shared_ptr<Group> Manager::createGroup (const string& name) {
    shared_ptr<Group> group(new Group(name));
    tableGroup[name]=group;
    return group;
}
/**
 * @brief Search for a multimedia or a group in the manager.
 * @param name Name of the multimedia or the group to search for
*/
void Manager::search (const string& name) {
    auto it_multimedia=tableMultimedia.find(name);
    auto it_group=tableGroup.find(name);
    if (it_multimedia!=tableMultimedia.end()) {
        it_multimedia->second->print(cout);
    }
    else if (it_group!=tableGroup.end()) {
        it_group->second->print(cout);
    }
    else {
        cout<<"No multimedia or group with name "<<name<<endl;
    }
}
/**
 * @brief Search for a multimedia or a group in the manager and return the information.
 * @param name Name of the multimedia or the group to search for
 * @return The information of the multimedia or the group.
*/
string Manager::searchAndGet (const string& name) {
    auto it_multimedia=tableMultimedia.find(name);
    auto it_group=tableGroup.find(name);
    if (it_multimedia!=tableMultimedia.end()) {
        return "Found multimedia: { "+it_multimedia->second->getInfo()+" } ";
    }
    else if (it_group!=tableGroup.end()) {
        return "Found group: { "+it_group->second->getInfo()+" } ";
    }
    else {
        return "No multimedia or group with name "+name;
    }
}
/**
 * @brief Play a multimedia.
 * @param name Name of the multimedia to play.
*/
void Manager::play (const string& name) {
    auto it_multimedia=tableMultimedia.find(name);
    if (it_multimedia!=tableMultimedia.end()) {
        it_multimedia->second->play();
    }
    else {
        cout<<"No multimedia with name "<<name<<endl;
    }
}
/**
 * @brief Play a multimedia and return the information.
 * @param name Name of the multimedia to play.
 * @return The information of the multimedia.
*/
string Manager::playAndGet (const string& name) {
    auto it_multimedia=tableMultimedia.find(name);
    if (it_multimedia!=tableMultimedia.end()) {
        it_multimedia->second->play();
        return "Found multimedia with name "+name;
    }
    else {
        return "No multimedia with name "+name;
    }
}
/**
 * @brief Remove a multimedia from the manager.
 * @param name Name of the multimedia to remove.
 * @return The status of the removal.
*/
string Manager::remove (const string& name) {
    auto it_multimedia=tableMultimedia.find(name);
    if (it_multimedia!=tableMultimedia.end()) {
        tableMultimedia.erase(it_multimedia);
        for (auto it_group=tableGroup.begin();it_group!=tableGroup.end();it_group++) {
            it_group->second->remove(it_multimedia->second);
        }
        return "Removed multimedia with name "+name;
    }
    else {
        return "No multimedia with name "+name;
    }
}