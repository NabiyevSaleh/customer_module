package growlab.customer.repository;

import growlab.customer.domain.Customer;
import growlab.customer.dto.request.CreatedCustomer;
import growlab.customer.dto.request.UpdatedCustomer;
import lombok.RequiredArgsConstructor;
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

    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Customer> customerRowMapper;

    public Integer create(CreatedCustomer request) {
        String sql = "INSERT INTO customers (internal_id, name, surname, middlename, legal_country_id, legal_city_id, registration_address1, registration_address2, registration_address3, registration_address4, residential_address1, residential_address2, residential_address3, residential_address4, authority, voen, customer_type, registration_date, created_by, created_at, auth_by, auth_at, status, customer_category) " +
                "VALUES(:internalId, :name, :surname, :middleName, :legalCountryId, :legalCityId, :registrationAddress1, :registrationAddress2, :registrationAddress3, :registrationAddress4, :residentialAddress1, :residentialAddress2, :residentialAddress3, :residentialAddress4, :authority, :voen, :customerType, :registrationDate, :createdBy, :createdAt, :authBy, :authAt, :status, :customerCategory)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("internalId", request.getInternalId())
                        .addValue("name", request.getName())
                        .addValue("surname", request.getSurname())
                        .addValue("middleName", request.getMiddleName())
                        .addValue("legalCountryId", request.getLegalCountryId())
                        .addValue("legalCityId", request.getLegalCityId())
                        .addValue("registrationAddress1", request.getRegistrationAddress1())
                        .addValue("registrationAddress2", request.getRegistrationAddress2())
                        .addValue("registrationAddress3", request.getRegistrationAddress3())
                        .addValue("registrationAddress4", request.getRegistrationAddress4())
                        .addValue("residentialAddress1", request.getResidentialAddress1())
                        .addValue("residentialAddress2", request.getResidentialAddress2())
                        .addValue("residentialAddress3", request.getResidentialAddress3())
                        .addValue("residentialAddress4", request.getResidentialAddress4())
                        .addValue("authority", request.getAuthority())
                        .addValue("voen", request.getVoen())
                        .addValue("customerType", request.getCustomerType())
                        .addValue("registrationDate", request.getRegistrationDate())
                        .addValue("createdBy", request.getCreatedBy())
                        .addValue("createdAt", request.getCreatedAt())
                        .addValue("authBy", request.getAuthBy())
                        .addValue("authAt", request.getAuthAt())
                        .addValue("status", request.isStatus())
                        .addValue("customerCategory", request.getCustomerCategory()),
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    public Customer getById(Integer id) {
        String sql = "SELECT * FROM customers WHERE id = :id";
        return jdbc.queryForObject(sql,
                new MapSqlParameterSource()
                        .addValue("id", id),
                customerRowMapper);
    }

    public List<Customer> getAll() {
        String sql = "SELECT * FROM customers";
        return jdbc.query(sql, customerRowMapper);
    }

    public void update(Integer id, UpdatedCustomer request) {
        String sql = "UPDATE customers SET name = :name, surname = :surname, middlename = :middleName, legal_country_id =:legalCountryId, legal_city_id = :legalCityId, registration_address1 = :registrationAddress1, registration_address2 = :registrationAddress2, registration_address3 = :registrationAddress3, registration_address4 = :registrationAddress4, residential_address1 = :residentialAddress1, residential_address2 = :residentialAddress2, residential_address3 = :residentialAddress3, residential_address4 = :residentialAddress4, authority = :authority, voen = :voen, customer_type = :customerType, registration_date = :registrationDate, created_by = :createdBy, created_at = :createdAt, auth_by = :authBy, auth_at = :authAt, status = :status, customer_category = :customerCategory WHERE id = :id";
        jdbc.update(sql,
                new MapSqlParameterSource()
                        .addValue("name", request.getName())
                        .addValue("surname", request.getSurname())
                        .addValue("middleName", request.getMiddleName())
                        .addValue("legalCountryId", request.getLegalCountryId())
                        .addValue("legalCityId", request.getLegalCityId())
                        .addValue("registrationAddress1", request.getRegistrationAddress1())
                        .addValue("registrationAddress2", request.getRegistrationAddress2())
                        .addValue("registrationAddress3", request.getRegistrationAddress3())
                        .addValue("registrationAddress4", request.getRegistrationAddress4())
                        .addValue("residentialAddress1", request.getResidentialAddress1())
                        .addValue("residentialAddress2", request.getResidentialAddress2())
                        .addValue("residentialAddress3", request.getResidentialAddress3())
                        .addValue("residentialAddress4", request.getResidentialAddress4())
                        .addValue("authority", request.getAuthority())
                        .addValue("voen", request.getVoen())
                        .addValue("registrationDate", request.getRegistrationDate())
                        .addValue("status", request.isStatus())
                        .addValue("customerCategory", request.getCustomerCategory())
                        .addValue("id", id));
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM customers WHERE id = :id";
        try {
            jdbc.update(sql, new MapSqlParameterSource()
                    .addValue("id", id));
        } catch (Exception e) {
        }
    }
}
