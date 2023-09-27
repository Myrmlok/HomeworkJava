
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Type;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        Byte byt=Byte.MIN_VALUE;
        Short sh=Short.MIN_VALUE;
        Integer num=Integer.MIN_VALUE;
        Long num1=Long.MIN_VALUE;
        Double dob=Double.MIN_VALUE;
        Float fl=Float.MIN_VALUE;
        Boolean status=false;
        Character ch=Character.MIN_VALUE;

        Byte byt1=Byte.MAX_VALUE;
        Short sh1=Short.MAX_VALUE;
        Integer num1_1=Integer.MAX_VALUE;
        Long num1_2=Long.MAX_VALUE;
        Double dob1=Double.MAX_VALUE;
        Float fl1=Float.MAX_VALUE;
        Boolean status1=true;
        Character ch1=Character.MAX_VALUE;

        System.out.println(byt.getClass().getSimpleName()+" "+"byt "+byt.BYTES+" " +byt);
        System.out.println(sh.getClass().getSimpleName()+" "+"sh "+sh.BYTES+" " +sh);
        System.out.println(num.getClass().getSimpleName()+" "+"num "+num.BYTES +" "+ num);
        System.out.println(num1.getClass().getSimpleName()+" "+"num1 "+num1.BYTES+" "+num1 );
        System.out.println(dob.getClass().getSimpleName()+" "+"dob "+dob.BYTES+" " +dob);
        System.out.println(fl.getClass().getSimpleName()+" "+"fl "+fl.BYTES+" " +fl);
        System.out.println(status.getClass().getSimpleName()+" "+"status "+"?" +" "+ status);
        System.out.println(ch.getClass().getSimpleName()+" "+"num1 "+ch.BYTES+" "+ch );

        System.out.println(byt1.getClass().getSimpleName()+" "+"byt1 "+byt1.BYTES+" " +byt1);
        System.out.println(sh1.getClass().getSimpleName()+" "+"sh1 "+sh1.BYTES+" " +sh1);
        System.out.println(num1_1.getClass().getSimpleName()+" "+"num_1 "+num1_1.BYTES +" "+ num1_1);
        System.out.println(num1_2.getClass().getSimpleName()+" "+"num1_2 "+num1_2.BYTES+" "+num1_2 );
        System.out.println(dob1.getClass().getSimpleName()+" "+"dob1 "+dob1.BYTES+" " +dob1);
        System.out.println(fl1.getClass().getSimpleName()+" "+"fl1 "+fl1.BYTES+" " +fl1);
        System.out.println(status1.getClass().getSimpleName()+" "+"status "+"?" +" "+ status1);
        System.out.println(ch1.getClass().getSimpleName()+" "+"ch1 "+ch.BYTES+" "+ch1 );
    }
}
