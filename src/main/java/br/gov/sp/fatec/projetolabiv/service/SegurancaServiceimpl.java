package br.gov.sp.fatec.projetolabiv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.projetolabiv.entity.Usuario;
import br.gov.sp.fatec.projetolabiv.repository.UsuarioRepository;

@Service 
public class SegurancaServiceimpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public SegurancaServiceimpl(UsuarioRepository usuarioRepo){
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario novoUsuario(Usuario usuario) {
        if (usuario.getName() == null || usuario.getName().trim().isEmpty()){
            if  (usuario.getSenha() == null || usuario.getSenha().trim().isEmpty()) {
                throw new IllegalArgumentException("Nome em branco");
            }
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public Usuario novoUsuario(String nome, String senha) {
      
        Usuario usuario = new Usuario();
        usuario.setName(nome);
        usuario.setSenha(senha);
        return novoUsuario(usuario);
    }

    @Override
    public List<Usuario> listarTodosUsuarios() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
