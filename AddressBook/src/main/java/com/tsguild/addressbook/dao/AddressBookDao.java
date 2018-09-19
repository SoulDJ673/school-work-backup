package com.tsguild.addressbook.dao;

import com.tsguild.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author souldj673
 */
public interface AddressBookDao {

    //Java Docs !!!!
    /**
     * Adds the given address to the book and associates it with the given
     * address id. If there is already an address associated with the given
     * address id it will return that address object, otherwise it will return
     * null.
     *
     * @param addressId id with which address is to be associated
     * @param address address to be added to the book
     * @return the Address object previously associated with the given address
     * id if it exists, null otherwise
     * @throws com.tsguild.addressbook.dao.AddressBookDaoException
     */
    Address addAddress(String addressId, Address address) throws AddressBookDaoException;

    /**
     * Returns a String array containing the address ids of all addresses in the
     * book.
     *
     * @return String array containing the ids of all the addresses in the book
     * @throws com.tsguild.addressbook.dao.AddressBookDaoException
     */
    List<Address> getAllAddresss() throws AddressBookDaoException;

    /**
     * Returns the address object associated with the given address id. Returns
     * null if no such address exists
     *
     * @param addressId ID of the address to retrieve
     * @return the Address object associated with the given address id, null if
     * no such address exists
     * @throws com.tsguild.addressbook.dao.AddressBookDaoException
     */
    Address getAddress(String addressId) throws AddressBookDaoException;

    /**
     * Removes from the book the address associated with the given id. Returns
     * the address object that is being removed or null if there is no address
     * associated with the given id
     *
     * @param addressId id of address to be removed
     * @return Address object that was removed or null if no address was
     * associated with the given address id
     * @throws com.tsguild.addressbook.dao.AddressBookDaoException
     */
    Address removeAddress(String addressId) throws AddressBookDaoException;
}
