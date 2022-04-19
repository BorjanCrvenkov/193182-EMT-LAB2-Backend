package mk.ukim.finki.lab2.service;

import mk.ukim.finki.lab2.model.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();

    Country findCountryById(Long countryId);

    Country createCountry(String name, String continent);

    Country deleteCountry(Long countryId);

    Country editCountry(Long countryId, String name, String continent);
}
