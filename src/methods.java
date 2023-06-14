import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class methods {

    /**
      * @param array //array of integer numbers
      * @return sorted array
      */
    public static int[] TempSortedArray(int [] array, Logger logger){
        int[] result=array;
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < (array.length) - 1; i++) {
                if (array[i] > array[i+1]) {
                    logger.info("sswap "+array[i]+" to "+array[i+1]);
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
        }
    }
    return result;
}

    /**
     * @param array //for print
     */
    public static void PrintArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = array[i];
            System.out.print(j + "; ");
        }
    }


    /**
    * 
    */
     public static void LoggerOfClass(int [] arr)  throws IOException{
         Logger logger = Logger.getLogger(App.class.getName());
         FileHandler fh = new FileHandler("log.txt");
         logger.addHandler(fh);
         SimpleFormatter sFormatter = new SimpleFormatter();
         fh.setFormatter(sFormatter);
        //logger.log(Level.WARNING, "Test log 1");
         logger.info("Test log 1");
         methods.TempSortedArray(arr, logger);
     }

     //1) Дана строка sql-запроса "select * from students where ". Сформируйте часть 
     // WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
     // Если значение null, то параметр не должен попадать в запрос.
     // Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
      
    //  public static StringBuilder WhereBuilder (){
    //     StringBuilder where =new StringBuilder();
    //     String lineFile;
    //     try{ 
    //     File file = new File("D:\\lesson_GB\\JAVA\\DZ_2\\src\\Txt1.txt");
    //     FileReader fr = new FileReader(file);
    //     BufferedReader reader = new BufferedReader(fr);
    //     while (reader.readLine()!=null){
    //       lineFile=reader.readLine();
    //     }
    //   }
    //     catch (FileNotFoundException e) {
    //       e.printStackTrace();
    //   } catch (IOException e) {
    //       e.printStackTrace();
    //   }
    //   String temp=lineFile.split(",")
    //   where.append(temp.split(":"));

      

      
    //   System.out.print(where.toString());
    //   return where;
      
    // } 
     public static String reader() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("D:\\lesson_GB\\JAVA\\DZ_2\\src\\Txt1.txt"))) {
          String line;
          while ((line = reader.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
        String str = sb.toString();
        return str;
    
      }
      public static void split(String str) {
        String str2 = str.replace("{", "")
            .replace("}", "")
            .replace("\"", "");
        String[] newStr = str2.split(", ");
    
        Map<String, String> dictionary = new HashMap<String, String>();
        for (String item : newStr) {
          String[] strnew = item.split(":");
          //System.out.println(Arrays.toString(strnew));
          for (int i = 0; i < newStr.length; i++) {
            dictionary.put(strnew[0], strnew[1]);
          }
        }
        //System.out.println(dictionary.entrySet());
        StringBuilder WHERE = new StringBuilder();
        Set<Map.Entry<String, String>> pair = dictionary.entrySet();
        List<Map.Entry<String, String>> list = new ArrayList<>(pair);
        for (int i = 0; i < list.size(); i++) {
          if (!list.get(i).getValue().equals("null")) {
            WHERE.append(list.get(i).getKey() + " = " + list.get(i).getValue() + " and ");
            
          }
        }
        System.out.println(WHERE);
     
    }
}
    


