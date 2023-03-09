/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.countsort;

/**
 *
 * @author ACER
 */
/* Java implementation Counting Sort */
import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    /* Mengitung fungsi sortir */
    void countingSort(int A[] , int max){
        int n= A.length ;
        int B[]=new int[n];
        int C[]=new int[max+1];

        //Menginisialisasi menghitung array C[] to 0
        for (int i=0; i <=max; i++)
            C[i] = 0;
        
        //Mengitung jumlah setiap elemen dalam array C
        for (int j=0; j<n; j++)
            C[A[j]] = C[A[j]] + 1;

        /* Ubah C[i] sedemikian rupa sehingga berisi posisi 
        sebenarnya dari elemen-elemen ini dalam larik keluaran array */
        for (int i=1; i<max+1; i++)
            C[i] = C[i] + C[i-1];

        //Membuat array keluaran dari C[i]
        //dan penurunan nilai C[i].
        for (int j=n-1; j>=0; j--)
        {
            B[C[A[j]]-1] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }

        //Printing sorted array
        System.out.println("Array yang diurutkan adalah  : ");
        //print sorted array
          System.out.println(Arrays.toString(B));
    }
    
    public static void main (String args[]){
        @SuppressWarnings("resource")
        Scanner sc=new Scanner(System.in);
        System.out.println("Masukkan Jumlah Masukan : ");
        
        int n= sc.nextInt();
        int A[] =new int[n];
        int max=0;
        
        System.out.println("Masukkan Elemen yang akan diurutkan :");
        
        /*Menyimpan elemen dalam array.
        Dan menemukan maksimal elemen untuk mengatur rentang
        menghitung array C[]*/
        for(int i=0; i<n; i++){
            A[i]=sc.nextInt();
            if (A[i] > max) {
                max= A[i];
            }
        }

        CountSort ob= new CountSort();
        //Memanggil menghitung fungsi semacam
        ob.countingSort(A, max);

    }
}
