
/**
 Part 1: Finding a Gene - Using the Simplified Algorithm
 */
public class Part1 {
public String findSimpleGene(String dna){
  System.out.println("Input string: "+dna) ; 
  int start_ind=dna.indexOf("ATG");
  int end_ind=dna.indexOf("TAA");
  if((start_ind==-1) || (end_ind==-1)){
    return "";}
  String gene=dna.substring(start_ind,end_ind+3);
  if(dna.length()%3==0){
    return dna;
    }
    return "";
}
  public void testSimpleGene(){
    String dna1="ATCCCGCTTGACTAA",dna2="ATGCCGCTTGAC",dna3="ATCCCGCTTGACTAC",dna4="ATGCCGCTTGACTAA",dna5="ATGTCCGCTTGACTAA";
    System.out.println(findSimpleGene(dna1));
    System.out.println(findSimpleGene(dna2));
    System.out.println(findSimpleGene(dna3));
    System.out.println(findSimpleGene(dna4));
    System.out.println(findSimpleGene(dna5));
    
    }

public static void main(String args[]){
Part1 t=new Part1();
t.testSimpleGene();
}   
 
