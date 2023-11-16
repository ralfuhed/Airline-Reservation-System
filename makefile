# Final Project makefile

main:
	javac *.java

run: main
	java Reservation

clean:
	rm -f *.class
	rm -f *.ser
	rm -f *.txt
	
debug:
	gdb main
