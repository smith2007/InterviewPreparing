package string;

public class ReadNCharactersGivenRead4II {

  public static void main(String[] args) {

  }

  /**
   * The read4 API is defined in the parent class Reader4.
   *     int read4(char[] buf);
   */
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return The number of actual characters read
   */
  private final char[] internalBuffer = new char[4];
  private int lengthOfDataInInternalBuffer = 0;
  private int alreadyReadPointerInInternalBuffer = 0;

  public int read(char[] buf, int n) {
    //итак нам надо прочитать n символов
    //мы не знаем сколько конкретно 3, 10, 20
    //знаем только одно что можем читать чанками по 4 ну супер соотв
    //делаем переменную то сколько мы положили в buf[]
    int alreadyRead = 0;
    while (alreadyRead < n) {
      //тут проверяем что буфер не пуст, если пуст надо его пополнить
      fillBufferIfNeeded();
      //если в буфере ничего не осталось - все выходим и возвращаем сколько есть
      if (remainingInBuffer() == 0) {
        break;
      }
      //n - alreadyRead - обрати внимание сюда
      //мы вычитываем то кол-во символов из буфера - которое необходимо
      //за вычетом того что уже прочитали
      alreadyRead += readFromBuffer(buf, alreadyRead, n - alreadyRead);
    }
    return alreadyRead;
  }

  private void fillBufferIfNeeded() {
    //читать из буфера можем только тогда
    //когда он пуст!
    if (remainingInBuffer() == 0) {
      //а как читаем?
      //мы передаем наш внутренний буфер и получаем то кол-во которое
      //read4 смог прочитать - максимум - 4
      //но может быть и меньше напиример осталось всего 2 символа он их
      //прочитал, положил в internalBuffer и вернул в lengthOfDataInInternalBuffer==2
      lengthOfDataInInternalBuffer = read4(internalBuffer);
      alreadyReadPointerInInternalBuffer = 0;
    }
  }

  private int remainingInBuffer() {
    //как праввильно понять сколько - какой размер буфера?
    //надо взять то последнее кол-во байт которое мы уже в
    return lengthOfDataInInternalBuffer - alreadyReadPointerInInternalBuffer;
  }

  private int readFromBuffer(char[] buf, int offset, int n) {
    //надо взять минимум из того что у нас есть в буфере и то что запросили
    //в буфере 10 а попросили 2 - супер вычитываем из буфера получаем то кол - во которое надо вычитаться
    int toRead = Math.min(n, remainingInBuffer());
    //копируем массив
    System.arraycopy(internalBuffer, alreadyReadPointerInInternalBuffer, buf, offset, toRead);
    //смещаем наш поинтер на то кол-во символов которое вычитали
    alreadyReadPointerInInternalBuffer += toRead;
    return toRead;
  }

  int read4(char[] buf) {
    return 0;
  }

}
