JC=javac
default:bbst.class RedBlackTree.class Node.class Sentinel.class
bbst.class: bbst.java
	$(JC)$(JFLAGS) bbst.java
RedBlackTree.class: bbst.java
	$(JC)$(JFLAGS) bbst.java
Node.class: bbst.java
	$(JC)$(JFLAGS) bbst.java
Sentinel.class: bbst.java
	$(JC)$(JFLAGS) bbst.java
clean:
	rm *.class
