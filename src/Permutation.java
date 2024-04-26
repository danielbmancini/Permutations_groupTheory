import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * A permutation, or an element from a permutation group.
 *
 * @author danielbmancini
 */
public class Permutation {
    /**
     * HashMap acting like a bijective function.
     */
    HashMap<Integer, Integer> thisPermutation;

    /**
     * Instantiates a new permutation -- <i>mappings</i> is the set of the values of this permutation.
     *
     * @param mappings ArrayList of the mappings of this permutation.
     */
    public Permutation(ArrayList<Integer> mappings) {
        thisPermutation = new HashMap<>();

        int key = 1;
        for (int sigma : mappings)
            thisPermutation.put(key++, sigma);
    }

    /**
     * Multiplies (with function composition) this permutation with <i>perm2</i>.
     *
     * @param perm2 A second permutation to multiply with.
     * @throws IllegalArgumentException Exception thrown if <i>perm2</i>'s size is different than this permutation's size.
     */
    public void multiplyWith(Permutation perm2) throws IllegalArgumentException {
        if (perm2.length() != this.length())
            throw new IllegalArgumentException("Second permutation has a different size from this permutation.");

        ArrayList<Integer> values = new ArrayList<>(perm2.thisPermutation.values());
        thisPermutation.replaceAll((a, sigma_a) -> values.get(sigma_a - 1));
    }

    /**
     * String representation that resembles Cauchy's two line notation.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n").append(
                thisPermutation
                        .keySet()
                        .toString()
                        .replaceAll("[\\[,\\]]", ""))
                .append("\n");
        for (int aValue : thisPermutation.values())
            stringBuilder.append(aValue).append(" ");
        return stringBuilder.toString();
    }

    /**
     * Evaluate if this permutation is the identity.
     *
     * @return A Boolean representing if this permutation is ι, the identity permutation.
     */
    public boolean isIdentity() {
        for (Map.Entry<Integer, Integer> entry : thisPermutation.entrySet())
            if (!entry.getValue().equals(entry.getKey()))
                return false;

        return true;
    }

    /**
     * String of the cycle notation of this permutation.
     *
     * @return String of the cycle notation
     */
    public String toCycleString() {
        int n = thisPermutation.size();
        boolean[] p = new boolean[n];
        Arrays.fill(p, true);

        StringBuilder sb = new StringBuilder();
        int j;
        for (int i = 0; i < n; i++) {
            if (p[i]) {
                sb.append('(');
                sb.append(i + 1);
                p[i] = false;
                j = i;
                while (p[thisPermutation.get(j + 1) - 1]) {
                    sb.append(", ");
                    j = thisPermutation.get(j + 1) - 1;
                    sb.append(j + 1);
                    p[j] = false;
                }
                sb.append(')');
            }
        }
        return sb.toString();
    }

    /**
     * Map this permutation to its inverse.
     */
    public void invert() {
        HashMap<Integer, Integer> inverse = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : thisPermutation.entrySet())
            inverse.put(entry.getValue(), entry.getKey());
        thisPermutation = inverse;
    }

    /**
     * Get the string of the orbit of <i>element</i>.
     *
     * @param element -- an element of the set of values of this permutation.
     * @return The string of the orbit of <i>element</i>.
     */
    public String getOrbit(int element) { //string representation of the orbit of element
        int nextElement = element;
        StringBuilder orbit = new StringBuilder("(");
        orbit.append(element).append(", ");
        while (element != thisPermutation.get(nextElement)) {
            nextElement = thisPermutation.get(nextElement);
            orbit.append(nextElement).append(", ");
        }
        orbit.replace(orbit.length() - 2, orbit.length(), ")");
        return orbit.toString();
    }

    /**
     * Get permutation length.
     *
     * @return n, from this permutation belonging to S_n.
     */
    public int length() {
        return thisPermutation.size();
    }

    /**
     * Get mapping of <i>key</i>.
     *
     * @param key A key from the HashMap.
     * @return Value mapped from key in this permutation.
     */
    public int value(int key) {
        return thisPermutation.get(key);
    }

}
