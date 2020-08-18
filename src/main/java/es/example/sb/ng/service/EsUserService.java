package es.example.sb.ng.service;

import java.util.List;

import es.example.sb.ng.model.EsUserEntity;

public interface EsUserService {

	List<EsUserEntity> getAllUsers();

	EsUserEntity getUserById(Long eId);

	EsUserEntity createUser(EsUserEntity emp);

}
