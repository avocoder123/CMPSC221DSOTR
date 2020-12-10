package com.darksideoftherainbow.bootstrap;

import com.darksideoftherainbow.model.Album;
import com.darksideoftherainbow.model.ApplicationUser;
import com.darksideoftherainbow.repository.AlbumRepository;
import com.darksideoftherainbow.repository.ApplicationUserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final AlbumRepository albumRepository;
    private ApplicationUserRepository applicationUserRepository;

    public DatabaseLoader(AlbumRepository albumRepository, ApplicationUserRepository applicationUserRepository) {

        this.albumRepository = albumRepository;
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        this.albumRepository.addAlbum(new Album("thank u, next","Ariana Grande",19.99,"Pop",12,"02/08/2019"));
        this.albumRepository.addAlbum(new Album("Care Package   ","Drake",29.99,"Hip-Pop/Rap",17,"08/02/2019"));
        this.albumRepository.addAlbum(new Album("Scorpion","Drake",59.99,"Hip-pop/Rap",25,"06/29/2018"));
        this.albumRepository.addAlbum(new Album("Dan+Shay","Dan+Shay",25.99,"Country",11,"06/22/2018"));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        ApplicationUser user1 = new ApplicationUser("admin", encoder.encode("secretpassword"), true);
        ApplicationUser user2 = new ApplicationUser("fred", encoder.encode("123456"), false);
        this.applicationUserRepository.addUser(user1);
        this.applicationUserRepository.addUser(user2);
    }
}
