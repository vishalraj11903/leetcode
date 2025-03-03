/*
// Take two positive numbers as strings, and return the sum of them.
// E.g. "3.14" + "0.90” => "4.04".


String addDecimals(String firstInput, String secondInput) {
    String[] firstTokens = firstInput.split("\\."); //3, 14
    String[] secondTokens = secondInput.split("\\.");// 0,90

    String firstBeforeDec = firstTokens[0];//3
    String secondBeforeDec = secondTokens[0]; //0

    String firstAfterDec = firstTokens[1];//14
    String secondAfterDec = secondTokens[1];//90

    String sumAfterDecimal = sumAfter(firstAfterDec, secondAfterDec);

    int carry = sumAfterDecimal > Math.max(firstAfterDec.length(), secondAfterDec.length()) ? 1 : 0;

    if (carry > 1) {
        sumAfterDecimal = sumAfterDecimal.
    }
    String sumBeforeDecimal = add(firstBeforeDec, secondBeforeDec,  carry);

    return sumBeforeDecimal + "." + sumAfterDecimal;
}

String sumAfter(String input1, String input2) { // 14, 90
    int diff = Math.abs(input1.length() - input2.length()); // 0

    if (diff > 0) {
        if (input1.length() < input2.length()) {
            input1 = rightPad(input1, diff);
        } else {
            input2 = rightPad(input2, diff);
        }
    }

    return add(input1, input2, 0); // 14, 90, 0
}

// 234.0 + 6.0
String add(String input1, String input2, int carry) { // 14, 90, 0
    int sum = 0;
    int first = input1.length() - 1; //1
    int second = input2.length() - 1; //1
    StrigBuilder output = new StringBuilder();
    while (first >= 0 && second >= 0) { // 1 >= 0
        int sum  = (input1.charAt(first) - '0') + (input2.charAt(second) - '0') + carry; //10
        carry = sum / 10; // 1
        output.append(sum % 10); //401
        first--;
        second--;
    }

    output.reverse();/
    if (carry > 0) { //104
        output = output.substring(1);//04
    }

  /104
    return output.toString();
}



Write an implementation of the following interface:
        {
void put(key, val);
V    get(key);
void delete(key);
K    last();
}
Where last() returns the last-accessed, non-deleted key. I.e.,


put("a", 1)
last()      => "a"
put("b", 2)
last()      => "b"
get("a")    => 1
/// a <-> b
last()      => "a"
delete("a")
last()      => "b"


class Node {
    int val;
}

Map<Integer, Node> map = new HashMap<>();
Node head = new Node(-1);
Node tail = new Node(-1);
head.next = tail;
tail.prev =  head;


void put(int key, int value) {//b, 2
    if (map.containsKey(key)) {
        removeNode(map.get(key));
    }

    Node node = new Node(key, value); //
    map.put(key, node); // b, (b,2)
    add(node); // h - a - b - t
}

Integer last() {
    if (map.isEmpty()) {
        return null;
    }
    return tail.prev.val;
}

Integer get(int key) {//
    if (!map.containsKey(key)) {
        return null;
    }

    Node node = map.get(key);//
    removeNode(node);//
    add(node);
    h - b - a - t
}

void delete(int key) {
    if (!map.containsKey(key)) {
        throw new RuntimeException("No elements found");
    }

    map.remove(key);
    remove(map.get(key));
}

void removeNode(Node node) {
    node.next.prev = node.prev.next;
    node.prev.next = node.next.prev;
}*/
