----------------------------------
EVENT COUNTER USING RED BLACK TREE
----------------------------------
Siddhant Deshmukh
University of Florida


COMPILING
---------
Go into project folder and type following command:
make

To clean and delete .class files type following:
make clean

RUNNING
-------
Type the following commands:

java bbst test_100.txt <commands.txt> my_out_100.txt
java bbst test_1000000.txt <commands.txt> my_out_1000000.txt
java bbst test_10000000.txt <commands.txt> my_out_10000000.txt
java -Xms1024m -Xmx8000m bbst test_100000000.txt <commands.txt> my_out_100000000.txt

NOTE: test_100000000.txt needs a large amount of heap space to run