import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test_01 {

    public static void main(String[] args){

        int[] a = {3, 2, 5, 4, 1, -7,-6, 0, 12, -5, -9};
        System.out.println(a);

        int i,j,k;

        for(j=0;j<a.length-1;j++){
            for(i=0;i<a.length-1;i++){
                if(a[j]>a[i]){
                    k=a[i];
                    a[i]=a[j];
                    a[j]=k;
                }
            }
        }

        for(i=0;i<a.length;i++){
            System.out.println(a[i]);
        }



    }





}
