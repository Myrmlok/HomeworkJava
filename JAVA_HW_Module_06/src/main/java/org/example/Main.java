package org.example;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        /*System.out.println("Zd1");
        int[]mus=new int[10];
        var thread1=new Thread(()->{
            Random random=new Random();
            for(int i=0;i<mus.length;i++){
                mus[i]=random.nextInt(20);
            }
            System.out.println(Arrays.toString(mus));
            System.out.println("Thread1 end");
        });
        var thread2=new Thread(()->{
            System.out.println("Thread 2 start");
            System.out.println( "Sum "+Arrays.stream(mus).sum());
            System.out.println("Thread 2 end");
        });
        var thread3=new Thread(()->{
            System.out.println("thread3 start");
            System.out.println("AVG "+ Arrays.stream(mus).sum()/ mus.length);
            System.out.println("Thread3 end");
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();
        System.out.println("Zd2");
        zd2();
        System.out.println("zd3");
        try {
            zd3();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
        System.out.println("Zd4");
        zd4();
    }
    static void zd2() throws InterruptedException {
        System.out.println("Write path");
        Scanner scanner = new Scanner(System.in);
        var str = scanner.next();
        var thread1 = new Thread(() -> {
            Random random = new Random();
            try {
                try (FileWriter fileWriter = new FileWriter(str)) {
                    for (int i = 0; i < 10; i++) {
                        if (i != 0) {
                            fileWriter.append(" ");
                        }
                        fileWriter.append(String.valueOf(random.nextInt(20)));

                    }
                }
                ;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        var thread2 = new Thread(() -> {
            try {
                try (FileReader fileReader = new FileReader(str)) {
                    try (FileWriter fileWriter = new FileWriter("Res1")) {
                        Scanner sc = new Scanner(fileReader);
                        while (sc.hasNext()) {
                            int num = Integer.parseInt(sc.next());
                            if(isPrime(num)){
                                fileWriter.append(String.valueOf( num)).append(" ");
                            }
                        }
                    }
                }
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        });
        var thread3 = new Thread(() -> {
            try {
                try (FileReader fileReader = new FileReader(str)) {
                    try (FileWriter fileWriter = new FileWriter("Res2")) {
                        Scanner sc = new Scanner(fileReader);
                        while (sc.hasNext()) {
                            var num =fact( Integer.parseInt(sc.next()));
                            fileWriter.append(String.valueOf( num)).append(" ");

                        }
                    }
                }
            } catch (IOException exception) {
                throw new RuntimeException(exception);
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread3.start();
    }
    static void zd3() throws IOException {
        System.out.println("Write path copy");
        Scanner sc=new Scanner(System.in);
        var directoryCopy=new File(sc.next());
        System.out.println("Write path to");
        var directoryTo=new File(sc.next());

        if(!directoryCopy.exists()|| (!directoryTo.exists() &&!directoryTo.mkdirs())){
            System.out.println("Not correct data");
            return;
        }
        Files.walkFileTree(directoryCopy.toPath(), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

                Files.createDirectories(Paths.get( dir.toString().replaceFirst(
                                        directoryCopy.toPath().toString()
                                        , directoryTo.getPath())));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                Files.copy(file,Paths.get( file.toString().replaceFirst(
                        directoryCopy.toPath().toString()
                        , directoryTo.getPath())));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }
        });




    }
    static void zd4() throws InterruptedException {
        System.out.println("Write path");
        Scanner sc=new Scanner(System.in);
        var pathCheck=new File(sc.next());
        if(!pathCheck.exists()){
            System.out.println("Not data correct");
            return;
        }
        System.out.println("Write word");
        var word=sc.next();
        Thread thread1=new Thread(()->{
            try {

                try {
                    Files.walk(pathCheck.toPath()).parallel().filter(Files::isRegularFile).forEach(c->{
                        try {
                            var content=Files.readString(c);
                            if(content.contains(word)){
                                try(FileWriter fw=new FileWriter("resZd4",true);) {

                                    fw.append("\n");
                                    fw.append(c.getFileName().toString());
                                    fw.append("\n");
                                    fw.append(content);
                                }

                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2=new Thread(()->{
            try( var fr=new FileReader("BadWords.txt");
                var scan=new Scanner(fr)){
                Path resZd4 = Path.of("resZd4");
                var content=Files.readString(resZd4);
                StringBuilder regex=new StringBuilder();
                while(scan.hasNext()){
                    if(!regex.isEmpty()){
                        regex.append("|");
                    }
                    regex.append(scan.next());

                }
                Files.writeString(resZd4, content.replaceAll(regex.toString(),"---"));

            }
            catch (IOException ex){
                throw new RuntimeException(ex);
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
    }
    static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    static long fact(int num){
        long res=1;
        for(int i=2;i<=num;i++){
            res*=i;
        }
        return res;
    }
}
