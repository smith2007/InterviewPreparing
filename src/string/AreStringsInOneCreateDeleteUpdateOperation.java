package string;

public class AreStringsInOneCreateDeleteUpdateOperation {

    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "paleq";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(areStringsInOneCreateDeleteUpdateOperation(str1.toCharArray(), str2.toCharArray()));
    }


    static boolean areStringsInOneCreateDeleteUpdateOperation(char[] str1, char[] str2) {

        boolean isInsert = isInsert(str1, str2);
        boolean isDelete = isInsert(str2, str1);
        boolean isUpdate = isUpdate(str1, str2);

        return isInsert || isDelete || isUpdate;
    }

    static boolean isUpdate(char[] str1, char[] str2) {
        boolean isUpdate = false;

        if (str1.length == str2.length) {
            for (int i = 0; i < str1.length; i++) {
                if (str1[i] != str2[i]) {
                    if (isUpdate) {
                        return false;
                    }
                    isUpdate = true;
                }
            }
        }

        return isUpdate;
    }

    static boolean isInsert(char[] str1, char[] str2) {
        boolean isInsert = false;
        //проверяем на инсерт
        if (str2.length - str1.length == 1) {
            int i = 0;
            int j = 0;
            while (true) {
                if (i >= str1.length || j >= str2.length) {
                    if (i == str1.length) {
                        return true;
                    }
                    break;
                }
                if (str1[i] != str2[j]) {
                    if (isInsert) {
                        return false;
                    }
                    isInsert = true;
                    j++;
                }
                i++;
                j++;
            }
        }

        return isInsert;
    }
}
