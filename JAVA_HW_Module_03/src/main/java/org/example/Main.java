package org.example;

import javax.swing.plaf.PanelUI;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.println("zd1");
        /*Station station=new Station(10,10,true);
        station.go(5);
        Station station1=new Station(10,10,false);
        station1.go(5);*/
        System.out.println("zd2");
        Dictionary dictionary=new Dictionary();
        boolean isDone=true;
        while(isDone){
            int choose;
            System.out.println("Write 0 to exit");
            System.out.println("Write 1 to add word ");
            System.out.println("Write 2 to add value with word");
            System.out.println("Write 3 to delete word");
            System.out.println("Write 4 to delete value with word");
            System.out.println("Write 5 to print  all word");
            System.out.println("Write 6 to print 10 famous word");
            System.out.println("Write 7 to print 10 not famous word");
            System.out.println("Write 8 to print 1 word");
            Scanner scanner=new Scanner(System.in);
            choose=scanner.nextInt();
            String word;
            String value;
            switch (choose){
                case 0:
                    isDone=false;
                    break;
                case 1:
                    System.out.println("Write word");
                    word=scanner.next();
                    System.out.println("Write value");
                    value=scanner.next();
                    dictionary.add(word,value);
                    break;
                case 2:
                    System.out.println("Write word");
                    word=scanner.next();
                    System.out.println("Write value");
                    value=scanner.next();
                    dictionary.addValue(word,value);
                    break;
                case 3:
                    System.out.println("Write word");
                    word= scanner.next();
                    dictionary.delete(word);
                    break;
                case 4:
                    System.out.println("Write word");
                    word=scanner.next();
                    System.out.println("Write value");
                    value=scanner.next();
                    dictionary.deleteValue(word,value);
                    break;
                case 5:
                    System.out.println(dictionary.dictionary);
                    break;
                case 6:
                    dictionary.printTop10();
                    break;
                case 7:
                    dictionary.printNoPopularTop10();
                    break;
                case 8:
                    System.out.println("Write word");
                    word=scanner.next();
                    System.out.println( dictionary.dictionary.get(word).getValues());
                    break;
            }
        }
    }
}
class Dictionary{
    HashMap<String, Translation> dictionary=new HashMap<>();
    public void add(String word,String translation){
        dictionary.put(word,new Translation(translation));
    }
    public void addValue(String word,String translation){
        dictionary.put(word,  dictionary.get(word).addValue(translation));
    }
    public void delete(String word){
        dictionary.remove(word);
    }
    public void deleteValue(String word,String value){
        dictionary.put(word,dictionary.get(word).removeEl(value));
    }
    public void printTop10(){
        dictionary.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(c->c.getValue().getCountGive())))
                .limit(10).forEach(c-> System.out.println(c.getKey()+" "+c.getValue()));
    }
    public void printNoPopularTop10(){

        dictionary.entrySet()
                .stream()
                .sorted(Comparator.comparing(c->c.getValue().getCountGive()))
                .limit(10).forEach(c-> System.out.println(c.getKey()+" "+c.getValue()));
    }
}
class Translation {
    private ArrayList<String> values=new ArrayList<>();
    private int countGive=0;

    public ArrayList<String> getValues() {
        countGive++;
        return values;
    }

    public int getCountGive() {
        return countGive;
    }
    public Translation addValue(String value){
        values.add(value);
        return this;
    }
    public Translation removeEl(String value){
        values.remove(value);
        return this;
    }
    public Translation(String value) {
        values.add(value);
    }

    public Translation(ArrayList<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "values=" + values +
                '}';
    }
}
class Station{
    Rider rider=new Rider();
    int spawnMan;
    int spawnRider;
    boolean isEnding;

    public Station(int spawnMan, int spawnRider, boolean isEnding) {
        this.spawnMan = spawnMan;
        this.spawnRider = spawnRider;
        this.isEnding = isEnding;
        rider=new Rider();
    }
    public void go(int n){
        float count=0;
        float res= (float) (spawnMan - n) /rider.countMan;
        ArrayList<Passager> arrayList=new ArrayList<>();
        for(int i=0;i<spawnMan;i++){
            arrayList.add(new Passager("Dima"+i));
        }
        int indx;
        do{
        if(isEnding){
            indx=0;
        }
        else{
            Random random=new Random();
             indx=random.nextInt(rider.countMan);
        }

        for(int i=indx;i<arrayList.size();i++){
            if(i>rider.countMan){

                break;
            }
            else{
                rider.man.add(arrayList.get(i));
                arrayList.remove(i);
            }
        }
        count=count/spawnRider;}
        while(!arrayList.isEmpty());
        System.out.println("AVg time been mn in station=" +count);
        System.out.println("Time for n ma"+res);
    }
}
class Rider{
    int countMan;
    ArrayList<Passager> man=new ArrayList<>();
    public  Rider(){
        Random random=new Random();
        countMan=random.nextInt(15);

    }
}
class Passager{
    String name;


    public Passager(String name) {
        this.name = name;
        Random random=new Random();

    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Man{
    int id;
    String name;
    ArrayList<Fine> fines=new ArrayList<>();

    public Man(int id, String name, ArrayList<Fine> fines) {
        this.id = id;
        this.name = name;
        this.fines = fines;
    }

    @Override
    public String toString() {
        return name +" "+fines.toString();
    }
}
class FinesDatabase{
    ArrayList<Man> manArrayList=new ArrayList<>();
    public void add(Man man){
        manArrayList.add(man);
    }
    public void printForId(int id){
        System.out.println( manArrayList.stream().filter(c->c.id==id).findFirst().get());
    }
    public void printForType(Fine.FineType type){
        manArrayList.forEach(c->{
            System.out.print(c.name);
            System.out.println(c.fines.stream().filter(e->e.fineType==type));
        });
    }
    public void printForTown(String town){
        manArrayList.forEach(c->{
            System.out.print(c.name);
            System.out.println(c.fines.stream().filter(e->e.town.equals(town)));
        });
    }
    public void addFine( int idMAn,Fine fine){
        manArrayList.stream().filter(c->c.id==idMAn).findFirst().get().fines.add(fine);
    }
    public  void remove(int idMan){
        manArrayList.remove(manArrayList.stream().filter(c->c.id==idMan).findFirst().get());
    }
    public void replace(int idMan,ArrayList<Fine> fines){
        manArrayList.stream().filter(c->c.id==idMan).findFirst().get().fines=fines;
    }
}
class Fine{
    FineType fineType;
    String town;

    @Override
    public String toString() {
        return "type"+fineType.toString()+"town"+town;
    }

    public Fine(FineType fineType, String town) {
        this.fineType = fineType;
        this.town = town;
    }

    enum FineType{
        Big,
        Normal,
        Small
    }
}