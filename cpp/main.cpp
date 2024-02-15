/**
 * @file main.cpp
 * @brief Main file of the project, which is used to start the server.
*/
//#define VERSION_1
#define VERSION_2
#ifdef VERSION_1
#include <iostream>
#include "manager.h"
using namespace std;
int main (int argc, const char* argv[]) {
    shared_ptr<Multimedia> media[3];
    Manager multimedia_manager;
    media[0]=multimedia_manager.createFilm("Film1","../multimedia/1.mp4",0,3,shared_ptr<int>(new int[3]{1,2,3}));
    media[1]=multimedia_manager.createPhoto("Photo1","../multimedia/1.jpg",0,0);
    media[2]=multimedia_manager.createPhoto("Photo2","../multimedia/2.jpg",0,0);
    
    shared_ptr<Group> group1=multimedia_manager.createGroup("MultimediaGroup1");
    shared_ptr<Group> group2=multimedia_manager.createGroup("MultimediaGroup2");
    group1->push_back(media[0]);
    group1->push_back(media[1]);
    group2->push_back(media[0]);
    group2->push_back(media[2]);

    cout<<multimedia_manager.search("MultimediaGroup1")<<endl;
    cout<<multimedia_manager.search("MultimediaGroup2")<<endl;

    group1.reset();
    group2->print(cout);
    return 0;
}
#endif
#ifdef VERSION_2
#include <iostream>
#include <string>
#include "manager.h"
#include "tcpserver.h"
using namespace std;
const int PORT = 3331;
int main ( ) {
    shared_ptr<Multimedia> media[3];
    Manager multimedia_manager;
    media[0]=multimedia_manager.createFilm("Film1","../multimedia/1.mp4",0,3,shared_ptr<int>(new int[3]{1,2,3}));
    auto* server=new TCPServer([&](string const& request,string& response) {
        response = "";
        cout << "Received request: " << request << endl;
        // Requests: SEARCH, PLAY, CREATE, DELETE
        if (request[0]=='S') {
            string name=request.substr(7);
            cout<<name<<endl;
            response = multimedia_manager.searchAndGet(name);
        }
        else if (request[0]=='P') {
            string name=request.substr(5);
            response = multimedia_manager.playAndGet(name);
        }
        else if (request[0]=='C') {
            if (request[7]=='P') {
                int pos = 13, lstpos = 13;
                while (request[pos] != ' ') pos++;
                string name = request.substr(lstpos, pos-lstpos);
                pos += 1; lstpos = pos;
                while (request[pos] != ' ') pos++;
                string pathname = request.substr(lstpos, pos-lstpos);
                pos += 1; lstpos = pos;
                while (request[pos] != ' ') pos++;
                int latitude = stoi(request.substr(lstpos, pos-lstpos));
                pos += 1; lstpos = pos;
                int longitude = stoi(request.substr(lstpos));
                multimedia_manager.createPhoto(name, pathname, latitude, longitude);
                response = "Photo created";
            }
            else if (request[7]=='V') {
                int pos = 13, lstpos = 13;
                while (request[pos] != ' ') pos++;
                string name = request.substr(lstpos, pos-lstpos);
                pos += 1; lstpos = pos;
                while (request[pos] != ' ') pos++;
                string pathname = request.substr(lstpos, pos-lstpos);
                pos += 1; lstpos = pos;
                int duration = stoi(request.substr(lstpos));
                multimedia_manager.createVideo(name, pathname, duration);
                response = "Video created";
            }
        }
        else if (request[0]=='D') {
            string name=request.substr(7);
            response = multimedia_manager.remove(name);
        }
        return true;
    });
    cout << "Starting Server on port " << PORT << endl;

    int status = server->run(PORT);

    if (status < 0) {
        cerr << "Could not start Server on port " << PORT << endl;
        return 1;
    }
    return 0;
}
#endif