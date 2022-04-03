package com.example.JayminPatel_ORMandSpringMVCAssignmentSolution.repositories;

import com.example.JayminPatel_ORMandSpringMVCAssignmentSolution.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
