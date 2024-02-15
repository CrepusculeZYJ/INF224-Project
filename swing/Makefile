##########################################
#
#  Exemple de Makefile
#  Eric Lecolinet - Reda Dehak - Telecom ParisTech 2015
#  INF224 - TP Java/Swing - http://www.telecom-paristech.fr/~elc/inf224
#
##########################################

#
# Nom du programme (doit correspondre au fichier qui contient main())
#
PROG = swing.Main

#
# Fichiers sources .java
#
SOURCES = Client.java MainFrame.java Main.java

#
# Compilateur Java
#
JC = javac

#
# Options du compilateur Java
#
JFLAGS = -g

#
# Repertoire des .class
#
BIN_DIR = ../bin

#
# Commande pour effacer des fichiers
#
RM = rm -rf


##########################################
#
# Regles de construction/destruction des .class et de l'executable
#
 
all: create_dir classes

run: all
	java -cp $(BIN_DIR) $(PROG)

classes: $(SOURCES)
	$(JC) $(JFLAGS) -cp $(BIN_DIR) -d $(BIN_DIR) $(SOURCES)

clean:
	$(RM) $(BIN_DIR)/*.class
  
tar:
	tar cvf ${PROG}.tar.gz ${SOURCES}

create_dir:
	mkdir -p $(BIN_DIR)


###########################################
#
# Regles implicites
#

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) -cp $(BIN_DIR) -d $(BIN_DIR) $<