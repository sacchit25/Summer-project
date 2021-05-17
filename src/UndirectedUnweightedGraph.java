
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * This class implements general operations on a graph as specified by UndirectedGraphADT.
 * It implements a graph where data is contained in Vertex class instances.
 * Edges between verticies are unweighted and undirected.
 * A graph coloring algorithm determines the chromatic number. 
 * Colors are represented by integers. 
 * The maximum number of vertices and colors must be specified when the graph is instantiated.
 * You may implement the graph in the manner you choose. See instructions and course material for background.
 */
 
 public class UndirectedUnweightedGraph {
   // private class variables here.
   
   Map<Vertex, ArrayList<Vertex>> map;

   /**
    * Initialize all class variables and data structures. 
   */   
   public UndirectedUnweightedGraph (){

      map = new HashMap<Vertex, ArrayList<Vertex>>();
   }

   /**
    * Add a vertex containing this data to the graph.
   */
   public void addVertex(String roomNo, String lang, String music, String food, String instaID, String hobby, ArrayList<String> coursesList) {

      Vertex curV = new Vertex();
      curV.setLang(lang);
      curV.setRoomNo(roomNo);
      curV.setMusic(music);
      curV.setFood(food);
      curV.setInsta(instaID);
      curV.setHobby(hobby);
      curV.setCourses(coursesList);
      map.put(curV, new ArrayList<Vertex>());
      intializeNeighbours(curV);
   }
   
   public void intializeNeighbours(Vertex curV){
      for (Map.Entry<Vertex, ArrayList<Vertex>> mapE : map.entrySet()) {
         Vertex k = mapE.getKey();
         if (k.getRoomNo() != curV.getRoomNo()) {
            Vertex cur = new Vertex(curV);
            
            cur.getCourses().retainAll(k.getCourses());
            cur.setCount(cur.getCourses().size());

            if (k.getLanguage().equals(curV.getLanguage()))
               cur.incCount();
            
            if (k.getMusic().equals(curV.getMusic()))
               cur.incCount();

            if (k.getFood().equals(curV.getFood()))
               cur.incCount();
               
            if (k.getHobby().equals(curV.getHobby()))
               cur.incCount();

            mapE.getValue().add(cur);
            
            Vertex ktemp = new Vertex(k);
            ktemp.setCount(cur.getCount());

            map.get(curV).add(ktemp);
         }   
      }
   }

   public void printRecomendations(Vertex curV) {
      Comparator<Vertex> compareByCount = (Vertex o1, Vertex o2) -> - o1.getCount() + o2.getCount();
      Collections.sort(map.get(curV), compareByCount);

      for (Vertex neighbour : map.get(curV)) {
         // System.out.println(neighbour.getInsta());
         System.out.println("You can connect with " + neighbour.getInsta() + " in room " + neighbour.getRoomNo());
      }    
   }
   
   public Vertex getVertex(String roomNo)
   {
      for (Map.Entry<Vertex, ArrayList<Vertex>> mapE : map.entrySet()) {
         if (mapE.getKey().getRoomNo().equals(roomNo))
            return mapE.getKey();
      }
      return null;
   }
 

public static void main(String args[]) throws FileNotFoundException {

   UndirectedUnweightedGraph obj = new UndirectedUnweightedGraph();

   String ch = "y";
   File file = new File("/Users/sacchitmittal/Documents/Summer-Project/src/input.txt");
   Scanner sc = new Scanner(file);
   while (ch.equals("y"))
   {
      Vertex vertex = new Vertex();
      System.out.println("Enter First Language");
      String language = sc.nextLine();
      System.out.println("Enter Room Number");
      String roomNumber = sc.nextLine();
      System.out.println("Enter Favourite Genre");
      String musicGenre = sc.nextLine();
      System.out.println("Enter favourtie cuisine choice");
      String cuisine = sc.nextLine();
      System.out.println("Enter your Instagram");
      String instaHandle = sc.nextLine();
      System.out.println("Enter favourtie extra curriculuar activity");
      String extraC = sc.nextLine();
      System.out.println("How many courses are you taking this semester");
      int size = sc.nextInt();
      sc.nextLine();
      ArrayList<String> courseList = new ArrayList<>();
      String c;
      for (int i = 0; i < size; i++) {
         System.out.println("Enter your courses");
         c = sc.nextLine();
         courseList.add(c);
      }
      obj.addVertex(roomNumber, language, musicGenre, cuisine, instaHandle, extraC, courseList);

      System.out.println("Continue (y/n)");
      ch = sc.nextLine();
   }

   System.out.println("Enter Room Number whose friend recommendations you are seeking");
   String roomNo = sc.nextLine();

   obj.printRecomendations(obj.getVertex(roomNo));
}
}
 