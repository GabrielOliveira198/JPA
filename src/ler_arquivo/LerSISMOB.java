package ler_arquivo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LerSISMOB {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String arquivoCSV = "../TesteLerAquivo/src/DataSets/sismob_ubsnone.csv";

        BufferedReader valoresArq = null;

        String linha = "";

        String separadorCampo = ",";

        EntityManagerFactory objFactory
                = Persistence.createEntityManagerFactory("TesteLerAquivoPU");
        EntityManager manager
                = objFactory.createEntityManager();
        // Cria a tabela
        SISMOBJpaController jpa
                = new SISMOBJpaController(objFactory);

        ArrayList<SISMOB> modelList = new ArrayList<>();

        try {

            valoresArq = new BufferedReader(new FileReader(arquivoCSV));

            while ((linha = valoresArq.readLine()) != null) {

                SISMOB u = new SISMOB();

                String[]    ubs = linha.split(separadorCampo);

                //u.setId(Integer.parseInt());
                u.setAno_habilitacao(Integer.parseInt(ubs[1]));
                u.setEstabelecimento(ubs[2]);
                u.setNome_cidade(ubs[3]);
                u.setPac(ubs[4]);
                u.setTipo_obra(ubs[5]);
                u.setUf(ubs[6]);
                u.setVlr_latitude(Float.parseFloat(ubs[7]));
                u.setVlr_longitude(Float.parseFloat(ubs[8]));

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
