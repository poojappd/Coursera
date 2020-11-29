
/**
 *Part 1: Finding many Genes z
 */
public class Part1 {

    public int findStopCodon(String dna, int startIndex, String stopcodon){
    int stopcodon_ind=dna.indexOf(stopcodon,startIndex);
    while (stopcodon_ind>-1){
    String Dna=dna.substring(startIndex,stopcodon_ind+3);
    if(Dna.length()%3==0){
    return stopcodon_ind;
           }
        else{
        stopcodon_ind=dna.indexOf(stopcodon,stopcodon_ind+1);}}
    return -1;
    
    }
public void testFindStopCodon(){
                                //012345678901234  
System.out.println(findStopCodon("GCATATGCdTAGGCTgTAGCA",4,"TAG"));
System.out.println(findStopCodon("GCAAATGGCTGTGCA",4,"TAG"));
System.out.println(findStopCodon("AATGACGTAA",1,"TAA"));
System.out.println(findStopCodon("AAGTTACCTT",0,"TAG"));}

public String findGene(String dna,int currIndex){
int startIndex=dna.indexOf("ATG",currIndex);
if(startIndex>-1){
    int stop1=findStopCodon(dna,startIndex,"TAA");
    int stop2=findStopCodon(dna,startIndex,"TGA");
    int stop3=findStopCodon(dna,startIndex,"TAG");
    int minIndex=stop1;
    if (stop2>-1 && stop2<stop1 || minIndex==-1){
        minIndex=stop2;
     }
    if(stop3>-1 && stop3<minIndex ||minIndex==-1){
     minIndex=stop3;}
    if(minIndex!=-1){
    return dna.substring(startIndex,minIndex+3);}
 }
 return "";
}
public void testFindGene(){
String dna1="GACABCTAA";
String dna2="ATGCAAFAATAA";
String dna3="ATGGAATAAFDCTAGVVVTGA";
String dna4="ATGCAAFAATAEFDE";
System.out.println("   DNA   "+dna1);
System.out.println(findGene(dna1,0));
System.out.println("   DNA   "+dna2);
System.out.println(findGene(dna2,0));
System.out.println("   DNA   "+dna3);
System.out.println(findGene(dna3,0));
System.out.println("   DNA   "+dna4);
System.out.println(findGene(dna4,0));}

public void printAllGenes(String dna){
int currIndex=0 ;   
while(true){
    String Dna=findGene(dna,currIndex);
if(Dna.isEmpty()){
 break;}
  System.out.println(Dna);
  currIndex=dna.indexOf(Dna)+Dna.length();
 }
}

public static void main(String Args[]){
Part1 p=new Part1();
//p.testFindStopCodon();
p.printAllGenes("ATGCAAVAATAATAGTGAATGRTTTAGTAATGA");
}
}
