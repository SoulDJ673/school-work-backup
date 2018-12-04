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
import java.io.FileNotFoundException;

/**
 *
 * @author souldj673
 */
public interface FlooringMasteryTaxesProductDao {

    public TaxRate createTax(TaxRate tax);

    public Product createProduct(Product product);

    public TaxRate editTax(TaxRate tax);

    public Product editProduct(Product product);

    public TaxRate removeTax(String abbr);

    public Product removeProduct(String type);

    public void loadProducts() throws FileNotFoundException;

    public void loadTaxes() throws FileNotFoundException;

    public TaxRate getTax(String abbr);

    public Product getProduct(String prod);

    public void saveProducts();

    public void saveTaxes();
}
