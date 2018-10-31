package graph;

import datastructure.Lqueue;
import datastructure.Lstack;
import datastructure.EmptyContainerException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean goon = true;
        while (goon) {
            System.out.print("Do you want to use stack or queue? (s to stack, q to queue, e to exit): ");
            switch (input.next().charAt(0)) {
            case 's':
            case 'S':
                System.out.println("You are using stack now.");
                testStack(input);
                break;
            case 'q':
            case 'Q':
                System.out.println("You are using queue now.");
                testQueue(input);
                break;
            case 'e':
            case 'E':
                goon = false;
                System.out.println("Exit.");
                break;
            }
        }
        input.close();
    }

    static void testStack(Scanner input) {
        Lstack<String> stack = new Lstack<String>();
        while (true) {
            System.out.println("Please input the operation you want to do.");
            System.out.print("p(push), o(pop), t(top), i(is empty or not), r(return): ");
            switch (input.next().charAt(0)) {
            case 'p':
            case 'P':
                System.out.print("Please input the word you want to push: ");
                stack.push(input.next());
                break;
            case 'o':
            case 'O':
                try {
                    System.out.println("You choosed to pop, and get: " + stack.pop());
                } catch (EmptyContainerException e) {
                    System.out.println("The stack is empty, you cannot pop it now.");
                }
                break;
            case 't':
            case 'T':
                try {
                    System.out.println("You choosed to get top, and get: " + stack.top());
                } catch (EmptyContainerException e) {
                    System.out.println("The stack is empty, you cannot get its top.");
                }
                break;
            case 'i':
            case 'I':
                System.out.println("the stack is" + (stack.isempty() ? " " : " not ") + "empty.");
                break;
            case 'r':
            case 'R':
                return;
            default:
                System.out.println("Input errror.");
            }
            System.out.println("now the stack is like: " + stack.toString());
        }
    }

    static void testQueue(Scanner input) {
        Lqueue<String> queue = new Lqueue<String>();
        while (true) {
            System.out.println("Please input the operation you want to do.");
            System.out.print("p(push), o(pop), f(front), b(back), i(is empty or not), r(return): ");
            switch (input.next().charAt(0)) {
            case 'p':
            case 'P':
                System.out.print("Please input the word you want to push: ");
                queue.push(input.next());
                break;
            case 'o':
            case 'O':
                try {
                    System.out.println("You choosed to pop, and get: " + queue.pop());
                } catch (EmptyContainerException e) {
                    System.out.println("The queue is empty, you cannot pop it now.");
                }
                break;
            case 'f':
            case 'F':
                try {
                    System.out.println("You choosed to get front, and get: " + queue.front());
                } catch (EmptyContainerException e) {
                    System.out.println("The queue is empty, you cannot get its front.");
                }
                break;
            case 'b':
            case 'B':
                try {
                    System.out.println("You choosed to get back, and get: " + queue.back());
                } catch (EmptyContainerException e) {
                    System.out.println("The queue is empty, you cannot get its back.");
                }
                break;
            case 'i':
            case 'I':
                System.out.println("the queue is" + (queue.isempty() ? " " : " not ") + "empty.");
                break;
            case 'r':
            case 'R':
                return;
            default:
                System.out.println("Input errror.");
            }
            System.out.println("now the queue is like: " + queue.toString());
        }
    }
}