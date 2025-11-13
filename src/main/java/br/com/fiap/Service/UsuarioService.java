package br.com.fiap.service;

import br.com.fiap.model.dto.UsuarioDTO;
import br.com.fiap.model.entity.Usuario;
import br.com.fiap.model.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Usuario> buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

        public Optional<Usuario> autenticar(String nome, String senha) {
        return repository.findByNomeAndSenha(nome, senha);
    }

    public Usuario criar(UsuarioDTO dto) {
        Usuario usuario = new Usuario(null, dto.nome(), dto.senha());
        return repository.save(usuario);
    }

    public Optional<Usuario> atualizar(Long id, UsuarioDTO dto) {
        return repository.findById(id).map(existente -> {
            existente.setNome(dto.nome());
            existente.setSenha(dto.senha());
            return repository.save(existente);
        });
    }

    public boolean remover(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
