package ss3_array.BaiTap;

import java.util.Scanner;

public class AddElementToArray {
  //Thêm phần tử vào mảng
  public static void main(String[] args) {
    int[] arr = {3,4,5,6,7,8};
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập số cần chèn: ");
    int number = scanner.nextInt();

    Scanner scanner1 = new Scanner(System.in);
    System.out.println("Nhập vị trí index cần chèn vào trong mảng: ");
    int index = scanner1.nextInt();

    if (index < 0 || index > arr.length){
      System.out.println("Vị trí không hợp lệ!");
    }else {
      arr = add(arr, number, index);

      System.out.println("Mảng sau khi thêm: ");
      for (int num : arr){
        System.out.println(num + " ");
      }
    }
  }
  public static int[] add(int [] arr,int number, int index){
    int[] newArr = new int[arr.length + 1];

    for (int i =0, j = 0; i < newArr.length; i++){
      if (i == index){
        newArr[i] = number;
      }else {
        newArr[i] = arr[j++];
      }
    }
    return newArr;
  }

}
