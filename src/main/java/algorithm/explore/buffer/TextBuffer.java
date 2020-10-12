package algorithm.explore.buffer;

import algorithm.explore.stack.Stack;

/**
 * 文本编辑缓冲区
 */
public class TextBuffer {

    private Stack<Character> left = new Stack<>();
    private Stack<Character> right = new Stack<>();

    public Integer size() {
        return left.size() + right.size();
    }


    public void insert(char c) {
        left.push(c);
    }

    public char delete() {
        return right.pop();
    }

    public void left(int k) {
        while (k > 0) {
            right.push(left.pop());
            k--;
        }
    }

    public void right(int k) {
        while (k > 0) {
            left.push(right.pop());
            k--;
        }
    }

    public TextBuffer() {

    }
}
