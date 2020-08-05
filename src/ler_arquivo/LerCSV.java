/* package ler_arquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LerCSV {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String arquivoCSV = "../TesteLerAquivo/src/DataSets/ubs.csv";

        BufferedReader valoresArq = null;

        String linha = "";

        String separadorCampo = ",";

        EntityManagerFactory objFactory
                = Persistence.createEntityManagerFactory("TesteLerAquivoPU");
        EntityManager manager
                = objFactory.createEntityManager();
        // Cria a tabela
        UBSJpaController jpa
                = new UBSJpaController(objFactory);

        ArrayList<SISMOB> modelList = new ArrayList<>();

        try {

            valoresArq = new BufferedReader(new FileReader(arquivoCSV));

            while ((linha = valoresArq.readLine()) != null) {

                SISMOB u = new SISMOB();

                String[] ubs = linha.split(separadorCampo);
                u.(Float.parseFloat(ubs[1]));
                u.setVlr_longitude(Float.parseFloat(ubs[2]));
                u.setCod_munic(Integer.parseInt(ubs[3]));
                u.setNom_estab(ubs[4]);
                u.setDsc_endereco(ubs[5]);
                u.setDsc_bairro(ubs[6]);
                u.setDsc_cidade(ubs[7]);
                u.setDsc_telefone(ubs[8]);
                u.setDsc_estrut_fisic_ambiencia(ubs[9]);
                u.setDsc_adap_defic_fisic_idosos(ubs[10]);
                u.setDsc_equipamentos(ubs[11]);
                u.setDsc_medicamentos(ubs[12]);
                modelList.add(u);
            }

            for (SISMOB p : modelList) {
                jpa.create(p);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: \n" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException: \n" + e.getMessage());
        } catch (IOException e) {

            System.out.println("IO Erro: \n" + e.getMessage());
        } finally {
            if (valoresArq != null) {
                try {
                    valoresArq.close();
                } catch (IOException e) {
                    System.out.println("IO Erro: \n" + e.getMessage());
                }
            }
        }
    }

    private static ArrayList<SISMOB> modelList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
*/