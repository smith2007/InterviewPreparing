package string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SimplifyPath {

  public static void main(String[] args) {
    System.out.println(simplifyPath("/a//b////c/d//././/.."));
  }

  static String simplifyPath(String path) {

    if (path == null || path.isEmpty()) {
      return null;
    }

    String[] pathArr = path.split("/+");

    List<String> res = new ArrayList<>();

    for (String curr : pathArr) {
      if (curr.isEmpty() || curr.equals(".")) {
        continue;
      }
      if (curr.equals("..") && res.size() > 0) {
        res.remove(res.size() - 1);
      } else if (!curr.equals("..")){
        res.add(curr);
      }
    }

    return "/" + String.join("/", res);


  }
}
