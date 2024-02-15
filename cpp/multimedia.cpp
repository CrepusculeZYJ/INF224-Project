/**
 * @file multimedia.cpp
 * @brief Implementation of the Multimedia class which is the base class.
*/
#include <iostream>
#include <string>
#include "multimedia.h"
using namespace std;
/**
 * @brief Default constructor of the Multimedia class.
*/
Multimedia::Multimedia ( ) {
    name="";
    pathname="";
}
/**
 * @brief Constructor of the Multimedia class.
 * @param name Name of the multimedia.
 * @param pathname Pathname of the multimedia.
*/
Multimedia::Multimedia (string name,string pathname) {
    this->name=name;
    this->pathname=pathname;
}
/**
 * @brief Destructor of the Multimedia class.
*/
Multimedia::~Multimedia ( ) {
}
/**
 * @brief Get the name of the multimedia.
 * @return The name of the multimedia.
*/
string Multimedia::getName ( ) const {
    return name;
}
/**
 * @brief Get the name of the path of the multimedia.
 * @return The name of the path of the multimedia.
*/
string Multimedia::getPathname ( ) const {
    return pathname;
}
/**
 * @brief Set the name of the multimedia.
 * @param name Name of the multimedia.
*/
void Multimedia::setName (string name) {
    this->name=name;
}
/**
 * @brief Set the name of the path of the multimedia.
 * @param pathname Name of the path of the multimedia.
*/
void Multimedia::setPathname (string pathname) {
    this->pathname=pathname;
}
/**
 * @brief Print the multimedia.
 * @param out The output stream.
*/
void Multimedia::print (ostream& out) const {
    out<<"Name: "<<name<<endl;
    out<<"Pathname: "<<pathname<<endl;
}