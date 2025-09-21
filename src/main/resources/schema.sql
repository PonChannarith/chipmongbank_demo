-- Drop tables if exist
DROP TABLE IF EXISTS contacts;
DROP TABLE IF EXISTS districts;
DROP TABLE IF EXISTS amphurs;
DROP TABLE IF EXISTS provinces;

-- Provinces table
CREATE TABLE provinces (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL
);

-- Amphurs table
CREATE TABLE amphurs (
                         id SERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         province_id INT REFERENCES provinces(id)
);

-- Districts table
CREATE TABLE districts (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           amphur_id INT REFERENCES amphurs(id)
);

-- Contacts table (store names directly)
CREATE TABLE contacts (
                          id SERIAL PRIMARY KEY,
                          address1 VARCHAR(255),
                          district_name VARCHAR(255),
                          amphur_name VARCHAR(255),
                          province_name VARCHAR(255),
                          postal_code1 VARCHAR(10),
                          telephone VARCHAR(20),
                          fax VARCHAR(20),
                          address2 VARCHAR(255),
                          city VARCHAR(255),
                          state_province VARCHAR(255),
                          postal_code2 VARCHAR(10),
                          country VARCHAR(255),
                          contact_person VARCHAR(255),
                          email VARCHAR(255)
);