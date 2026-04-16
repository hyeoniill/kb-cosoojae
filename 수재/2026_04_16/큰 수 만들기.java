package ct;

public class Main {
    public static void main(String[] args) {
        String number = "4177252841", answer = "";
        int k = 4;
        int n = 0;

        for (int i = 0; i < number.length()-k; i++) {
            int max = 0;
            for (int j = n; j < k + i + 1; j++){
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    n = j;
                }
                System.out.println(max + ", " + n);
            }
            answer += max;
            n += 1;
            System.out.println("-----------------------------------");
        }

        System.out.println(answer);
    }
}
