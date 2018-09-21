package com.tsguild.addressbook.dao;

import com.tsguild.addressbook.dto.Address;
import java.io.FileNotFoundException;
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
     * @throws java.io.FileNotFoundException
     */
    Address addAddress(String addressId, Address address) throws FileNotFoundException;

    /**
     * Returns a String array containing the address ids of all addresses in the
     * book.
     *
     * @return String array containing the ids of all the addresses in the book
     * @throws java.io.FileNotFoundException
     */
    List<Address> getAllAddresss() throws FileNotFoundException;

    /**
     * Returns the address object associated with the given address id. Returns
     * null if no such address exists
     *
     * @param addressId ID of the address to retrieve
     * @return the Address object associated with the given address id, null if
     * no such address exists
     * @throws java.io.FileNotFoundException
     */
    Address getAddress(String addressId) throws FileNotFoundException;

    /**
     * Removes from the book the address associated with the given id. Returns
     * the address object that is being removed or null if there is no address
     * associated with the given id
     *
     * @param addressId id of address to be removed
     * @return Address object that was removed or null if no address was
     * associated with the given address id
     * @throws java.io.FileNotFoundException
     */
    Address removeAddress(String addressId) throws FileNotFoundException;
    
    /**
     * Edits an existing entry with the provided id.
     * @param oldId id of original entry
     * @param changedAddress Address object that is similar to the original, but with changed parts
     * @throws java.io.FileNotFoundException
    */
    void editAddress(String oldId, Address changedAddress) throws FileNotFoundException;
}
