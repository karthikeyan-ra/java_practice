import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    private  void readLogFile()
    {
        try
        {

            // File file = new File("D:\\projectss\\test\\exercise\\log\\log_1.txt");

            File parentDire = new File("D:\\projectss\\test\\exercise\\log");
            File lastModifiedFile=null;
            if(parentDire.isDirectory())
            {
               File[] files=parentDire.listFiles();

                Optional<File> opFile = Arrays.stream(parentDire.listFiles(File::isFile))
                        .max((f1, f2) -> Long.compare(f1.lastModified(), f2.lastModified()));

                if (opFile.isPresent()){
                    lastModifiedFile= opFile.get();
                }


                  System.out.println(lastModifiedFile.getName());

                   ArrayList<Record> lst=new ArrayList<Record>();
                   BufferedReader br = new BufferedReader(new FileReader(lastModifiedFile));
                   String line;
                   while ((line = br.readLine()) != null) {
                      System.out.println("line::"+line);
                       String[] arr=line.split("[|]");
                       Record r=new Record();
                       for(int i=0;i< arr.length;i++)
                       {
                         Object token=  arr[i];
                           //System.out.println("type::"+token.getClass().toString());
                           if(i==0)
                           {
                                r.setProcessName((String)token);
                           }
                           else if(i==1)
                           {
                                   r.setProcessId(Integer.parseInt((String)token));

                           }
                           else if(i==2)
                           {
                                   r.setUser((String)token);
                           }
                           else if(i==3)
                           {
                                   r.setCpu(Integer.parseInt((String)token));
                           }
                           else if(i==4)
                           {
                                   r.setBytesOfMemeory(Integer.parseInt((String)token));
                           }
                       }
                   //    System.out.println("record::"+r);
                       lst.add(r);
                   }

                   System.out.println(" ###########output#########");


              long cnt=  lst.stream().filter(r->
                {
                    System.out.println(";;"+r.getCpu());
                    if(r.getCpu()==0)
                     return true;
                    else
                        return false;

                }).count();

                System.out.println("cnt::"+cnt);

                long cntViaPredicate=  lst.stream().filter(r->Utils.isZeroCpu.test(r)).count();

                System.out.println("cnt::"+cntViaPredicate);
              //  Map map=  lst.stream().filter(r->Utils.isGreaterThanZeroCpu.test(r)).collect(Collectors.groupingBy(r->r.getCpu()));
                Map map=  lst.stream().filter(r->Utils.isGreaterThanZeroCpu.test(r)).collect(Collectors.groupingBy(Record::getCpu));
                System.out.println("map::"+map.size());
                System.out.println("map::"+map);

                List modifiedLst= lst.stream().map(r->{
                    if(r.getCpu()==0)
                      r.setUser("xxxx");
                   return r;
                        }).collect(Collectors.toList());

                System.out.println("modifiedLst::"+modifiedLst);


                // List a= lst.stream().collect(Collectors.toList());
                //System.out.println("a::"+a);




            }

        } catch (Exception e) {
            e.printStackTrace();

        }

       /* public static Integer findMax(List<Integer> list)
        {

            // check list is empty or not
            if (list == null || list.size() == 0) {
                return Integer.MIN_VALUE;
            }

            // create a new list to avoid modification
            // in the original list
            List<Integer> sortedlist = new ArrayList<>(list);

            // sort list in natural order
            Collections.sort(sortedlist);

            // last element in the sorted list would be maximum
            return sortedlist.get(sortedlist.size() - 1);
        }

        */
    }

    public static void main(String args[])
    {
        System.out.println(" ## Test ## ");
        Test t=new Test();
        t.readLogFile();
    }


}
