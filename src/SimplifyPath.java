import java.util.Stack;

// https://leetcode.com/problems/simplify-path/
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/abc//s//"));
    }
    public String simplifyPath(String path) {

        String[] paths = path.split("/");
        Stack<String> stk = new Stack<>();

        for(String _path: paths){
            if(_path.equals("")) continue;
            else if(_path.equals("."))continue;
            else if(_path.equals("..")){
                if(!stk.isEmpty()) stk.pop();
            }else stk.push(_path);
        }

        return "/" + String.join("/", stk);
    }
}
