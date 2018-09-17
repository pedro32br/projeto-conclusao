package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;

	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", email)
				.getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}

	public Usuario gravar(Usuario usuario) {
		List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", usuario.getEmail()).getResultList();
		if(usuarios.isEmpty()) {
			manager.persist(usuario);
			return new Usuario();
		} else {
			return usuarios.get(0);
		}
	}
	
	public List<Usuario> listar() {
		return manager.createQuery("select distinct(u) from Usuario u", Usuario.class)
				.getResultList();
	}
	
	public Usuario find(String email) {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
        		.setParameter("email", email).getResultList();
        return usuarios.get(0);
	}
	
	public Usuario setRole(Usuario usuario) {
		manager.merge(usuario);
		return usuario;
	}
}