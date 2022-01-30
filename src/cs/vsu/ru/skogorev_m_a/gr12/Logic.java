package cs.vsu.ru.skogorev_m_a.gr12;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


public class Logic {

    public static List<Integer> createNewList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        int[] occurrence = findCount(list);

        for (int i = findMax(occurrence); i > 0; i--){
            int count = 0;
            for (int j = 0; j < occurrence.length; j++){
                if (occurrence[j] == i){
                    newList.add(list.get(j));
                    count++;
                }
            }
            sort(newList, newList.size()-count, newList.size());
        }
        return newList;
    }

    public static int[] findCount(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i=0; i<list.size(); i++){
            result[i] = countOf(list, list.get(i));
        }
        return result;
    }

    public static int countOf (List<Integer> list, int value){
        int count = 0;
        for (int elem : list){
            if (elem == value){
                count++;
            }
        }
        return count;
    }

    public static void sort(List<Integer> list, int index1, int index2){
        for (int i = index1; i < index2; i++) {
            int pos = i;
            int min = list.get(i);
            for (int j = i + 1; j < index2; j++) {
                if (list.get(j) < min) {
                    pos = j;
                    min = list.get(j);
                }
            }
            list.set(pos, list.get(i));
            list.set(i, min);
        }
    }

    public static int findMax(int [] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }


    public static int[] listIntoArr(List<Integer> list){
        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static List<Integer> arrIntoList(int[] arr){
        List<Integer> list = new ArrayList<>();

        for (int elem : arr){
            list.add(elem);
        }
        return list;
    }

    public static void saveOutputIntoFile(String fileName, List<Integer> result) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(Arrays.toString(Logic.listIntoArr(result)));
        }
    }


    public static void checkIfArrayIsNull(int[] arr) throws Exception{
        if (arr == null){
            throw new Exception("Такой input-файл не существует");
        }
    }


    public static void checkIfArrayIsEmpty(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("Пустой массив");
        }
    }

}
