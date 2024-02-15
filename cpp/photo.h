/**
 * @file photo.h
 * @brief Definition and implementation of the Photo class.
*/
#ifndef PHOTO_H
#define PHOTO_H
#include <string>
#include <utility>
#include <iostream>
#include <cstdlib>
#include "multimedia.h"
using namespace std;
/**
 * @class Photo
 * @brief This class is a derived class from the Multimedia class. It can be used to store the information of a photo.
*/
class Photo : public Multimedia {
public:
    /**
     * @brief Default constructor of the class.
    */
    Photo ( ) {
        latitude=0;
        longitude=0;
    }
    /**
     * @brief Constructor of the class.
     * @param name Name of the photo.
     * @param pathname Pathname of the photo.
     * @param latitude Latitude of the photo.
     * @param longitude Longitude of the photo.
    */
    Photo (string name,string pathname,int latitude,int longitude) : Multimedia(name,pathname) {
        this->latitude=latitude;
        this->longitude=longitude;
    }
    /**
     * @brief Destructor of the class.
    */
    virtual ~Photo ( ) {
    }
    /**
     * @brief Get the latitude of the photo.
     * @return The latitude of the photo.
    */
    int getLatitude ( ) const {
        return latitude;
    }
    /**
     * @brief Get the longitude of the photo.
     * @return The longitude of the photo.
    */
    int getLongitude  ( ) const {
        return longitude;
    }
    /**
     * @brief Get the shape of the photo.
     * @return The shape of the photo.
    */
    pair<int,int> getShape () const {
        return make_pair(latitude,longitude);
    }
    /**
     * @brief Set the latitude of the photo.
     * @param latitude Latitude of the photo.
    */
    void setLatitude (int latitude) {
        this->latitude=latitude;
    }
    /**
     * @brief Set the longitude of the photo.
     * @param longitude Longitude of the photo.
    */
    void setLongitude (int longitude) {
        this->longitude=longitude;
    }
    /**
     * @brief Set the shape of the photo.
     * @param latitude Latitude of the photo.
     * @param longitude Longitude of the photo.
    */
    void setShape (int latitude,int longitude) {
        this->latitude=latitude;
        this->longitude=longitude;
    }
    /**
     * @brief Set the shape of the photo.
     * @param shape Shape of the photo.
    */
    void setShape (pair<int,int> shape) {
        latitude=shape.first;
        longitude=shape.second;
    }
    /**
     * @brief Print the photo.
     * @param stream Output stream.
    */
    virtual void print (ostream& stream) const {
        Multimedia::print(stream);
        stream<<"Latitude: "<<latitude<<endl;
        stream<<"Longitude: "<<longitude<<endl;
    }
    /**
     * @brief Get the information of the photo.
     * @return The information of the photo.
    */
    virtual string getInfo ( ) {
        string info="";
        info+="Latitude: "+to_string(latitude)+" , ";
        info+="Longitude: "+to_string(longitude);
        return info;
    }
    /**
     * @brief Play the photo.
    */
    virtual void play ( ) const {
        string command="start "+getPathname()+" &";
        system(command.data());
    }
private:
    int latitude;
    int longitude;
};
#endif