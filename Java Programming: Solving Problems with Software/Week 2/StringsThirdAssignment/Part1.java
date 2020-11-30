
/**
 *Part 1: Use a StorageResource to store the genes 
 */
 import edu.duke.*; 
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
System.out.println(findGene(dna4,0));
}

 public void printAllGenes(String dna){
        int startIndex = 0;
        while (true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
            break;             
        }
    }
public StorageResource getAllGenes(String dna){
int currIndex=0 ; 
StorageResource s=new StorageResource();
  
while(true){
    String Dna=findGene(dna,currIndex);
if(Dna.isEmpty()){
 break;}
  s.add(Dna);
  
  
  currIndex=dna.indexOf(Dna)+Dna.length();
 }
 return s;
}

public void testGetAllGenes(){
    StorageResource sr=getAllGenes("ATGCAAVAATAATAGTGAATGRTTTAGTAATGA");
    for (String s:sr.data()){
        System.out.println(s);}
}
public int count(String dna, String letter){
    int count=0;
    int index=dna.indexOf(letter);
    //System.out.println(index);
    while(index!=-1){
    count+=1;
    index=dna.indexOf(letter,index+1);
}
    return count;
}
public float cgRatio(String dna){
    int cRatio=count(dna,"C");
    int gRatio=count(dna,"G");
    //System.out.println("Cratio- "+cRatio+" Gratio- "+gRatio);
    return ((float)(cRatio+gRatio))/dna.length();
}
public int countCTG(String dna){
    return count(dna,"CTG");
}
public void processGenes(StorageResource sr){
    int count9l=0;
    int cgcount=0;
    int max=0;
   
    for(String s:sr.data()){
       // System.out.println(s+" string ");
        // if(s.length()>9){
        // System.out.println("Strings longer than 9 characters: "+s);
        // count9l+=1;
         // if(s.length()>max){
            // max=s.length();
            
        // }
        //}
         if(s.length()>60){
        System.out.println("Strings longer than 60 characters: "+s);
        count9l+=1;
         if(s.length()>max){
            max=s.length();
            
        }}
        if(cgRatio(s)>0.35){
            System.out.println("Strings whose C-G-ratio is higher than 0.35: "+s);
        
            cgcount+=1;
        }
    }
    System.out.println("No. of strings longer than 9 characters: "+count9l);
    System.out.println("No. of strings whose C-G-ratio is higher than 0.35: "+cgcount);
    System.out.println("Length of the longest gene in sr: "+max);    
}

public void testProcessGenes(){
//FileResource fr = new FileResource("brca1line.fa");
URLResource ur=new URLResource("https://users.cs.duke.edu/~rodger/GRch38dnapart.fa");
String dna = ur.asString();
StorageResource sr=getAllGenes(dna);
printAllGenes(dna);   

// sr.add("ATGCTGRAATAA");
// sr.add("ATGCTGTAA");
// sr.add("ATGCCATAG");
// sr.add("ATGCCATAA");

//processGenes(sr);
}
public static void main(String Args[]){
Part1 p=new Part1();

//p.testGetAllGenes();
//System.out.println(p.cgRatio("ATGCCATAG"));
//System.out.println(p.countCTG("ATGCAACTGVAACTGBAACTHG"));
p.testProcessGenes();

}
}
