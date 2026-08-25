package com.yukitey.spring.vtmv20.vtmv20cadtool.entity.players;

import com.yukitey.spring.vtmv20.vtmv20cadtool.entity.characters.VampireCharacter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "players")
@Getter
@Setter
public class Player implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PlayerRole role = PlayerRole.PLAYER;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VampireCharacter> characters = new ArrayList<>();

    // Вспомогательные методы синхронизации остаются без изменений
    public void addCharacter(VampireCharacter character) {
        characters.add(character);
        character.setPlayer(this);
    }

    public void removeCharacter(VampireCharacter character) {
        characters.remove(character);
        character.setPlayer(null);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }
}
