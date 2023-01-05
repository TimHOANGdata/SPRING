package spring.countries;

public class CountryMapper {
    public CountryDTO convertToDTO(Country entity){

        CountryDTO dto = new CountryDTO();
        dto.setName(entity.getName());
        dto.setId(entity.getId());
        return dto;
    }
}
