package ler_arquivo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@XStreamAlias("")
public class SISMOB implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private int ano_habilitacao;
    private String estabelecimento;
    private String nome_cidade;
    private String pac;
    private String tipo_obra;
    private String uf;
    private float vlr_latitude;
    private float vlr_longitude;

    public int getId() {
        return id;
    }

    public int getAno_habilitacao() {
        return ano_habilitacao;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public String getNome_cidade() {
        return nome_cidade;
    }

    public String getPac() {
        return pac;
    }

    public String getTipo_obra() {
        return tipo_obra;
    }

    public String getUf() {
        return uf;
    }

    public float getVlr_latitude() {
        return vlr_latitude;
    }

    public float getVlr_longitude() {
        return vlr_longitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAno_habilitacao(int ano_habilitacao) {
        this.ano_habilitacao = ano_habilitacao;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public void setNome_cidade(String nome_cidade) {
        this.nome_cidade = nome_cidade;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }

    public void setTipo_obra(String tipo_obra) {
        this.tipo_obra = tipo_obra;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setVlr_latitude(float vlr_latitude) {
        this.vlr_latitude = vlr_latitude;
    }

    public void setVlr_longitude(float vlr_longitude) {
        this.vlr_longitude = vlr_longitude;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.ano_habilitacao;
        hash = 53 * hash + Objects.hashCode(this.estabelecimento);
        hash = 53 * hash + Objects.hashCode(this.nome_cidade);
        hash = 53 * hash + Objects.hashCode(this.pac);
        hash = 53 * hash + Objects.hashCode(this.tipo_obra);
        hash = 53 * hash + Objects.hashCode(this.uf);
        hash = 53 * hash + Float.floatToIntBits(this.vlr_latitude);
        hash = 53 * hash + Float.floatToIntBits(this.vlr_longitude);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SISMOB other = (SISMOB) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.ano_habilitacao != other.ano_habilitacao) {
            return false;
        }
        if (Float.floatToIntBits(this.vlr_latitude) != Float.floatToIntBits(other.vlr_latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.vlr_longitude) != Float.floatToIntBits(other.vlr_longitude)) {
            return false;
        }
        if (!Objects.equals(this.estabelecimento, other.estabelecimento)) {
            return false;
        }
        if (!Objects.equals(this.nome_cidade, other.nome_cidade)) {
            return false;
        }
        if (!Objects.equals(this.pac, other.pac)) {
            return false;
        }
        if (!Objects.equals(this.tipo_obra, other.tipo_obra)) {
            return false;
        }
        if (!Objects.equals(this.uf, other.uf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UBS{" + "id=" + id + ", ano_habilitacao=" + ano_habilitacao + ", estabelecimento=" + estabelecimento + ", nome_cidade=" + nome_cidade + ", pac=" + pac + ", tipo_obra=" + tipo_obra + ", uf=" + uf + ", vlr_latitude=" + vlr_latitude + ", vlr_longitude=" + vlr_longitude + '}';
    }

   
}
