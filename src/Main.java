import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = createArray();
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
    }

    public static int[] createArray() {
        Random random = new Random();
        int[] arr = new int[random.nextInt(10, 15)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 100);
        }
        return arr;
    }

    private static void heapSort(int[] arr) {
        int len = arr.length;
        for (int i = len/2 - 1; i >= 0; i --) {
            heaps(arr, len, i);
        }
        for (int i = len - 1; i >= 0 ; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heaps(arr, i, 0);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void heaps(int[] arr, int len, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (i != largest) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heaps(arr, len, largest);
        }
    }
}