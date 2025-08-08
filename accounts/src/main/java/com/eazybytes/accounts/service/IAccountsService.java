package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;
import org.springframework.data.repository.query.Param;

public interface IAccountsService {

    /**
     *
     * @param customerDto
     */

     void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
     CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto
     * @return
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber
     * @return
     */
    boolean deleteAccount(String mobileNumber);
}
