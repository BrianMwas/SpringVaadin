package com.briandev.springvaadin.backend.repositories

import com.briandev.springvaadin.backend.models.Tasks
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface taskRepo : JpaRepository<Tasks, Long>