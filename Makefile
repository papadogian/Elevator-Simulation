# Makefile
# author : papadogian

# To get the executable Simulation type (on command line) : $ make all
# To remove the dot class files (*.class) type (on command line) : $ make clean

JFLAGS = -g
JC= javac
RM = rm -rf

PACKAGE = simulation/

SRC = 	$(PACKAGE)Simulation.java \
	$(PACKAGE)Utilities.java \
	$(PACKAGE)Person.java \
	$(PACKAGE)ElevatorThread.java \
	$(PACKAGE)PersonThread.java

OUTPUT = output/
CLASSES = $(PACKAGE)*.class

all :
	$(JC) $(JFLAGS) $(SRC)
	$(RM) $(OUTPUT)
	@echo make directory output/
	mkdir $(OUTPUT) 
	@echo made directory output successfully
	@echo To run the executable type :
	@echo java $(PACKAGE)Simulation [number of elevators [0, N]] [number of floors [0, N]] [text file with people\'s behavior]

clean: 
	$(RM) $(CLASSES)
	@echo removed classes
	$(RM) $(OUTPUT)
	@echo removed output folder


