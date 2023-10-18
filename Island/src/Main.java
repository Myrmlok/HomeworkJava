import java.util.HashSet;
import java.util.Hashtable;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    char[][]map={{'*','0','*','0','*'},
                 {'0','*','*','0','*'},
                 {'*','0','*','0','*'},
                 {'0','*','*','0','*'}};
    HashSet<Point> points=new HashSet<>();
    int res=0;
    for(int i=0;i<map.length;i++){
      for(int j=0;j<map[i].length;j++){
        if(map[i][j]=='*'){
            if(checkJMore(map,i,j)){
                if(map[i][j+1]=='*') {
                  if (contains(points, new Point(i, j + 1))) {
                    points.add(new Point(i, j));
                  } else {
                    points.add(new Point(i, j + 1));
                    if(!contains(points,new Point(i,j))){
                      res++;
                    }
                  }
                }
            }
          if(checkIMore(map,i)){
            if(map[i+1][j]=='*') {
              if (contains(points, new Point(i+1, j))) {
                points.add(new Point(i, j));
              } else {
                points.add(new Point(i+1, j ));
                if(!contains(points,new Point(i,j))){
                  res++;
                }
              }
            }
          }
          if(checkJMin(map,i,j)){
            if(map[i][j-1]=='*') {
              if (contains(points, new Point(i, j - 1))) {
                points.add(new Point(i, j));
              } else {
                points.add(new Point(i, j - 1));
                if(!contains(points,new Point(i,j))){
                  res++;
                }
              }
            }
          }
          if(checkIMinus(map,i)){
            if(map[i-1][j]=='*') {
              if (contains(points, new Point(i-1, j))) {
                points.add(new Point(i, j));
              } else {
                points.add(new Point(i-1, j ));
                if(!contains(points,new Point(i,j))){
                  res++;
                }
              }
            }
          }
        }
      }
    }
    System.out.println(res);
  }
  public static boolean contains(HashSet<Point> mus,Point point){
    for(var e:mus){
      if(e.equals(point)){
        return true;
      }
    }
    return false;
  }
  public static   boolean checkIMore(char[][] mus,int i){
    return mus.length>i+1;
  }
  public static boolean checkJMore(char[][] mus,int i,int j){
    return mus[i].length>j+1;
  }
  public static boolean checkIMinus(char[][] mus,int i){
    return i-1>=0;
  }
  public static boolean checkJMin(char[][] mus,int i,int j){
    return j-1>=0;
  }
}
class Point{
  int x;
  int y;
  public Point(int x,int y){
    this.x=x;
    this.y=y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
};
