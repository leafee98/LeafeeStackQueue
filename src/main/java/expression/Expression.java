package expression;

import datastructure.*;

public class Expression {
    public static void main(String[] args) {
        Lqueue<String> test = str2queue("1+2*(3+4)*5+67");
        System.out.println(calculate(infix2suffix(test)));
    }

    static Lqueue<String> str2queue(String str) {
        Lqueue<String> que = new Lqueue<String>();
        int j = 0, i;
        for (i = 0; i < str.length(); ++i) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                if (j != i)
                    que.push(str.substring(j, i));
                que.push("" + str.charAt(i));
                j = i + 1;
            }
        }
        if (!(str.charAt(str.length() - 1) < '0' || str.charAt(str.length() - 1) > '9')) {
            que.push(str.substring(j, str.length()));
        }
        return que;
    }

    static Lqueue<String> infix2suffix(Lqueue<String> exp) {
        Lstack<String> temp = new Lstack<String>();
        Lqueue<String> result = new Lqueue<String>();

        String t;
        try {
            while (true) {
                t = exp.pop();

                if (t.equals(")")) {
                    String t1 = temp.pop();
                    while (!t1.equals("(")) {
                        result.push(t1);
                        t1 = temp.pop();
                    }
                } else if (t.equals("(")) {
                    temp.push(t);
                } else if (t.equals("+") || t.equals("-")) {
                    if (!temp.isempty() && (temp.top().equals("*") || temp.top().equals("/"))) {
                        while (!temp.isempty()) {
                            result.push(temp.pop());
                        }
                    }
                    temp.push(t);
                } else if (t.equals("*") || t.equals("/")) {
                    temp.push(t);
                } else { // if t is a number
                    result.push(t);
                }
                System.out.println("stack is:" + temp.toString() + "; output is:" + result.toString(" "));
            }
        } catch (EmptyContainerException e) { // if catch the end of the queue
            try {
                while (!temp.isempty()) {
                    result.push(temp.pop());
                }
            } catch (Exception e1) {
                System.out.println("Something is error!");
                e1.printStackTrace();
            }
        } finally {
            System.out.println("stack is:" + temp.toString() + "; output is:" + result.toString(" "));
        }

        return result;
    }

    static double calculate(Lqueue<String> que) {
        Lstack<String> stk = new Lstack<String>();
        try {
            while (true) {
                try {
                    Double.parseDouble(que.front());
                    stk.push(que.pop());
                } catch (NumberFormatException e) {
                    try {
                        if (que.front().equals("+")) {
                            stk.push(Double.parseDouble(stk.pop()) + Double.parseDouble(stk.pop()) + "");
                        } else if (que.front().equals("-")) {
                            stk.push(Double.parseDouble(stk.pop()) - Double.parseDouble(stk.pop()) + "");
                        } else if (que.front().equals("*")) {
                            stk.push(Double.parseDouble(stk.pop()) * Double.parseDouble(stk.pop()) + "");
                        } else if (que.front().equals("/")) {
                            stk.push(Double.parseDouble(stk.pop()) / Double.parseDouble(stk.pop()) + "");
                        }
                        que.pop();
                    } catch (EmptyContainerException f) {
                        System.out.println("Something is error!");
                        f.printStackTrace();
                    }
                }

            }
        } catch (EmptyContainerException e) { }

        try {
            return Double.parseDouble(stk.pop());
        } catch (EmptyContainerException f) {
            System.out.println("Something is error!");
            f.printStackTrace();
            System.exit(-1);
        }
        return -1.1;
    }
}