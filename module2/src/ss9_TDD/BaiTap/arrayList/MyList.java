package ss9_TDD.BaiTap.arrayList;

public class MyList <E> {
    private int size = 0;
    private static final int DEFAUL_CAPACITY = 10;
    private Object elements [];

    public MyList (){
        elements = new Object[DEFAUL_CAPACITY];
    }

   public MyList (int capacity){
        elements = new Object[capacity];

    }
    public void add(int index, E element){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + size);
        }
        if (size == elements.length){
            ensureCapacity(elements.length * 2);
        }
        for (int i = size; i > index; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }
    public void add(E e){
        if (size == elements.length){
            ensureCapacity(elements.length * 2);
        }
        elements[size++] = e;
    }
    public E remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) elements[index];
        for (int i = index; i < size - 1; i++){
        }
        elements[size - 1] = null;
        size--;
        return removedElement;
    };
    public E get(int index){
        if (index >= size || index <0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        }
        return (E) elements[index];
    }
    public int size(){
        return size;
    }
    public void clear(){
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }
public void ensureCapacity(int minCapacity){
        if (minCapacity > elements.length){
            Object[] newElement = new Object[minCapacity];
            for (int i = 0; i < size; i++){
                newElement[i] = elements[i];
            }
            elements = newElement;
        }
}
public boolean contains(E o) {
        return indexOf(o) >=0;
}
public int indexOf(E o){
        for (int i = 0; i < size; i++){
            if (o.equals(elements[i])){
                return i;
            }
        }
        return -1;
}
public MyList<E> clone(){
        MyList<E> newList = new MyList<>(elements.length);
        for (int i = 0; i < size; i++){
            newList.add((E) elements[i]);
        }
        return newList;
}
}
