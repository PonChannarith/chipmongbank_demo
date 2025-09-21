-- Insert Provinces
INSERT INTO provinces (name) VALUES
                                 ('Phnom Penh'),('Kandal'),('Takeo');

-- Insert Amphurs
INSERT INTO amphurs (name, province_id) VALUES
                                            ('Chamkar Mon', 1),('Daun Penh', 1),('Toul Kork',1),
                                            ('Khsach Kandal',2),('Kandal Stung',2),('Kaoh Thum',2),
                                            ('Tram Kak',3),('Kirivong',3),('Daun Keo',3);

-- Insert Districts
INSERT INTO districts (name, amphur_id) VALUES
                                            ('Boeng Keng Kang I',1),('Boeng Keng Kang II',1),('Phsar Thmei',2),
                                            ('Toul Kork Town',3),('Khsach Kandal Town',4),('Kandal Stung Town',5),
                                            ('Kaoh Thum Town',6),('Tram Kak Town',7),('Kirivong Town',8),('Daun Keo Town',9);
