-- Insert categories
INSERT INTO category (id, description, name) VALUES
                                                 (1, 'Electronics and gadgets', 'Electronics'),
                                                 (2, 'Home appliances', 'Home Appliances'),
                                                 (3, 'Books and stationery', 'Books'),
                                                 (4, 'Clothing and accessories', 'Clothing'),
                                                 (5, 'Sports and outdoor', 'Sports');

-- Insert products
INSERT INTO product (id, description, name, available_quantity, price, category_id) VALUES
                                                                                        (1, 'Smartphone with 128GB storage', 'Smartphone', 100, 699.99, 1),
                                                                                        (2, 'Wireless Bluetooth Headphones', 'Headphones', 150, 199.99, 1),
                                                                                        (3, '4K Ultra HD Smart TV', 'Smart TV', 50, 999.99, 1),
                                                                                        (4, 'Microwave Oven with Grill', 'Microwave Oven', 75, 299.99, 2),
                                                                                        (5, 'Refrigerator with Ice Maker', 'Refrigerator', 30, 1199.99, 2),
                                                                                        (6, 'Washing Machine - Front Load', 'Washing Machine', 40, 799.99, 2),
                                                                                        (7, 'The Great Gatsby - Novel', 'The Great Gatsby', 200, 10.99, 3),
                                                                                        (8, 'Python Programming Book', 'Learn Python', 180, 29.99, 3),
                                                                                        (9, 'Art Supplies Set for Beginners', 'Art Supplies', 150, 49.99, 3),
                                                                                        (10, 'Men''s Casual Shirt', 'Casual Shirt', 120, 39.99, 4), -- Escaped single quote
                                                                                        (11, 'Women''s Summer Dress', 'Summer Dress', 100, 59.99, 4), -- Escaped single quote
                                                                                        (12, 'Running Shoes - Size 10', 'Running Shoes', 80, 89.99, 4),
                                                                                        (13, 'Tennis Racket - Lightweight', 'Tennis Racket', 60, 129.99, 5),
                                                                                        (14, 'Camping Tent for Two People', 'Camping Tent', 45, 199.99, 5),
                                                                                        (15, 'Yoga Mat - Non-slip Surface', 'Yoga Mat', 90, 29.99, 5);
