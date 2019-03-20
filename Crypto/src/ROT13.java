import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Character.*;

public class ROT13  {
    private String sonnet;
    private String cryptedUpperAlph;
    private String cryptedLowerAlph;
    private String normalUpperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String lowerCaseAlphabet = normalUpperCaseAlphabet.toLowerCase();

    ROT13(Character cs, Character cf) {

        this.cryptedUpperAlph = rotate(normalUpperCaseAlphabet,Character.toUpperCase(cf));
        this.cryptedLowerAlph = rotate(lowerCaseAlphabet,Character.toLowerCase(cf));
        this.sonnet = loadFile();
    }

    public ROT13(){

    }


    public String crypt(String text) throws UnsupportedOperationException {

        return encrypt(text);
    }

    public String encrypt(String text) {
        String answer = "";

        for(int i = 0; i < text.length(); i++){
            if(Character.isUpperCase(text.charAt(i)) && Character.isLetter(text.charAt(i))) {
                int index = normalUpperCaseAlphabet.indexOf(text.charAt(i));
                answer += cryptedUpperAlph.charAt(index);

            } else if(!Character.isLetter(text.charAt(i))){
                answer+=text.charAt(i);
            } else if(Character.isLowerCase(text.charAt(i))){
                int index = lowerCaseAlphabet.indexOf(text.charAt(i));
                answer += cryptedLowerAlph.charAt(index);
            }
      }

        return answer;
    }

    public String decrypt(String text) {

        return encrypt(text);
    }

    public static String rotate(String s, Character c) {

        int index = s.indexOf(c);
        int length = s.length();

        String a = s.substring(index, length);

        String b = s.substring(0,index);

        return a+b;
    }


    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("sonnet18.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String encryptSonnet(){
        return encrypt(this.sonnet);
    }

    public String decryptSonnet(){
        return encrypt(this.sonnet);
    }

    public static void main(String[] args) {
        ROT13 r = new ROT13('A', 'N');

        System.out.println(r.encryptSonnet());
        System.out.println(r.decrypt(r.encryptSonnet()));
    }

}
