package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Captura.
 */
@Entity
@Table(name = "captura")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Captura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Lob
    @Column(name = "imagem")
    private byte[] imagem;

    @Column(name = "imagem_content_type")
    private String imagemContentType;

    @Column(name = "data")
    private Instant data;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "video")
    private String video;

    @OneToMany(mappedBy = "captura")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "user", "captura" }, allowSetters = true)
    private Set<Estacao> estacaos = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Captura id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getImagem() {
        return this.imagem;
    }

    public Captura imagem(byte[] imagem) {
        this.setImagem(imagem);
        return this;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public String getImagemContentType() {
        return this.imagemContentType;
    }

    public Captura imagemContentType(String imagemContentType) {
        this.imagemContentType = imagemContentType;
        return this;
    }

    public void setImagemContentType(String imagemContentType) {
        this.imagemContentType = imagemContentType;
    }

    public Instant getData() {
        return this.data;
    }

    public Captura data(Instant data) {
        this.setData(data);
        return this;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public Captura descricao(String descricao) {
        this.setDescricao(descricao);
        return this;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public Captura status(Boolean status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getVideo() {
        return this.video;
    }

    public Captura video(String video) {
        this.setVideo(video);
        return this;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Set<Estacao> getEstacaos() {
        return this.estacaos;
    }

    public void setEstacaos(Set<Estacao> estacaos) {
        if (this.estacaos != null) {
            this.estacaos.forEach(i -> i.setCaptura(null));
        }
        if (estacaos != null) {
            estacaos.forEach(i -> i.setCaptura(this));
        }
        this.estacaos = estacaos;
    }

    public Captura estacaos(Set<Estacao> estacaos) {
        this.setEstacaos(estacaos);
        return this;
    }

    public Captura addEstacao(Estacao estacao) {
        this.estacaos.add(estacao);
        estacao.setCaptura(this);
        return this;
    }

    public Captura removeEstacao(Estacao estacao) {
        this.estacaos.remove(estacao);
        estacao.setCaptura(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Captura)) {
            return false;
        }
        return id != null && id.equals(((Captura) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Captura{" +
            "id=" + getId() +
            ", imagem='" + getImagem() + "'" +
            ", imagemContentType='" + getImagemContentType() + "'" +
            ", data='" + getData() + "'" +
            ", descricao='" + getDescricao() + "'" +
            ", status='" + getStatus() + "'" +
            ", video='" + getVideo() + "'" +
            "}";
    }
}
