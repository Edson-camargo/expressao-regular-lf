import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class App {

    String input = "1*";
    Pattern patternUnion = Pattern.compile("(\\d{1})(\\|)(\\d{1})");
    Pattern patternConcatenate = Pattern.compile("(\\d{1})(\\.)(\\d{1})");
    Pattern patternKleeneClosure = Pattern.compile("(\\d{1})(\\*)");
    ArrayList<String> alphabet = new ArrayList<String>();
    ArrayList<String> unionExpected = new ArrayList<String>(Arrays.asList("\u03B5","1","2"));
    ArrayList<String> concatenateExpected = new ArrayList<String>(Arrays.asList("\u03B5","11","12","21","22"));
    ArrayList<String> kleeneExpected = new ArrayList<String>(Arrays.asList("\u03B5","1","11","111","1111","11111"));
    
        

    @Test
    public void unionTest(){
        alphabet.add("\u03B5");

        if (patternUnion.matcher(input).matches())
            alphabet.addAll(union(patternUnion, input));

        assertEquals(unionExpected, alphabet);
    }

    @Test
    public void concatenateTest(){
        alphabet.add("\u03B5");

        if (patternConcatenate.matcher(input).matches())
            alphabet.addAll(concatenate(patternConcatenate, input));

        assertEquals(concatenateExpected, alphabet);
    }

    @Test
    public void kleeneTest(){
        alphabet.add("\u03B5");

        if (patternKleeneClosure.matcher(input).matches())
            alphabet.addAll(kleeneClosure(patternKleeneClosure, input, 5));

        assertEquals(kleeneExpected, alphabet);
    }

    public void print(){
        System.out.println("\u03A3 = "+alphabet);
    }

    static ArrayList<String> union(Pattern pattern, String input){
        ArrayList<String> list = new ArrayList<String>();
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        list.add(matcher.group(1));
        list.add(matcher.group(3));

        return list;
    }


    static ArrayList<String> concatenate(Pattern pattern, String input){
        ArrayList<String> list = new ArrayList<String>();
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        list.add(matcher.group(1).concat(matcher.group(1)));
        list.add(matcher.group(1).concat(matcher.group(3)));
        list.add(matcher.group(3).concat(matcher.group(1)));
        list.add(matcher.group(3).concat(matcher.group(3)));

        return list;
    }


    static ArrayList<String> kleeneClosure(Pattern pattern, String input, int chain){
        ArrayList<String> list = new ArrayList<String>();
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        list.add(matcher.group(1));
        for (int i = 1; i < chain; i++) {
            list.add(i, list.get(i-1).concat(matcher.group(1)));
        }

        return list;
    }

}