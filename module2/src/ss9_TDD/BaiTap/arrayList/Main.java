package ss9_TDD.BaiTap.arrayList;

public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.add("Java");
        list.add("C++");
        list.add("Python");

        System.out.println("List size: "+ list.size());
        System.out.println("Element at index 1: " + list.get(1));

        list.remove(1);

        System.out.println("List after removal:");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println("Constains Java? " + list.contains("Java"));
        System.out.println("Index of python: " + list.indexOf("Python"));
    }
}
