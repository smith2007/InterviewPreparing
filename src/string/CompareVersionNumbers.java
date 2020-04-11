package string;

public class CompareVersionNumbers {

  public static void main(String[] args) {

  }

  /**
   *
   хмм, тут можно идти с начала и брать по символьно - ориентируясь на самую длинную строчку
   заменяя нулями не существующий символы - 1 превратится в 1.0.0 например
   */
  public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");
    String[] levels2 = version2.split("\\.");

    int length = Math.max(levels1.length, levels2.length);
    for (int i = 0; i < length; i++) {
      Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
      Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
      int compare = v1.compareTo(v2);
      if (compare != 0) {
        return compare;
      }
    }

    return 0;
  }

  /**
   * split: O(n), n is the length of the longer string array.
   * loop: O(kn), k is the average length of subversion number
   * I check the Integer.parseInt source code, it should be O(k).
   */
}
