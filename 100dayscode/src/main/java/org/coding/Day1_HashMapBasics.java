package org.coding;

import java.util.*;

public class Day1_HashMapBasics {

    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "apple", "orange", "banana", "apple"};
        Map<String,Integer> map = wordCount(arr);
        map.forEach((key,value) -> System.out.println(key+ " " +value));

        System.out.println(createPairs(107));

    }

    //WordCount
    public static Map<String,Integer> wordCount(String[] arr){
        Map<String,Integer> wordCountMap = new HashMap<>();
        for(String word: arr){
            wordCountMap.put(word,word.length());
        }
        return wordCountMap;
    }

    //Create Pairs
    public static String createPairs(int lookUpId){
        Map<Integer,String> pairMap = new HashMap<>();
        int[] employeeIdsList = {101, 102, 103, 104};
        String[] employeeNamesList = {"Ravi", "Anita", "John", "Priya"};

        for(int i = 0; i<employeeIdsList.length; i++)
            pairMap.put(employeeIdsList[i],employeeNamesList[i]);

        return pairMap.getOrDefault(lookUpId, "Unknown Employee");

    }

    //Product Catalog
    public  void productCatalogAddUpdate(String key,int value) {
        Map<String, Integer> productCatalogMap = new HashMap<>();
        {
            productCatalogMap.put("Laptop", 2000);
            productCatalogMap.put("Tablet", 1500);
            productCatalogMap.put(key, value);
            productCatalogMap.remove(key);
            System.out.println(productCatalogMap.containsValue(value));
        }
    }

    //MarksReport
    public  void marksReport(){
        List<List<Object>> input = new ArrayList<>();
        input.add(List.of("Ravi",92));
        input.add(List.of("Anita",78));
        input.add(List.of("John",55));
        input.add(List.of("Sam",65));
        input.add(List.of("Priya",88));

        Map<String, List<String>> reportMap = new HashMap<>();

        for (List<Object> objects : input) {
            String grade;
            String name = (String) objects.get(0);
            int marks = (int) objects.get(1);
            if (marks >= 90)
                grade = "A";
            else if (marks >= 75)
                grade = "B";
            else
                grade = "C";
            reportMap.computeIfAbsent(grade, k -> new ArrayList<>()).add(name);

        }
        }

        //Sort Salary
    public void sortSalary(){
        Map<Integer,Integer> salaryMap = Map.of(  101, 50000,
                102, 75000,
                103, 60000,
                104, 75000,
                105, 50000);

        //Without Streams
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(salaryMap.entrySet());
        entries.sort(Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed());
        for (Map.Entry<Integer, Integer> e : entries) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        //With Streams
        salaryMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));
    }

    //Non-repeating character
    public void firstNonRepeatingCharacter(String s){
        Map<Character,Integer> countMap = new LinkedHashMap<>();
        for(char ch: s.toCharArray()){
            countMap.put(ch,countMap.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry:countMap.entrySet()){
            if(entry.getValue().equals(1))
                System.out.println(entry.getKey());
        }
    }

    //Merge Hashmaps
    public void mergeMaps(){
        Map<String,Integer> map1 = Map.of("Pen",50, "Book",30, "Bag",10);
        Map<String,Integer> map2 = Map.of("Pen",20, "Bag",10, "Pencil",10);

        map2.forEach((k,v) -> map1.merge(k,v,Integer::sum));

        System.out.println(map2);
        System.out.println(map1);
    }

    //Concurrent Modification
    public void concurrentModify() {
        Map<String, Integer> countryMap = Map.of("Dublin", 1400000, "Cork", 210000, "Galway", 85000, "Mumbai", 20000000,
                "Delhi", 19000000, "Pune", 310000);
        //Remove If
        countryMap.entrySet().removeIf(x -> x.getValue() < 50000);

        //Iterator
        Iterator<Map.Entry<String, Integer>> it = countryMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() < 500000)
                it.remove();

        }
    }

    //Order Management
    public void manageOrder(){
            HashMap<String, List<String>> orderMap = new HashMap<>();
            List<List<Object>> input = new ArrayList<>();
            input.add(List.of("O1","C1",500));
            input.add(List.of("O2","C2",300));
            input.add(List.of("O3","C1",700));
            input.add(List.of("O4","C3",100));
            input.add(List.of("O5","C2",250));

            for(List<Object> object: input){
                String order = (String)object.get(0);
                String cust = (String) object.get(1);
                orderMap.computeIfAbsent(cust,x -> new ArrayList<>()).add(order);
            }
    }

    //Stock Management
    public void stockManage(){
        Map<String,Integer> stockInMap = Map.of("AAPL",150,"GOOG",2800,"MSFT",150,"AMZN",3400,"META",2800);
        Map<Integer,List<String>> stockOutMap = new HashMap<>();

        for(Map.Entry<String,Integer> entry: stockInMap.entrySet()){
            stockOutMap.computeIfAbsent(entry.getValue(),x-> new ArrayList<>()).add(entry.getKey());
        }
    }

    public void minMax(){
        Map<String,Integer> mapIn = Map.of("Alice",8500,"Bob",9200,"Carol",7800,"Dave",9200,"Eve",6500);

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for(Map.Entry<String,Integer> entry: mapIn.entrySet()){
            if(entry.getValue()>maxValue)
                maxValue= entry.getValue();
            if(entry.getValue()<minValue)
                minValue = entry.getValue();
        }

        //from the val get the key and print

    }








}
