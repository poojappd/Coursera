
/**
 Part 4: Finding Web Links 
 */
import edu.duke.*;
public class Part4 {
public void Urlcreator(){
URLResource ur=new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
for(String word: ur.words()){
// System.out.println("asdfghi".lastIndexOf("f",2));
int youtube=word.indexOf("youtube.com");
if (youtube!=-1){
  int start=word.lastIndexOf("\"",youtube);
  int stop=word.indexOf("\"",youtube+1);
  String the_url=word.substring(start,stop+1);
  System.out.println( the_url )  ;  }
   }
}    
public static void main(String args[]){    
Part4 eg=new Part4();
//eg.Urlcreator();

    }
}
 
