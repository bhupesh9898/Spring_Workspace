package com.zensar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.model.Mail;
import com.zensar.model.User;
import com.zensar.repository.UserRepository;
import com.zensar.service.UserService;
import com.zensar.util.EmailVerificationAndValidation;
import com.zensar.util.EncryptDecryptPassword;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public int sendMail(Mail mail) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int login(String email,String password) {

		User extractedUser =userRepository.getByEmail(email) ;
		System.out.println(userRepository.getByEmail(email));
		if (extractedUser == null) {
			return 400;
		} else {
			boolean validUser = EncryptDecryptPassword.checkPassword(password, extractedUser.getPassword());
			if (validUser) {
				return 200;
			} else {
				return 401;
			}
		}

	}

	@Override
	public int register(User user) {
		if (EmailVerificationAndValidation.verifyEmailAddress(user.getEmail())) {
			user.setPassword(EncryptDecryptPassword.encryptPassword(user.getPassword()));
			userRepository.save(user);
			return 200;
		} else {
			return 400;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.getByEmail(email);
	}

}
