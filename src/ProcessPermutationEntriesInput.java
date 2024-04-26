import java.util.ArrayList;
import java.util.Scanner;
public class ProcessPermutationEntriesInput { //contains utility method to return a permutation ArrayList

    //insert and process sequentially all entries
    public static ArrayList<Integer> process(int length){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> sigma = new ArrayList<>();
        System.out.println("Enter values [1,2,3,...,n] or -1 to fill all empty values with available keys (σ(a) = a or σ(a) = b, if σ(b) = a):");
        for (int i = 1; i <= length ; i++) {
            System.out.printf("%nσ(%d) = ",i);
            int sigma_i = scanner.nextInt();

            if(sigma_i == -1){
                for(int k = i; k <= length ; k++)
                    if(sigma.contains(k))
                        sigma.add(sigma.indexOf(k) + 1);
                    else {
                        sigma.add(k);
                    }
                break;
            }

            if(sigma_i < 1 || sigma_i > length || sigma.contains(sigma_i)){
                System.out.println("Non permitted entry or already input.");
                i--;
                continue;
            }

            sigma.add(sigma_i);
        }
        return sigma;
    }
}
