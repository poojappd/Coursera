
/**
 Part 3: Problem Solving with Strings
 */
public class Part3 {
public boolean twoOccurences(String a,String b){
    System.out.println("String a- \'"+a+"'  String b- '"+b+"'");
    int count=b.indexOf(a);
if (count!=-1){
  int count2=b.indexOf(a,count+1);
  if (count2!=-1){
  System.out.println(count+"   "+count2);  return true;
}
   }return false;
 }
public void testing(){
System.out.println(twoOccurences("by","A story by Abby Long")); 
System.out.println(twoOccurences("atg","ctgtatgta"));
System.out.println(twoOccurences("a","banana"));
}
public static void main(String args[]){
Part3 o1=new Part3();    
o1.testing();}}
