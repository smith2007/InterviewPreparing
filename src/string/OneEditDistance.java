package string;

public class OneEditDistance {

  public static void main(String[] args) {
    String str1 = "ab";
    String str2 = "acd";
    System.out.println(str1);
    System.out.println(str2);
    System.out.println(isOneEditDistance(str1, str2));
  }


  static boolean isOneEditDistance(String s, String t) {
    //если разница больше чем в один символ - все уже не валидно
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }
    //если длины одинаковы то может быть только модификация
    if (s.length() == t.length()) {
      return isUpdate(s, t);
    }
    //если дошли сюда то перед нами может быть только удаление символа у одной из строк, он же инсерт
    //смотрим кто из них длиннее и те и проверяем
    //если s длиннее значит у нее теоретически удалили символ
    //если t длиннее то у нее
    return s.length() > t.length() ? isDelete(s, t) : isDelete(t, s);

  }

  static boolean isDelete(String s, String t) {
    //проверка на делит очень простая - идем двумя указателями по строкам
    for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
      //как только какие то текущие символы не равны - сразу повод к тому что
      //потенциально может быть удаление - соотв остальные части будут равны
      if (s.charAt(i) != t.charAt(j)) {
        //ну вот и берем сабстринги и сравниваем у них
        //строка s так как больше откусываем на один символ больше
        return s.substring(i + 1).equals(t.substring(j));
      }
    }
    return true;
  }

  static boolean isUpdate(String s, String t) {
    int diff = 0;
    //апдейт считается еще проще - надо всего лишь посмотреть сколько символ различны
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        diff++;
      }
    }
    return diff == 1;
  }


}
