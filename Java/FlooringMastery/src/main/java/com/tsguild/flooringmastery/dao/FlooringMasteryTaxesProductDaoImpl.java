/*
 * Copyright (C) 2018 souldj673
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tsguild.flooringmastery.dao;

import com.tsguild.flooringmastery.dto.Product;
import com.tsguild.flooringmastery.dto.TaxRate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.*;

/**
 *
 * @author souldj673
 */
public class FlooringMasteryTaxesProductDaoImpl implements FlooringMasteryTaxesProductDao {

    private final Map<String, TaxRate> taxes = new HashMap<>();
    private final Map<String, Product> products = new HashMap<>();

    //File Locations
    private final String TAXES;
    private final String PRODUCTS;

    public FlooringMasteryTaxesProductDaoImpl(String TAXES, String PRODUCTS) {
        this.TAXES = TAXES;
        this.PRODUCTS = PRODUCTS;
    }

    //Taxes
    @Override
    public TaxRate getTax(String abbr) {
        //Compatibility with abbr/State Name
        if (abbr.length() == 2) {
            try {
                return taxes.get(abbr.toUpperCase());
            } catch (NullPointerException n) {
                return null;
            }
        } else {
            for (TaxRate state : taxes.values()) {
                if (state.getState().equalsIgnoreCase(abbr)) {
                    return state;
                }
            }
        }

        //It's being a b lasagna
        return null;
    }

    @Override
    public TaxRate createTax(TaxRate tax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaxRate editTax(TaxRate tax) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaxRate removeTax(String abbr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadTaxes() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(TAXES)));

        while (scanner.hasNextLine()) {
            String taxInfo = scanner.nextLine();
            TaxRate tax = unmarshallTax(taxInfo);
            taxes.put(tax.getAbbr(), tax);
        }
        scanner.close();
    }

    private TaxRate unmarshallTax(String stringedTax) {
        /**
         * TX,Texas,4.45
         */
        String[] taxationIsTheft = stringedTax.split(",");
        TaxRate state = new TaxRate(taxationIsTheft[0], taxationIsTheft[1], Double.parseDouble(taxationIsTheft[2]));
        return state;
    }

    @Override
    public void saveTaxes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaxRate> getAllTaxes() {
        Collection<TaxRate> taxesC = taxes.values();
        List<TaxRate> taxesList = new ArrayList<>();
        for (TaxRate tax : taxesC) {
            taxesList.add(tax);
        }
        return taxesList;
    }

    //Products
    @Override
    public Product getProduct(String prod) {
        return products.get(prod);
    }

    @Override
    public Product createProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product editProduct(Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product removeProduct(String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadProducts() throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(PRODUCTS)));

        while (scanner.hasNextLine()) {
            String productType = scanner.nextLine();
            Product product = unmarshallProduct(productType);
            products.put(product.getType(), product);
        }
        scanner.close();
    }

    private Product unmarshallProduct(String stringedProduct) {
        /**
         * Tile,3.50,4.15 ProductType,CostPerSquareFoot,LaborCostPerSquareFoot
         */
        String[] productPieces = stringedProduct.split(",");
        BigDecimal sqrFtRate = new BigDecimal(Double.parseDouble(productPieces[1]));
        BigDecimal laborSqrFtRate = new BigDecimal(Double.parseDouble(productPieces[2]));
        return new Product(productPieces[0], sqrFtRate, laborSqrFtRate);
    }

    @Override
    public void saveProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getAllProducts() {
        Collection<Product> productsC = products.values();
        List<Product> productList = new ArrayList<>();
        for (Product product : productsC) {
            productList.add(product);
        }
        return productList;
    }

}
