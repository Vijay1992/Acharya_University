package com.au.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.au.dto.UserRoleRequest;
import com.au.exception.ResourceNotFoundException;
import com.au.model.UserAuthentication;
import com.au.model.UserRole;
import com.au.repository.UserAuthenticationRepository;
import com.au.repository.UserRoleRepository;
import net.bytebuddy.utility.RandomString;

@Service
@Transactional
public class UserAuthenticationService {

	@Autowired
	private UserAuthenticationRepository uar_repo;

	@Autowired
	private UserRoleRepository urr_repo;
	
	//@Autowired
	//private JavaMailSender mailsender;

	public List<UserAuthentication> listAll() {
		return uar_repo.findAll();
	}

	public UserAuthentication saveUserAuthentication(UserAuthentication userauthentication) {
		return uar_repo.save(userauthentication);
	}

	public UserAuthentication get(Integer id) {
		return uar_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User Not Found:" + id));
	}

	public void delete(Integer id) {
		UserAuthentication ay = uar_repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found:" + id));
		uar_repo.delete(ay);
	}

	public UserAuthentication saveUserRole(UserRoleRequest userrolerequest) {

		UserAuthentication userauthentication = new UserAuthentication();
		userauthentication.setId(userrolerequest.getId());
		userauthentication.setEmail(userrolerequest.getEmail());
		userauthentication.setUsercode(userrolerequest.getUsercode());
		userauthentication.setUsertype(userrolerequest.getUsertype());
		userauthentication.setUsername(userrolerequest.getUsername());
		userauthentication.setStatus(userrolerequest.getStatus());

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String passwordEncoder1 = passwordEncoder.encode(RandomString.make(8));
		System.out.println(passwordEncoder1);
		userauthentication.setPassword(passwordEncoder1);
		UserAuthentication user = saveUserAuthentication(userauthentication);

		userrolerequest.getRole_id().stream().forEach(u -> {
			UserRole userrole = new UserRole();
			userrole.setId(user.getId());
			userrole.setRole_id(u);
			urr_repo.save(userrole);});
		
	//	String content="Hello your user name" + userauthentication.getId() + "and password is" + userauthentication.getPassword();
	//	sendSimpleEmail(content, passwordEncoder1, content);
		return user;
	}
/*	
	public String sendSimpleEmail(String toEmail,String body,String subject) {
              SimpleMailMessage message = new SimpleMailMessage();

              message.setFrom("spring.email.from@gmail.com");
              message.setTo(toEmail);
              message.setText(body);
              message.setSubject(subject);

              mailsender.send(message);
              System.out.println("Mail Send...");
			return body;
        }  */
}