DROP TABLE IF EXISTS contacts;

CREATE TABLE contacts (
                          id SERIAL PRIMARY KEY,
                          address1 VARCHAR(255),
                          district VARCHAR(255),
                          amphur VARCHAR(255),
                          province VARCHAR(255),
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
