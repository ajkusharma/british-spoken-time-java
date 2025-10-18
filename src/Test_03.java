public class Test_03 {
    public static void main(String[] args) {
        int n = 5;
        int result = factorial(n);
        System.out.println("Factorial of " + n + " is: " + result);
    }

    private static int factorial(int n) {
        if(n==0) return 1;
        return n * factorial(n-1);
    }
}
