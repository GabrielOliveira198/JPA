package JPA;

import java.io.FileReader;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;


public class LerJSON {

    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser(null, null, false);

        try  {
            
            FileReader reader = new FileReader("C:\\contratos.json");

            Object obj = jsonParser.parse();
            JSONArray listaContratos = (JSONArray) obj;

            listaContratos.forEach(contrato -> parserContratos((JSONObject) contrato));

        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private static void parserContratos(JSONObject pContratos) {

        System.out.println("Identificador: " + Integer.parseInt(pContratos.get("identificador").toString()));
        System.out.println("UASG: " + Integer.parseInt(pContratos.get("uasg").toString()));
        System.out.println("Modalidade da licitação: " + Integer.parseInt(pContratos.get("modalidade_licitacao").toString()));
        System.out.println("Número de aviso da licitação: " + Integer.parseInt(pContratos.get("numero_aviso_licitacao").toString()));
        System.out.println("Código do contrato: " + Integer.parseInt(pContratos.get("codigo_contrato").toString()));
        System.out.println("Origem da licitação: " + pContratos.get("origem_licitacao"));
        System.out.println("Número: " + Integer.parseInt(pContratos.get("numero").toString()));
        System.out.println("Objeto: " + pContratos.get("objeto"));
        System.out.println("Número do processo: " + Integer.parseInt(pContratos.get("mumero_processo").toString()));
        System.out.println("CNPJ contratado: " + Integer.parseInt(pContratos.get("cnpj_contratado").toString()));
        System.out.println("Data da assinatura: " + pContratos.get("data_assinatura"));
        System.out.println("Fundamento legal: " + pContratos.get("fundamento_legal"));
        System.out.println("Data de início da vigência: " + pContratos.get("data_inicio_vigencia"));
        System.out.println("Data de término da vigência: " + pContratos.get("data_termino_vigencia"));
        System.out.println("Valor inicial: " + String.valueOf(pContratos.get("valor_inicial").toString()));

        System.out.println("\n------------------------------------------------------------------------------------");

    }

}
