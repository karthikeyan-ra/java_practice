public class Sample {
    public static void main(String args[]) throws Exception
    {
        /* immutable and mutable diff*/
        String s1="xxx";
        String s2="yyy";

        s2=s1;
        System.out.println("s1:"+s1+" ::"+s1.hashCode());
        System.out.println("s2:"+s2+" ::"+s2.hashCode());

        s2="zzz";
        System.out.println("s1:"+s1+" ::"+s1.hashCode());
        System.out.println("s2:"+s2+" ::"+s2.hashCode());

        int a=10;
        StringBuffer sb1=new StringBuffer("xxx");
        StringBuffer sb2=new StringBuffer("yyy");

        sb2=sb1;
        System.out.println("sb2:"+sb2+" ::"+sb2.hashCode());

        sb2.append("zzz"); //mutable
        System.out.println("sb1:"+sb1 +" ::"+sb1.hashCode());
        System.out.println("sb2:"+sb2+" ::"+sb2.hashCode());


        String sm1=new String("mani");
        String sm2=new String("ravi");

        sm2=sm1;
        sm2="ttt"; //immutable
        System.out.println("sm1:"+sm1 +" ::"+sm1.hashCode());
        System.out.println("sm2:"+sm2+" ::"+sm2.hashCode());


        // cloning
        Record r1=new Record();
        r1.setCpu(22);

        Record r2=(Record)r1.clone();

        /*
        Record r2=r1;

        Record r2=new Record();
        r2=r1;
        */
        r2.setProcessName("notepad");

        System.out.println("r1:"+" ::"+r1.hashCode());
        System.out.println("r1:"+" :v:"+r1);

        System.out.println("r2:"+" ::"+r2.hashCode());
        System.out.println("r2:"+" :v:"+r2);




    }
}
