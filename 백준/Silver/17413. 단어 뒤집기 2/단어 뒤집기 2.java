import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean isTag = false;
        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                printStack(stack, sb);
                sb.append(ch);
                isTag = true;
            } else if (ch == '>') {
                sb.append(ch);
                isTag = false;
            } else if (isTag) {
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    printStack(stack, sb);
                    sb.append(ch);
                } else {
                    stack.push(ch);
                }
            }
        }

        printStack(stack, sb);

        System.out.println(sb.toString());
    }

    private static void printStack(Stack<Character> stack, StringBuilder sb) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
