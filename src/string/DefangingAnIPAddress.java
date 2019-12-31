package string;

public class DefangingAnIPAddress {

    public static void main(String[] args) {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }


    static String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                res.append("[.]");
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
