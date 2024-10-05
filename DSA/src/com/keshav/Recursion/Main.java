package com.keshav.Recursion;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        mergeInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeInPlace(int[] arr,int start,int end){

        if((end-start)==1){
            return;
        }

        int mid=start+(end-start)/2;
        mergeInPlace(arr,start,mid);
        mergeInPlace(arr,mid,end);
        merge(arr,start,mid,end);
    }

    static void merge(int[] arr,int s,int m,int e){
        int[] mix=new int[e-s];

        int i=s;
        int j=m;
        int k=0;

        while(i<m && j<e){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }
            else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }

        while(i<m){
            mix[k]=arr[i];
            i++;
            k++;
        }

        while(j<e){
            mix[k]=arr[j];
            j++;
            k++;
        }

        for(int res = 0; res <mix.length; res++){
            arr[s+res]=mix[res];
        }
    }
}
