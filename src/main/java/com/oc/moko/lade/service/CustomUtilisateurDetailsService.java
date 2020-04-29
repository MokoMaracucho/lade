package com.oc.moko.lade.service; 
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oc.moko.lade.entity.Utilisateur;
import com.oc.moko.lade.entity.UtilisateurProfile;

@Service("customUserDetailsService")
public class CustomUtilisateurDetailsService implements UtilisateurDetailsService {
	
    @Autowired
    private UtilisateurService utilisateurService;
     
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String emailFormConnection)  throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurService.selectionUtilisateurParEmail(emailFormConnection);
        System.out.println("Utilisateur : " + utilisateur);
        if(utilisateur == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found"); 
        }
            return new org.springframework.security.core.userdetails.User(utilisateur.getSsoId(), utilisateur.getPassword(), 
            		utilisateur.getState().equals("Active"), true, true, true, getGrantedAuthorities(utilisateur));
    }
 
     
    private List<GrantedAuthority> getGrantedAuthorities(Utilisateur utilisateur){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(UtilisateurProfile utilisateurProfile : utilisateur.getUtilisateurProfiles()){
            System.out.println("utilisateurProfile : "+ utilisateurProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_" + utilisateurProfile.getType()));
        }
        System.out.print("authorities : " + authorities);
        return authorities;
    }
}
