
/**
 Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
 */
public class Part2 {
public String findSimpleGene(String dna,String startcodon,String stopcodon){
  System.out.println("Input string: "+dna) ; 
  if((Character.isLowerCase(dna.charAt(0)))){
    startcodon=startcodon.toLowerCase();
    stopcodon=stopcodon.toLowerCase(); }
  int start_ind=dna.indexOf(startcodon);
  int end_ind=dna.indexOf(stopcodon);
  if((start_ind==-1) || (end_ind==-1)){
    return "";}
  String gene=dna.substring(start_ind,end_ind+3);
  if(gene.length()%3==0){
      
        
    return gene;
    }
    return "";
}
  public void testSimpleGene(){
    String dna1="ATCCCGCTTGACTAA",dna2="gatgctataat",dna3="ATCCCGCTTGACTAC",dna4="ATGCCGCTTGACTAA",dna5="ATGTCCGCTTGACTAA";
    String startcodon="ATG";
    String stopcodon="TAA";
    System.out.println(findSimpleGene(dna1,startcodon,stopcodon));
    System.out.println(findSimpleGene(dna2,startcodon,stopcodon));
    System.out.println(findSimpleGene(dna3,startcodon,stopcodon));
    System.out.println(findSimpleGene(dna4,startcodon,stopcodon));
    System.out.println(findSimpleGene(dna5,startcodon,stopcodon));
    
    }

public static void main(String args[]){
Part2 t=new Part2();
t.testSimpleGene();

}   
}
