package Model;

public class Empresa {
    private Long id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String cidade;
    private String estado;

    public Empresa() {

    }

    public Empresa(String nome, String cnpj, String endereco, String cidade, String estado) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void mostraAtributos(){
        System.out.println("Id: "+getId());
        System.out.println("Nome: "+getNome());
        System.out.println("cnpj: "+getCnpj());
        System.out.println("endereco: "+getEndereco());
        System.out.println("cidade: "+getCidade());
        System.out.println("estado: "+getEstado());
    }

}
