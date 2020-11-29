
/**
 * Part 2: HowMany - Finding Multiple Occurrences
 */
public class Part2 {
public int howMany(String a, String b){
    System.out.println("String B-"+b+" String A-"+a);
    int till=b.length();
    int a_ind=b.indexOf(a);
    int count=0;
    
    while(till>0){
        
        if (a_ind>-1){
        count+=1;
        
        a_ind=b.indexOf(a,(a_ind+a.length()));
    }till-=1;
   }
   return count;
 }
 public void testHowMany(){
     System.out.println(howMany("GAA", "ATGAACGAATTGAATC"));//3
      System.out.println(howMany("AA","ATAAAA"));//2
       System.out.println(howMany("ft","ccc"));
        System.out.println(howMany("3","32345355"));
    }
 public static void main(String args[]){
    Part2 p=new Part2();
    p.testHowMany();}   
}
