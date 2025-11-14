package adotematch;

public abstract class Usuario {
    protected String id;
    protected String email;
    protected String senha; // Hash em produção
    protected String nome;
    protected Role role; // Enum para diferenciar

    public enum Role {
        ADOTANTE, ADMINISTRADOR, VETERINARIO
    }

    public Usuario(String email, String senha, String nome, Role role) {
        this.id = java.util.UUID.randomUUID().toString();
        this.email = email;
        this.senha = senha; // Em prod: use hashing
        this.nome = nome;
        this.role = role;
    }

    // Getters e Setters
    public String getId() { return id; }
    public String getEmail() { return email; }
    // ...

    // Método abstrato para ações específicas por role
    public abstract void atualizarPerfil(String novoNome);
}