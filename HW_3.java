import java.util.*;
public class HW_3 {
    public static void main(String[] args) {

//        1. Реализовать алгоритм сортировки списков компаратором
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(new Random().nextInt(10));
        }
        System.out.println(list1);
        Collections.sort(list1);
        list1.sort(new Comparator<>() {
            @Override
            public int compare(Integer elem1, Integer elem2) {
                if (elem2 > elem1) return 1;
                else if (elem2 < elem1) return -1;
                return 0;
            }
        });
        System.out.println(list1);

//        2. Пусть дан произвольный список целых чисел, удалить из него чётные числа
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list2.add(new Random().nextInt(10));
        }
        System.out.println(list2);
        removeEvenNumbers(list2);
        System.out.println(list2);

//        3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list3.add(new Random().nextInt(10));
        }
        System.out.println(list3);
        int min = Collections.min(list3);
        int max = Collections.max(list3);
        double averageValue = arraySum(list3) / list3.size();
        System.out.println("Минимальное значение: " + min + "\n" + "Максимальное значение: " + max + "\n" +
                "Среднее значение: " + averageValue);

//        4. Дано два целочисленных списка, объеденить их не допуская элементы второго списка уже встречающиеся
//        в первом
        ArrayList<Integer> list4a = new ArrayList<>();
        ArrayList<Integer> list4b = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list4a.add(new Random().nextInt(10));
            list4b.add(new Random().nextInt(10));
        }
        System.out.println(list4a);
        System.out.println(list4b);
        ArrayList<Integer> commonList = mergeLists(list4a, list4b);
        System.out.println("Объединение: " + commonList);

//        5. Создать ArrayList<Integer> и добавить нулевым эллементом ноль 10000 раз
        long start = System.currentTimeMillis();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            myArrayList.add(0, 0);
        }
        long arrayListTime = System.currentTimeMillis() - start;
        System.out.println(myArrayList);

//        6. Повторить пятый пункт но с LinkedList
        start = System.currentTimeMillis();
        Deque<Integer> myLinkedList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            myLinkedList.offerFirst(0);
        }
        long linkedListTime = System.currentTimeMillis() - start;
        System.out.println(myLinkedList);

//        7. Сравнить время работы пятого и шестого пунктов
        System.out.println("Время работы ArrayList: " + arrayListTime);
        System.out.println("Время работы LinkedList: " + linkedListTime);

    }

//    2-ой метод
    public static void removeEvenNumbers(ArrayList<Integer> list){
        list.removeIf(integer -> integer % 2 == 0);
    }

//    3-ий метод
    public static double arraySum(ArrayList<Integer> list) {
        double mySum = 0;
        for (Integer integer : list) {
            mySum += integer;
        }
        return mySum;
    }

//    4-ый метод
public static ArrayList<Integer> mergeLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {
    ArrayList<Integer> merge = new ArrayList<>(list1);
    for (Integer elem : list2) {
        if (!list1.contains(elem)) {
            merge.add(elem);
        }
    }
    return merge;
}



}
