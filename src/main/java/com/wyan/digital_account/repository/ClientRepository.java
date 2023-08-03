package com.wyan.digital_account.repository;

import com.wyan.digital_account.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    public Client findClientByName(String name);
}
