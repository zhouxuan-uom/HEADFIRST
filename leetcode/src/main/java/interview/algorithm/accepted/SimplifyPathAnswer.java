package interview.algorithm.accepted;

import interview.algorithm.questions.SimplifyPath;

import java.util.Stack;

/**
 * Created by zhouxuan on 16/9/1.
 */
public class SimplifyPathAnswer implements SimplifyPath {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        String result = "";
        Stack<String> pathStack = new Stack<String>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals("") || paths[i].equals(".")) {
                continue;
            } else if (paths[i].equals("..")) {
                if (pathStack.size() != 0) {
                    pathStack.pop();
                }
            } else {
                pathStack.push(paths[i]);
            }
        }
        int size = pathStack.size();
        for (int i = 0; i < size; i++) {
            result = "/" + pathStack.pop() + result;
        }
        if (result.equals("")) {
            result = "/";
        }
        return result;
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPathAnswer();
        System.out.println(simplifyPath.simplifyPath("/home/a/b/c/../../"));
    }
}
