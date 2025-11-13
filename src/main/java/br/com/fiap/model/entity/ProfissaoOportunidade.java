package br.com.fiap.model.entity;

public class ProfissaoOportunidade {

    private final String slug;
    private final String nome;
    private final String resumo;
    private final String comoComecar;
    private final String habilidadesChave;
    private final String visaoFuturo;

    public ProfissaoOportunidade(String slug,
                                 String nome,
                                 String resumo,
                                 String comoComecar,
                                 String habilidadesChave,
                                 String visaoFuturo) {
        this.slug = slug;
        this.nome = nome;
        this.resumo = resumo;
        this.comoComecar = comoComecar;
        this.habilidadesChave = habilidadesChave;
        this.visaoFuturo = visaoFuturo;
    }

    public String getSlug() { return slug; }
    public String getNome() { return nome; }
    public String getResumo() { return resumo; }
    public String getComoComecar() { return comoComecar; }
    public String getHabilidadesChave() { return habilidadesChave; }
    public String getVisaoFuturo() { return visaoFuturo; }
}
