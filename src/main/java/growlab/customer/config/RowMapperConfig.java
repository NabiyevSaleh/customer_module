package growlab.customer.config;

import growlab.customer.domain.*;
import growlab.customer.enums.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;


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
                .birthdate(rs.getDate("birthdate").toLocalDate())
                .gender(Gender.valueOf(rs.getString("gender")))
                .maritalStatus(MaritalStatus.valueOf(rs.getString("marital_status")))
                .workPlace(rs.getString("work_place"))
                .position(rs.getString("position"))
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
                .registrationDate(checkDate(rs.getDate("registration_date")))
                .createdBy(rs.getString("created_by"))
                .createdAt(checkDate(rs.getDate("created_at")))
                .authBy(rs.getString("auth_by"))
                .authAt(checkDate(rs.getDate("auth_at")))
                .status(rs.getInt("status"))
                .customerCategory(CustomerCategory.valueOf(rs.getString("customer_category")))
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

    private LocalDate checkDate(Date date) {
        LocalDate result = null;
        if (!Objects.isNull(date)) {
            result = date.toLocalDate();
        }
        return result;
    }

}
