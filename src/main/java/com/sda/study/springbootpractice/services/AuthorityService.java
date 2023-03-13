package com.sda.study.springbootpractice.services;

import com.sda.study.springbootpractice.exceptions.AuthorityNotFoundException;
import com.sda.study.springbootpractice.models.Authority;

import java.util.List;

/**
 * Service to handle authority related operations
 *
 * @author Vinod John
 * @Date 13.03.2023
 */
public interface AuthorityService {
    /**
     * To fina all authorities
     *
     * @return a list of authorities
     */
    List<Authority> findAllAuthorities();

    /**
     * To find authority by name
     *
     * @param name Authority name
     * @return Authority
     */
    Authority findAuthorityByName(String name) throws AuthorityNotFoundException;

    /**
     * To create a new authority
     *
     * @param authority Authority
     */
    void createAuthority(Authority authority);
}
