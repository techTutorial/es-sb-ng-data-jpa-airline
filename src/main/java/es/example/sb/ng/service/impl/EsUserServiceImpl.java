package es.example.sb.ng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.example.sb.ng.exception.ResourceNotFoundException;
import es.example.sb.ng.model.EsUserEntity;
import es.example.sb.ng.repository.EsUserRepository;
import es.example.sb.ng.service.EsUserService;

@Service
public class EsUserServiceImpl implements EsUserService {

	@Autowired
	private EsUserRepository userRepo;

	@Override
	public List<EsUserEntity> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public EsUserEntity getUserById(Long eId) throws ResourceNotFoundException {
		return userRepo.findById(eId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found for id:: " + eId));
	}

	@Override
	public EsUserEntity createUser(EsUserEntity emp) {
		return userRepo.save(emp);
	}

}
