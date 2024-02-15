/**
 * @file multimedia.h
 * @brief Definition of the Multimedia class which is the base class.
*/
#ifndef MULTIMEDIA_H
#define MULTIMEDIA_H
#include <string>
using namespace std;
/**
 * @class Multimedia
 * @brief This class is the base class of the multimedia objects.
*/
class Multimedia {
public:
    Multimedia();
    Multimedia(string name, string pathname);
    virtual ~Multimedia();
    string getName () const;
    string getPathname () const;
    void setName (string name);
    void setPathname (string pathname);
    virtual void print (ostream& stream) const;
    virtual void play () const=0;
    virtual string getInfo ()=0;
private:
    string name;
    string pathname;
};
#endif