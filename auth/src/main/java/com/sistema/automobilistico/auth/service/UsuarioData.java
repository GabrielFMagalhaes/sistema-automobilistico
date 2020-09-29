package com.sistema.automobilistico.auth.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sistema.automobilistico.auth.model.Role;
import com.sistema.automobilistico.auth.model.Usuario;

public class UsuarioData implements UserDetails {
    private Usuario usuario;
    List<Role> roleList;

    public UsuarioData() {
        usuario = new Usuario();
        roleList = new ArrayList<>();
    }

    public UsuarioData(Usuario usuario) {
        this.usuario = usuario;
        this.roleList = usuario.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorityList = new ArrayList<>();
        for(Role role: roleList) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
            simpleGrantedAuthorityList.add(authority);
        }
        return simpleGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
