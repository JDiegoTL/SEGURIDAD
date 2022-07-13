package com.idat.seg.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.seg.model.Usuarios;
import com.idat.seg.repository.UsuarioRepository;




@Service
public class UserDetailService implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios usuario = repository.findByUsuario(username);
		
		if (usuario != null) {
			
			List<GrantedAuthority> listGranted = new ArrayList<>();
			GrantedAuthority granted = new SimpleGrantedAuthority(usuario.getRol());
			
			listGranted.add(granted);
			return  new User(usuario.getUsuario(), usuario.getPassword(), listGranted);
		}else {
			throw new UsernameNotFoundException("Usuario no existe" + username);
		}
		
	}

}
