package br.com.fiap.tech_challenge.service;

import br.com.fiap.tech_challenge.dto.UsuarioDTO;
import br.com.fiap.tech_challenge.entities.Usuario;
import br.com.fiap.tech_challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final String COLLECTION_NAME = "usuarios";

    private UsuarioRepository usuarioRepository;
    private DefaultSslBundleRegistry sslBundleRegistry;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, DefaultSslBundleRegistry sslBundleRegistry) {
        this.usuarioRepository = usuarioRepository;
        this.sslBundleRegistry = sslBundleRegistry;
    }

    public Collection<UsuarioDTO> findAll() {
        var aparelhos = usuarioRepository.findAll();
        return aparelhos.stream().map(this::toDTO).collect(Collectors.toList());

    }

    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getIsAdmin(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTime()
        );
    }

    private Usuario toEntity(UsuarioDTO usuarioDTO) {
        return new Usuario(
                usuarioDTO.id(),
                usuarioDTO.isAdmin(),
                usuarioDTO.nome(),
                usuarioDTO.email(),
                usuarioDTO.time()
        );
    }

    public UsuarioDTO findById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        return toDTO(usuario);
    }

    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = toEntity(usuarioDTO);
        Usuario saveUsuario = usuarioRepository.save(usuario);
        return toDTO(saveUsuario);
    }

    public UsuarioDTO update(UsuarioDTO usuarioDTO) {

        try {
            Usuario usuario = usuarioRepository.getReferenceById(usuarioDTO.id());

            usuario.setNome(usuarioDTO.nome());
            usuario.setEmail(usuarioDTO.email());
            usuario.setTime(usuarioDTO.time());

            usuarioRepository.save(usuario);
            return toDTO(usuario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o usuário " + usuarioDTO.nome()  + "("
                    + usuarioDTO.id() + "): " + e);
        }
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
