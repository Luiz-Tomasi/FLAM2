import java.io.StringReader;


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        try {
            Lexico lexico = new Lexico(new StringReader("a = 1; b = 11; c = a + b; show(c);"));
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}