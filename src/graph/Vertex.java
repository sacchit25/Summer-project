package graph;

import java.util.ArrayList;

/**
 * This class serves as a vertex in a graph.
 * It contains data, of generic type T, a color (an integer) assigned
 * by a graph coloring algorithm, and a boolean variable to record if 
 * this vertex has been visited.
 * Note that a color value of -1 indicated the Vertex is not colored.
 */
 
 public class Vertex{

   
   boolean visited; 
   String food;
   String music;
   String hobby;
   String firstLanguage;
   String instagram;
   String roomNo;
   //String courses; //might need an array for this
   ArrayList<String> courses = new ArrayList<>();
   int count;

   public Vertex(){
      visited = false;
      food = null;
      music = null;
      hobby = null;
      firstLanguage = null;
      instagram = null;
      roomNo = null;
      courses = null;
      count  = 0;
   }

   public Vertex(Vertex vertex)
   {
      visited = false;
      food = vertex.getFood();
      music = vertex.getMusic();
      hobby = vertex.getHobby();
      firstLanguage = vertex.getLanguage();
      for (String course : vertex.getCourses())
         courses.add(course);
      instagram = vertex.getInsta();
      roomNo = vertex.getRoomNo();
      count = 0;
   }
   
   public boolean isVisited(){return visited;}
   
   public void setVisited(boolean visited){this.visited = visited;}

   public void setFood(String food) {this.food = food;}

   public String getFood() {return food;}

   public void setMusic(String music) {this.music = music;}

   public String getMusic() {return music;}

   public void setHobby(String hobby) {this.hobby = hobby;}

   public String getHobby() {return hobby;}

   public void setInsta(String instagram) {this.instagram = instagram;}

   public String getInsta() {return instagram;}

   public void setRoomNo(String roomNo) {this.roomNo = roomNo;}

   public String getRoomNo() {return roomNo;}

   public void setCourses(ArrayList<String> courses) {this.courses = courses;}

   public ArrayList<String> getCourses() {return courses;}

   public void setLang(String firstLanguage) {this.firstLanguage = firstLanguage;}

   public String getLanguage() {return firstLanguage;}

   public int getCount() {return count;}

   public void setCount(int count) {this.count = count;}

   public void incCount() {count++;}
   
   public void incCount(int count) {this.count += count;}
}