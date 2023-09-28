import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
      /*  System.out.println("zd1");
        zd1();
        System.out.println("zd2");
        zd2();
        System.out.println("zd3");
        zd3();
        System.out.println("zd4");
        zd4();
        System.out.println("zd5");
        zd5();
        System.out.println("Zd6");
        zd6();


        System.out.println("Zd7");
        zd7();


        System.out.println("Zd8");
        zd8();


        System.out.println("Zd9");
        zd9();

        System.out.println("Zd10");
        zd10();

        System.out.println("Zd11");
        zd11();

       */
        System.out.println("zd12");
        zd12();
    }
     static public void zd1(){
        System.out.println("'Your time is limited,");
        System.out.println("    so don’t waste it ");
        System.out.println("        living someone else’s life'");
        System.out.println("            Steve Jobs");
    }
    static  public void zd2(){
        Scanner sc=new Scanner(System.in);
        double num1=sc.nextDouble();
        Scanner sc1=new Scanner(System.in);
        double num2=sc1.nextDouble();
        System.out.println("Res:"+((num1/100)*num2));
    }
    static  void zd3(){
        StringBuffer str=new StringBuffer ((new Scanner(System.in)).next());
        str.append((new Scanner(System.in)).next());
        str.append((new Scanner(System.in)).next());
        try{
            Integer num=Integer.valueOf(str.toString());
            System.out.println("Res:"+num);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    static  void zd4(){
        StringBuffer str=new StringBuffer(new Scanner(System.in).next());
        String first=str.substring(0,1);
        str.replace(0,1,str.substring(5,6));
        str.replace(5,6,first);
        String second=str.substring(1,2);
        str.replace(1,2,str.substring(4,5));
        str.replace(4,5,second);
        System.out.println(str);

    }
    static  void zd5(){
        Integer month=new Scanner(System.in).nextInt();
        if(month.equals(1)||month.equals(2)||month.equals(12)){
            System.out.println("Winter");
            return;
        };
        if(month>2&& month<6){
            System.out.println("Spring");
            return;
        }
        if(month>5&&month<9){
            System.out.println("Summer");
            return;
        }
        if(month>8&&month<12){
            System.out.println("Autumn");
            return;
        }
        System.out.println("Erore");
    }
    static  void zd6(){
        double num=(new Scanner(System.in)).nextDouble();
        System.out.println("Дециметры: "+num*10);
        System.out.println("Мили: "+(num*0.00062));
        System.out.println("ярды: "+(num*1.09));
    }
    static  void zd7(){
        int[]nums={
                (new Scanner(System.in).nextInt()),
                (new Scanner(System.in).nextInt())
        };
        Arrays.sort(nums);
        int first=nums[0]+(nums[0]%2==0?1:0);
        for(int i=first;i<=nums[1];i+=2){
            System.out.println(i);
        }
    }
    static  void zd8(){
        int[]nums={
                (new Scanner(System.in).nextInt()),
                (new Scanner(System.in).nextInt())
        };
        Arrays.sort(nums);
        for(int i=nums[0];i<=nums[1];i++){
            for(int j=1;j<=10;j++){
                System.out.print(i+"*"+j+"= "+(i*j)+"   ");
            }
            System.out.println();
        }
    }
    static void zd9(){
        int[]nums=new int[1000];
        Random rand=new Random();
        int countPlus=0;
        int countMinus=0;
        int countNul=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=rand.nextInt();
            if(nums[i]<0){
               countMinus++;
            }
            if(nums[i]>0){
                countPlus++;
            }
            if(nums[i]==0){
                countNul++;
            }
        }
        System.out.println("0:"+countNul+" "+"Minus"+countMinus+"  "+"Plus"+countPlus);

    }
    static void zd10(){

        List<Integer> numsPlus=new ArrayList<Integer>();
        List<Integer> numsMinus=new ArrayList<Integer>();
        List<Integer> numsCh=new ArrayList<Integer>();
        List<Integer> numsNCH=new ArrayList<Integer>();
        int[]nums=new int[1000];
        Random rand=new Random();
        for(int i=0;i<nums.length;i++){
            nums[i]=rand.nextInt();
            if(nums[i]<0){
               numsMinus.add(nums[i]);
            }
            if(nums[i]>0){
                numsPlus.add((nums[i]));
            }
            if(nums[i]%2==0){
                numsCh.add(nums[i]);
            }
            else{
                numsNCH.add(nums[i]);
            }
        }
        System.out.println("Nums plus\n"+Arrays.toString(numsPlus.toArray()));
        System.out.println("Nums minus\n"+Arrays.toString(numsMinus.toArray()));
        System.out.println("Nums chet\n"+Arrays.toString(numsCh.toArray()));
        System.out.println("Nums nchet\n"+Arrays.toString(numsNCH.toArray()));
    }
    static void zd11(){
        boolean ishorizantal=new Scanner(System.in).nextBoolean();
        int count=new Scanner(System.in).nextInt();
        char simv=new Scanner(System.in).next().charAt(0);
        for(int i=0;i<count;i++){
            if(ishorizantal){
                System.out.print(simv);
            }
            else{
                System.out.println(simv);
            }
        }
    }
    static void zd12(){
        boolean isMintoMAx=new Scanner(System.in).nextBoolean();
        Integer[]nums=new Integer[1000];
        Random rand=new Random();
        for(int i=0;i<nums.length;i++){
            nums[i]=rand.nextInt();
        }
        if(isMintoMAx){
            Arrays.sort(nums);
        }
        else {
            Arrays.sort(nums,Collections.reverseOrder());
        }
        System.out.println("Arr: "+Arrays.toString(nums));
    }
}
