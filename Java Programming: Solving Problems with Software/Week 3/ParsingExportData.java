
/**
 *Programming Exercise: Parsing Export Data
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class ParsingExportData {
public void tester(){
FileResource fr=new FileResource();
CSVParser parser=fr.getCSVParser();
//countryInfo(parser,"Nauru");
//listExportersTwoProducts(parser,"fish","nuts");
System.out.println(numberOfExporters(parser,"gold"));
bigExporters(parser,"$999,999,999,999") ;
}
public String countryInfo(CSVParser parser,String country){
    
    for(CSVRecord record:parser ){
        String Country=record.get("Country");
        
        if (Country.contains(country)){
        System.out.println(Country+": "+record.get("Exports")+":");
        System.out.println(record.get("Value (dollars)"));
        }
        
    }
    return "NOT FOUND";
}

public void listExportersTwoProducts(CSVParser parser,String ex1,String ex2){
    for (CSVRecord rec:parser){
    String Export=rec.get("Exports");
    if(Export.contains(ex1)&&Export.contains(ex2)){
        System.out.println(rec.get("Country"));
    }
}
}
public int numberOfExporters(CSVParser parser,String exp){
    int count=0;
    for(CSVRecord rec:parser){
     String Exp=rec.get("Exports");
     if(Exp.contains(exp)){count+=1;}
    }
    return count;
}
public long amount(String amt){
    amt=amt.substring(1);
    char amt_arr[]=amt.toCharArray();
    int le=amt.length();
    String val="";
    for(char s:amt_arr){
        
        if(s!=','){val+=s;} 
    }
   
  
    return(Long.parseLong(val));
}

public void bigExporters(CSVParser parser,String amount){
    long val=amount(amount);
    for(CSVRecord rec:parser){
    String country=rec.get("Country");
    long num=amount(rec.get("Value (dollars)"));
    if (num>val){
    System.out.println(country+" "+num); } } 
}  
public static void main(String args[]){
    ParsingExportData p=new ParsingExportData();
    p.tester();
    
}
}
