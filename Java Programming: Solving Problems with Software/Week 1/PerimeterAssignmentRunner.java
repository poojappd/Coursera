import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for (Point i:s.getPoints()){
            count++;
        
    }return count;
}

    public double getAverageLength(Shape s) {
        // Put code here
        Point prept=s.getLastPoint();
        double dist=0;
        for(Point i:s.getPoints()){
            Point curpt=i;
             System.out.println("curr-"+curpt);
            dist+=prept.distance(curpt);
            prept=curpt;
            System.out.println("pre-"+prept);
        
    }
    double avg=dist/(getNumPoints(s));
    return avg;
}
    public double getLargestSide(Shape s) {
        // Put code here
        Point prept=s.getLastPoint();
        Point curpt;
        double maxlen=0;
        for(Point i:s.getPoints()){
            curpt=i;
            double dis=prept.distance(curpt);
            if (dis>maxlen){
                maxlen=dis;
            }
            prept=curpt;
        }    
        return maxlen;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double lx,maxlx=0;
        for(Point i:s.getPoints()){
            lx=i.getX();
            if (lx>maxlx){
                maxlx=lx;
            }
        }

        return maxlx;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double maxper=0;
        double per;
        DirectoryResource d= new DirectoryResource();
        for(File fil:d.selectedFiles()){
            FileResource fr=new FileResource(fil);
            Shape s=new Shape(fr);
            per=getPerimeter(s);
            if( per>maxper){
                maxper=per;
            }
        }
        return maxper;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        
        File temp=null;
        double per=0;
        DirectoryResource d= new DirectoryResource();
        double maxper=0;
        for(File fil:d.selectedFiles()){
            FileResource fr=new FileResource(fil);
            Shape s=new Shape(fr);
            per=getPerimeter(s);
            if( per>maxper){
                maxper=per;
                temp=fil;
            }
        }
        return temp.getName();
       
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int np=getNumPoints(s);
        double av=getAverageLength(s);
        double avgt=getLargestSide(s);
        double x=getLargestX(s);
        System.out.println("no. of points: "+np);
        System.out.println("perimeter = " + length);
        System.out.println("av len="+av);
        System.out.println("av greatest len="+avgt);
        System.out.println("greatest x value"+x);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double mxp=getLargestPerimeterMultipleFiles();
        System.out.println("Max perimeter from all files-"+mxp);
        
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String mxp=getFileWithLargestPerimeter();
        System.out.println("File name of Max perimeter-"+mxp);
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
