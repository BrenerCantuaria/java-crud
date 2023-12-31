package Model;

public class Pessoa {
    public String getId;
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Pessoa() {

    }

    public Pessoa(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    public Pessoa( String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void mostraPessoa(){
        System.out.println("-----------------");
        System.out.println("id: " +getId());
        System.out.println("nome: " +getNome());
        System.out.println("email: " +getEmail());
        System.out.println("senha: " +getSenha());

    }
}
