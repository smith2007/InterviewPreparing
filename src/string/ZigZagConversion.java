package string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

  public static void main(String[] args) {
    ZigZagConversion zigZagConversion = new ZigZagConversion();
    String res = zigZagConversion.convert("PAYPALISHIRING", 3);

    System.out.println(res);
  }

  /**
   * блять ну и тупая задача - тут сколько ты на неее смотрел
   * все не мог понять по человечески - короче тут надо идти вверх вниз фиксируя индексы
   */
  public String convert(String str, int numRows) {
    if (numRows == 1) {
      return str;
    }

    //набиваем наши строки
    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < Math.min(numRows, str.length()); i++) {
      rows.add(new StringBuilder());
    }

    int curRow = 0;
    boolean goingDown = false;

    //итерируя по символам
    for (char ch : str.toCharArray()) {
      rows.get(curRow).append(ch);
      //если достигли начала или конца
      //разворачиваемся
      if (curRow == 0 || curRow == numRows - 1) {
        goingDown = !goingDown;
      }
      //идем вверх или вниз
      curRow += goingDown ? 1 : -1;
    }

    StringBuilder ret = new StringBuilder();
    for (StringBuilder row : rows) {
      ret.append(row);
    }
    return ret.toString();
  }

}
