package string;

public class ReadNCharactersGivenRead4 {

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

  public int read(char[] buf, int n) {
    int alreadyRead = 0;
    while (n > alreadyRead) {
      int lengthOfDataInInternalBuffer = read4(internalBuffer);
      if (lengthOfDataInInternalBuffer == 0) {
        break;
      }
      //например lengthOfDataInInternalBuffer == 4, а нас попросили n = 5
      //читаем 4
      int toRead = Math.min(n-alreadyRead, lengthOfDataInInternalBuffer);
      for (int i = 0; i < toRead; i++) {
        buf[alreadyRead++] = internalBuffer[i];
      }
    }
    return alreadyRead;
  }


  int read4(char[] buf) {
    return 0;
  }

}
