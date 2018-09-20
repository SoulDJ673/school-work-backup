package com.tsguild.addressbook.dao;

import com.tsguild.addressbook.dto.Address;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author souldj673
 */
public class AddressBookDaoFileImpl implements AddressBookDao {

    //File Persistence
    public static final String BOOK_FILE = "book.txt";
    public static final String DELIMITER = "::";

    @Override
    public Address addAddress(String addressId, Address address) throws AddressBookDaoException {
        loadBook();
        Address newAddress = addresses.put(addressId, address);
        writeBook();
        return newAddress;
    }

    @Override
    public List<Address> getAllAddresss() throws AddressBookDaoException {
        loadBook();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address getAddress(String addressId) throws AddressBookDaoException {
        loadBook();
        return addresses.get(addressId);
    }

    @Override
    public Address removeAddress(String addressId) throws AddressBookDaoException {
        loadBook();
        Address removedAddress = addresses.remove(addressId);
        writeBook();
        return removedAddress;
    }

    //Map for storing/sorting address data
    private Map<String, Address> addresses = new HashMap<>();

    private Address unmarshallAddress(String addressAsText) {
        // addressAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::123 Sesame Street::SomeCity::SomeState::SomeCountry::40065
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in addressTokens.
        // Which should look like this:
        // __________________________________________________________________________________
        // |    |   |        |                  |          |           |             |       |
        // |1234|Ada|Lovelace|123 Sesame Street | SomeCity | SomeState | SomeCountry | 40065 |
        // |    |   |        |                  |          |           |             |       |
        // ----------------------------------------------------------------------------------
        //  [0]  [1]    [2]         [3]              [4]        [5]          [6]        [7]
        String[] addressTokens = addressAsText.split(DELIMITER);

        // Given the pattern above, the address Id is in index 0 of the array.
        String addressId = addressTokens[0];

        // Which we can then use to create a new Address object to satisfy
        // the requirements of the Address constructor.
        Address addressFromFile = new Address(addressId);

        // However, there are 3 remaining tokens that need to be set into the
        // new address object. Do this manually by using the appropriate setters.
        // Index 1 - OwnerFirstName
        addressFromFile.setOwnerOwnerFirstName(addressTokens[1]);

        // Index 2 - OwnerLastName
        addressFromFile.setOwnerOwnerLastName(addressTokens[2]);

        // Index 3 - StreetAddress
        addressFromFile.setStreetAddress(addressTokens[3]);
        
        //Index 4 - City
        addressFromFile.setCity(addressTokens[4]);
        
        //Index 5 - State/Providence
        addressFromFile.setState(addressTokens[5]);
        
        //Index 6 - Country
        addressFromFile.setCountry(addressTokens[6]);
        
        //Index 7 - Zip
        addressFromFile.setZipCode(addressTokens[7]);

        // We have now created an address! Return it!
        return addressFromFile;
    }

    private void loadBook() throws AddressBookDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(BOOK_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
                    "-_- Could not load address book data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentAddress holds the most recent address unmarshalled
        Address currentAddress;
        // Go through BOOK_FILE line by line, decoding each line into a 
        // Address object by calling the unmarshallAddress method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into an Address
            currentAddress = unmarshallAddress(currentLine);

            // We are going to use the address id as the map key for our address object.
            // Put currentAddress into the map using address id as the key
            addresses.put(currentAddress.getId(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    	private String marshallAddress(Address anAddress){
	    // We need to turn an Address object into a line of text for our file.
	    // For example, we need an in memory object to end up like this:
	    // 4321::Charles::Babbage::Java-September1842

	    // It's not a complicated process. Just get out each property,
	    // and concatenate with our DELIMITER as a kind of spacer. 
	    
	    // Start with the address id, since that's supposed to be first.
	    String addressAsText = anAddress.getId() + DELIMITER;
	    
	    // add the rest of the properties in the correct order:

	    // OwnerFirstName
	    addressAsText += anAddress.getOwnerFirstName() + DELIMITER;
		
	    // OwnerLastName
	    addressAsText += anAddress.getOwnerLastName() + DELIMITER;
				
	    // StreetAddress - don't forget to skip the DELIMITER here.
	    addressAsText += anAddress.getStreetAddress();
		
	    // We have now turned an address to text! Return it!
	    return addressAsText;
	}
	/**
	 * Writes all addresses in the book out to a BOOK_FILE.  See loadBook
	 * for file format.
	 * 
	 * @throws AddressBookDaoException if an error occurs writing to the file
	 */
	private void writeBook() throws AddressBookDaoException {
	    // NOTE FOR APPRENTICES: We are not handling the IOException - but
	    // we are translating it to an application specific exception and 
	    // then simple throwing it (i.e. 'reporting' it) to the code that
	    // called us.  It is the responsibility of the calling code to 
	    // handle any errors that occur.
	    PrintWriter out;
	    
	    try {
	        out = new PrintWriter(new FileWriter(BOOK_FILE));
	    } catch (IOException e) {
	        throw new AddressBookDaoException(
	                "Could not save address data.", e);
	    }
	    
	    // Write out the Address objects to the book file.
	    // NOTE TO THE APPRENTICES: We could just grab the address map,
	    // get the Collection of Addresss and iterate over them but we've
	    // already created a method that gets a List of Addresss so
	    // we'll reuse it.
	    String addressAsText;
	    List<Address> addressList = this.getAllAddresss();
	    for (Address currentAddress : addressList) {
	    	// turn an Address into a String
	    	addressAsText = marshallAddress(currentAddress);
	        // write the Address object to the file
	        out.println(addressAsText);
	        // force PrintWriter to write line to the file
	        out.flush();
	    }
	    // Clean up
	    out.close();
	}
}
