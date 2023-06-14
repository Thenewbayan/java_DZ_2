public class App {
    public static void main(String[] args) throws Exception {
        //int[] arr=new int[] {5,1,5,7,1,10,9,100,2,8,7,96,63,8}; //for example
        // methods.PrintArray(arr);
        // System.out.println();
        //methods.PrintArray(arr);
        // methods.LoggerOfClass(arr);
        methods.split(methods.reader());
        
        
    }
}

// Задание

// 1) Дана строка sql-запроса "select * from students where ". Сформируйте часть 
// WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

// 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации 
// запишите в лог-файл.