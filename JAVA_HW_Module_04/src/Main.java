
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    zd1(LocalDateTime.now());
    zd2();
    zd3();
  }
  public  static void zd1(LocalDateTime localDateTime){
    IAction<Boolean, LocalDateTime> isLeapYear;
    isLeapYear =(v)->{
       var year= v.getYear();
       return (year % 400 == 0) || (year %4 == 0 && year % 100 != 0);
    };
    System.out.println("This is a leap year? "+ isLeapYear.Action(localDateTime));
    IAction<Long,LocalDateTime> countDay;
    countDay=(a)->{
      long num1= a.getDayOfYear();
      var year=a.getYear();
      var countleap=(long)(year/4);
      num1+=countleap*366;
      num1+=(year-countleap)*365;
      return num1;
    };
    System.out.println(countDay.Action(LocalDateTime.now())- countDay.Action(localDateTime));
    IAction<Long,LocalDateTime> getfullweek;
    getfullweek=(a)->{
       var countDayOfFullWeek= countDay.Action(a)- a.getDayOfWeek().getValue();
       return countDayOfFullWeek/7;
    };
    System.out.println(getfullweek.Action(LocalDateTime.now())-getfullweek.Action(localDateTime));
    IAction<String,LocalDateTime> getDayOfWeek;
    getDayOfWeek=(a)->a.getDayOfWeek().toString();
    System.out.println(getDayOfWeek.Action(localDateTime));
  }
  public static void zd2(){
    IAction<Drob,Drob[]> sum;
    sum=(a)->{
      Drob drob=new Drob(0,1);
      for (var el: a) {
        UmnZnam(drob, el);
        drob.chisl+=el.chisl;
      }
      return drob;
    };
    System.out.println(sum.Action(new Drob[]{new Drob(2,2),new Drob(1,2)}));
    IAction<Drob,Drob[]> minus;
    minus=(a)->{
      Drob drob=new Drob(0,1);
      boolean isFirst=true;
      for (var el: a) {
        UmnZnam(drob, el);
        if(isFirst){
          isFirst=false;
          drob.chisl+=el.chisl;
          continue;
        }
        drob.chisl-=el.chisl;
      }
      return drob;
    };
    System.out.println(minus.Action(new Drob[]{new Drob(3,2),new Drob(1,2)}));
    IAction<Drob,Drob[]> umn;
    umn=(a)->{
      Drob res=new Drob(1,1);
      for(var el:a){
        res.chisl*=el.chisl;
        res.znam*=el.znam;
      }
      return res;
    };
    System.out.println(umn.Action(new Drob[]{new Drob(3,2),new Drob(1,2)}));
    IAction<Drob,Drob[]> del;
    del=(a)->{
      Drob res=new Drob(1,1);
      for(var el:a){
        res.chisl*=el.znam;
        res.znam*=el.chisl;
      }
      return res;
    };
    System.out.println(del.Action(new Drob[]{new Drob(3,2),new Drob(1,2)}));
  }

  private static void UmnZnam(Drob drob, Drob el) {
    if(el.znam!=drob.znam){
      var znam=drob.znam;
      drob.znam*=el.znam;
      drob.chisl*=el.znam;
      el.znam*=znam;
      el.chisl*=znam;
    }
  }
  static void zd3(){
    Integer[] mus=new Integer[10];
    Random rn=new Random();
    for(int i=0;i<mus.length;i++){
      mus[i]=rn.nextInt(10)-7;
    }
    System.out.println(Arrays.toString(mus));
    SumCMus<Integer> sumCMus=new SumCMus<>();
    System.out.println(sumCMus.SumMus(mus,(a)->true));
    System.out.println( sumCMus.SumMus(mus,(a)->a<5));
    System.out.println(sumCMus.SumMus(mus,(a)->a>6||a<4));
    System.out.println(sumCMus.SumMus(mus,(a)->Math.abs(a)==a));
    System.out.println(sumCMus.SumMus(mus,(a)->Math.abs(a)!=a));
  }

}
interface IAction<TRes,TValue>{
    TRes Action(TValue value);

}
class SumCMus<Tmus>{
  public  double SumMus(Tmus[]mus,IAction<Boolean,Tmus> iAction){
    double res=0;
      for (Tmus tmus : mus) {
          if (iAction.Action(tmus)) {
              res += ((Number) tmus).doubleValue();
          }

      }
    return res;
  }
}
class Drob{
  int chisl;
  int znam;
  public Drob(int chisl,int znam){
    this.chisl=chisl;
    this.znam=znam;
  }

  @Override
  public String toString() {
    return "Drob{" +
      "chisl=" + chisl +
      ", znam=" + znam +
      '}';
  }
}
