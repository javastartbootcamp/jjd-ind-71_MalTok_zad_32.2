package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    public List<LanguageCountry> findAllLanguages() {
        return countryLanguageRepository.findAllLanguages();
    }

    public Map<String, List<String>> findAllLanguagesWithCountriesNames() {
        Map<String, List<String>> map = findAllLanguages().stream()
                .collect(Collectors.groupingBy(
                        LanguageCountry::getLanguage,
                        Collectors.mapping(LanguageCountry::getCountryName, Collectors.toList())
                ));
        return new TreeMap<>(map);
    }

}
