mkdir -p out
javac -sourcepath ./src -d out src/animalworld/view/MainFrame.java
java -classpath ./out animalworld.view.MainFrame