package dynamicArray;

import java.util.Arrays;

public class DynamicArray {
    int[] a;
    int index = 0;

    public DynamicArray(int initialCapacity) {
        a = new int[initialCapacity];
    }

//     just remove first One
//    void remove(int x) {
//        int xIndex = -1;
//        for (int i = 0; i < index; i++) {
//            if (a[i] == x) {
//                xIndex = i;
//                break;
//            }
//        }
//
//        if (xIndex == -1) {
//            System.out.println("Element not found!");
//            return;
//        }
//
//        for (int i = xIndex; i < index - 1; i++) {
//            a[i] = a[i + 1];
//        }
//
//        index--;
//        a[index] = 0;
//    }

    void remove(int x) {
        int shiftCount = 0;

        for (int i = 0; i < index; i++) {
            if (a[i] == x) {
                shiftCount++;
            } else if (shiftCount > 0) {
                a[i - shiftCount] = a[i];
            }
        }

        index -= shiftCount;

        for (int i = index; i < a.length; i++) {
            a[i] = 0;
        }

        if (shiftCount == 0) {
            System.out.println("Element not found!");
        }
    }


    void add(int x) {

        if (index == a.length) {
            int[] b = new int[a.length * 2];
            System.arraycopy(a, 0, b, 0, a.length);
            a = b;
        }
        a[index++] = x;
    }

    void printArray() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, 0, index)));
    }

    int size() {
        return index;
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(3);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(0);
        arr.add(2);
        arr.add(4);
        arr.add(2);
        arr.printArray();

        arr.remove(2);
        arr.printArray();

        arr.remove(10);
    }
}
