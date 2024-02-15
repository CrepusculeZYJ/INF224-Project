/**
 * @file group.cpp
 * @brief Implementation of the Group class.
*/
#include "group.h"
using namespace std;
/**
 * @brief Default constructor of the Group class.
*/
Group::Group ( ) {
    this->name="";
}
/**
 * @brief Constructor of the Group class.
 * @param name Name of the group.
*/
Group::Group (const string& name) {
    this->name=name;
}
/**
 * @brief Destructor of the Group class.
*/
Group::~Group ( ) {
}
/**
 * @brief Get the name of the group.
 * @return The name of the group.
*/
string Group::getName ( ) const {
    return name;
}
/**
 * @brief Set the name of the group.
 * @param name Name of the group.
*/
void Group::setName (string name) {
    this->name=name;
}
/**
 * @brief Print the group.
 * @param out Output stream.
*/
void Group::print (ostream& out) const {
    out<<"Group name: "<<name<<endl;
    for (auto it=begin();it!=end();it++) {
        (*it)->print(out);
    }
    out<<endl;
}
/**
 * @brief Get the information of the group.
 * @return The information of the group.
*/
string Group::getInfo ( ) {
    string info="";
    info+="Group name: "+name+" | ";
    for (auto it=begin();it!=end();it++) {
        info+=(*it)->getInfo()+" | ";
    }
    return info;
}