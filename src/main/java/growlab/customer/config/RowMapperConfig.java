package growlab.customer.config;

import growlab.customer.domain.*;
import growlab.customer.enums.ContactType;
import growlab.customer.enums.CustomerType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;


@Configuration
public class RowMapperConfig {

    @Bean("individualCustomerDetailsRowMapper")
    public RowMapper<IndividualCustomerDetail> getIndividualCustomerDetailsRowMapper() {
        return (rs, rowNum) -> IndividualCustomerDetail.builder()
                .id(rs.getInt("id"))
                .pin(rs.getString("pin"))
                .uniqueIdName(rs.getString("unique_id_name"))
                .uniqueIdValue(rs.getString("unique_id_value"))
                .birthCountryId(rs.getInt("birth_country_id"))
                .birthCityId(rs.getInt("birth_city_id"))
                .idBeginDate(rs.getDate("id_begin_date").toLocalDate())
                .idEndDate(rs.getDate("id_end_date").toLocalDate())
                .image(rs.getString("image"))
                .build();
    }

    @Bean("customerRowMapper")
    public RowMapper<Customer> getCustomerRowMapper() {
        return (rs, rowNum) -> Customer.builder()
                .id(rs.getInt("id"))
                .internalId(rs.getInt("internal_id"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .middleName(rs.getString("middlename"))
                .legalCountryId(rs.getInt("legal_country_id"))
                .legalCityId(rs.getInt("legal_city_id"))
                .registrationAddress1(rs.getString("registration_address1"))
                .registrationAddress2(rs.getString("registration_address2"))
                .registrationAddress3(rs.getString("registration_address3"))
                .registrationAddress4(rs.getString("registration_address4"))
                .residentialAddress1(rs.getString("residential_address1"))
                .residentialAddress2(rs.getString("residential_address2"))
                .residentialAddress3(rs.getString("residential_address3"))
                .residentialAddress4(rs.getString("residential_address4"))
                .authority(rs.getString("authority"))
                .voen(rs.getString("voen"))
                .customerType(CustomerType.valueOf(rs.getString("customer_type")))
                .registrationDate(rs.getDate("registration_date").toLocalDate())
                .createdBy(rs.getInt("created_by"))
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .authBy(rs.getInt("auth_by"))
                .authAt(rs.getTimestamp("auth_at").toLocalDateTime())
                .status(rs.getInt("status"))
                .customerCategory(rs.getString("customer_category"))
                .build();
    }

    @Bean("corporateCustomerShareholderRowMapper")
    public RowMapper<CorporateCustomerShareholder> getCorporateCustomerShareholderRowMapper() {
        return (rs, rowNum) -> CorporateCustomerShareholder.builder()
                .id(rs.getInt("id"))
                .customerId(rs.getInt("customer_id"))
                .shareholder(rs.getString("shareholder"))
                .sharePercent(rs.getDouble("share_percent"))
                .build();
    }

    @Bean("customerContactDetailRowMapper")
    public RowMapper<CustomerContactDetail> getCustomerContactDetailRowMapper() {
        return (rs, rowNum) -> CustomerContactDetail.builder()
                .id(rs.getInt("id"))
                .customerId(rs.getInt("customer_id"))
                .contactType(ContactType.valueOf(rs.getString("contact_type")))
                .contactValue(rs.getString("contact_value"))
                .isActive(rs.getInt("is_active"))
                .build();

    }

    @Bean("recordLogRowMapper")
    public RowMapper<RecordLog> getRecordLogRowMapper() {
        return (rs, rowNum) -> RecordLog.builder()
                .id(rs.getInt("id"))
                .eventTime(rs.getTimestamp("event_time").toLocalDateTime())
                .customerId(rs.getInt("customer_id"))
                .parameter(rs.getString("parameter"))
                .oldValue(rs.getString("old_value"))
                .newValue(rs.getString("new_value"))
                .build();
    }

    @Bean("countryRowMapper")
    public RowMapper<Country> getCountryRowMapper() {
        return (rs, rowNum) -> Country.builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();
    }

    @Bean("cityRowMapper")
    public RowMapper<City> getCityRowMapper() {
        return (rs, rowNum) -> City.builder()
                .id(rs.getInt("id"))
                .countryId(rs.getInt("country_id"))
                .name(rs.getString("name"))
                .build();
    }

}
