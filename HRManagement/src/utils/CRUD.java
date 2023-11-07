package utils;

import java.util.ArrayList;
import java.util.List;

public class CRUD<E> {
    List<E> list = new ArrayList<>();

    public boolean add(E e) {
        if (!list.contains(e)) {
            return list.add(e);  
        } else {
            return false;
        }
    }
    public boolean remove(E e){
        if(list.contains(e)){
            return list.remove(e);
        } else {
            return false;
        }
    }
    public void read(){
        for (E a : list) {
            System.out.println(a);
        }
    }

    public void read(E e){
        if(list.contains(e)){
            System.out.println(e);
        } else {
            System.out.println("The element doesn't exist");
        }
    }

    public static void update(List<E> list, E e, E a){
        if(list.contains(e)){
           int index = list.indexOf(e);
           list.set(index, a);
        } else {
            System.out.println("The object doesn't exist");
        }
    }
}
