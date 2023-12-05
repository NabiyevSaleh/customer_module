package growlab.customer.repository;

import growlab.customer.domain.Customer;
import growlab.customer.enums.CustomerType;
import growlab.customer.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomerRepository {

    private static final String NOT_FOUND_MESSAGE = "Customer not found";
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Customer> customerRowMapper;

    public Integer create(Customer customer) {
        String sql = "INSERT INTO customers (internal_id, name, surname, middlename, legal_country_id, legal_city_id, registration_address1, registration_address2, registration_address3, registration_address4, residential_address1, residential_address2, residential_address3, residential_address4, authority, voen, customer_type, registration_date, created_by, created_at, auth_by, auth_at, status, customer_category) " +
                "VALUES(:internalId, :name, :surname, :middleName, :legalCountryId, :legalCityId, :registrationAddress1, :registrationAddress2, :registrationAddress3, :registrationAddress4, :residentialAddress1, :residentialAddress2, :residentialAddress3, :residentialAddress4, :authority, :voen, :customerType, :registrationDate, :createdBy, :createdAt, :authBy, :authAt, :status, :customerCategory)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("internalId", getInternalId())
                        .addValue("name", customer.getName())
                        .addValue("surname", customer.getSurname())
                        .addValue("middleName", customer.getMiddleName())
                        .addValue("legalCountryId", customer.getLegalCountryId())
                        .addValue("legalCityId", customer.getLegalCityId())
                        .addValue("registrationAddress1", customer.getRegistrationAddress1())
                        .addValue("registrationAddress2", customer.getRegistrationAddress2())
                        .addValue("registrationAddress3", customer.getRegistrationAddress3())
                        .addValue("registrationAddress4", customer.getRegistrationAddress4())
                        .addValue("residentialAddress1", customer.getResidentialAddress1())
                        .addValue("residentialAddress2", customer.getResidentialAddress2())
                        .addValue("residentialAddress3", customer.getResidentialAddress3())
                        .addValue("residentialAddress4", customer.getResidentialAddress4())
                        .addValue("authority", customer.getAuthority())
                        .addValue("voen", customer.getVoen())
                        .addValue("customerType", customer.getCustomerType().name())
                        .addValue("registrationDate", customer.getRegistrationDate())
                        .addValue("createdBy", customer.getCreatedBy())
                        .addValue("createdAt", customer.getCreatedAt())
                        .addValue("authBy", customer.getAuthBy())
                        .addValue("authAt", customer.getAuthAt())
                        .addValue("status", 1)
                        .addValue("customerCategory", customer.getCustomerCategory().name()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Customer getIndividualCustomerById(Integer id) {
        String sql = "SELECT * FROM customers WHERE id = :id AND customer_type = :type AND status = :status";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id)
                            .addValue("type", CustomerType.INDIVIDUAL.toString())
                            .addValue("status", 1),
                    customerRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Individual " + NOT_FOUND_MESSAGE);
        }
    }

    public Customer getCorporateCustomerById(Integer id) {
        String sql = "SELECT * FROM customers WHERE id = :id AND customer_type = :type AND status = :status";
        try {
            return jdbc.queryForObject(sql,
                    new MapSqlParameterSource()
                            .addValue("id", id)
                            .addValue("type", CustomerType.CORPORATE.toString())
                            .addValue("status", 1),
                    customerRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Corporate " + NOT_FOUND_MESSAGE);
        }
    }

    public List<Customer> getAllByType(CustomerType type) {
        String sql = "SELECT * FROM customers WHERE customer_type = :customerType AND status = :status";
        try {
            return jdbc.query(sql,
                    new MapSqlParameterSource()
                            .addValue("customerType", type.toString())
                            .addValue("status", 1),
                    customerRowMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public void update(Integer id, Customer customer) {
        String sql = "UPDATE customers SET name = :name, surname = :surname, middlename = :middleName, registration_address1 = :registrationAddress1, registration_address2 = :registrationAddress2, registration_address3 = :registrationAddress3, registration_address4 = :registrationAddress4, residential_address1 = :residentialAddress1, residential_address2 = :residentialAddress2, residential_address3 = :residentialAddress3, residential_address4 = :residentialAddress4, authority = :authority, voen = :voen, customer_category = :customerCategory WHERE id = :id";
        try {
            jdbc.update(sql,
                    new MapSqlParameterSource()
                            .addValue("name", customer.getName())
                            .addValue("surname", customer.getSurname())
                            .addValue("middleName", customer.getMiddleName())
                            .addValue("legalCountryId", customer.getLegalCountryId())
                            .addValue("legalCityId", customer.getLegalCityId())
                            .addValue("registrationAddress1", customer.getRegistrationAddress1())
                            .addValue("registrationAddress2", customer.getRegistrationAddress2())
                            .addValue("registrationAddress3", customer.getRegistrationAddress3())
                            .addValue("registrationAddress4", customer.getRegistrationAddress4())
                            .addValue("residentialAddress1", customer.getResidentialAddress1())
                            .addValue("residentialAddress2", customer.getResidentialAddress2())
                            .addValue("residentialAddress3", customer.getResidentialAddress3())
                            .addValue("residentialAddress4", customer.getResidentialAddress4())
                            .addValue("authority", customer.getAuthority())
                            .addValue("voen", customer.getVoen())
                            .addValue("customerCategory", customer.getCustomerCategory().name())
                            .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }

    }

    public void delete(Integer id) {
        String sql = "UPDATE customers SET status = :status WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("status", 2)
                    .addValue("id", id));
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException(NOT_FOUND_MESSAGE);
        }
    }

    public boolean checkCustomerExist(Integer id) {
        String sql = "SELECT COUNT(*) FROM customers WHERE id = :id AND status = :status";

        int count = jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id)
                        .addValue("status", 1),
                Integer.class);
        if (count == 0) {
            return false;
        }
        return true;
    }

    private String getInternalId() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            int randomNumber = (int) (Math.random() * 10);
            result.append(randomNumber);
        }
        checkInternalIdExist(result.toString());
        return result.toString();
    }

    private void checkInternalIdExist(String internalId) {
        String sql = "SELECT COUNT(*) FROM customers WHERE internal_id = :internalId";

        int count = jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("internalId", internalId),
                Integer.class);
        if (count > 0) {
            getInternalId();
        }
    }

}