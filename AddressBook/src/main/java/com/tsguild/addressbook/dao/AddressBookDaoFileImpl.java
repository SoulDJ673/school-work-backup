package com.tsguild.addressbook.dao;

import com.tsguild.addressbook.dto.Address;
import java.util.List;

/**
 *
 * @author souldj673
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    @Override
    public Address addAddress(String addressId, Address address) throws AddressBookDaoException {
        
    }

    @Override
    public List<Address> getAllAddresss() throws AddressBookDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address getAddress(String addressId) throws AddressBookDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Address removeAddress(String addressId) throws AddressBookDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
