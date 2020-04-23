package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {

  public List<String> subdomainVisits(String[] cpdomains) {
    HashMap<String, Integer> domainCountMap = new HashMap<>();
    List<String> res = new ArrayList<>();
    //Iterate over each String
    for (String cpdomain : cpdomains) {
      //Split with " " and get int and domain
      String[] arrIntDom = cpdomain.split(" ");
      int visits = Integer.parseInt(arrIntDom[0]);

      //second element contains "discuss.leetcode.com"
      domainCountMap.merge(arrIntDom[1], visits, Integer::sum);

      //Split the domain in at least 2 //array contains "discuss", "leetcode.com"
      String[] arrSubDom2 = arrIntDom[1].split("\\.", 2);
      if (arrSubDom2.length == 2) {
        domainCountMap.merge(arrSubDom2[1], visits, Integer::sum);
      }
      //Split the domain in at least 3
      //array contains "discuss", "leetcode" ,"com"
      String[] arrSubDom3 = arrIntDom[1].split("\\.", 3);
      if (arrSubDom3.length == 3) {
        domainCountMap.merge(arrSubDom3[2], visits, Integer::sum);
      }
    }
    //Construct the result
    for (String key : domainCountMap.keySet()) {
      res.add(domainCountMap.get(key) + " " + key);
    }
    return res;
  }
}
