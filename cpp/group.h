/**
 * @file group.h
 * @brief Definition of the Group class.
*/
#ifndef GROUP_H
#define GROUP_H
#include <iostream>
#include <string>
#include <list>
#include <memory>
#include "multimedia.h"
/**
 * @class Group
 * @brief This class is a derived class from the STL list class. It can be used to store the information of a group of multimedia objects.
*/
class Group : public list<shared_ptr<Multimedia>> {
public:
    Group();
    Group(const string& name);
    virtual ~Group();
    string getName() const;
    void setName(string name);
    void print(ostream& stream) const;
    string getInfo();
private:
    string name;
};
#endif