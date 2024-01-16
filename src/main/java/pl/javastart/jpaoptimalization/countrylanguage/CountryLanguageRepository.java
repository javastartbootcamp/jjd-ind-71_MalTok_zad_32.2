package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguageKey> {

    @Query("SELECT cl.language as language, c.name as countryName " +
            "FROM CountryLanguage cl LEFT JOIN Country c ON cl.countryCode = c.code ORDER BY cl.language ASC")
    List<LanguageCountry> findAllLanguages();
}
