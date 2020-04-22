package bit_manipulation;

import java.util.HashMap;
import java.util.Map;

public class UTF8Validation {


  /**
   * Intuition
   * It's obviously a bit manipulation problem. But also there are lots of states need to be considered. An encoded UTF-8 character is possiblely represented by 1 to 4 bytes, which actually depends on the first byte. So after we have encountered the first byte, the next following 0 ~ 3 byte(s) must satisfy some constraints. Isn't it like a state machine? Namely, DFA (Deterministic Finite Automaton).
   * Algorithm
   * Follow me up to build the DFA. Input is a byte represented by an integer and initial state is 0 (clear, all previous bytes are handled). Then all the valid inputs are 0xxxxxxx, 110xxxxx, 1110xxxxx, 11110xxx. So state 0 can transfer to four states. Wait, just think of the input 0xxxxxxx: it means a single byte UTF-8 character, so all the previous byte are cleared again. Here I directly give the DFA. Any question is welcome.
   *
   *
   * We take a quick glance of the longest path 0 -> 3 -> 5 -> 6 -> 0, which is relate to a 4-byte UTF-8 character. After encounters four bytes (11110xxx, 10xxxxxx, 10xxxxxx, 10xxxxxx in order), the state return to 0 again. Any other inputs are illegal and will result validation failure. State 0 is the initial state and the final state.
   */
  // input types: determined by most significant 1 ~ 5 bits
  static final int TYPE_0 = 0b00000000;
  static final int TYPE_1 = 0b10000000;
  static final int TYPE_2 = 0b11000000;
  static final int TYPE_3 = 0b11100000;
  static final int TYPE_4 = 0b11110000;
  // masks for most significant 1 to 5 bis
  static final int[] MASKS = new int[]{0b10000000, 0b11000000, 0b11100000, 0b11110000, 0b11111000};
  // input type enumation
  static final int[] TYPES = new int[]{TYPE_0, TYPE_1, TYPE_2, TYPE_3, TYPE_4};
  // map of cur_stat : (input_type : next_stat)
  static final Map<Integer, Map<Integer, Integer>> DFA = new HashMap<>();

  private static int getType(int in) {
    // type 0: 0xxxxxxx
    // type 1: 10xxxxxx
    // type 2: 110xxxxx
    // type 3: 1110xxxx
    // type 4: 11110xxx
    for (int i = 0; i < TYPES.length; i++) {
      if ((MASKS[i] & in) == TYPES[i]) {
        return TYPES[i];
      }
    }
    // unreachable. unless input is "11111xxx" which is not a valid utf-8 character.
    return -1;
  }
  // build the dfa
  static {
    DFA.put(0, Map.of(TYPE_0, 0, TYPE_2, 1, TYPE_3, 2, TYPE_4, 3));
    DFA.put(1, Map.of(TYPE_1, 0));
    DFA.put(2, Map.of(TYPE_1, 4));
    DFA.put(4, Map.of(TYPE_1, 0));
    DFA.put(3, Map.of(TYPE_1, 5));
    DFA.put(5, Map.of(TYPE_1, 6));
    DFA.put(6, Map.of(TYPE_1, 0));
  }

  public boolean validUtf8(int[] data) {
    int cur = 0;
    for (int input : data) {
      Integer next = getNext(cur, input);
      if (next == null) {
        return false;
      }
      cur = next;
    }
    return cur == 0;
  }

  private static Integer getNext(int cur, int input) {
    int type = getType(input);
    if (type == -1) return null;
    return DFA.get(cur).get(type);
  }

}
