public class Change {
    private String data[];
        int i = 0;

    Change(String data[]) {
        this.data = data;
    }

    void start() {
        boolean flag;
        while (i + 1 < data.length) {
            flag = changePossible(data[i], data[++i]);
            if(flag)
                System.out.println("uzyskanie lancucha mozliwe");
            else
                System.out.println("uzyskanie lancucha niemozliwe");
        }
    }

    boolean changePossible(String s1, String s2) {
        int i = 0;
        int count = 0;
        boolean flag = true;

        while (i < s1.length()) {
            if(s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2)
                    flag = false;
            }
            i++;
        }
        return flag;
    }

}
