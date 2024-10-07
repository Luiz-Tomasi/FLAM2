import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    public void executeAction(int action, Token token)	throws SemanticError
    {
        Stack<Integer> stack = new Stack();
        Map<String, Integer> vars = new HashMap<String, Integer>();
        String VarAtual = "";

        // APAGAR LINHA ABAIXO APÓS TERMINAR TODAS AS OPERAÇÕES
        System.out.println("Acao #"+action+", Token: "+token);

        Integer a, b;
        switch (action){
            case 1: //binario
                stack.push(Integer.parseInt(token.getLexeme(),2));
                break;

            case 2: //salvar variavel pilha
                stack.push(vars.get(token.getLexeme()));
                break;

            case 3: //soma
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(Integer.valueOf(a.intValue() + b.intValue()));
                break;

            case 4: //subtracao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(Integer.valueOf(a.intValue() - b.intValue()));
                break;

            case 5: //multiplicacao
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(Integer.valueOf(a.intValue() * b.intValue()));
                break;

            case 6:
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();
                stack.push(Integer.valueOf(a.intValue() / b.intValue()));
                break;

            case 7: //expo
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();

                stack.push(Integer.valueOf((int)(Math.pow(a.intValue(), b.intValue()))));
                break;

            case 8: //log
                b = (Integer) stack.pop();
                a = (Integer) stack.pop();

                stack.push(Integer.valueOf((int)(Math.log(a.intValue()) / Math.log(b.intValue()))));
                break;

            case 9: //ler variavel
                VarAtual = token.getLexeme();
                break;

            case 10: //atribuicao
                vars.put(VarAtual, stack.pop());
                break;

            case 11: //show
                System.out.println("Resultado: " + Integer.toBinaryString(vars.get(VarAtual)));
                break;
    }	
}
}
