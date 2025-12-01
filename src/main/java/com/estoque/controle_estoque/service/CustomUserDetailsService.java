package com.estoque.controle_estoque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.estoque.controle_estoque.model.TbLogin;
import com.estoque.controle_estoque.repository.TbLoginRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private TbLoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbLogin login = loginRepository.findByNmLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));

        return User.builder()
                .username(login.getNmLogin())
                .password(login.getPassword())
                .roles("USER") // pode ajustar se tiver diferentes roles
                .build();
    }
}
