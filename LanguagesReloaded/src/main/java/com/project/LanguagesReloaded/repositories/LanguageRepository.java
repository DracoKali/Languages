package com.project.LanguagesReloaded.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.LanguagesReloaded.models.Language;

@Repository 												
public interface LanguageRepository extends CrudRepository<Language,Long>{

}
