/**
 * @file video.h
 * @brief Definition and implementation of the Video class.
*/
#ifndef VIDEO_H
#define VIDEO_H
#include <string>
#include <iostream>
#include <cstdlib>
#include "multimedia.h"
/**
 * @class Video
 * @brief This class is a derived class from the Multimedia class. It can be used to store the information of a video.
*/
class Video : public Multimedia {
public:
    /**
     * @brief Default constructor of the class.
    */
    Video ( ) {
        duration=0;
    }
    /**
     * @brief Constructor of the class.
     * @param name Name of the video.
     * @param pathname Pathname of the video.
     * @param duration Duration of the video.
    */
    Video (string name,string pathname,int duration) : Multimedia(name,pathname) {
        this->duration=duration;
    }
    /**
     * @brief Destructor of the class.
    */
    virtual ~Video ( ) {
    }
    /**
     * @brief Get the duration of the video.
     * @return The duration of the video.
    */
    int getDuration ( ) const {
        return duration;
    }
    /**
     * @brief Set the duration of the video.
     * @param duration Duration of the video.
    */
    void setDuration (int duration) {
        this->duration=duration;
    }
    /**
     * @brief Print the video.
     * @param out The output stream.
    */
    virtual void print (ostream& out) const {
        Multimedia::print(out);
        out<<"Duration: "<<duration<<endl;
    }
    /**
     * @brief Get the information of the video.
     * @return The information of the video.
    */
    virtual string getInfo ( ) {
        string info="";
        info+="Duration: "+to_string(duration);
        return info;
    }
    /**
     * @brief Play the video.
    */
    virtual void play ( ) const {
        string command="start "+getPathname()+" &";
        system(command.data());
    }
private:
    int duration;
};
#endif