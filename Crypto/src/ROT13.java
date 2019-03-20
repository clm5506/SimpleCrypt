import static java.lang.Character.*;

public class ROT13  {
    public static void main(String[] args) {
        System.out.println("hi");
    }

    ROT13(Character cs, Character cf) {
    }

    ROT13() {

    }


    public String crypt(String text) throws UnsupportedOperationException {

        return "";
    }

    public String encrypt(String text) {
        return text;
    }

    public String decrypt(String text) {
        return text;
    }

    public static String rotate(String s, Character c) {
       // String ans = "";
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            if (Character.isUpperCase(s.charAt(i))) {
               int temp = s.charAt(i) + (c - 65);
               if(temp > ){

               }
               ans.append((char) temp);
            }

        }
        return ans.toString();
    }

}
