import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)throws IllegalAccessException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        MyClass myClass=new MyClass();
        Json<MyClass> json=new Json<MyClass>();
        StringBuffer js=json.ToJson(myClass);
        System.out.println( js);
        ToManyLineJson(js.toString());

    }
    public static  void ToManyLineJson(String json){
        String[]strs= json.split(",");
        System.out.println(strs.length);
        for(int i=0;i< strs.length;i++){
            System.out.println(strs[i]);
            String[] name_value= strs[i].split(":");
            if(name_value.length>1){
            if(name_value[1].startsWith("[")){
                i=ShowMus(strs,i);
            }}
        }


    }
    public static int ShowMus( String[]mus,int startIndex){
        int i=startIndex;
        System.out.println(mus.length);
        while(mus[i].contains("]")){
            System.out.print(mus[i]);
            i++;
        }

        return i;
    }
}

class Json<ClassParsed>{


    public StringBuffer ToJson(ClassParsed obj)throws IllegalAccessException {
        return ObjectToJson(obj);
    }
    StringBuffer ObjectToJson(Object obj){
        StringBuffer str=new StringBuffer("{");
        Field[] fields=obj.getClass().getDeclaredFields();
        try {


        for(int i=0;i< fields.length;i++){
            str.append("\"");
            str.append( fields[i].getName());
            str.append("\"");
            str.append(":");
            if(fields[i].getType().isPrimitive()){
                str.append(fields[i].get(obj).toString());
            }
            else if(fields[i].getType().isAssignableFrom(String.class)||
                    fields[i].getType().isAssignableFrom(StringBuffer.class)||
                    fields[i].getType().isAssignableFrom(StringBuilder.class)){
                str.append("\"");
                str.append(fields[i].get(obj).toString());
                str.append("\"");
            }
            else if(fields[i].getType().isArray()){
                Object[] objects=(Object []) fields[i].get(obj);



                str.append("[");

                for(int j=0;j<objects.length;j++){
                    Object val= objects[j];

                    if (objects[j].getClass().isAssignableFrom(Integer.class)||
                            objects[j].getClass().isAssignableFrom(Short.class)||
                            objects[j].getClass().isAssignableFrom(Byte.class)||
                            objects[j].getClass().isAssignableFrom(Double.class)||
                            objects[j].getClass().isAssignableFrom(Float.class)||
                            objects[j].getClass().isAssignableFrom(Boolean.class)){
                        str.append(objects[j]);
                    }
                    else if(val.getClass().isAssignableFrom(String.class)||
                            fields[i].getType().isAssignableFrom(StringBuffer.class)||
                            fields[i].getType().isAssignableFrom(StringBuilder.class)){
                        str.append("\"");
                        str.append(val.toString());
                        str.append("\"");
                    }
                    else{

                        str.append(ObjectToJson(val));

                    };
                    if(j< objects.length-1){
                    str.append(", ");
                    }

                }
                str.append("]");
            }
            else{

                str.append(ObjectToJson(fields[i].get(obj)));

            }
            if(i!= fields.length-1){
                str.append(", ");
            }
        }
        str.append("}");
        
        }
        catch (IllegalAccessException ex){
            System.out.println(ex.getMessage());
        };

        return str;
    }

    class Values{
        String name;
        Object value;
    }
}
class MyClass{
    public String name,password;
    public int age;
    public  MyClass(){
        name="Misha";
        password="1234";
    }
    public Integer[]mus={1,2,3,4};
    public Short[]mus1={2,3,4,5,6};
    public St st=new St();
    public St[]musSt={new St(),new St()};

}
class St{
    public String name="Dima";
    public int money=123454;
}