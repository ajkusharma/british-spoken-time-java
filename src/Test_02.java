import java.net.StandardSocketOptions;

public class Test_02 {

    public static void main(String[] args) {

        int result = test_of_fibanacci(7);
        System.out.println(result);

    }

    private static int test_of_fibanacci(int i) {
        if(i==0) return 0;
        if(i==1) return 1;
        return test_of_fibanacci(i-1)+test_of_fibanacci(i-2);
    }

}
