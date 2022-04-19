package mk.ukim.finki.lab2.service.impl;

import mk.ukim.finki.lab2.model.Country;
import mk.ukim.finki.lab2.repository.CountryRepository;
import mk.ukim.finki.lab2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country findCountryById(Long countryId) {
        return this.countryRepository.findById(countryId).get();
    }

    @Override
    public Country createCountry(String name, String continent) {
        Country country = new Country(name,continent);

        return this.countryRepository.save(country);
    }

    @Override
    public Country deleteCountry(Long countryId) {
        Country country = this.findCountryById(countryId);

        this.countryRepository.delete(country);

        return country;
    }

    @Override
    public Country editCountry(Long countryId, String name, String continent) {
        Country country = this.findCountryById(countryId);

        country.setName(name);
        country.setContinent(continent);

        return this.countryRepository.save(country);
    }
}
