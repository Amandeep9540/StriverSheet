package Strings.matchingAlgos.Zalgorith;

public class ZAlgo {
    public static void main(String[] args) {
        String text = "ababcabc";
        String pattern = "abc";

        search(text, pattern);
    }
    // Pattern matching using Z Algorithm
    public static void search(String text, String pattern) {
        String combined = pattern + "$" + text;
        int[] z = computeZ(combined);

        int pLen = pattern.length();

        for (int i = 0; i < z.length; i++) {
            if (z[i] == pLen) {
                System.out.println("Pattern found at index: " + (i - pLen - 1));
            }
        }
    }

    public static int[] computeZ(String s) {
        int n = s.length();
        int[] z = new int[n];

        int left = 0, right = 0;

        for (int i = 1; i < n; i++) {

            // Case 1: i is outside the Z-box
            if (i > right) {
                left = right = i;

                while (right < n && s.charAt(right - left) == s.charAt(right)) {
                    right++;
                }

                z[i] = right - left;
                right--;  // adjust because we went one step ahead

            } else {
                // Case 2: i is inside the Z-box
                int k = i - left;

                // Case 2A: value doesn't exceed the Z-box
                if (z[k] < right - i + 1) {
                    z[i] = z[k];
                } else {
                    // Case 2B: need to expand beyond right
                    left = i;

                    while (right < n && s.charAt(right - left) == s.charAt(right)) {
                        right++;
                    }

                    z[i] = right - left;
                    right--;
                }
            }
        }

        return z;
    }
}
