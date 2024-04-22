package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("x y z w");
        for(int x=0;x<2;x++){
            for(int y=0;y<2;y++){
                for(int z=0;z<2;z++){
                    for(int w=0;w<2;w++){
                        if(!((x<=y)==(z<=w)||(x ==1 &&w==1))){
                            System.out.println(x+" "+y+" "+z+" "+w);
                        }
                    }
                }
            }
        }
        zd17();
    }
    public static void zd17() throws IOException {
        var lines= Files.readAllLines(Path.of("C:/Users/User/Downloads/17.txt")).stream().map(Integer::getInteger).toList();
        var ch=lines.stream().filter(c->c%2==0).toList();
        var avg=0;
        for (var e:ch
             ) {
            if(e!=null){
            avg+=e;
            }
        }
        avg/=lines.size();
        int res=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i< lines.size();i+=2){
            var num1=lines.get(i);
            var num2=lines.get(i+1);
            if((num1%3==0 ||num2%2==0)&&(num1<avg||num2<avg)){
                res++;
                max=Math.max(max,num1+num2);
            }
        }
        System.out.println(res);
        System.out.println(max);
    }
}