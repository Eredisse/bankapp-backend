package com.bev.bankappbackend.security;

import com.bev.bankappbackend.model.Customer;
import com.bev.bankappbackend.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BankUserDetails implements UserDetailsService {

    private final CustomerRepo customerRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String userName, password = null;
        List<GrantedAuthority> authorities = null;
        Optional<Customer> customer = customerRepo.findByEmail(username);
        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("User details not found for the user : " + username);
        } else{
            userName = customer.get().getEmail();
            password = customer.get().getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get().getRole()));
        }
        return new User(username,password,authorities);
    }
}
