package rest.with.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import rest.with.spring.exception.ResourceNotFoundException;
import rest.with.spring.model.User;
import rest.with.spring.repository.UserRepository;
import rest.with.spring.types.UserRoles;

@Component
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = (User) Optional.ofNullable(this.userRepository.findByUsername(username))
				.orElseThrow(() -> new ResourceNotFoundException("Resource Not FoundException User:" + username));

		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList(UserRoles.ROLE_ADM.toString(),
				UserRoles.ROLE_USER.toString());
		
		List<GrantedAuthority> authorityListNotAdmin = AuthorityUtils
				.createAuthorityList(UserRoles.ROLE_USER.toString());

		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				user.isAdmin() ? authorityListAdmin : authorityListNotAdmin);
	}

}
