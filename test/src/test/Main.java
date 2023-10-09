package test;

import java.util.Scanner;

public class Main {    
    // 재귀함수를 이용해 숫자를 n부터 1까지 출력하고, 다시 1부터 n까지 출력합니다.
    public static void printStar(int n) {
        if(n == 0)
            return;
    
        System.out.print(n + " ");
        printStar(n - 1);
        System.out.print(n + " ");
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 변수 선언 및 입력:
        int n = sc.nextInt();

        printStar(n);
    }
}