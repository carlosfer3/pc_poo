package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class GeneradorCodigoAutomatico implements GeneradorDeCodigo{
    private static Random random = new Random();
    private static final List<Character> caracteres =
        Arrays.asList('a','b','c','d','e','f','g','h','i','j',
                      'k','l','m','n','o','p','q','r','s','t',
                      'u','v','w','x','y','z');

    @Override
    public String generarCodigo() {
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int numero = random.nextInt(10); // 0 a 9
            codigo.append(numero);
        }

        codigo.append(generarCaracter());
        return codigo.toString();
    }
    
    public Character generarCaracter() {
        int indice = random.nextInt(caracteres.size());
        return caracteres.get(indice);
    }
}
