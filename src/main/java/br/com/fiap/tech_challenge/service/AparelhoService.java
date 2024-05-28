package br.com.fiap.tech_challenge.service;

import br.com.fiap.tech_challenge.dto.AparelhoDTO;
import br.com.fiap.tech_challenge.entities.Aparelho;
import br.com.fiap.tech_challenge.repository.AparelhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class AparelhoService {

    private final AparelhoRepository aparelhoRepository;
    private final DefaultSslBundleRegistry sslBundleRegistry;

    @Autowired
    public AparelhoService(AparelhoRepository aparelhoRepository, DefaultSslBundleRegistry sslBundleRegistry) {
        this.aparelhoRepository = aparelhoRepository;
        this.sslBundleRegistry = sslBundleRegistry;
    }

    public Collection<AparelhoDTO> findAll() {
        var aparelhos = aparelhoRepository.findAll();
        return aparelhos.stream().map(this::toDTO).collect(Collectors.toList());
    }

    private AparelhoDTO toDTO(Aparelho aparelho) {
        return new AparelhoDTO(
                aparelho.getId(),
                aparelho.isEstaReservado(),
                aparelho.getNomeAparelho(),
                aparelho.getModelo(),
                aparelho.getObservacao(),
                aparelho.getTimeResponsavel(),
                aparelho.getQuemReservou()
        );
    }

    private Aparelho toEntity(AparelhoDTO aparelhoDTO) {
        return new Aparelho(
                aparelhoDTO.id(),
                aparelhoDTO.estaReservado(),
                aparelhoDTO.nomeAparelho(),
                aparelhoDTO.modelo(),
                aparelhoDTO.observacao(),
                aparelhoDTO.timeResponsavel(),
                aparelhoDTO.quemReservou()
        );
    }

    public AparelhoDTO findById(Long id) {
        Aparelho aparelho = aparelhoRepository.findById(id).orElse(null);
        return toDTO(aparelho);
    }

    public AparelhoDTO insert(AparelhoDTO aparelhoDTO) {
        Aparelho aparelho = toEntity(aparelhoDTO);
        Aparelho saved = aparelhoRepository.save(aparelho);
        return toDTO(saved);
    }

    public AparelhoDTO update(Long id, AparelhoDTO aparelhoDTO) {

        try {
            Aparelho aparelho = aparelhoRepository.getReferenceById(id);
            aparelho.setEstaReservado(aparelhoDTO.estaReservado());
            aparelho.setNomeAparelho(aparelhoDTO.nomeAparelho());
            aparelho.setModelo(aparelhoDTO.modelo());
            aparelho.setObservacao(aparelhoDTO.observacao());
            aparelho.setTimeResponsavel(aparelhoDTO.timeResponsavel());
            aparelho.setQuemReservou(aparelhoDTO.quemReservou());

            Aparelho updated = aparelhoRepository.save(aparelho);
            return toDTO(updated);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar o aparelho " + aparelhoDTO.nomeAparelho()  + ":" + e);
        }
    }

    public void delete(Long id) {
        aparelhoRepository.deleteById(id);
    }

}
