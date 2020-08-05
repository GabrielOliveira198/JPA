package JPA;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LerXML {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("C:\\contratos.xml");

            NodeList listaEmpregados = doc.getElementsByTagName("resource");

            int lista = listaEmpregados.getLength();
            for (int i = 0; i < lista; i++) {
                Node noEmpregado = listaEmpregados.item(i);

                if (noEmpregado.getNodeType() == Node.ELEMENT_NODE) {

                    Element contrato = (Element) noEmpregado;

                    //String identificador = elementoEmpregado.getAttribute("identificador");
                    //System.out.println("Id: " + identificador);
                    NodeList listaNome = contrato.getChildNodes();

                    int tamanhoListaFilhos = listaNome.getLength();
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        Node noFilho = listaNome.item(j);

                        if (noFilho.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementoFilho = (Element) noFilho;
                            
                            switch (elementoFilho.getTagName()) {
                                
                                case "identificador":
                                    System.out.println("-------------------------------------------------------------------------------------------------------------------");
                                    System.out.println("Identificador=" + elementoFilho.getTextContent());
                                    break;
                                case "uasg":
                                    System.out.println("UASG=" + elementoFilho.getTextContent());
                                    break;
                                case "modalidade_licitacao":
                                    System.out.println("Modalidade da licitação=" + elementoFilho.getTextContent());
                                    break;
                                case "numero_aviso_licitacao":
                                    System.out.println("Número do aviso da licitação=" + elementoFilho.getTextContent());
                                    break;
                                case "codigo_contrato":
                                    System.out.println("Código do contrato=" + elementoFilho.getTextContent());
                                    break;
                                case "licitacao_associada":
                                    System.out.println("Licitação associada=" + elementoFilho.getTextContent());
                                    break;
                                case "origem_licitacao":
                                    System.out.println("Origem da licitação=" + elementoFilho.getTextContent());
                                    break;
                                case "numero":
                                    System.out.println("Número=" + elementoFilho.getTextContent());
                                    break;
                                case "objeto":
                                    System.out.println("objeto=" + elementoFilho.getTextContent());
                                    break;
                                case "numero_processo":
                                    System.out.println("Número do processo=" + elementoFilho.getTextContent());
                                    break;
                                case "cnpf_contratada":
                                    System.out.println("CNPJ contratado=" + elementoFilho.getTextContent());
                                    break;
                                case "data_assinatura":
                                    System.out.println("Data da assinatura=" + elementoFilho.getTextContent());
                                    break;
                                case "fundamento_legal":
                                    System.out.println("Fundamento legal=" + elementoFilho.getTextContent());
                                    break;
                                case "data_inicio_vigencia":
                                    System.out.println("Data de início da vigência=" + elementoFilho.getTextContent());
                                    break;
                                case "data_termino_vigencia":
                                    System.out.println("Data de término da vigência=" + elementoFilho.getTextContent());
                                    break;
                                case "valor_inicial":
                                    System.out.println("Valor inicial=" + elementoFilho.getTextContent());
                                    break;
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(LerXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(LerXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
