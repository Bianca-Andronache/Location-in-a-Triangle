package triangle;

import java.io.*;

public class Triangle {

    public float determinant(Point m, Point a, Point b){
        return m.x * a.y + a.x * b.y + m.y * b.x - (b.x * a.y + a.x * m.y + m.x * b.y);
    }
    
    public int signDet(Point m, Point a, Point b)
    {
        if(determinant(m,a,b)==0) return 0;
        else if(determinant(m,a,b)>0) return 1;
            else return -1;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        // File path "file.txt"
        String name_file = "D:\\Facultate\\Anul 2 sem 1\\GC\\Triangle\\file.txt";
        BufferedReader buf = new BufferedReader(new FileReader(name_file));
        
        // My example
        Point A = new Point(3,5);
        Point B = new Point(0,0);
        Point C = new Point(7,0);
        Point M = new Point(0,0);
        
        Triangle ob = new Triangle();
        
        while(true){
            String p_str = buf.readLine();
            if(p_str == null)
                break;
            else{
                String[] p = p_str.split(" ");
                M.x = Float.parseFloat(p[0]);
                M.y =Float.parseFloat(p[1]);
                
                switch(ob.signDet(M, A, B)){
                    case 1: if(ob.signDet(M,B,C)==1){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is inside the triangle(area 1)");
                                else if(ob.signDet(M,C,A)==-1) System.out.println("Point M(" + M.x + "," + M.y + ") is outside the triangle(area 4)");
                                    else System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 1-4)");
                            }
                            if(ob.signDet(M,B,C)==-1){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is outside the triangle(area 3)");
                                else if(ob.signDet(M,C,A)==-1) System.out.println("Point M(" + M.x + "," + M.y + ") is outside the triangle(area 7)");
                                    else System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 3-7)");
                            }
                            if(ob.signDet(M,B,C)==0){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 1-3)");
                                else if(ob.signDet(M,C,A)==-1) System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 4-7)");
                                    else System.out.println("Point M(" + M.x + "," + M.y + ") is C");
                            }
                            System.out.println();
                            break;

                    case -1: if(ob.signDet(M,B,C)==1){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is outside the triangle(area 2)");
                                else if(ob.signDet(M,C,A)==-1) System.out.println("Point M(" + M.x + "," + M.y + ") is outside the triangle(area 5)");
                                    else System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 2-5)");
                            }
                            if(ob.signDet(M,B,C)==-1){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is outside the triangle(area 6)");
                            }
                            if(ob.signDet(M,B,C)==0){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 2-6)");
                            }
                            System.out.println();
                            break;

                    case 0: if(ob.signDet(M,B,C)==1){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 1-2)");
                                else if(ob.signDet(M,C,A)==-1) System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 4-5)");
                                    else System.out.println("Point M(" + M.x + "," + M.y + ") is A");
                            }
                            if(ob.signDet(M,B,C)==-1){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is on the border of the triangle (border 3-6)");
                            }
                            if(ob.signDet(M,B,C)==0){
                                if(ob.signDet(M,C,A)==1) System.out.println("Point M(" + M.x + "," + M.y + ") is B");
                            }
                            System.out.println();
                            break;
                }
                
            }
        }
    }
}
